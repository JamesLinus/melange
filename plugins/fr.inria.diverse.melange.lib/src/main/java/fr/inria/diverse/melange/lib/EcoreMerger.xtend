package fr.inria.diverse.melange.lib

import com.google.inject.ImplementedBy
import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.ecore.EAnnotation
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EParameter
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.emf.ecore.util.Diagnostician
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.lib.annotations.Data

@ImplementedBy(PackageMergeMerger)
interface EcoreMerger {
	/**
	 * Note: assuming that receiving and merged are valid wrt Ecore
	 */
	def EPackage merge(EPackage receiving, EPackage merged)
	def List<EPackage> merge(List<EPackage> receiving, List<EPackage> merged)
	def List<Conflict> getConflicts()

	@Data
	static class Conflict {
		EObject receiving
		EObject merged
		String message
		Diagnostic emfDiagnostic
	}
}

/**
 * Inspired from UML2.5 PackageMerge specification,
 * as refined by Dingel et al.
 * "Understanding and improving UML package merge"
 * 
 *   - If any constraint is violated, EcoreMergerException is thrown
 *   - Which implies that any resulting EPackage is valid
 *   - Receiving package and resulting package are *different*. The
 *     receiving package does not play a dual role. Thus, the constraints
 *     on cycle detection do not make sense.
 *   - Ignores generics
 *   - Ignores constraints
 *   - Resulting elements are checked wrt. EcoreValidator
 */
class PackageMergeMerger implements EcoreMerger {
	@Inject extension EcoreExtensions
	List<Conflict> conflicts
	static final String ORIGIN_ANNOTATION_SOURCE = "http://www.inria.fr/melange/origin"

	override merge(EPackage receiving, EPackage merged) {
		conflicts = newArrayList
		val resulting = EcoreUtil::copy(receiving)

		if (receiving === null || merged === null)
			return null
		if (receiving == merged || receiving.nsURI == merged.nsURI)
			addConflict(receiving, merged, "Cannot merge packages with same URI")
		if (receiving.allSubPkgs.contains(merged))
			addConflict(receiving, merged, "Receiving package cannot contain merged package")
		if (merged.allSubPkgs.contains(receiving))
			addConflict(receiving, merged, "Merged package cannot contain receiving package")
		// FIXME: We should check for forbidden cross-refs between receiving/merged
		//         but this is quite costly

		if (receiving.doMatch(merged))
			resulting.doMerge(merged)

		if (!conflicts.empty)
			return null

		resulting.updateReferences

		val diag = Diagnostician.INSTANCE.validate(resulting)
		if (diag.severity != Diagnostic::OK) {
			diag.children.forEach[d |
				val diagSource = d.data.head
				if (diagSource instanceof ENamedElement) {
					diagSource.EAnnotations.filter[source == ORIGIN_ANNOTATION_SOURCE].forEach[ann |
						addConflict(diagSource, ann.references.head as ENamedElement, d)
					]
				}
			]
			return null
		} else return resulting
	}

	def void updateReferences(EPackage pkg) {
		EcoreUtil.ExternalCrossReferencer.find(pkg).forEach[o, s |
			s.forEach[ss |
				if (ss.EStructuralFeature !== null && !ss.EStructuralFeature.derived && !ss.EStructuralFeature.many) {
					if (o instanceof EClassifier) {
						val corresponding = pkg.EClassifiers.findFirst[name == o.name]
						if (corresponding !== null)
							ss.EObject.eSet(ss.EStructuralFeature, corresponding)
					} else if (o instanceof EReference) {
						if (o.EOpposite !== null) {
							val correspondingCls = pkg.EClassifiers.findFirst[name == o.EContainingClass.name] as EClass
							val correspondingRef = correspondingCls.EReferences.findFirst[name == o.name]

							if (correspondingRef !== null)
								ss.EObject.eSet(ss.EStructuralFeature, correspondingRef)
						}
					}
				}
			]
		]
	}

	override merge(List<EPackage> receiving, List<EPackage> merged) {
		merged.forEach[mergedPkg |
			val correspondingPkg = receiving.findFirst[doMatch(mergedPkg)]

			if (correspondingPkg !== null)
				merge(correspondingPkg, mergedPkg)
			else
				receiving += EcoreUtil::copy(mergedPkg)
		]

		return receiving
	}

	private def dispatch boolean doMatch(ENamedElement rcv, ENamedElement merged) {
		return false
	}

	private def dispatch boolean doMatch(EPackage rcv, EPackage merged) {
		return rcv.name == merged.name
	}

	private def dispatch boolean doMatch(EClass rcv, EClass merged) {
		return rcv.name == merged.name
	}

	private def dispatch boolean doMatch(EDataType rcv, EDataType merged) {
		return rcv.name == merged.name
	}

	private def dispatch boolean doMatch(EEnum rcv, EEnum merged) {
		return rcv.name == merged.name
	}

	private def dispatch boolean doMatch(EAttribute rcv, EAttribute merged) {
		return
			   rcv.name == merged.name
			&& rcv.unique == merged.unique
			&& typesMatch(rcv.EType, merged.EType)
	}

