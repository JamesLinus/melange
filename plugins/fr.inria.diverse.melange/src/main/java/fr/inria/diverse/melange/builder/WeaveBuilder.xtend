package fr.inria.diverse.melange.builder

import com.google.inject.Inject
import fr.inria.diverse.melange.ast.AspectExtensions
import fr.inria.diverse.melange.lib.EcoreExtensions
import fr.inria.diverse.melange.metamodel.melange.Weave
import fr.inria.diverse.melange.utils.AspectToEcore
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EPackage
import org.eclipse.xtext.common.types.JvmDeclaredType
import java.util.Set

/**
 * Builder for the {@link Weave} operator.
 */
class WeaveBuilder extends OperatorBuilder<Weave> {
	@Inject extension AspectExtensions
	@Inject extension AspectToEcore
	@Inject extension EcoreExtensions
	/**
	 * The {@link EPackage}s on which the aspect pointed by the current
	 * {@link Weave} operator should be woven.
	 */
	Set<EPackage> baseModel

	new(Weave op, Set<EPackage> baseModel) {
		super(op)
		this.baseModel = baseModel
	}

	/**
	 * Process the current {@link Weave} operator and build the fragment
	 * of {@link EPackage} corresponding to it.
	 */
	override make() {
		val aspRef = source.aspectTypeRef

		if (aspRef?.type instanceof JvmDeclaredType) {
			val className = aspRef.getAspectAnnotationValue

			val baseClass = if (className !== null) baseModel.findClass(className)
			val aspect = aspRef.type as JvmDeclaredType
			model = newHashSet(aspect.inferEcoreFragment(baseClass, baseModel))

			alignInferredClassifiers(baseModel, model)
		}
	}

	/**
	 * Because aspect inference happens sequentially, one may infer
	 * a concept as a datatype and the other as a plain class.
	 * Thus, we need to align the inferred types, classes taking priority
	 * over datatypes.
	 */
	private def void alignInferredClassifiers(Set<EPackage> base, Set<EPackage> fragment) {
		val find = fragment.map[EClassifiers].flatten.filter(EDataType).findFirst[dt |
			fragment.map[EClassifiers].flatten.filter(EClass).exists[cls | cls.name == dt.name]
		]

		if (find !== null)
			replaceDataTypeWithEClass(fragment, find)

		fragment.map[EClassifiers].flatten.forEach[cls1 |
			val cls2 = base.map[EClassifiers].flatten.findFirst[cls2 | cls2.name == cls1.name && cls2.eClass !== cls1.eClass]
			if (cls2 !== null) {
				if (cls2 instanceof EClass) {
					if (cls1 instanceof EDataType)
						replaceDataTypeWithEClass(fragment, cls1)
				} else if (cls1 instanceof EClass) {
					if (cls2 instanceof EDataType)
						replaceDataTypeWithEClass(base, cls2)
				}
			}
		]
	}

	def Weave getSource() {
		return source
	}
}
