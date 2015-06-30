package fr.inria.diverse.melange.tests

import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.InjectWith
import fr.inria.diverse.melange.tests.common.MelangeTestsInjectorProvider
import fr.inria.diverse.melange.tools.xtext.testing.XtextTest
import fr.inria.diverse.melange.metamodel.melange.ModelTypingSpace
import org.junit.Test
import fr.inria.diverse.melange.metamodel.melange.Metamodel
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.common.util.URI
import fr.inria.diverse.melange.lib.MatchingHelper
import com.google.inject.Inject
import fr.inria.diverse.melange.ast.ModelingElementExtensions
import java.util.Collections
import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(MelangeTestsInjectorProvider)
@XtextTest(rootType = ModelTypingSpace, inputFile = "tests-inputs/melange/MergeTest.melange")
class MergeTest
{
	@Inject MatchingHelper helper
	@Inject extension ModelingElementExtensions
	
	@Test
	def void testPackagesSelfMatching() {
		val packagesPkg1 = "tests-inputs/metamodels/merge/MM1.ecore".loadEcore
		assertTrue(packagesPkg1.simpleMatch(MM1.exactType.pkgs.head))

		val packagesPkg2 = "tests-inputs/metamodels/merge/MM2.ecore".loadEcore
		assertTrue(packagesPkg2.simpleMatch(MM2.exactType.pkgs.head))
	}
	
	@Test
	def void testSelfMerge() {
		val packagesPkg1 = "tests-inputs/metamodels/merge/MM1.ecore".loadEcore
		assertTrue(packagesPkg1.simpleMatch(autoMerge1a.exactType.pkgs.head))
		assertTrue(packagesPkg1.simpleMatch(autoMerge1b.exactType.pkgs.head))

		val packagesPkg2 = "tests-inputs/metamodels/merge/MM2.ecore".loadEcore
		assertTrue(packagesPkg2.simpleMatch(autoMerge2a.exactType.pkgs.head))
		assertTrue(packagesPkg2.simpleMatch(autoMerge2b.exactType.pkgs.head))
	}
	
	@Test
	def void testImplements() {
		assertTrue(mergeLangA.implements.contains(MM1.exactType))
		assertTrue(mergeLangA.implements.contains(MM2.exactType))
	}
	
	@Test
	def void testStructuralCommutativity() {
		assertTrue(mergeLangA.implements.contains(mergeLangB.exactType))
		assertTrue(mergeLangB.implements.contains(mergeLangA.exactType))
	}
	
	@Test
	def void testEcore(){
		assertTrue(mergeEcore.implements.contains(MM1.exactType))
		assertTrue(mergeEcore.implements.contains(MM2.exactType))
		assertTrue(mergeEcore.implements.contains(mergeLangA.exactType))
		assertTrue(mergeEcore.implements.contains(mergeLangB.exactType))
	}
	
	@Test
	def void testBothMergeEcore() {
		assertTrue(bothLangA.implements.contains(MM1.exactType))
		assertTrue(bothLangA.implements.contains(MM2.exactType))
		assertTrue(bothLangA.implements.contains(mergeLangA.exactType))
		assertTrue(bothLangA.implements.contains(mergeLangB.exactType))
		
		assertTrue(bothLangB.implements.contains(MM1.exactType))
		assertTrue(bothLangB.implements.contains(MM2.exactType))
		assertTrue(bothLangB.implements.contains(mergeLangA.exactType))
		assertTrue(bothLangB.implements.contains(mergeLangB.exactType))
	}
	
	
	private def EPackage loadEcore(String uri) {
		val rs = new ResourceSetImpl
		val res = rs.getResource(URI.createURI(uri), true)

		return res.contents.head as EPackage
	}
	
	private def boolean simpleMatch(EPackage pkgA, EPackage pkgB) {
		return helper.match(Collections.singletonList(pkgA), Collections.singletonList(pkgB), null)
	}
	
	def Metamodel getMM1()         { return root.elements.get(0) as Metamodel }
	def Metamodel getMM2()         { return root.elements.get(1) as Metamodel }
	def Metamodel getAutoMerge1a() { return root.elements.get(2) as Metamodel }
	def Metamodel getAutoMerge1b() { return root.elements.get(3) as Metamodel }
	def Metamodel getAutoMerge2a() { return root.elements.get(4) as Metamodel }
	def Metamodel getAutoMerge2b() { return root.elements.get(5) as Metamodel }
	def Metamodel getMergeLangA()  { return root.elements.get(6) as Metamodel }
	def Metamodel getMergeLangB()  { return root.elements.get(7) as Metamodel }
	def Metamodel getMergeEcore()  { return root.elements.get(8) as Metamodel }
	def Metamodel getBothLangA()   { return root.elements.get(9) as Metamodel }
	def Metamodel getBothLangB()   { return root.elements.get(10) as Metamodel }
	
}