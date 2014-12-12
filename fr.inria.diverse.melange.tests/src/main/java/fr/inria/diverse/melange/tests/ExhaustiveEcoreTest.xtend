package fr.inria.diverse.melange.tests

import com.google.inject.Inject

import exhaustive.AbstractTest
import exhaustive.AttributesTest
//import exhaustive.GenericChildTest
import exhaustive.GenericTest
import exhaustive.InterfaceTest
import exhaustive.MultipleSuperTest
import exhaustive.OperationsTest
import exhaustive.ReferencesTest
import exhaustive.SerializableEnumTest
import exhaustive.UnserializableEnumTest

import fr.inria.diverse.melange.lib.GenericAdapter
import fr.inria.diverse.melange.lib.IModelType
import fr.inria.diverse.melange.lib.ListAdapter

import fr.inria.diverse.melange.metamodel.melange.Metamodel
import fr.inria.diverse.melange.metamodel.melange.ModelType
import fr.inria.diverse.melange.metamodel.melange.ModelTypingSpace
import fr.inria.diverse.melange.metamodel.melange.Transformation

import fr.inria.diverse.melange.tests.common.MelangeTestHelper
import fr.inria.diverse.melange.tests.common.MelangeTestsInjectorProvider

import fr.inria.diverse.k3.tools.xtext.testing.XtextTest

import org.eclipse.emf.common.util.EList

import org.eclipse.emf.ecore.EObject

import org.eclipse.emf.ecore.resource.Resource

import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl

import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.InMemoryFileSystemAccess

import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner

import org.junit.Test

import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(MelangeTestsInjectorProvider)
@XtextTest(rootType = ModelTypingSpace, inputFile = "tests-inputs/melange/ExhaustiveEcoreTest.melange")
class ExhaustiveEcoreTest
{
	@Inject extension MelangeTestHelper
	@Inject IGenerator generator

	@Test
	def testStructure() {
		assertNotNull(root)
		assertEquals(root.name, "exhaustiveecoretest")
		assertNotNull(root.imports)

		assertTrue(root.elements.get(0) instanceof Metamodel)
		assertTrue(root.elements.get(1) instanceof Metamodel)
		assertTrue(root.elements.get(2) instanceof Transformation)
		assertTrue(root.elements.get(3) instanceof ModelType)
		assertTrue(root.elements.get(4) instanceof ModelType)

		assertEquals(exhaustive.name,    "Exhaustive")
		assertEquals(exhaustive2.name,   "Exhaustive2")
		assertEquals(test.name,          "test")
		assertEquals(exhaustiveMt.name,  "ExhaustiveMT")
		assertEquals(exhaustive2Mt.name, "Exhaustive2MT")
	}

	@Test
	def testRelations() {
		assertEquals(exhaustive.exactType,    exhaustiveMt)
		assertEquals(exhaustive2.exactType,   exhaustive2Mt)
		assertEquals(exhaustiveMt.extracted,  exhaustive)
		assertEquals(exhaustive2Mt.extracted, exhaustive2)
	}

	@Test
	def testImplements() {
		assertEquals(exhaustive.^implements.size, 2)
		assertTrue(exhaustive.^implements.contains(exhaustiveMt))
		assertTrue(exhaustive.^implements.contains(exhaustive2Mt))

		assertEquals(exhaustive2.^implements.size, 2)
		assertTrue(exhaustive2.^implements.contains(exhaustiveMt))
		assertTrue(exhaustive2.^implements.contains(exhaustive2Mt))
	}

	@Test
	def testInheritance() {
		assertNull(exhaustive.inheritanceRelation)
		assertNull(exhaustive2.inheritanceRelation)
	}

	@Test
	def testSubtyping() {
		assertEquals(exhaustiveMt.subtypingRelations.size, 1)
		assertTrue(exhaustiveMt.subtypingRelations.map[superType].contains(exhaustive2Mt))

		assertEquals(exhaustive2Mt.subtypingRelations.size, 1)
		assertTrue(exhaustive2Mt.subtypingRelations.map[superType].contains(exhaustiveMt))
	}

	@Test
	def testGeneration() {
		val fsa = new InMemoryFileSystemAccess
		generator.doGenerate(root.eResource, fsa)

		assertEquals(fsa.textFiles.size, 67)
	}

	// Won't compile until generics are implented
	@Test
	def testRuntime() {
		try {
			// Consider moving these runtime dependencies somewhere else
			setJavaCompilerClassPath(
				typeof(AbstractTest),
				typeof(AttributesTest),
				//typeof(GenericChildTest),
				typeof(GenericTest),
				typeof(InterfaceTest),
				typeof(MultipleSuperTest),
				typeof(OperationsTest),
				typeof(ReferencesTest),
				typeof(SerializableEnumTest),
				typeof(UnserializableEnumTest),
				IModelType,
				GenericAdapter,
				ListAdapter,
				Resource,
				EObject,
				EList,
				Exceptions,
				IterableExtensions,
				XMIResourceFactoryImpl
			)
			inputSequence.compile[
				initialize("exhaustiveecoretest.test")
			]
		} catch (Exception e) {
			e.printStackTrace
			fail(e.message)
		}
	}

	def getExhaustive()    { root.elements.get(0) as Metamodel }
	def getExhaustive2()   { root.elements.get(1) as Metamodel }
	def getTest()          { root.elements.get(2) as Transformation }
	def getExhaustiveMt()  { root.elements.get(3) as ModelType }
	def getExhaustive2Mt() { root.elements.get(4) as ModelType }
}
