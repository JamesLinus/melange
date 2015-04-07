package fr.inria.diverse.melange.utils

import fr.inria.diverse.commons.asm.shade.DirectoryShader
import fr.inria.diverse.commons.asm.shade.ShadeRequest
import fr.inria.diverse.commons.asm.shade.relocation.Relocator
import fr.inria.diverse.commons.asm.shade.relocation.SimpleRelocator
import fr.inria.diverse.commons.asm.shade.resource.K3AspectPropertiesTransformer
import fr.inria.diverse.commons.asm.shade.resource.ResourceTransformer
import fr.inria.diverse.melange.ast.MetamodelExtensions
import fr.inria.diverse.melange.ast.ModelingElementExtensions
import fr.inria.diverse.melange.ast.NamingHelper
import fr.inria.diverse.melange.eclipse.EclipseProjectHelper
import fr.inria.diverse.melange.metamodel.melange.Aspect
import fr.inria.diverse.melange.metamodel.melange.Metamodel
import java.io.File
import java.io.IOException
import java.util.ArrayList
import javax.inject.Inject
import org.apache.log4j.Logger
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IResourceVisitor
import org.eclipse.core.runtime.CoreException
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.util.internal.Stopwatches

import static fr.inria.diverse.melange.utils.AspectCopier.*

/**
 * Baaah, full of sh*t
 */
class AspectCopier
{
	@Inject extension ModelingElementExtensions
	@Inject extension MetamodelExtensions
	@Inject extension IQualifiedNameConverter
	@Inject extension NamingHelper
	@Inject extension EclipseProjectHelper
	@Inject ErrorHelper errorHelper
	static Logger log = Logger.getLogger(AspectCopier)

	// FIXME: We should first check that aspects are importable (i.e. defined
	//         on a type group this metamodel is a subtype of)
	def String copyAspectTo(Aspect asp, Metamodel mm) {
		val task = Stopwatches.forTask("copying aspects in new type group")
		task.start

		val project = mm.eResource.project

		if (project === null)
			return null

		val ws = project.workspace.root
		val shader = new DirectoryShader
		val request = new ShadeRequest
		val relocators = new ArrayList<Relocator>
		val sourceEmfNamespace = asp.targetedNamespace
		val targetEmfNamespace = mm.packageFqn.toQualifiedName.skipLast(1)
				
		val sourceAspectNamespace = asp.aspectTypeRef.identifier.toQualifiedName.skipLast(1)
		
		
		if(sourceEmfNamespace.equals(sourceAspectNamespace)){
			errorHelper.addError(asp, "Melange cannot correctly handle aspect classes if they use the same package name as the aspectized emf classes, please move the aspect classes in a dedicated package", null)
		}
		val targetAspectNamespace = getAspectTargetNamespace(sourceAspectNamespace,mm)
		

		val projectPathTmp = new StringBuilder
		val projectNameTmp = new StringBuilder
		ws.accept(new IResourceVisitor {
			override visit(IResource resource) throws CoreException {
				if (resource instanceof IFile) {
					val resourcePath = resource.locationURI.path
					val toBeMatched = asp.aspectTypeRef.identifier.replace(".", "/") + ".java"
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
		val findTargetProject = ws.getProject(targetAspectNamespace.toString)
		// FIXME: Just to have a first call of the EPackageProvider
		//        in order to set the ecoreUri when inherited
		val x = mm.pkgs
		val ecoreUri = URI::createURI(mm.ecoreUri)
		val emfRuntimeProject = ecoreUri.segment(1)
		val targetProject =
			if (findTargetProject.exists)
				findTargetProject
			else
				EclipseProjectHelper::createAspectsRuntimeProject(
					sourceProject,
					targetAspectNamespace.toString,
					targetAspectNamespace.toString,
					emfRuntimeProject
				)
		//ws.getProject(targetAspectNamespace.toString).rawLocation
		val targetAspectFolder = findTargetProject.locationURI.path + "/src-gen/"
		val targetFolderFile = new File(targetAspectFolder)
//		val filenameToBeFound = '''/src-gen/«targetAspectNamespace.toString.replace(".", "/")»/«asp.aspectTypeRef.simpleName».java'''
//		val fileToBeFound = targetProject.getFile(filenameToBeFound)

		EclipseProjectHelper::addDependencies(project, #[targetProject.name])

		relocators += new SimpleRelocator(sourceAspectNamespace.toString, targetAspectNamespace.toString, null, #[])
		relocators += new SimpleRelocator(sourceEmfNamespace.toString, targetEmfNamespace.toString, null, #[])

		request.inputFolders = #{sourceFolderFile}
		request.outputFolder = targetFolderFile
		request.filters = #[]
		request.resourceTransformers = #[]
		request.relocators = relocators

		try {
			log.debug('''Copying aspect «asp.aspectTypeRef.identifier» to «mm.name»:''')
			log.debug('''	sourceEmfNamespace    = «sourceEmfNamespace»''')
			log.debug('''	targetEmfNamespace    = «targetEmfNamespace»''')
			log.debug('''	sourceAspectNamespace = «sourceAspectNamespace»''')
			log.debug('''	targetAspectNamespace = «targetAspectNamespace»''')
			log.debug('''	sourceAspectFolder    = «sourceAspectFolder»''')
			log.debug('''	targetAspectFolder    = «targetAspectFolder»''')

//			if (!fileToBeFound.exists) {
			shader.shade(request)
			
			log.debug('''Copying META-INF aspect_properties «asp.aspectTypeRef.identifier» to «mm.name»:''')	
			val sourceMetaInfFolder = projectPathTmp.toString + "/META-INF/"
			val sourceMetaInfFile = new File(sourceMetaInfFolder)	
			val targetMetaInfFile = new File(findTargetProject.locationURI.path + "/META-INF/")
			request.inputFolders = #{sourceMetaInfFile}
			request.outputFolder = targetMetaInfFile
			request.resourceTransformers = #[new K3AspectPropertiesTransformer(targetAspectNamespace.toString) as ResourceTransformer]
			
			shader.shade(request)
				
			targetProject.refreshLocal(IResource.DEPTH_INFINITE, null)
//			}
			return '''«targetAspectNamespace».«asp.aspectTypeRef.simpleName»'''
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
	
	def protected QualifiedName getAspectTargetNamespace(QualifiedName sourceAspectNamespace , Metamodel mm){
		val postfix = if(sourceAspectNamespace.segmentCount > 1 &&(sourceAspectNamespace.lastSegment.equals("aspect") 
				|| sourceAspectNamespace.lastSegment.equals("aspects")
				|| sourceAspectNamespace.lastSegment.equals("k3dsa")
				)){ sourceAspectNamespace.lastSegment } else{"aspect"}
				
		
		if(sourceAspectNamespace.segmentCount > 2){
			return sourceAspectNamespace.skipLast(2).append(mm.name.toLowerCase).append(postfix)
		} else {
				return sourceAspectNamespace.skipLast(1).append(mm.name.toLowerCase).append(postfix)
		}

	}
}

