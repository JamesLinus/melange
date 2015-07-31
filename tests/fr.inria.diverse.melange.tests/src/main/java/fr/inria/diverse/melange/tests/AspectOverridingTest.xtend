package fr.inria.diverse.melange.tests

import com.google.inject.Inject
import fr.inria.diverse.melange.ast.ModelingElementExtensions
import fr.inria.diverse.melange.lib.MatchingHelper
import fr.inria.diverse.melange.metamodel.melange.Language
import fr.inria.diverse.melange.metamodel.melange.MelangePackage
import fr.inria.diverse.melange.metamodel.melange.Metamodel
import fr.inria.diverse.melange.metamodel.melange.ModelTypingSpace
import fr.inria.diverse.melange.tests.common.MelangeTestsInjectorProvider
import fr.inria.diverse.melange.tools.xtext.testing.XtextTest
import fr.inria.diverse.melange.validation.MelangeValidationConstants
import java.util.Collections
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(MelangeTestsInjectorProvider)
@XtextTest(rootType = ModelTypingSpace, inputFile = "tests-inputs/melange/AspectOverridingTest.melange")
class AspectOverridingTest
{
	@Inject MatchingHelper helper
	@Inject extension ModelingElementExtensions
	
	@Test
	def void testInheritAttributeOverride(){
		assertError(inheritsOverriding.semantics.get(0),
					MelangePackage.eINSTANCE.aspect,
					MelangeValidationConstants.MERGE_ATTRIBUTE_OVERRIDING,
					"Aspect \'fr.inria.diverse.melange.tests.aspect.merge.AttributesTestAspect\' has an attribute \'changeableYes\' typed String but in \'Exhaustive\' it is typed EDouble"
		)
	}
	@Test
	def void testInheritReferenceOverride(){
		assertError(inheritsOverriding.semantics.get(0),
					MelangePackage.eINSTANCE.aspect,
					MelangeValidationConstants.MERGE_REFERENCE_OVERRIDING,
					"Aspect \'fr.inria.diverse.melange.tests.aspect.merge.ReferencesTestAspect\' has a reference \'upperBoundN\' typed OperationsTest but in \'Exhaustive\' it is typed AttributesTest"
		)
	}
	@Test
	def void testInheritOperationOverride(){
		assertError(inheritsOverriding.semantics.get(0),
					MelangePackage.eINSTANCE.aspect,
					MelangeValidationConstants.MERGE_OPERATION_OVERRIDING,
					"Aspect \'fr.inria.diverse.melange.tests.aspect.merge.OperationsTestAspect\' has an operation \'lowerBound1\' typed boolean but in \'Exhaustive\' it is typed Void"
		)
	}
	@Test
	def void testInheritOperationManyOverride(){
		assertError(inheritsOverriding.semantics.get(0),
					MelangePackage.eINSTANCE.aspect,
					MelangeValidationConstants.MERGE_OPERATION_OVERRIDING,
					"Aspect \'fr.inria.diverse.melange.tests.aspect.merge.OperationsTestAspect\' has an operation \'manyParameters\' typed String but in \'Exhaustive\' it is typed Void"
		)
	}
	
	@Test
	def void testMergeAttributeOverride(){
		assertError(mergeOverriding.semantics.get(0),
					MelangePackage.eINSTANCE.aspect,
					MelangeValidationConstants.MERGE_ATTRIBUTE_OVERRIDING,
					"Aspect \'fr.inria.diverse.melange.tests.aspect.merge.AttributesTestAspect\' has an attribute \'changeableYes\' typed String but in \'Exhaustive\' it is typed EDouble"
		)
	}
	@Test
	def void testMergeReferenceOverride(){
		assertError(mergeOverriding.semantics.get(0),
					MelangePackage.eINSTANCE.aspect,
					MelangeValidationConstants.MERGE_REFERENCE_OVERRIDING,
					"Aspect \'fr.inria.diverse.melange.tests.aspect.merge.ReferencesTestAspect\' has a reference \'upperBoundN\' typed OperationsTest but in \'Exhaustive\' it is typed AttributesTest"
		)
	}
	@Test
	def void testMergeOperationOverride(){
		assertError(mergeOverriding.semantics.get(0),
					MelangePackage.eINSTANCE.aspect,
					MelangeValidationConstants.MERGE_OPERATION_OVERRIDING,
					"Aspect \'fr.inria.diverse.melange.tests.aspect.merge.OperationsTestAspect\' has an operation \'lowerBound1\' typed boolean but in \'Exhaustive\' it is typed Void"
		)
	}
	@Test
	def void testMergeOperationManyOverride(){
		assertError(mergeOverriding.semantics.get(0),
					MelangePackage.eINSTANCE.aspect,
					MelangeValidationConstants.MERGE_OPERATION_OVERRIDING,
					"Aspect \'fr.inria.diverse.melange.tests.aspect.merge.OperationsTestAspect\' has an operation \'manyParameters\' typed String but in \'Exhaustive\' it is typed Void"
		)
	}
	
	@Test
	def void testSliceAttributeOverride(){
		assertError(sliceOverriding.semantics.get(0),
					MelangePackage.eINSTANCE.aspect,
					MelangeValidationConstants.MERGE_ATTRIBUTE_OVERRIDING,
					"Aspect \'fr.inria.diverse.melange.tests.aspect.merge.AttributesTestAspect\' has an attribute \'changeableYes\' typed String but in \'Exhaustive\' it is typed EDouble"
		)
	}
	@Test
	def void testSliceReferenceOverride(){
		assertError(sliceOverriding.semantics.get(0),
					MelangePackage.eINSTANCE.aspect,
					MelangeValidationConstants.MERGE_REFERENCE_OVERRIDING,
					"Aspect \'fr.inria.diverse.melange.tests.aspect.merge.ReferencesTestAspect\' has a reference \'upperBoundN\' typed OperationsTest but in \'Exhaustive\' it is typed AttributesTest"
		)
	}
	@Test
	def void testSliceOperationOverride(){
		assertError(sliceOverriding.semantics.get(0),
					MelangePackage.eINSTANCE.aspect,
					MelangeValidationConstants.MERGE_OPERATION_OVERRIDING,
					"Aspect \'fr.inria.diverse.melange.tests.aspect.merge.OperationsTestAspect\' has an operation \'lowerBound1\' typed boolean but in \'Exhaustive\' it is typed Void"
		)
	}
	@Test
	def void testSliceOperationManyOverride(){
		assertError(sliceOverriding.semantics.get(0),
					MelangePackage.eINSTANCE.aspect,
					MelangeValidationConstants.MERGE_OPERATION_OVERRIDING,
					"Aspect \'fr.inria.diverse.melange.tests.aspect.merge.OperationsTestAspect\' has an operation \'manyParameters\' typed String but in \'Exhaustive\' it is typed Void"
		)
	}
	
	
	private def EPackage loadEcore(String uri) {
		val rs = new ResourceSetImpl
		val res = rs.getResource(URI.createURI(uri), true)

		return res.contents.head as EPackage
	}
	
	private def boolean simpleMatch(EPackage pkgA, EPackage pkgB) {
		return helper.match(Collections.singletonList(pkgA), Collections.singletonList(pkgB), null)
	}
	
	def Language getExhaustive()         { return root.elements.get(0) as Language }
	def Language getInheritsOverriding() { return root.elements.get(1) as Language }
	def Language getMergeOverriding()    { return root.elements.get(2) as Language }
	def Language getSliceOverriding()    { return root.elements.get(3) as Language }
	
}