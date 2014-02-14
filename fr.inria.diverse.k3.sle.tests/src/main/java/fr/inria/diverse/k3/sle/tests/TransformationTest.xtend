package fr.inria.diverse.k3.sle.tests

import fr.inria.diverse.k3.sle.K3SLEInjectorProvider

import fr.inria.diverse.k3.sle.metamodel.k3sle.MegamodelRoot
import fr.inria.diverse.k3.sle.metamodel.k3sle.Transformation

import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper

import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.InMemoryFileSystemAccess

import org.eclipse.xtext.xbase.compiler.CompilationTestHelper

import java.lang.reflect.Modifier

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import com.google.inject.Inject

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(K3SLEInjectorProvider)
class TransformationTest
{
	@Inject extension ParseHelper<MegamodelRoot>
	@Inject extension ValidationTestHelper
	@Inject IGenerator generator
	@Inject CompilationTestHelper compiler
	CharSequence input
	MegamodelRoot root

	@Before
	def void setUp() {
		input = '''
		package foo

		import static extension fr.inria.diverse.k3.sle.lib.MetamodelExtensions.*

		transformation foo() {
			val x = 2
			bar.call("foo")
		}
		
		transformation bar(String s) {
			System.out.println(s)
		}
		
		transformation String baz() {
			return "baz"
		}
		
		@Main
		transformation main() {
			val x = "bar"
			
			foo.call
			bar.call(x)
			bar.call(baz.call)
		}
		'''

		root = input.parse

		compiler.setJavaCompilerClassPath(
			org.eclipse.emf.ecore.resource.Resource,
			org.eclipse.emf.common.notify.Notifier,
			org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
		)
	}

	@Test
	def testParsing() {
		root.assertNoErrors
	}

	@Test
	def testStructure() {
		(0..3).forEach[assertTrue(root.elements.get(it) instanceof Transformation)]
	}

	// Just to show how we can generate code
	@Test
	def testGeneration() {
		val fsa = new InMemoryFileSystemAccess
		generator.doGenerate(root.eResource, fsa)

		assertEquals(fsa.allFiles.size, 4)

		// Debug output
		fsa.allFiles.forEach[filename, content |
			println('''
				Generated «filename»:
				«content»
			''')
		]
	}

	@Test
	def testFooCompilation() {
		compiler.compile(input)[
			val foo = getCompiledClass("foo.foo")

			assertNotNull(foo)
			assertEquals(foo.declaredMethods.size, 1)

			val call = foo.declaredMethods.head
			assertEquals(call.name, "call")
			assertEquals(call.returnType, Void::TYPE)
			assertEquals(call.parameterTypes.size, 0)
			assertTrue(Modifier.isStatic(call.modifiers))
			assertTrue(Modifier.isPublic(call.modifiers))
		]
	}

	@Test
	def testBarCompilation() {
		compiler.compile(input)[
			val bar = getCompiledClass("foo.bar")

			assertNotNull(bar)
			assertEquals(bar.declaredMethods.size, 1)

			val call = bar.declaredMethods.head
			assertEquals(call.name, "call")
			assertEquals(call.returnType, Void::TYPE)
			assertEquals(call.parameterTypes.size, 1)
			assertEquals(call.parameterTypes.head, typeof(String))
			assertTrue(Modifier.isStatic(call.modifiers))
			assertTrue(Modifier.isPublic(call.modifiers))
		]
	}

	@Test
	def testBazCompilation() {
		compiler.compile(input)[
			val baz = getCompiledClass("foo.baz")

			assertNotNull(baz)
			assertEquals(baz.declaredMethods.size, 1)

			val call = baz.declaredMethods.head
			assertEquals(call.name, "call")
			assertEquals(call.returnType, typeof(String))
			assertEquals(call.parameterTypes.size, 0)
			assertTrue(Modifier.isStatic(call.modifiers))
			assertTrue(Modifier.isPublic(call.modifiers))
		]
	}

	@Test
	def testMainCompilation() {
		compiler.compile(input)[
			val mainC = getCompiledClass("foo.main")

			assertNotNull(mainC)
			assertEquals(mainC.declaredMethods.size, 2)

			val call = mainC.declaredMethods.findFirst[name == "call"]
			assertNotNull(call)
			assertEquals(call.name, "call")
			assertEquals(call.returnType, Void::TYPE)
			assertTrue(Modifier.isStatic(call.modifiers))
			assertTrue(Modifier.isPublic(call.modifiers))

			val main = mainC.declaredMethods.findFirst[name == "main"]
			assertNotNull(main)
			assertEquals(main.name, "main")
			assertEquals(main.returnType, Void::TYPE)
			assertEquals(main.parameterTypes.size, 1)
			assertEquals(main.parameterTypes.head, typeof(String[]))
			assertTrue(Modifier.isStatic(main.modifiers))
			assertTrue(Modifier.isPublic(main.modifiers))
		]
	}
}
