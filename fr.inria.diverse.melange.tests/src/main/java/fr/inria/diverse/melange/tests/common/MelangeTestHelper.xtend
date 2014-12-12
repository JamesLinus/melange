package fr.inria.diverse.melange.tests.common

import fr.inria.diverse.melange.metamodel.melange.ModelTypingSpace
import fr.inria.diverse.melange.metamodel.melange.Metamodel
import fr.inria.diverse.melange.metamodel.melange.ModelType
import fr.inria.diverse.melange.metamodel.melange.Transformation

import org.eclipse.xtext.xbase.compiler.CompilationTestHelper$Result

import java.util.List

class MelangeTestHelper
{
	def mm(ModelTypingSpace root, String mmName) {
		root.elements.filter(Metamodel).findFirst[name == mmName]
	}

	def mt(ModelTypingSpace root, String mtName) {
		root.elements.filter(ModelType).findFirst[name == mtName]
	}

	def t(ModelTypingSpace root, String tName) {
		root.elements.filter(Transformation).findFirst[name == tName]
	}

	def initialize(Result res, String cls) {
		val String[] p = null
		res.getCompiledClass(cls)?.getMethod("main", typeof(String[]))?.invoke(null, p as Object)
	}

	def <T> T invokeTransfo(Result res, String cls) {
		res.getCompiledClass(cls)?.getMethod("call", null)?.invoke(null, null) as T
	}

	def <T> T invokeTransfo(Result res, String cls, List<String> pTypes, List<Object> pValues) {
		res.getCompiledClass(cls)?.getMethod("call", pTypes.map[res.getCompiledClass(it)])?.invoke(null, pValues?.toArray) as T
	}
}
