package fr.inria.diverse.melange.ui.builder

import com.google.inject.Inject
import com.google.inject.Provider
import fr.inria.diverse.melange.ast.LanguageExtensions
import fr.inria.diverse.melange.ast.ModelTypeExtensions
import fr.inria.diverse.melange.ast.ModelingElementExtensions
import fr.inria.diverse.melange.eclipse.EclipseProjectHelper
import fr.inria.diverse.melange.lib.EcoreExtensions
import fr.inria.diverse.melange.metamodel.melange.Language
import fr.inria.diverse.melange.metamodel.melange.ModelType
import fr.inria.diverse.melange.metamodel.melange.ModelTypingSpace
import fr.inria.diverse.melange.processors.ExtensionPointProcessor
import fr.inria.diverse.melange.resource.MelangeDerivedStateComputer
import org.apache.log4j.Logger
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.core.runtime.SubProgressMonitor
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.OutputConfigurationProvider
import org.eclipse.xtext.resource.DerivedStateAwareResource

class MelangeBuilder
{
	@Inject IGenerator generator
	@Inject MelangeDerivedStateComputer computer
	@Inject Provider<EclipseResourceFileSystemAccess2> fileSystemAccessProvider
	@Inject OutputConfigurationProvider outputProvider
	@Inject EclipseProjectHelper eclipseHelper
	@Inject ExtensionPointProcessor extensionProcessor
	@Inject extension LanguageExtensions
	@Inject extension ModelingElementExtensions
	@Inject extension ModelTypeExtensions
	@Inject extension EcoreExtensions
	static final Logger log = Logger.getLogger(MelangeBuilder)

	def void generateAll(Resource res, IProject project, IProgressMonitor monitor) {
		monitor.beginTask("Generating all artifacts", 700)
		generateInterfaces(res, project, new SubProgressMonitor(monitor, 50))
		generateLanguages(res, project, new SubProgressMonitor(monitor, 300))
		generateAdapters(res, project, new SubProgressMonitor(monitor, 300))
		generatePluginXml(res, project, new SubProgressMonitor(monitor, 10))
	}

	def void generateInterfaces(Resource res, IProject project, IProgressMonitor monitor) {
		val root = res.contents.head as ModelTypingSpace
		val mts = root.elements.filter(ModelType)
		val nb = mts.size

		monitor.beginTask("Generating interfaces", 10 * nb)

		mts.filter[isExtracted].forEach[mt |
			if (monitor.canceled)
				throw new OperationCanceledException

			monitor.subTask("Generating interface for " + mt.name)

			log.debug('''Registering new EPackage for «mt.name» in EMF registry''')
			if (!EPackage.Registry.INSTANCE.containsKey(mt.pkgs.head.nsURI))
				EPackage.Registry.INSTANCE.put(mt.pkgs.head.nsURI, mt.pkgs.head)

			val ecoreUri = mt.inferredEcoreUri
			log.debug('''Serializing Ecore interface description for «mt.name» in «ecoreUri»''')
			mt.createEcore(ecoreUri, mt.uri, false)
			val gmUri = ecoreUri.substring(0, ecoreUri.lastIndexOf(".")) + ".genmodel"
			val gm = mt.createGenmodel(ecoreUri, gmUri)
			gm.generateModelTypeCode
			monitor.worked(10)
		]
	}

