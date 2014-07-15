package fr.inria.diverse.k3.sle.typing

import com.google.inject.Inject

import fr.inria.diverse.k3.sle.ast.ASTHelper
import fr.inria.diverse.k3.sle.ast.ASTProcessingException
import fr.inria.diverse.k3.sle.ast.MetamodelExtensions
import fr.inria.diverse.k3.sle.ast.ModelTypeExtensions

import fr.inria.diverse.k3.sle.lib.EcoreExtensions
import fr.inria.diverse.k3.sle.lib.ModelUtils

import fr.inria.diverse.k3.sle.metamodel.k3sle.K3sleFactory
import fr.inria.diverse.k3.sle.metamodel.k3sle.Metamodel
import fr.inria.diverse.k3.sle.metamodel.k3sle.ModelType
import fr.inria.diverse.k3.sle.metamodel.k3sle.ModelTypingSpace
import fr.inria.diverse.k3.sle.metamodel.k3sle.ResourceType
import fr.inria.diverse.k3.sle.metamodel.k3sle.Transformation

import fr.inria.diverse.k3.sle.utils.AspectToEcore

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EcoreFactory

import org.eclipse.xtext.common.types.JvmDeclaredType
import fr.inria.diverse.k3.sle.algebra.ModelTypeAlgebra

class K3SLETyping
{
	@Inject extension ASTHelper
	@Inject extension MetamodelExtensions
	@Inject extension ModelTypeExtensions
	@Inject extension EcoreExtensions
	@Inject extension AspectToEcore
	@Inject ModelUtils modelUtils
	@Inject ModelTypeAlgebra algebra

	def inferTypingRelations(ModelTypingSpace root) {
		root.modelTypes
		.forEach[mt1 |
			root.modelTypes
			.filter[mt2 | mt2 != mt1 && !mt1.subtypingRelations.exists[superType?.name == mt2?.name] && mt1.subtypeOf(mt2)]
			.forEach[mt2 |
				mt1.subtypingRelations += K3sleFactory.eINSTANCE.createSubtyping => [
					subType = mt1
					superType = mt2
				]
			]

			root.metamodels
			.filter[mm | !mm.^implements.exists[name == mt1.name] && mm.typedBy(mt1)]
			.forEach[mm |
				mm.^implements += mt1
			]
		]
	}

	def dispatch void complete(ModelTypingSpace root) {
		val newMTs = newArrayList

		root.metamodels.forEach[mm |
			val newMT = K3sleFactory.eINSTANCE.createModelType => [
				name = mm.exactTypeRef
			]

			if (!root.modelTypes.exists[name == newMT.name])
				newMTs += newMT
		]

		root.elements += newMTs
		root.metamodels.forEach[mm |
			mm.exactType = root.modelTypes.findFirst[name == mm.exactTypeRef]
		]

		root.elements.forEach[complete]
	}

