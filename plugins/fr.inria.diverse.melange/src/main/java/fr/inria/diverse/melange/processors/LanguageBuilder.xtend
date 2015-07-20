package fr.inria.diverse.melange.processors

import com.google.inject.Inject
import fr.inria.diverse.melange.algebra.EmfCompareAlgebra
import fr.inria.diverse.melange.ast.ASTHelper
import fr.inria.diverse.melange.ast.MetamodelExtensions
import fr.inria.diverse.melange.lib.EcoreExtensions
import fr.inria.diverse.melange.lib.ModelUtils
import fr.inria.diverse.melange.lib.slicing.ecore.StrictEcore
import fr.inria.diverse.melange.metamodel.melange.Ecore
import fr.inria.diverse.melange.metamodel.melange.Merge
import fr.inria.diverse.melange.metamodel.melange.Metamodel
import fr.inria.diverse.melange.metamodel.melange.ModelTypingSpace
import fr.inria.diverse.melange.metamodel.melange.Slice
import fr.inria.diverse.melange.utils.EPackageProvider
import java.io.IOException
import java.util.ArrayList
import java.util.HashMap
import java.util.List
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EModelElement
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.util.EcoreUtil
import fr.inria.diverse.melange.metamodel.melange.Aspect
import fr.inria.diverse.melange.eclipse.EclipseProjectHelper
import com.google.common.collect.ArrayListMultimap
import fr.inria.diverse.melange.metamodel.melange.ClassBinding

/**
 * This class build languages by merging differents parts declared in each language definitions
 * and generates new ecore & genmodel if needed
 */
class LanguageBuilder extends DispatchMelangeProcessor{
	
	@Inject extension ASTHelper
	@Inject ModelUtils modelUtils
	@Inject EmfCompareAlgebra algebra
	@Inject AspectsCopier aspectCopier
	@Inject AspectsWeaver aspectWeaver
	@Inject EPackageProvider packageProvider
	@Inject extension EcoreExtensions
	@Inject extension MetamodelExtensions
	
	/**
	 * Store root EPackage for each built languages 
	 */
	Map<Metamodel,EPackage> registry
	
