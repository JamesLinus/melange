package fr.inria.diverse.k3.sle.ast

import fr.inria.diverse.k3.sle.metamodel.k3sle.ModelType
import fr.inria.diverse.k3.sle.lib.ModelUtils

import static extension fr.inria.diverse.k3.sle.lib.EcoreExtensions.*
import fr.inria.diverse.k3.sle.lib.MatchingHelper
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier

class ModelTypeExtensions
{
	// TODO
	static def isValid(ModelType mt) {
		true
	}

	// TODO FootprintedMT
	static def completeAST(ModelType mt) {
		if (mt.isImported) {
			val pkg = ModelUtils.loadPkg(mt.ecore.uri)

			if (!mt.pkgs.exists[nsURI == pkg.nsURI])
				mt.pkgs += pkg

			pkg.referencedPkgs.forEach[p |
				if (!mt.pkgs.exists[nsURI == p.nsURI])
					mt.pkgs += p
			]
		} else if (mt.isExtracted) {
			mt.extracted.pkgs.forEach[p |
				if (!mt.pkgs.exists[nsURI == p.nsURI])
					mt.pkgs += p.copy
			]
		}
	}

	static def isExtracted(ModelType mt) {
		mt.extracted !== null
	}

	static def isImported(ModelType mt) {
		mt.ecore !== null
	}

	// FIXME: More than one pkg BRO
	static def subtypeOf(ModelType mt1, ModelType mt2) {
		val x = new MatchingHelper
		x.match(mt1.pkgs.head, mt2.pkgs.head)
	}

	static def findClassifier(ModelType mt, String clsName) {
		mt.allClassifiers.findFirst[name == clsName]
	}

	static def findClass(ModelType mt, String clsName) {
		mt.allClasses.findFirst[name == clsName]
	}

	static def getAllClassifiers(ModelType mt) {
		mt.pkgs.map[EClassifiers].flatten
	}

	static def getAllClasses(ModelType mt) {
		mt.allClassifiers.filter(EClass)
	}

	static def isUml(ModelType mt, EClassifier cls) {
		val pkg = mt.pkgs.findFirst[EClassifiers.exists[name == cls.name]]
		return pkg.name == "uml"
	}
}
