package fr.inria.diverse.melange.resource.loader

import org.dozer.DozerBeanMapper
import org.dozer.config.BeanContainer
import org.dozer.loader.api.BeanMappingBuilder
import org.dozer.loader.api.FieldsMappingOptions
import org.dozer.loader.api.TypeMappingOptions
import org.dozer.util.DozerClassLoader
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl

import static extension fr.inria.diverse.melange.resource.loader.EcoreHelper.*

class DozerLoader implements ExtensionsAwareLoader
{
	private EPackage pkgBase
	private EPackage pkgExtended

	override initialize(EPackage base, EPackage extended) {
		pkgBase = base
		pkgExtended = extended

		// Regular EMF Registration
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put(base.nsPrefix,     new XMIResourceFactoryImpl)
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put(extended.nsPrefix, new XMIResourceFactoryImpl)

		EPackage.Registry.INSTANCE.put(base.nsURI,     base)
		EPackage.Registry.INSTANCE.put(extended.nsURI, extended)
	}

	override loadExtendedAsBase(String uri, boolean loadOnDemand) throws PackageCompatibilityException {
		val mapper = new DozerBeanMapper
		val builder = new ExtendedToBaseBuilder(pkgBase, pkgExtended)
		val rs = new ResourceSetImpl
		val res = loadModel(uri, loadOnDemand) // Just propagate thrown exceptions if any
		val newRes = rs.createResource(URI::createURI(uri))
		val root = res.contents.head

		// Ensure that loaded model conforms to the extended metamodel
		if (root.eClass.EPackage != pkgExtended)
			throw new PackageCompatibilityException('''«uri» doesn't conform to the extended metamodel''')

		// Remove all extension-specific elements
		cleanExtendedResource(res)

		// Use Dozer to map a new graph of instances
		// in the newly created resource
		mapper.addMapping(builder)
		res.contents.forEach[o |
			newRes.contents += mapper.map(o, pkgBase.EClassifiers.findFirst[name == o.eClass.name].implementationClass) as EObject
		]

		return newRes
	}

	override loadBaseAsExtended(String uri, boolean loadOnDemand) throws PackageCompatibilityException {
		val mapper = new DozerBeanMapper
		val builder = new BaseToExtendedBuilder(pkgBase, pkgExtended)
		val rs = new ResourceSetImpl
		val res = loadModel(uri, loadOnDemand) // Just propagate thrown exceptions if any
		val newRes = rs.createResource(URI::createURI(uri))
		val root = res.contents.head

		// Ensure that loaded model conforms to the base metamodel
		if (root.eClass.EPackage != pkgBase)
			throw new PackageCompatibilityException('''«uri» doesn't conform to the base metamodel''')

		mapper.addMapping(builder)
		res.contents.forEach[o |
			newRes.contents += mapper.map(o, pkgExtended.EClassifiers.findFirst[name == o.eClass.name].implementationClass) as EObject
		]

		return newRes
	}
	
	
//	public def Resource loadBaseAsExtended(URI baseModelURI, EPackage expectedPackage) throws PackageCompatibilityException {
//		val baseResource = loadModel(baseModelURI, true) // Just propagate thrown exceptions if any
//		val rs = baseResource.resourceSet
//
//		pkgBase = baseResource.contents.head.eClass.EPackage
//
//		val mapper = new DozerBeanMapper
//		val builder = new BaseToExtendedBuilder(pkgBase, expectedPackage)
//
//		val extendedURI = baseModelURI.appendSegment("extended")
//		val extendedResource = rs.createResource(extendedURI)
//
//		mapper.addMapping(builder)
//		baseResource.contents.forEach[o |
//			extendedResource.contents += mapper.map(o, pkgExtended.EClassifiers.findFirst[name == o.eClass.name].implementationClass) as EObject
//		]
//		extendedResource.contents.addAll(baseResource.contents)
//		return extendedResource
//	}
	
	public def Resource loadBaseAsExtended(Resource baseResource, EPackage expectedPackage) throws PackageCompatibilityException 
	{
		val resourceSet = new ResourceSetImpl

		val basePackage = baseResource.contents.head.eClass.EPackage
		val mapper = new DozerBeanMapper
		val builder = new BaseToExtendedBuilder(basePackage, expectedPackage)

		val extendedURI = URI.createURI("modelAsExtended")
		val extendedResource = resourceSet.createResource(extendedURI)

		mapper.addMapping(builder)
		baseResource.getContents().forEach[o |
			extendedResource.getContents() += mapper.map(o, expectedPackage.EClassifiers.findFirst[name == o.eClass.name].implementationClass) as EObject
		]
		//extendedResource.contents.addAll(baseResource.contents)
		return extendedResource
	}
	