	def dispatch void preProcess(ModelTypingSpace root, boolean isPreLinkingPhase) {
		
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
		val ecores = language.operators.filter(Ecore)
		if(ecores.size == 1){
			language.ecoreUri = ecores.get(0).ecoreUri
			language.genmodelUris.addAll(ecores.get(0).genmodelUris)
			base = modelUtils.loadPkg(ecores.get(0).ecoreUri)
			applyRenaming(base, ecores.get(0).mappingRules)
		}
		else if(ecores.size > 1){
			needNewEcore = true
			val firstEcore = ecores.get(0)
			val ecoreBase = modelUtils.loadPkg(firstEcore.ecoreUri)
			applyRenaming(ecoreBase, firstEcore.mappingRules)

			ecores.drop(1).forEach[ nextEcore |
				val ecoreUnit = modelUtils.loadPkg(nextEcore.ecoreUri)
				EcoreUtil.resolveAll(ecoreUnit) //Need to solve crossref because EMF Compare don't
				applyRenaming(ecoreUnit, nextEcore.mappingRules)
				algebra.merge(ecoreUnit,ecoreBase)
			]
			base = ecoreBase
		}
		
		/****************************
		 * STEP 2: merge inherited languages
		 ****************************/
		 val inherits = language.inheritanceRelation
		 if(inherits.size > 0){
			needNewEcore = true
			val firstInherit = inherits.get(0)
			val inheritBase = EcoreUtil::copy(getRootPackage(firstInherit.superMetamodel,history))
			EcoreUtil.resolveAll(inheritBase)
			
			inherits.drop(1).forEach[ nextInherit |
				val inheritUnit = getRootPackage(nextInherit.superMetamodel,history)
				EcoreUtil.resolveAll(inheritUnit)
				algebra.merge(inheritUnit,inheritBase)
			]
			
			if(base !== null && inheritBase !== null){
				algebra.merge(inheritBase,base)
			}
			else if(base === null && inheritBase !== null){
				base = inheritBase
			}
		}
		
		/****************************
		 * STEP 3: merge languages
		 ****************************/
		val merges = language.operators.filter(Merge)
		if(merges.size > 0){
			needNewEcore = true
			val firstMerge = merges.get(0)
			val mergeBase = EcoreUtil::copy(getRootPackage(firstMerge.language,history))
			EcoreUtil.resolveAll(mergeBase)
			applyRenaming(mergeBase, firstMerge.mappingRules)

			merges.drop(1).forEach[ nextMerge |
				val mergeUnit = getRootPackage(nextMerge.language,history)
				EcoreUtil.resolveAll(mergeUnit)
				applyRenaming(mergeUnit, nextMerge.mappingRules)
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
		 val slices = language.operators.filter(Slice)
		 if(slices.size > 0){
		 	needNewEcore = true
		 	val firstSlice = slices.get(0)
			val sliceBase = applySlice(firstSlice, history)
			applyRenaming(sliceBase, firstSlice.mappingRules)
			
			slices.drop(1).forEach[ nextSlice |
				val sliceUnit = applySlice(nextSlice, history)
				applyRenaming(sliceUnit, nextSlice.mappingRules)
				algebra.merge(sliceUnit, sliceBase)
			]
			
			if(base !== null && sliceBase !== null){
				algebra.merge(sliceBase,base)
			}
			else if(base === null && sliceBase !== null){
				base = sliceBase
			}
		 }
		 
		
		if(base === null){
			//TODO: raise an error, language not well defined
		}
		

		/****************************
		 * STEP 5: 
		 ****************************/
		if(base !== null){
			registry.put(language, base)
		}
		
		if(needNewEcore){
//			pkgs.add(base)
//			createEcore(pkgs, language.localEcoreUri, null) //should be refactored
//			language.ecoreUri = language.localEcoreUri
//			language.createLocalGenmodel
//			language.genmodelUris += language.getLocalGenmodelUri

			language.ecoreUri = language.externalEcoreUri
			language.genmodelUris += language.externalGenmodelUri
		}
		
		packageProvider.registerPackages(language,base)
		 
		/****************************
		 * STEP 5: merge aspects
		 ****************************/
		aspectWeaver.preProcess(language, false)
		
		history.remove(language)
	} 
	
	/**
	 * Check if {@link language} is a dependency of an other language
	 * and has this language as dependency at the same time
	 */
	private def boolean isWithCycle(Metamodel language, List<Metamodel> history){
		
		val List<Metamodel> dependencies = new ArrayList<Metamodel>()
		language.inheritanceRelation.forEach[inherit |
			dependencies.add(inherit.superMetamodel)
		]
		language.operators.filter(Merge).forEach[merge |
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
				res = registry.get(language)
			}
		}
		
		return res
	}
	
	/**
 	 * Copy/Past from ModelingElementExtension
 	 */
	static def EPackage createEcore(List<EPackage> pkgs, String uri, String pkgUri) {
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
	
	/**
	 * Return a copy of the part of language defined in {@link slice}
	 */
	private def EPackage applySlice(Slice slice, List<Metamodel> history){
		val sliceBase = EcoreUtil::copy(getRootPackage(slice.language,history))
		EcoreUtil.resolveAll(sliceBase)
		
		val roots = getClasses(sliceBase, slice.roots)
		val slicer = new StrictEcore(roots,sliceBase,false,"ecore",false)
		slicer.slice
		
		val res = slicer.getclonedElts.filter(EPackage).filter[eContainer===null].head
		EcoreUtil.resolveAll(slice)
		
		return res
	}
	
	/**
	 * Renames classes from {@link model} according to the rules from {@link mappingRules}
	 */
	private def void applyRenaming(EPackage model, List<ClassBinding> mappingRules){
		val allClasses = model.EClassifiers.filter(EClass).toList
			allClasses.addAll((model.allSubPkgs.map[EClassifiers].flatten.filter(EClass)))
		
		mappingRules.forEach[ rule |
			allClasses.filter[name == rule.from].forEach[ clazz |
				
				//Change name for properties
				rule.properties.forEach[propertyRule |
					val target = clazz.EReferences.findFirst[name == propertyRule.from]
					if(target == null) clazz.EAttributes.findFirst[name == propertyRule.from]
					
					if(target != null) target.name = propertyRule.to
				]
				
				//Change name for classes
				clazz.name = rule.to
			]
		]
	}
}