package fr.inria.diverse.k3.sle.lib

import java.util.HashMap
import java.util.Map

import org.eclipse.emf.common.util.URI

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import java.lang.reflect.InvocationTargetException

class MetamodelExtensions
{
	// FIXME: re static-type me please
	def static <MT extends IModelType, MM/*extends MT*/> MT load(Class<MM> mm, String uri, Class<MT> mt) throws ModelTypeException , InstantiationException, IllegalAccessException, InvocationTargetException {
		val resSet = new ResourceSetImpl
		val res = resSet.getResource(URI.createURI(uri), true)

		if (AdaptersRegistry.instance.getAdapter(mm.name, mt.name) === null)
			throw new ModelTypeException("Cannot find adapter for " + mm + " towards " + mt)

		val ret = AdaptersRegistry.instance.getAdapter(mm.name, mt.name).declaredConstructors.head.newInstance as GenericAdapter<Resource>
		ret.setAdaptee(res)

		return ret as MT
	}
}

class AdaptersRegistry {
	static AdaptersRegistry registry = new AdaptersRegistry
	Map<Pair<String, String>, Class<? extends GenericAdapter<Resource>>> adaptersRegistry = new HashMap<Pair<String, String>, Class<? extends GenericAdapter<Resource>>>

	static def AdaptersRegistry getInstance() { return registry }

	def void registerAdapter(String mm, String mt, Class<? extends GenericAdapter<Resource>> adapter) {
		adaptersRegistry.put(mm -> mt, adapter)
	}

	def Class<? extends GenericAdapter<Resource>> getAdapter(String mm, String mt) {
		return adaptersRegistry.get(mm -> mt)
	}
}
