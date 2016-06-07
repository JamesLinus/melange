/**
 */
package fr.inria.diverse.melanger.minifsmmt.minifsm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FSM</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.melanger.minifsmmt.minifsm.FSM#getStates <em>States</em>}</li>
 *   <li>{@link fr.inria.diverse.melanger.minifsmmt.minifsm.FSM#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link fr.inria.diverse.melanger.minifsmmt.minifsm.FSM#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link fr.inria.diverse.melanger.minifsmmt.minifsm.FSM#getCurrentState <em>Current State</em>}</li>
 *   <li>{@link fr.inria.diverse.melanger.minifsmmt.minifsm.FSM#getCurrentEvent <em>Current Event</em>}</li>
 * </ul>
 *
 * @see fr.inria.diverse.melanger.minifsmmt.minifsm.MinifsmPackage#getFSM()
 * @model
 * @generated
 */
public interface FSM extends EObject {
	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link fr.inria.diverse.melanger.minifsmmt.minifsm.State}.
	 * It is bidirectional and its opposite is '{@link fr.inria.diverse.melanger.minifsmmt.minifsm.State#getFsm <em>Fsm</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see fr.inria.diverse.melanger.minifsmmt.minifsm.MinifsmPackage#getFSM_States()
	 * @see fr.inria.diverse.melanger.minifsmmt.minifsm.State#getFsm
	 * @model opposite="fsm" containment="true"
	 * @generated
	 */
	EList<State> getStates();

	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link fr.inria.diverse.melanger.minifsmmt.minifsm.Transition}.
	 * It is bidirectional and its opposite is '{@link fr.inria.diverse.melanger.minifsmmt.minifsm.Transition#getFsm <em>Fsm</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see fr.inria.diverse.melanger.minifsmmt.minifsm.MinifsmPackage#getFSM_Transitions()
	 * @see fr.inria.diverse.melanger.minifsmmt.minifsm.Transition#getFsm
	 * @model opposite="fsm" containment="true"
	 * @generated
	 */
	EList<Transition> getTransitions();

	/**
	 * Returns the value of the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial State</em>' reference.
	 * @see #setInitialState(State)
	 * @see fr.inria.diverse.melanger.minifsmmt.minifsm.MinifsmPackage#getFSM_InitialState()
	 * @model required="true"
	 * @generated
	 */
	State getInitialState();

	/**
	 * Sets the value of the '{@link fr.inria.diverse.melanger.minifsmmt.minifsm.FSM#getInitialState <em>Initial State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial State</em>' reference.
	 * @see #getInitialState()
	 * @generated
	 */
	void setInitialState(State value);

	/**
	 * Returns the value of the '<em><b>Current State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current State</em>' reference.
	 * @see #setCurrentState(State)
	 * @see fr.inria.diverse.melanger.minifsmmt.minifsm.MinifsmPackage#getFSM_CurrentState()
	 * @model
	 * @generated
	 */
	State getCurrentState();

	/**
	 * Sets the value of the '{@link fr.inria.diverse.melanger.minifsmmt.minifsm.FSM#getCurrentState <em>Current State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current State</em>' reference.
	 * @see #getCurrentState()
	 * @generated
	 */
	void setCurrentState(State value);

	/**
	 * Returns the value of the '<em><b>Current Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Event</em>' attribute.
	 * @see #setCurrentEvent(String)
	 * @see fr.inria.diverse.melanger.minifsmmt.minifsm.MinifsmPackage#getFSM_CurrentEvent()
	 * @model
	 * @generated
	 */
	String getCurrentEvent();

	/**
	 * Sets the value of the '{@link fr.inria.diverse.melanger.minifsmmt.minifsm.FSM#getCurrentEvent <em>Current Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Event</em>' attribute.
	 * @see #getCurrentEvent()
	 * @generated
	 */
	void setCurrentEvent(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model eventsMany="true"
	 * @generated
	 */
	void execute(EList<String> events);

} // FSM