	def dispatch void complete(Metamodel mm) {
		if (mm.hasSuperMetamodel) {
			// EMF resource = extension with inheritance
			if (mm.resourceType == ResourceType.EMF) {
				val pkg = modelUtils.loadPkg(mm.inheritanceRelation.superMetamodel.ecore.uri)

				val newPkg = EcoreFactory.eINSTANCE.createEPackage => [
					name = mm.name.toLowerCase
					nsURI = mm.resourceUri ?: '''http://«mm.name.toLowerCase»'''
					nsPrefix = mm.name.toLowerCase

					pkg.EClassifiers.filter(EClass).forEach[cls |
						EClassifiers += EcoreFactory.eINSTANCE.createEClass => [newCls |
							newCls.name = cls.name
							newCls.^abstract = cls.^abstract
							newCls.^interface = cls.^interface
							newCls.ESuperTypes += cls

							if (cls.name == "EStringToStringMapEntry") { // Stupid workaround
								newCls.instanceClassName = "java.util.Map$Entry"
								newCls.instanceTypeName = "java.util.Map$Entry"
							}
						]
					]
				]

				if (!mm.pkgs.exists[nsURI == newPkg.nsURI])
					mm.pkgs += newPkg

				pkg.referencedPkgs.filterNull.forEach[p |
					val nPkg = EcoreFactory.eINSTANCE.createEPackage => [
						name = p.name
						nsURI = p.nsURI + "/extended" // Naively suffix all the packages so that
						                              // they don't clash with the previous ones
						nsPrefix = p.nsPrefix

						p.EClassifiers.filter(EClass).forEach[cls |
							EClassifiers += EcoreFactory.eINSTANCE.createEClass => [newCls |
								newCls.name = cls.name
								newCls.^abstract = cls.^abstract
								newCls.^interface = cls.^interface
								newCls.ESuperTypes += cls

								if (cls.name == "EStringToStringMapEntry") { // Stupid workaround
									newCls.instanceClassName = "java.util.Map$Entry"
									newCls.instanceTypeName = "java.util.Map$Entry"
								}
							]
						]
					]

					if (!mm.pkgs.exists[nsURI == nPkg.nsURI])
						mm.pkgs += nPkg
				]

				mm.aspects.forEach[asp |
					if (!(asp.aspectRef.type instanceof JvmDeclaredType))
						throw new ASTProcessingException("Aspect must be a generic type: " + asp.aspectRef?.type)

					val className = asp.aspectAnnotationValue

					if (className === null)
						throw new ASTProcessingException("Cannot find annotation value for " + asp.aspectRef?.type)

					val cls = mm.findClass(className)

					if (cls === null)
						throw new ASTProcessingException("Cannot find aspectized class for " + asp.aspectRef?.type)

					asp.aspectedClass = cls

					mm.weaveAspect(asp.aspectedClass, asp.aspectRef.type as JvmDeclaredType)
				]

				// Once everything's done, recreate the aspect hierarchy
				// FIXME: Actually, we should look for the with=#[] parameter, not the only extendedClass
				mm.aspects
					.filter[(aspectRef.type as JvmDeclaredType).extendedClass !== null]
					.forEach[
						val superAspect = (aspectRef.type as JvmDeclaredType).extendedClass.type as JvmDeclaredType
						val superClsName = superAspect.aspectAnnotationValue
						if (superClsName !== null) {
							val superCls = mm.findClass(superClsName)
							if (superCls !== null)
								aspectedClass.ESuperTypes += superCls
						}
					]

				//val copy = EcoreUtil.copy(mm.pkgs.head)
				val ecoreUri = '''platform:/resource/«mm.project.name»/model/«mm.name».ecore'''
				val genmodelUri = '''platform:/resource/«mm.project.name»/model/«mm.name».genmodel'''
				val srcFolder = '''«mm.project.name»/src'''
				mm.createExtendedMetamodel(ecoreUri)
				mm.createExtendedGenmodel(ecoreUri, genmodelUri, srcFolder)
				//copy.createEcore(ecoreUri)
				//copy.createGenModel(mm, ecoreUri, genmodelUri, srcFolder)

				throw new ASTProcessingException("Gemoc: stop here")
			} else {
				val rootPkg = mm.inheritanceRelation.superMetamodel.pkgs.head.copy(mm.name)

				val pkg = rootPkg
				if (!mm.pkgs.exists[nsURI == pkg.nsURI])
					mm.pkgs += pkg

				pkg.referencedPkgs.filterNull.forEach[p |
					if (!mm.pkgs.exists[nsURI == p.nsURI])
						mm.pkgs += p.copy
				]

				// For each aspect, infer the corresponding ecore fragment
				// and merge it into the base metamodel
				mm.aspects.forEach[asp |
					if (!(asp.aspectRef.type instanceof JvmDeclaredType))
						throw new ASTProcessingException("Aspect must be a generic type: " + asp.aspectRef?.type)

					val className = asp.aspectAnnotationValue

					if (className === null)
						throw new ASTProcessingException("Cannot find annotation value for " + asp.aspectRef?.type)

					val cls = mm.findClass(className)

					if (cls === null)
						throw new ASTProcessingException("Cannot find aspectized class for " + asp.aspectRef?.type)

					asp.aspectedClass = cls
					asp.inferEcoreFragment

					// FIXME: _not_ .head, could be any of them
					algebra.weaveAspect(mm.pkgs.head, asp.ecoreFragment)
				]

				mm.createEcore
				mm.pkgs.head.createGenModel(mm, mm.generationFolder + mm.name + ".ecore", mm.generationFolder + mm.name + ".genmodel")

				val gm = modelUtils.loadGenmodel(mm.generationFolder + mm.name + ".genmodel")
				if (!mm.genmodels.exists[genPackages.exists[gp | gm.genPackages.exists[gpp | gpp.getEcorePackage?.nsURI == gp.getEcorePackage?.nsURI]]])
					mm.genmodels += gm
			}
		} else {
			val pkg = modelUtils.loadPkg(mm.ecore.uri)

			// TODO: Check that loaded pkgs/genmodels match
			if (!mm.pkgs.exists[nsURI == pkg.nsURI])
				mm.pkgs += pkg

			pkg.referencedPkgs.forEach[p |
				if (!mm.pkgs.exists[nsURI == p.nsURI])
					mm.pkgs += p.copy
			]

			mm.allSubPkgs.forEach[p |
				if (!mm.pkgs.exists[nsURI == p.nsURI])
					mm.pkgs += p
			]

			mm.^implements.forEach[mt |
				mt.complete
				mm.exactType.complete

				if (!mm.typedBy(mt))
					throw new ASTProcessingException('''«mm.name» doesn't match interface «mt.name»''')
			]

			if (mm.ecore.genmodelUris.size == 0) {
				// FIXME
				mm.ecore.genmodelUris += mm.ecore.uri.substring(0, mm.ecore.uri.lastIndexOf(".")) + ".genmodel"
			}

			mm.ecore.genmodelUris.forEach[
				val gm = modelUtils.loadGenmodel(it)
				if (!mm.genmodels.exists[genPackages.exists[gp | gm.genPackages.exists[gpp | gpp.getEcorePackage?.nsURI == gp.getEcorePackage?.nsURI]]])
					mm.genmodels += gm
			]

			// For each aspect, infer the corresponding ecore fragment
			// and merge it into the base metamodel
			mm.aspects.forEach[asp |
				if (!(asp.aspectRef.type instanceof JvmDeclaredType))
					throw new ASTProcessingException("Aspect must be a generic type: " + asp.aspectRef?.type)

				val className = asp.aspectAnnotationValue

				if (className === null)
					throw new ASTProcessingException("Cannot find annotation value for " + asp.aspectRef?.type)

				val cls = mm.findClass(className)

				if (cls === null)
					throw new ASTProcessingException("Cannot find aspectized class for " + asp.aspectRef?.type)

				asp.aspectedClass = cls
				asp.inferEcoreFragment

				// FIXME: _not_ .head, could be any of them
				algebra.weaveAspect(mm.pkgs.head, asp.ecoreFragment)
			]
		}
	}