	private def loadModel(String uri, boolean loadOnDemand) {
		return loadModel(URI.createURI(uri), loadOnDemand)
	}

	private def loadModel(URI uri, boolean loadOnDemand) {
		val rs = new ResourceSetImpl
		val res = rs.getResource(uri, loadOnDemand)

		return res
	}

	/**
	 * Remove all extension-specific elements from a resource.
	 * Elements are extension-specific if their metaclass doesn't
	 * directly inherit from a metaclass of the base metamodel.
	 */
	private def cleanExtendedResource(Resource res) {
		res.allContents
			.filter[!eClass.ESuperTypes.exists[EPackage == pkgBase]]
			.map[EcoreUtil::copy(it)] // sigh
			.forEach[EcoreUtil::delete(it)]
	}
}

class ExtendedToBaseBuilder extends BeanMappingBuilder
{
	private EPackage pkgBase
	private EPackage pkgExtended

	new(EPackage base, EPackage extended) {
		pkgBase = base
		pkgExtended = extended
	}

	override protected configure() {
		val classLoader = new OsgiDozerClassLoader
		BeanContainer.getInstance.classLoader = classLoader

		pkgBase.EClassifiers.filter(EClass).forEach[cls |
			val extendedCls = pkgExtended.EClassifiers.filter(EClass).findFirst[name == cls.name]
			val baseImpl = cls.implementationClass
			val extendedImpl = extendedCls.implementationClass
			classLoader.updateContext(baseImpl, extendedImpl)

			val map = mapping(
				extendedImpl,
				baseImpl
			)

			cls.EReferences
			.filter[many]
			.forEach[ref |
				val baseRefImpl = ref.EReferenceType.implementationClass
				val extendedRefImpl = extendedCls.EAllReferences.findFirst[name == ref.name].EReferenceType.implementationClass

				map.fields(
					ref.name,
					ref.name,
					FieldsMappingOptions.hintA(extendedRefImpl),
					FieldsMappingOptions.hintB(baseRefImpl)
				)
			]
		]
	}
}

class BaseToExtendedBuilder extends BeanMappingBuilder
{
	private EPackage pkgBase
	private EPackage pkgExtended

	new(EPackage base, EPackage extended) {
		pkgBase = base
		pkgExtended = extended
	}

	override protected configure() {
		val classLoader = new OsgiDozerClassLoader
		BeanContainer.getInstance.classLoader = classLoader
		
		pkgBase.EClassifiers.filter(EClass).forEach[cls |
			val extendedCls = pkgExtended.EClassifiers.filter(EClass).findFirst[name == cls.name]

			val baseImpl = cls.implementationClass
			val extendedImpl = extendedCls.implementationClass
			classLoader.updateContext(baseImpl, extendedImpl)

				// borner la recherche
			val map = mapping(
				baseImpl,
				extendedImpl,
				TypeMappingOptions.oneWay()
			)

			cls.EReferences
			.filter[many]
			.forEach[ref |
				val baseRefImpl = ref.EReferenceType.implementationClass
				val extendedRefImpl = pkgExtended.EClassifiers.filter(EClass).findFirst[name == ref.EReferenceType.name].implementationClass

				map.fields(
					ref.name,
					ref.name,
					FieldsMappingOptions.hintA(baseRefImpl),
					FieldsMappingOptions.hintB(extendedRefImpl)
				)
			]
		]
	}
	
}

public class OsgiDozerClassLoader implements DozerClassLoader {

	private ClassLoader cl1
	private ClassLoader cl2
   
    override loadClass(String className) {
        try {
            return cl1.loadClass(className)
        } catch (ClassNotFoundException e1) {
	        try {
	            return cl2.loadClass(className)
	        } catch (ClassNotFoundException e2) {
	            return null
	        }
        }
    }
 
	override loadResource(String uri) {
		return
			cl1.getResource(uri) ?:
			cl2.getResource(uri) ?:
			class.classLoader.getResource(uri)
    }

	def void updateContext(Class<?> class1, Class<?> class2) {
		cl1 = class1.classLoader
		cl2 = class2.classLoader
	}
}