	def void generateLanguages(Resource res, IProject project, IProgressMonitor monitor) {
		val root = res.contents.head as ModelTypingSpace
		val toGenerate = root.elements.filter(Language).filter[generatedByMelange]
		val nb = toGenerate.size

		monitor.beginTask("Generating EMF runtime for languages", 100 * nb)

		toGenerate.forEach[l |
			if (monitor.canceled)
				throw new OperationCanceledException

			val sub = new SubProgressMonitor(monitor, 100)
			sub.beginTask("Generating runtime for " + l.name, 100)
			sub.subTask("Creating new project for " + l.name)
			eclipseHelper.createEMFRuntimeProject(l.externalRuntimeName, l)
			monitor.worked(5)
			sub.subTask("Serializing Ecore description for " + l.name)
			l.createExternalEcore
			monitor.worked(5)
			sub.subTask("Serializing Genmodel for " + l.name)
			l.createExternalGenmodel
			monitor.worked(5)
			sub.subTask("Generating code")
			l.syntax.genmodels.head.generateCode
			monitor.worked(40)
			sub.subTask("Copying aspects for " + l.name)
			l.createExternalAspects
			monitor.worked(40)
			sub.subTask("Updating dependencies for " + l.name)
			eclipseHelper.addDependencies(project, #[l.externalRuntimeName])
			monitor.worked(5)
		]
	}

	def void generateAdapters(Resource res, IProject project, IProgressMonitor monitor) {
		monitor.beginTask("Generating adapters", 100)

		val fsa = fileSystemAccessProvider.get => [f |
			f.monitor = new SubProgressMonitor(monitor, 50)
			f.project = project
		]

		outputProvider.outputConfigurations.forEach [
			fsa.outputConfigurations.put(name, it)
		]

		if (res instanceof DerivedStateAwareResource) {
			monitor.subTask("Inferring derived state")
			computer.inferFullDerivedState(res)
			monitor.worked(50)
			monitor.subTask("Generating code")
			generator.doGenerate(res, fsa)
		}
	}

	def void generatePluginXml(Resource res, IProject project, IProgressMonitor monitor) {
		monitor.beginTask("Generating new plugin.xml", 1)
		monitor.subTask("Generating new plugin.xml")
		try{
			val root = res.contents.head as ModelTypingSpace
			extensionProcessor.preProcess(root, false)
		} catch (Exception e) {
			log.error("Fatal exception", e)
		}
		monitor.worked(1)
	}

	/**
	 * - Clean the src-gen/ and model-gen/ folders of the current project
	 * - For each language generated by Melange, delete its associated projects
	 * - Remove the dangling dependencies from the current project
	 */
	def void cleanAll(Resource res, IProject project, IProgressMonitor monitor) {
		monitor.beginTask("Cleaning old derived artifacts", 60)
		monitor.subTask("Cleaning generated interfaces")
		cleanInterfaces(res, project, new SubProgressMonitor(monitor, 20))
		monitor.subTask("Cleaning generated adapters")
		cleanAdapters(res, project, new SubProgressMonitor(monitor, 20))
		monitor.subTask("Cleaning generated projects")		
		cleanLanguages(res, project, new SubProgressMonitor(monitor, 20))
	}

	def void cleanLanguages(Resource res, IProject project, IProgressMonitor monitor) {
		val root = res.contents.head as ModelTypingSpace
		val danglingBundles = newArrayList

		root.elements
		.filter(Language)
		.filter[generatedByMelange]
		.forEach[l |
			val runtimeName = l.externalRuntimeName
			val runtimeProject = project.workspace.root.getProject(runtimeName)
			runtimeProject.delete(true, true, monitor)
			danglingBundles += runtimeName
		]

		eclipseHelper.removeDependencies(project, danglingBundles)
	}

	def void cleanInterfaces(Resource res, IProject project, IProgressMonitor monitor) {
		val modelGenFolder = project.getFolder("model-gen/")

		if (modelGenFolder.exists)
			modelGenFolder.members.forEach[delete(true, monitor)]
	}

	def void cleanAdapters(Resource res, IProject project, IProgressMonitor monitor) {
		val srcGenFolder = project.getFolder("src-gen/")

		if (srcGenFolder.exists)
			srcGenFolder.members.forEach[delete(true, monitor)]
	}

	private def void waitForAutoBuild() {
		var wasInterrupted = false
		do {
			try {
				Job.jobManager.join(ResourcesPlugin::FAMILY_AUTO_BUILD,	null)
				wasInterrupted = false
			} catch (OperationCanceledException e) {
				e.printStackTrace
			} catch (InterruptedException e) {
				wasInterrupted = true
			}
		} while (wasInterrupted)
	}
}