	def dispatch void complete(ModelType mt) {
		if(mt.isImported) {
			val pkg = modelUtils.loadPkg(mt.ecore.uri)

			if (!mt.pkgs.exists[nsURI == pkg.nsURI])
				mt.pkgs += pkg

			pkg.referencedPkgs.forEach[p |
				if (!mt.pkgs.exists[nsURI == p.nsURI])
					mt.pkgs += p.copy
			]
		} else if (mt.isExtracted) {
			mt.extracted.pkgs.forEach[p |
				if (!mt.pkgs.exists[nsURI == p.nsURI])
					mt.pkgs += p.copy
			]
		}
	}

	def dispatch void complete(Transformation t) {

	}

	def dispatch boolean isValid(ModelTypingSpace root) {
		   !root.name.empty
		&& !root.metamodels.exists[mm | root.metamodels.exists[mm_ | mm != mm_ && mm.name == mm_.name]]
		&& !root.modelTypes.exists[mt | root.modelTypes.exists[mt_ | mt != mt_ && mt.name == mt_.name]]
		&& !root.transformations.exists[t | root.transformations.exists[t_ | t != t_ && t.name == t_.name]]
		&& root.elements.forall[isValid]
	}

	def dispatch boolean isValid(Metamodel mm) {
		   mm !== null
		&& !mm.name.empty
		&& (mm.inheritanceRelation !== null || mm.ecore?.uri !== null)
		&& mm.aspects.forall[it !== null && aspectRef?.type instanceof JvmDeclaredType && aspectedClass !== null]
		&& !mm.exactTypeRef.empty
		&& mm.exactType !== null
		&& mm.^implements.forall[it !== null]
		&& mm.genmodels.forall[it !== null]
		&& mm.pkgs.forall[it !== null]
	}

	def dispatch boolean isValid(ModelType mt) {
		   mt !== null
		&& !mt.name.empty
		&& (mt.ecore?.uri !== null
			|| mt.extracted !== null)
		&& mt.subtypingRelations.forall[it !== null]
		&& mt.pkgs.forall[it !== null]
	}

	def dispatch boolean isValid(Transformation t) {
		   t !== null
		&& !t.name.empty
		&& t.parameters.forall[it !== null]
		&& t.body !== null
		// t.input / t.output?
	}
}
