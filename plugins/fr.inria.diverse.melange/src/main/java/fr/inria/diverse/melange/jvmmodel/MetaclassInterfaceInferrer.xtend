package fr.inria.diverse.melange.jvmmodel

import com.google.inject.Inject
import fr.inria.diverse.melange.ast.NamingHelper
import fr.inria.diverse.melange.lib.EcoreExtensions
import fr.inria.diverse.melange.metamodel.melange.ModelType
import org.eclipse.emf.common.util.EMap
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.util.internal.Stopwatches
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder

/**
 * This class manages creation of Java interface corresponding to Object type. 
 */
class MetaclassInterfaceInferrer
{
	@Inject extension JvmModelInferrerHelper
	@Inject extension JvmTypesBuilder
	@Inject extension NamingHelper
	@Inject extension EcoreExtensions
	@Inject extension MelangeTypesBuilder

	/**
	 * Creates an interface based on elements defined in {@link cls} and provide it to {@link acceptor}
	 * 
	 * @param mt Model type
	 * @param cls Metaclass corresponding to an Object type in {@link mt}
	 * @param acceptor 
	 * @param builder
	 */
	def void generateInterface(ModelType mt, EClass cls, IJvmDeclaredTypeAcceptor acceptor, extension JvmTypeReferenceBuilder builder) {
		val task = Stopwatches.forTask("generate metaclass interfaces")
		task.start

		acceptor.accept(mt.toInterface(mt.interfaceNameFor(cls))[intf |
			intf.superTypes += EObject.typeRef
		])[intf |
			cls.ETypeParameters.forEach[p |
				intf.typeParameters += TypesFactory::eINSTANCE.createJvmTypeParameter => [name = p.name]
			]

			cls.EGenericSuperTypes.forEach[sup |
				intf.superTypes += mt.interfaceNameFor(sup.EClassifier as EClass).typeRef(
					sup.ETypeArguments.map[arg | mt.typeRef(arg, #[intf])]
				)
			]

			cls.EAttributes.forEach[attr |
				val attrType = mt.typeRef(attr, #[intf])

				intf.members += mt.toGetterSignature(attr, attrType)

				if (attr.needsSetter)
					intf.members += mt.toSetterSignature(attr, attrType)

				if (attr.needsUnsetter)
					intf.members += mt.toUnsetterSignature(attr)

				if (attr.needsUnsetterChecker)
					intf.members += mt.toUnsetterCheckSignature(attr)
			]

			cls.EReferences.forEach[ref |
				val refType = mt.typeRef(ref, #[intf])

				if (ref.isEMFMapDetails) // Special case: EMF Map$Entry
					intf.members += mt.toMethod("getDetails", EMap.typeRef(String.typeRef, String.typeRef))[^abstract = true]
				else
					intf.members += mt.toGetterSignature(ref, refType)

				if (ref.needsSetter)
					intf.members += mt.toSetterSignature(ref, refType)

				if (ref.needsUnsetter)
					intf.members += mt.toUnsetterSignature(ref)

				if (ref.needsUnsetterChecker)
					intf.members += mt.toUnsetterCheckSignature(ref)
			]

			cls.EOperations.filter[!hasSuppressedVisibility].forEach[op |
				val opName = if (!cls.EPackage.isUml) op.name else op.formatUmlOperationName

				intf.members += mt.toMethod(opName, null)[m |
					op.ETypeParameters.forEach[t |
						m.typeParameters += TypesFactory.eINSTANCE.createJvmTypeParameter => [tp |
							tp.name = t.name
						]
					]

					op.ETypeParameters.forEach[t |
						t.EBounds
						.forEach[b |
							val tp = m.typeParameters.findFirst[name == t.name]

							if (b.EClassifier !== null) {
								tp.constraints += TypesFactory.eINSTANCE.createJvmUpperBound => [
									typeReference = mt.typeRef(b, #[m, intf])
								]
							} else if (b.ETypeParameter !== null) {
								tp.constraints += TypesFactory.eINSTANCE.createJvmUpperBound => [
									typeReference = createTypeParameterReference(#[m, intf], b.ETypeParameter.name)
								]
							}
						]
					]

					op.EParameters.forEach[p |
						m.parameters += mt.toParameter(p.name, mt.typeRef(p, #[m, intf]))
					]

					op.EExceptions.forEach[e |
						m.exceptions += mt.typeRef(e, #[m, intf])
					]

					// TODO: Manage generic exceptions
					op.EGenericExceptions.forEach[e |]
				] => [m |
					m.returnType = mt.typeRef(op, #[m, intf])
				]
			]
		]

		task.stop
	}

//	def boolean +=(EList<JvmMember> members, JvmOperation m) {
//		if (!members.filter(JvmOperation).exists[overrides(m)])
//			members += (m as JvmMember)
//
//		return false
//	}
}
