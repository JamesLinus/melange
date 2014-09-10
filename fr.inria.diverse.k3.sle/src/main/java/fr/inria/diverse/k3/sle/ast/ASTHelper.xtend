package fr.inria.diverse.k3.sle.ast

//import fr.inria.diverse.k3.sle.metamodel.k3sle.KomprenSlicer
import fr.inria.diverse.k3.sle.metamodel.k3sle.Metamodel
import fr.inria.diverse.k3.sle.metamodel.k3sle.ModelType
import fr.inria.diverse.k3.sle.metamodel.k3sle.ModelTypingSpace
import fr.inria.diverse.k3.sle.metamodel.k3sle.XbaseTransformation

import java.util.Collections
import java.util.Comparator

import org.apache.log4j.Logger

import org.eclipse.emf.common.util.URI

import org.eclipse.emf.ecore.EClass

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl

import org.eclipse.emf.ecore.util.EcoreUtil

import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import java.io.IOException

class ASTHelper
{
	Logger logger = Logger.getLogger(ASTHelper)

	def void saveAs(ModelTypingSpace root, String uri) {
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("*", new XMIResourceFactoryImpl)
		val rs = new ResourceSetImpl
		val res = rs.createResource(URI.createURI(uri))

		res.contents.add(EcoreUtil.copy(root))

		try {
			res.save(Collections.EMPTY_MAP)
		} catch (IOException e) {
			e.printStackTrace
		}
	}

	def void printDebug(ModelTypingSpace root) {
		root.metamodels.forEach[mm |
			logger.debug('''MM «mm.name»''')
			logger.debug('''\tpkgs = «mm.pkgs.map[name].join(", ")»''')
			logger.debug('''\tgenmodels = «mm.genmodels.map[it.class].join(", ")»''')
			logger.debug('''\texactType = «mm.exactType.name»''')
			logger.debug('''\timplements = «mm.^implements.map[name].join(", ")»''')
			logger.debug('''\tsuperMM = «mm.inheritanceRelation?.superMetamodel?.name»''')
			logger.debug('''\taspects = «mm.aspects.map[aspectTypeRef.simpleName].join(", ")»''')
		]

		root.modelTypes.forEach[mt |
			logger.debug('''MT «mt.name»''')
			logger.debug('''pkgs = «mt.pkgs.map[name].join(", ")»''')
			logger.debug('''extracted = «mt.extracted?.name»''')
			logger.debug('''superTypes = «mt.subtypingRelations.map[superType?.name].join(", ")»''')
		]
	}

	def Iterable<Metamodel> getMetamodels(ModelTypingSpace root) {
		return root.elements.filter(Metamodel)
	}

	def Iterable<ModelType> getModelTypes(ModelTypingSpace root) {
		return root.elements.filter(ModelType)
	}

	def Iterable<XbaseTransformation> getTransformations(ModelTypingSpace root) {
		return root.elements.filter(XbaseTransformation)
	}

//	def Iterable<KomprenSlicer> getSlicers(ModelTypingSpace root) {
//		return root.elements.filter(KomprenSlicer)
//	}

	def Iterable<EClass> sortByClassInheritance(Iterable<EClass> classes) {
		return classes.sort(new Comparator<EClass>() {
			override compare(EClass clsA, EClass clsB) {
				if (clsA.EAllSuperTypes.contains(clsB))
					return -1
				else if (clsB.EAllSuperTypes.contains(clsA))
					return 1
				else
					return 0
			}

			override equals(Object obj) {
				return false
			}
		})
	}
}

class ASTProcessingException extends Exception
{
	new(String msg) {
		super(msg)
	}
}