	private def dispatch boolean doMatch(EReference rcv, EReference merged) {
		return
			   rcv.name == merged.name
			&& rcv.unique == merged.unique
			&& typesMatch(rcv.EType, merged.EType)
	}

	private def dispatch boolean doMatch(EOperation rcv, EOperation merged) {
		return
			   rcv.name == merged.name
			&& rcv.unique == merged.unique
			&& typesMatch(rcv.EType, merged.EType)
	}

	private def dispatch boolean doMatch(EParameter rcv, EParameter merged) {
		return rcv.name == merged.name
	}

	private def dispatch boolean doMatch(EAnnotation rcv, EAnnotation merged) {
		return false // TODO
	}

	private def boolean typesMatch(EClassifier eA, EClassifier eB) {
		return eA == eB || doTypesMatch(eA, eB)
	}

	private def dispatch boolean doTypesMatch(EClassifier eA, EClassifier eB) {
		return false
	}

	private def dispatch boolean doTypesMatch(EClass clsA, EClass clsB) {
		return
			   clsA.name == clsB.name
			|| clsA.EAllSuperTypes.exists[name == clsB.name]
	}

	private def dispatch boolean doTypesMatch(EDataType dtA, EDataType dtB) {
		// FIXME: Should we match instanceClass instead?
		return	dtA.name == dtB.name
	}

	private def dispatch boolean doTypesMatch(EEnum enumA, EEnum enumB) {
		return enumA.name == enumB.name
	}

	private def dispatch void doMerge(EPackage rcv, EPackage merged) {
		// TODO: what about URIs, prefix, etc. ?
		doCollectionsMerge(rcv, rcv.EClassifiers, merged.EClassifiers)
		doCollectionsMerge(rcv, rcv.ESubpackages, merged.ESubpackages)
	}

	private def dispatch void doMerge(EClass rcv, EClass merged) {
		// TODO: What about superTypes?
		rcv.abstract = rcv.abstract && merged.abstract
		rcv.interface = rcv.interface && merged.interface
		doCollectionsMerge(rcv, rcv.EStructuralFeatures, merged.EStructuralFeatures)
		doCollectionsMerge(rcv, rcv.EOperations, merged.EOperations)
	}

	private def dispatch void doMerge(EDataType rcv, EDataType merged) {
	}

	private def dispatch void doMerge(EEnum rcv, EEnum merged) {
	}

	private def dispatch void doMerge(EAttribute rcv, EAttribute merged) {
		rcv.derived = rcv.derived || merged.derived
		rcv.changeable = rcv.changeable && merged.changeable
		rcv.ordered = rcv.ordered || merged.ordered
		rcv.unique = rcv.ordered || merged.unique
		rcv.lowerBound = #[rcv.lowerBound, merged.lowerBound].min
		rcv.upperBound = maxBound(rcv.upperBound, merged.upperBound)
	}

	private def dispatch void doMerge(EReference rcv, EReference merged) {
		rcv.derived = rcv.derived || merged.derived
		rcv.changeable = rcv.changeable && merged.changeable
		rcv.ordered = rcv.ordered || merged.ordered
		rcv.unique = rcv.ordered || merged.unique
		rcv.lowerBound = #[rcv.lowerBound, merged.lowerBound].min
		rcv.upperBound = maxBound(rcv.upperBound, merged.upperBound)
	}

	private def dispatch void doMerge(EOperation rcv, EOperation merged) {
		rcv.ordered = rcv.ordered || merged.ordered
		rcv.unique = rcv.ordered || merged.unique
	}

	private def dispatch void doMerge(EParameter rcv, EParameter merged) {
	}

	private def dispatch void doMerge(EAnnotation rcv, EAnnotation merged) {
	}

	private def <T extends ENamedElement> void deepCopy(ENamedElement context, List<T> receiving, T merged) {
		receiving += EcoreUtil::copy(merged)
		context.EAnnotations += EcoreFactory.eINSTANCE.createEAnnotation => [
			source = ORIGIN_ANNOTATION_SOURCE
			references += merged
		]
	}

	private def <T extends ENamedElement> void doCollectionsMerge(ENamedElement context, List<T> rcv, List<T> merged) {
		merged.forEach[m |
			val match = rcv.findFirst[r | r.doMatch(m)]

			if (match !== null)
				match.doMerge(m)
			else
				deepCopy(context, rcv, m)
		]
	}

	private def int maxBound(int a, int b) {
		return
			if (a == -1 || b == -1) -1
			else #[a, b].max
	}

	private def void addConflict(ENamedElement rcv, ENamedElement merged, String message) {
		addConflict(rcv, merged, message, null)
	}

	private def void addConflict(ENamedElement rcv, ENamedElement merged, Diagnostic d) {
		addConflict(
			rcv,
			merged,
			'''Cannot merge «merged.uniqueId» with «rcv.uniqueId»: «d.message»''',
			d
		)
	}

	private def void addConflict(ENamedElement rcv, ENamedElement merged, String message, Diagnostic d) {
		conflicts += new Conflict(rcv, merged, message, d)
	}

	override List<Conflict> getConflicts() {
		return conflicts
	}
}
