package fr.inria.diverse.melange.utils

import fr.inria.diverse.commons.asm.shade.DirectoryShader
import fr.inria.diverse.commons.asm.shade.ShadeRequest
import fr.inria.diverse.commons.asm.shade.filter.Filter
import fr.inria.diverse.commons.asm.shade.relocation.Relocator
import fr.inria.diverse.commons.asm.shade.relocation.SimpleRelocator
import fr.inria.diverse.commons.asm.shade.resource.K3AspectPropertiesTransformer
import fr.inria.diverse.commons.asm.shade.resource.ResourceTransformer
import fr.inria.diverse.melange.ast.AspectExtensions
import fr.inria.diverse.melange.ast.LanguageExtensions
import fr.inria.diverse.melange.ast.ModelingElementExtensions
import fr.inria.diverse.melange.ast.NamingHelper
import fr.inria.diverse.melange.eclipse.EclipseProjectHelper
import fr.inria.diverse.melange.metamodel.melange.Language
import java.io.File
import java.io.IOException
import java.util.ArrayList
import java.util.List
import javax.inject.Inject
import org.apache.log4j.Logger
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IResourceVisitor
import org.eclipse.core.runtime.CoreException
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.util.internal.Stopwatches

import static fr.inria.diverse.melange.utils.AspectCopier.*

/**
 * Baaah, full of sh*t
 */
class AspectCopier
{
	@Inject extension AspectExtensions
	@Inject extension ModelingElementExtensions
	@Inject extension LanguageExtensions
	@Inject extension IQualifiedNameConverter
	@Inject extension NamingHelper
	@Inject EclipseProjectHelper eclipseHelper
	@Inject ErrorHelper errorHelper
	static Logger log = Logger.getLogger(AspectCopier)

