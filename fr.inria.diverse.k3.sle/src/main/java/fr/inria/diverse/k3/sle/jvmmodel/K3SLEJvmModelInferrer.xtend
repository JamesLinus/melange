package fr.inria.diverse.k3.sle.jvmmodel

import fr.inria.diverse.k3.sle.ast.ASTProcessingException

import fr.inria.diverse.k3.sle.metamodel.k3sle.ModelTypingSpace

import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor

import fr.inria.diverse.k3.sle.typing.K3SLETyping

import org.apache.log4j.Logger

import com.google.inject.Inject

import fr.inria.diverse.k3.sle.ast.ASTHelper

class K3SLEJvmModelInferrer extends AbstractModelInferrer
{
	@Inject K3SLETyping typingHelper
	@Inject extension ASTHelper
	@Inject extension ModelTypeJvmModelInferrer
	@Inject extension MetamodelJvmModelInferrer
	@Inject extension TransformationJvmModelInferrer

	ModelTypingSpace root
	Logger logger = Logger.getLogger(K3SLEJvmModelInferrer)

	def dispatch infer(ModelTypingSpace typingSpace, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
		root = typingSpace

		try {
			typingHelper.complete(root)

			if (typingHelper.isValid(root)) {
					typingHelper.complete(root)
					typingHelper.inferTypingRelations(root)

					root.modelTypes.forEach[generateInterfaces(acceptor)]
					root.metamodels.forEach[generateAdapters(acceptor)]
					root.transformations.forEach[generateTransformation(acceptor)]
			}
		} catch (ASTProcessingException e) {
			logger.error('''ASTProcessingException: «e.message»''', e)
		} catch (Exception e) {
			logger.error('''Exception: «e.message»''', e)
		}
	}
}
