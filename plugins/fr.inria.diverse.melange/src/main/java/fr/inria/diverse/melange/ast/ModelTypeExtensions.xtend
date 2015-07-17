package fr.inria.diverse.melange.ast

import com.google.inject.Inject
import fr.inria.diverse.melange.algebra.ModelTypeAlgebra
import fr.inria.diverse.melange.lib.EcoreExtensions
import fr.inria.diverse.melange.metamodel.melange.ModelType
import java.util.List
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EPackage

class ModelTypeExtensions
{
	@Inject extension ModelingElementExtensions
	@Inject extension EcoreExtensions
	@Inject ModelTypeAlgebra algebra

	def String getUri(ModelType mt) {
		val userDefinedUri =
			if (mt.isExtracted) mt.extracted.exactTypeUri
			else mt.mtUri
		return userDefinedUri ?: '''http://«mt.name.toLowerCase»/'''
	}

	def boolean getIsComplete(ModelType mt) {
		return !mt.pkgs.filterNull.empty
	}

	def boolean isExtracted(ModelType mt) {
		return mt.extracted !== null
	}

	def boolean isImported(ModelType mt) {
		return mt.ecoreUri !== null
	}

	def List<EPackage> getAllSubPkgs(ModelType mt) {
		return mt.pkgs.head.allSubPkgs
	}

	def boolean isSubtypeOf(ModelType mt1, ModelType mt2) {
		return algebra.isSubtypeOf(mt1, mt2)
	}

	def EClassifier findClassifier(ModelType mt, String clsName) {
		return mt.allClassifiers.findFirst[name == clsName]
	}

	def EClass findClass(ModelType mt, String clsName) {
		return mt.allClasses.findFirst[name == clsName]
	}

	def List<EClassifier> getAllClassifiers(ModelType mt) {
		return mt.pkgs.map[EClassifiers].flatten.toList
	}

	def Iterable<EClass> getAllClasses(ModelType mt) {
		return mt.allClassifiers.filter(EClass)
	}

	def Iterable<EEnum> getAllEnums(ModelType mt) {
		return mt.allClassifiers.filter(EEnum)
	}
}