	// FIXME: We should first check that aspects are importable (i.e. defined
	//         on a type group this metamodel is a subtype of)
	def String copyAspectTo(JvmTypeReference asp, List<String> sourceEmfNamespaces, Language l) {
		val task = Stopwatches.forTask("copying aspects in new type group")
		task.start

		val project = eclipseHelper.getProject(l.eResource)

		if (project === null)
			return null

		val ws = project.workspace.root
		val shader = new DirectoryShader
		val request = new ShadeRequest
		val relocators = new ArrayList<Relocator>
		val targetEmfNamespace = l.syntax.packageFqn.toQualifiedName.skipLast(1)
		val sourceAspectNamespace = asp.identifier.toQualifiedName.skipLast(1)
		val targetAspectNamespace = l.aspectTargetNamespace
		val newFqn = '''«targetAspectNamespace».«asp.simpleName»'''
		
//		if(sourceEmfNamespace.equals(sourceAspectNamespace)){
//			errorHelper.addError(asp, "Melange cannot correctly handle aspect classes if they use the same package name as the aspectized emf classes, please move the aspect classes in a dedicated package", null)
//		}

		val projectPathTmp = new StringBuilder
		val projectNameTmp = new StringBuilder
		ws.accept(new IResourceVisitor {
			override visit(IResource resource) throws CoreException {
				if (resource instanceof IFile) {
					val resourcePath = resource.locationURI.path
					val toBeMatched = asp.identifier.replace(".", "/") + ".java"
					if (resourcePath.endsWith(toBeMatched)) {
						val projectPath = resource.project.locationURI.path
						if (projectPathTmp.length == 0)
							projectPathTmp.append(projectPath)
						if (projectNameTmp.length == 0)
							projectNameTmp.append(resource.project.name)
					}
					return false
				}
				
				return true
			}
		})

		val sourceAspectFolder = projectPathTmp.toString + "/xtend-gen/"
		//val targetAspectFolder = projectPathTmp.toString + "/../" + targetAspectNamespace + "/src-gen/"
		val sourceFolderFile = new File(sourceAspectFolder)
		val sourceProject = ws.getProject(projectNameTmp.toString)
		val findTargetProject = ws.getProject(l.externalRuntimeName)
		// FIXME: Just to have a first call of the EPackageProvider
		//        in order to set the ecoreUri when inherited
		val x = l.syntax.pkgs
		val ecoreUri = URI::createURI(l.syntax.ecoreUri)
		val emfRuntimeProject = ecoreUri.segment(1)
		val targetProject =
			if (findTargetProject.exists)
				findTargetProject
			else
				eclipseHelper.createAspectsRuntimeProject(
					sourceProject,
					l.externalRuntimeName,
					targetAspectNamespace.toString,
					emfRuntimeProject
				)
		//ws.getProject(targetAspectNamespace.toString).rawLocation
		val targetAspectFolder = findTargetProject.locationURI.path + "/src-gen/"
		val targetFolderFile = new File(targetAspectFolder)
//		val filenameToBeFound = '''/src-gen/«targetAspectNamespace.toString.replace(".", "/")»/«asp.aspectTypeRef.simpleName».java'''
//		val fileToBeFound = targetProject.getFile(filenameToBeFound)

		if(project.name != targetProject.name){
			eclipseHelper.addDependencies(project, #[targetProject.name])
		}

		relocators += new SimpleRelocator(sourceAspectNamespace.toString, targetAspectNamespace.toString, null, #[])
		sourceEmfNamespaces.forEach[sourceEmfNamespace |
			relocators += new SimpleRelocator(sourceEmfNamespace.toString, targetEmfNamespace.toString, null, #[])
		]

		val aspectFqn = asp.identifier
		val aspectTargetClass = asp.aspectAnnotationValue
		// Filter files not related to targeted aspect
		val filter = new Filter {
			String prefix = aspectFqn.replaceAll("\\.", "/")
			String targetClass = aspectTargetClass

			override canFilter(File jar) {
				return true
			}

			override finished() {}

			override isFiltered(String classFile) {
				return
					   !(classFile.endsWith('''«prefix».java''')
					|| classFile.endsWith('''«prefix»«targetClass»AspectContext.java''')
					|| classFile.endsWith('''«prefix»«targetClass»AspectProperties.java'''))
			}
		}
		request.inputFolders = #{sourceFolderFile}
		request.outputFolder = targetFolderFile
		request.filters = #[filter]
		request.resourceTransformers = #[]
		request.relocators = relocators

		try {
			log.debug('''Copying aspect «asp.identifier» to «l.name» as «newFqn»''')
//			log.debug('''	sourceEmfNamespace    = «sourceEmfNamespace»''')
//			log.debug('''	targetEmfNamespace    = «targetEmfNamespace»''')
//			log.debug('''	sourceAspectNamespace = «sourceAspectNamespace»''')
//			log.debug('''	targetAspectNamespace = «targetAspectNamespace»''')
//			log.debug('''	sourceAspectFolder    = «sourceAspectFolder»''')
//			log.debug('''	targetAspectFolder    = «targetAspectFolder»''')

//			if (!fileToBeFound.exists) {
			shader.shade(request)
			
//			log.debug('''Copying META-INF aspect_properties «asp.identifier» to «l.name» as «»''')
			val sourceMetaInfFolder = projectPathTmp.toString + "/META-INF/"
			val sourceMetaInfFile = new File(sourceMetaInfFolder)	
			val targetMetaInfFile = new File(findTargetProject.locationURI.path + "/META-INF/")
			request.inputFolders = #{sourceMetaInfFile}
			request.outputFolder = targetMetaInfFile
			request.resourceTransformers = #[new K3AspectPropertiesTransformer(targetAspectNamespace.toString) as ResourceTransformer]
			
			shader.shade(request)
				
			targetProject.refreshLocal(IResource.DEPTH_INFINITE, null)
//			}
			return newFqn
		} catch (IOException e) {
			log.debug("Copy failed", e)
			return null
		} catch (CoreException e) {
			log.debug("Refresh failed", e)
			return null
		} catch (Exception e) {
			log.error("Unexpected error", e)
			return null
		
		} finally {
			task.stop
		}
	}
}
