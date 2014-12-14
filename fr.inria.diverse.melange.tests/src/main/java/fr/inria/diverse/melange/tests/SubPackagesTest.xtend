package fr.inria.diverse.melange.tests

import com.google.inject.Inject

import fr.inria.diverse.melange.lib.GenericAdapter
import fr.inria.diverse.melange.lib.IModelType
import fr.inria.diverse.melange.lib.ListAdapter

import fr.inria.diverse.melange.metamodel.melange.ModelTypingSpace

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

import toppkg.TopClass1
import toppkg.TopClass2

import toppkg.subpkg1.Subpkg1Class1
import toppkg.subpkg1.Subpkg1Class2

import toppkg.subpkg2.Subpkg2Class1
import toppkg.subpkg2.Subpkg2Class2

import toppkg.subpkg2.subpkg3.Subpkg3Class1
import toppkg.subpkg2.subpkg3.Subpkg3Class2

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(MelangeTestsInjectorProvider)
@XtextTest(rootType = ModelTypingSpace, inputFile = "tests-inputs/melange/SubPackagesTest.melange")
class SubPackagesTest
{
	@Inject extension MelangeTestHelper
	@Inject IGenerator generator

	@Test
	def void testGeneration() {
		val fsa = new InMemoryFileSystemAccess
		generator.doGenerate(root.eResource, fsa)

		assertEquals(fsa.textFiles.size, 27)
	}

	@Test
	def void testRuntime() {
		try {
			// Consider moving these runtime dependencies somewhere else
			setJavaCompilerClassPath(
				typeof(TopClass1),
				typeof(TopClass2),
				typeof(Subpkg1Class1),
				typeof(Subpkg1Class2),
				typeof(Subpkg2Class1),
				typeof(Subpkg2Class2),
				typeof(Subpkg3Class1),
				typeof(Subpkg3Class2),
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
				initialize("subpackagestest.test")

				val m1 = invokeTransfo("subpackagestest.loadTopPkg")
				val m2 = invokeTransfo("subpackagestest.loadSubPkg2")
				val m3 = invokeTransfo("subpackagestest.loadSubPkg3")

				assertNotNull(m1)
				assertNotNull(m2)
				assertNotNull(m3)

				val String a1 = invokeTransfo("subpackagestest.adapterName", #["subpackagestest.SubPackagesTestMT"], #[m1])
				val String a2 = invokeTransfo("subpackagestest.adapterName", #["subpackagestest.SubPackagesTestMT"], #[m2])
				val String a3 = invokeTransfo("subpackagestest.adapterName", #["subpackagestest.SubPackagesTestMT"], #[m3])

				assertTrue(a1.contains("TopClass1Adapter"))
				assertTrue(a2.contains("Subpkg2Class1Adapter"))
				assertTrue(a3.contains("Subpkg3Class1Adapter"))
			]
		} catch (Exception e) {
			e.printStackTrace
			fail(e.message)
		}
	}
}
