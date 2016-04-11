package simplefsmtest.timedfsm.adapters.timedfsmmt.fsm;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import fsm.FSM;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import simplefsmtest.timedfsm.adapters.timedfsmmt.TimedFsmMTAdaptersFactory;
import simplefsmtest.timedfsmmt.fsm.State;

@SuppressWarnings("all")
public class FSMAdapter extends EObjectAdapter<FSM> implements simplefsmtest.timedfsmmt.fsm.FSM {
  private TimedFsmMTAdaptersFactory adaptersFactory;
  
  public FSMAdapter() {
    super(simplefsmtest.timedfsm.adapters.timedfsmmt.TimedFsmMTAdaptersFactory.getInstance());
    adaptersFactory = simplefsmtest.timedfsm.adapters.timedfsmmt.TimedFsmMTAdaptersFactory.getInstance();
  }
  
  private EList<State> ownedState;
  
  @Override
  public EList<State> getOwnedState() {
    if (ownedState == null)
    	ownedState = fr.inria.diverse.melange.adapters.EListAdapter.newInstance(adaptee.getOwnedState(), adaptersFactory);
    return ownedState;
  }
  
  @Override
  public State getInitialState() {
    return (State) adaptersFactory.createAdapter(adaptee.getInitialState(), eResource);
  }
  
  @Override
  public void setInitialState(final State o) {
    if (o != null)
    	adaptee.setInitialState(((simplefsmtest.timedfsm.adapters.timedfsmmt.fsm.StateAdapter) o).getAdaptee());
    else adaptee.setInitialState(null);
  }
  
  private EList<State> finalState;
  
  @Override
  public EList<State> getFinalState() {
    if (finalState == null)
    	finalState = fr.inria.diverse.melange.adapters.EListAdapter.newInstance(adaptee.getFinalState(), adaptersFactory);
    return finalState;
  }
  
  @Override
  public EClass eClass() {
    return simplefsmtest.timedfsmmt.fsm.FsmPackage.eINSTANCE.getFSM();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case simplefsmtest.timedfsmmt.fsm.FsmPackage.FSM__OWNED_STATE:
    		return getOwnedState();
    	case simplefsmtest.timedfsmmt.fsm.FsmPackage.FSM__INITIAL_STATE:
    		return getInitialState();
    	case simplefsmtest.timedfsmmt.fsm.FsmPackage.FSM__FINAL_STATE:
    		return getFinalState();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case simplefsmtest.timedfsmmt.fsm.FsmPackage.FSM__OWNED_STATE:
    		return getOwnedState() != null && !getOwnedState().isEmpty();
    	case simplefsmtest.timedfsmmt.fsm.FsmPackage.FSM__INITIAL_STATE:
    		return getInitialState() != null;
    	case simplefsmtest.timedfsmmt.fsm.FsmPackage.FSM__FINAL_STATE:
    		return getFinalState() != null && !getFinalState().isEmpty();
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case simplefsmtest.timedfsmmt.fsm.FsmPackage.FSM__OWNED_STATE:
    		getOwnedState().clear();
    		getOwnedState().addAll((Collection) newValue);
    		return;
    	case simplefsmtest.timedfsmmt.fsm.FsmPackage.FSM__INITIAL_STATE:
    		setInitialState(
    		(simplefsmtest.timedfsmmt.fsm.State)
    		 newValue);
    		return;
    	case simplefsmtest.timedfsmmt.fsm.FsmPackage.FSM__FINAL_STATE:
    		getFinalState().clear();
    		getFinalState().addAll((Collection) newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
