package fr.inria.diverse.melange.processors

import fr.inria.diverse.melange.metamodel.melange.ModelTypingSpace
import fr.inria.diverse.melange.ast.ASTHelper
import com.google.inject.Inject
import fr.inria.diverse.melange.metamodel.melange.Metamodel
import java.util.List
import java.util.ArrayList
import fr.inria.diverse.melange.metamodel.melange.Inheritance
import fr.inria.diverse.melange.metamodel.melange.Merge
import org.eclipse.emf.ecore.EPackage
import java.util.Map
import java.util.HashMap
import fr.inria.diverse.melange.metamodel.melange.Ecore
import fr.inria.diverse.melange.lib.ModelUtils
import fr.inria.diverse.melange.algebra.EmfCompareAlgebra
import fr.inria.diverse.melange.utils.EPackageProvider
import fr.inria.diverse.melange.lib.EcoreExtensions
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.util.EcoreUtil
import fr.inria.diverse.melange.ast.MetamodelExtensions
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EReference
import java.io.IOException
import fr.inria.diverse.melange.metamodel.melange.Slice
import fr.inria.diverse.melange.lib.slicing.ecore.StrictEcore
import org.eclipse.emf.ecore.EModelElement

/**
 * This class build languages by merging differents parts declared in each language definitions
 * and generates new ecore & genmodel if needed
 */
class LanguageBuilder extends DispatchMelangeProcessor{
	
	@Inject extension ASTHelper
	@Inject ModelUtils modelUtils
	@Inject EmfCompareAlgebra algebra
	@Inject AspectsWeaver aspectWeaver
	@Inject EPackageProvider packageProvider
	@Inject extension EcoreExtensions
	@Inject extension MetamodelExtensions
	
	/**
	 * Store root EPackage for each built languages 
	 */
	Map<Metamodel,EPackage> registry
	
	def dispatch void preProcess(ModelTypingSpace root) {
		
		registry = new HashMap<Metamodel,EPackage>()
		
		root.metamodels.forEach[language |
			build(language, new ArrayList<Metamodel>())
		]
	}
	
	/**
	 * Build {@link language} and register the root EPackage.
	 * {@link history} store languages waiting for this build.
	 */
	private def build(Metamodel language, List<Metamodel> history){
		
		var EPackage res = registry.get(language)
		if(res !== null) return res

		history.add(language)

		var EPackage base = null
		var pkgs = new ArrayList<EPackage>()
		var needNewEcore = false

		/****************************
		 * STEP 1: merge ecore files
		 ****************************/
		val ecores = language.units.filter(Ecore)
		if(ecores.size == 1){
			language.ecoreUri = ecores.get(0).ecoreUri
			language.genmodelUris.addAll(ecores.get(0).genmodelUris)
			base = modelUtils.loadPkg(ecores.get(0).ecoreUri)
		}
		else if(ecores.size > 1){
			needNewEcore = true
			val firstEcore = ecores.get(0)
			val ecoreBase = modelUtils.loadPkg(firstEcore.ecoreUri)

			ecores.drop(1).forEach[ nextEcore |
				val ecoreUnit = modelUtils.loadPkg(nextEcore.ecoreUri)
				EcoreUtil.ExternalCrossReferencer.find(ecoreUnit) //Need to solve crossref because EMF Compare don't
				algebra.merge(ecoreUnit,ecoreBase)
			]
			base = ecoreBase
		}
		
		/****************************
		 * STEP 2: merge inherited languages
		 ****************************/
		
		/****************************
		 * STEP 3: merge languages
		 ****************************/
		val merges = language.units.filter(Merge)
		if(merges.size > 0){
			needNewEcore = true
			val firstMerge = merges.get(0)
			val mergeBase = getRootPackage(firstMerge.language,history)
			EcoreUtil.ExternalCrossReferencer.find(mergeBase)
			
			merges.drop(1).forEach[ nextMerge |
				val mergeUnit = getRootPackage(nextMerge.language,history)
				EcoreUtil.ExternalCrossReferencer.find(mergeUnit)
				algebra.merge(mergeUnit,mergeBase)
			]
			
			if(base !== null && mergeBase !== null){
				algebra.merge(mergeBase,base)
			}
			else if(base === null && mergeBase !== null){
				base = mergeBase
			}
		}
		
		/****************************
		 * STEP 4: merge sliced languages
		 ****************************/
		 val slices = language.units.filter(Slice)
		 if(slices.size > 0){
		 	needNewEcore = true
		 	val firstSlice = slices.get(0)
			val sliceBase = getRootPackage(firstSlice.language,history)
			EcoreUtil.ExternalCrossReferencer.find(sliceBase)
			
			val roots = getClasses(sliceBase, firstSlice.roots)
			val slicer = new StrictEcore(roots,sliceBase,false,"ecore",false)
			slicer.slice
			slicer.save(language.localEcoreUri)
			
			val slice = modelUtils.loadPkg(language.localEcoreUri)
			
			if(base !== null && slice !== null){
				algebra.merge(slice,base)
			}
		 }
		 
		
		if(base === null){
			//TODO: raise an error, language not well defined
		}
		
		/****************************
		 * STEP 5: merge aspects
		 ****************************/
		aspectWeaver.preProcess(language)
		
		/****************************
		 * STEP 6: 
		 ****************************/
		if(base !== null){
			registry.put(language, base)
		}
		
		if(needNewEcore){
			pkgs.add(base)
			createEcore(pkgs, language.localEcoreUri, null) //should be refactored
			language.ecoreUri = language.localEcoreUri
			language.createLocalGenmodel
			language.genmodelUris += language.getLocalGenmodelUri
		}
		
		history.remove(language)
	} 
	
