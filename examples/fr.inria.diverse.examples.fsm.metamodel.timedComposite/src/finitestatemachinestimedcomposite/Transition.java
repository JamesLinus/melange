/**
 */
package finitestatemachinestimedcomposite;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link finitestatemachinestimedcomposite.Transition#getTarget <em>Target</em>}</li>
 *   <li>{@link finitestatemachinestimedcomposite.Transition#getSource <em>Source</em>}</li>
 *   <li>{@link finitestatemachinestimedcomposite.Transition#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link finitestatemachinestimedcomposite.Transition#getStateMachine <em>State Machine</em>}</li>
 *   <li>{@link finitestatemachinestimedcomposite.Transition#getInitialTime <em>Initial Time</em>}</li>
 *   <li>{@link finitestatemachinestimedcomposite.Transition#getFinalTime <em>Final Time</em>}</li>
 *   <li>{@link finitestatemachinestimedcomposite.Transition#getTime <em>Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see finitestatemachinestimedcomposite.FinitestatemachinestimedcompositePackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link finitestatemachinestimedcomposite.State#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(State)
	 * @see finitestatemachinestimedcomposite.FinitestatemachinestimedcompositePackage#getTransition_Target()
	 * @see finitestatemachinestimedcomposite.State#getIncoming
	 * @model opposite="incoming" required="true"
	 * @generated
	 */
	State getTarget();

	/**
	 * Sets the value of the '{@link finitestatemachinestimedcomposite.Transition#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(State value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link finitestatemachinestimedcomposite.State#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(State)
	 * @see finitestatemachinestimedcomposite.FinitestatemachinestimedcompositePackage#getTransition_Source()
	 * @see finitestatemachinestimedcomposite.State#getOutgoing
	 * @model opposite="outgoing" required="true"
	 * @generated
	 */
	State getSource();

	/**
	 * Sets the value of the '{@link finitestatemachinestimedcomposite.Transition#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(State value);

	/**
	 * Returns the value of the '<em><b>Trigger</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger</em>' containment reference.
	 * @see #setTrigger(Trigger)
	 * @see finitestatemachinestimedcomposite.FinitestatemachinestimedcompositePackage#getTransition_Trigger()
	 * @model containment="true"
	 * @generated
	 */
	Trigger getTrigger();

	/**
	 * Sets the value of the '{@link finitestatemachinestimedcomposite.Transition#getTrigger <em>Trigger</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trigger</em>' containment reference.
	 * @see #getTrigger()
	 * @generated
	 */
	void setTrigger(Trigger value);

	/**
	 * Returns the value of the '<em><b>State Machine</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link finitestatemachinestimedcomposite.StateMachine#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Machine</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Machine</em>' container reference.
	 * @see #setStateMachine(StateMachine)
	 * @see finitestatemachinestimedcomposite.FinitestatemachinestimedcompositePackage#getTransition_StateMachine()
	 * @see finitestatemachinestimedcomposite.StateMachine#getTransitions
	 * @model opposite="transitions" required="true" transient="false"
	 * @generated
	 */
	StateMachine getStateMachine();

	/**
	 * Sets the value of the '{@link finitestatemachinestimedcomposite.Transition#getStateMachine <em>State Machine</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Machine</em>' container reference.
	 * @see #getStateMachine()
	 * @generated
	 */
	void setStateMachine(StateMachine value);

	/**
	 * Returns the value of the '<em><b>Initial Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Time</em>' attribute.
	 * @see #setInitialTime(int)
	 * @see finitestatemachinestimedcomposite.FinitestatemachinestimedcompositePackage#getTransition_InitialTime()
	 * @model
	 * @generated
	 */
	int getInitialTime();

	/**
	 * Sets the value of the '{@link finitestatemachinestimedcomposite.Transition#getInitialTime <em>Initial Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Time</em>' attribute.
	 * @see #getInitialTime()
	 * @generated
	 */
	void setInitialTime(int value);

	/**
	 * Returns the value of the '<em><b>Final Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Final Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final Time</em>' attribute.
	 * @see #setFinalTime(int)
	 * @see finitestatemachinestimedcomposite.FinitestatemachinestimedcompositePackage#getTransition_FinalTime()
	 * @model
	 * @generated
	 */
	int getFinalTime();

	/**
	 * Sets the value of the '{@link finitestatemachinestimedcomposite.Transition#getFinalTime <em>Final Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Final Time</em>' attribute.
	 * @see #getFinalTime()
	 * @generated
	 */
	void setFinalTime(int value);

	/**
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see #setTime(int)
	 * @see finitestatemachinestimedcomposite.FinitestatemachinestimedcompositePackage#getTransition_Time()
	 * @model
	 * @generated
	 */
	int getTime();

	/**
	 * Sets the value of the '{@link finitestatemachinestimedcomposite.Transition#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(int value);

} // Transition
