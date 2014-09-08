package fr.inria.diverse.k3.sle.jvmmodel

import com.google.inject.Inject

import fr.inria.diverse.k3.sle.ast.ASTHelper
import fr.inria.diverse.k3.sle.ast.ASTPostProcessor
import fr.inria.diverse.k3.sle.ast.ASTProcessingException
import fr.inria.diverse.k3.sle.ast.ASTValidator

import fr.inria.diverse.k3.sle.metamodel.k3sle.ModelTypingSpace

import org.apache.log4j.Logger

import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor

class K3SLEJvmModelInferrer extends AbstractModelInferrer
{
	@Inject ASTPostProcessor postProcessor
	@Inject ASTValidator validator
	@Inject extension ASTHelper
	@Inject extension ModelTypeInferrer
	@Inject extension MetamodelInferrer
	@Inject extension TransformationInferrer
//	@Inject extension KomprenInferrer

	ModelTypingSpace root
	Logger logger = Logger.getLogger(K3SLEJvmModelInferrer)

	def dispatch void infer(ModelTypingSpace typingSpace, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
		root = typingSpace

		try {
			postProcessor.complete(root)

			if (validator.isValid(root)) {
					postProcessor.complete(root)
					postProcessor.inferTypingRelations(root)

					root.modelTypes.forEach[generateInterfaces(acceptor)]
					root.metamodels.forEach[generateAdapters(acceptor)]
					root.transformations.forEach[generateTransformation(acceptor)]
//					root.slicers.forEach[generateSlicer]
			}
		} catch (ASTProcessingException e) {
			logger.error('''ASTProcessingException: «e.message»''')
		} catch (Exception e) {
			logger.error('''Exception: «e.message»''', e)
		}
	}
}
