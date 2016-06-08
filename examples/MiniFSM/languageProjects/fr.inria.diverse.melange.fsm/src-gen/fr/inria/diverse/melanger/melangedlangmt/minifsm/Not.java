/**
 */
package fr.inria.diverse.melanger.melangedlangmt.minifsm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Not</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.melanger.melangedlangmt.minifsm.Not#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see fr.inria.diverse.melanger.melangedlangmt.minifsm.MinifsmPackage#getNot()
 * @model
 * @generated
 */
public interface Not extends BooleanExpression {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(BooleanExpression)
	 * @see fr.inria.diverse.melanger.melangedlangmt.minifsm.MinifsmPackage#getNot_Expression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BooleanExpression getExpression();

	/**
	 * Sets the value of the '{@link fr.inria.diverse.melanger.melangedlangmt.minifsm.Not#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(BooleanExpression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean eval(Context ctx);

} // Not
