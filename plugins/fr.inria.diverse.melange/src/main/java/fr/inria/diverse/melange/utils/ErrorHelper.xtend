package fr.inria.diverse.melange.utils

import com.google.inject.Inject
import fr.inria.diverse.melange.lib.EcoreExtensions
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.validation.EObjectDiagnosticImpl

class ErrorHelper
{
	@Inject extension EcoreExtensions
	static final String DEFAULT_PROBLEM_CODE = "MelangeProblemCode"

	def void addError(EObject eo, String message) {
		addError(eo, message, null)
	}

	/** 
	 * Add an error diagnostic (and marker) to an EObject
	 */
	def void addError(EObject eo, String message, String problemCode) {
		eo.eResource.errors.add(new EObjectDiagnosticImpl(
			Severity.ERROR,
			problemCode ?: DEFAULT_PROBLEM_CODE,
			message,
			eo,
			null,
			-1,
			null
		))	
	}

	/** 
	 * Add a warning diagnostic (and marker) to an EObject
	 */
	def void addWarning(EObject eo, String message, String problemCode) {
		eo.eResource.errors.add(new EObjectDiagnosticImpl(
			Severity.WARNING,
			problemCode ?: DEFAULT_PROBLEM_CODE,
			message,
			eo,
			null,
			-1,
			null
		))	
	}

	/**
	 * Checks whether {@link o} or one of its children
	 * has an error marker produced by the validator
	 */
	def boolean isInError(EObject o) {
		return
			o.eResource.errors.filter(EObjectDiagnosticImpl).exists[
				problematicObject.isContainedBy(o)
			]
	}
}
