/**
 */
package fr.inria.diverse.melanger.minilangmt.minilang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Assignemnt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.melanger.minilangmt.minilang.BooleanAssignemnt#getVariable <em>Variable</em>}</li>
 *   <li>{@link fr.inria.diverse.melanger.minilangmt.minilang.BooleanAssignemnt#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see fr.inria.diverse.melanger.minilangmt.minilang.MinilangPackage#getBooleanAssignemnt()
 * @model
 * @generated
 */
public interface BooleanAssignemnt extends Statement {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference.
	 * @see #setVariable(BooleanVariableRef)
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.MinilangPackage#getBooleanAssignemnt_Variable()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BooleanVariableRef getVariable();

	/**
	 * Sets the value of the '{@link fr.inria.diverse.melanger.minilangmt.minilang.BooleanAssignemnt#getVariable <em>Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' containment reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(BooleanVariableRef value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(BooleanExpression)
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.MinilangPackage#getBooleanAssignemnt_Value()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BooleanExpression getValue();

	/**
	 * Sets the value of the '{@link fr.inria.diverse.melanger.minilangmt.minilang.BooleanAssignemnt#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(BooleanExpression value);

} // BooleanAssignemnt