	/**
	 * Check if {@link language} is a dependency of an other language
	 * and has this language as dependency at the same time
	 */
	private def boolean isWithCycle(Metamodel language, List<Metamodel> history){
		
		val List<Metamodel> dependencies = new ArrayList<Metamodel>()
		language.units.filter(Inheritance).forEach[inherit |
			dependencies.add(inherit.superMetamodel)
		]
		language.units.filter(Merge).forEach[merge |
			dependencies.add(merge.language)
		]
		
		return dependencies.exists[dep | history.contains(dep)]
	}
	
	/**
	 * Get the root EPackage of {@link language}.
	 */
	private def EPackage getRootPackage(Metamodel language, List<Metamodel> history){
		
		var EPackage res = registry.get(language)
		
		if(res == null && language != null) {
			if(isWithCycle(language, history)){
				//TODO: raise error
			}
			else{
				build(language,history)
				registry.get(language)
			}
		}
		
		return res
	}
	
	/**
 	 * Copy/Past from ModelingElementExtension
 	 */
	def EPackage createEcore(List<EPackage> pkgs, String uri, String pkgUri) {
		val resSet = new ResourceSetImpl
		val res = resSet.createResource(URI::createURI(uri))
		val rootPkg = pkgs.head

		if (pkgUri !== null)
			rootPkg.nsURI = pkgUri

		val copy = EcoreUtil::copyAll(pkgs)

		// FIXME:
		copy.forEach[pkg |
			EcoreUtil.ExternalCrossReferencer.find(pkg).forEach[o, s |
				s.forEach[ss |
					if (ss.EStructuralFeature !== null && !ss.EStructuralFeature.derived && !ss.EStructuralFeature.many) {
						if (o instanceof EClassifier) {
							val corresponding = copy.map[EClassifiers].flatten.findFirst[name == o.name]
							if (corresponding !== null)
								ss.EObject.eSet(ss.EStructuralFeature, corresponding)
						} else if (o instanceof EReference) {
							if (o.EOpposite !== null) {
								val correspondingCls = copy.map[EClassifiers].flatten.findFirst[name == o.EContainingClass.name] as EClass
								val correspondingRef = correspondingCls.EReferences.findFirst[name == o.name]

								if (correspondingRef !== null)
									ss.EObject.eSet(ss.EStructuralFeature, correspondingRef)
							}
						}
					}
				]
			]
		]

		res.contents += copy

//		new Job("Serializing Ecore") {
//			override run(IProgressMonitor monitor) {
				try {
					res.save(null)
				} catch (IOException e) {
					e.printStackTrace
				}

//				return Status.OK_STATUS
//			}
//		}.schedule

		return rootPkg
	}
	
	/**
	 * Search in {@link rootPackage} for EClass named as in {@link classes}
	 */
	private def List<EModelElement> getClasses(EPackage rootPackage, List<String> classes){
		//TODO: manage sub packages
		val res = new ArrayList<EModelElement>()
		
		rootPackage.EClassifiers.filter(EClass).forEach[cl|
			if(classes.contains(cl.name)) res.add(cl)
		]
		
		return res
	}
}