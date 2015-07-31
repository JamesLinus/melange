package simplefsm.timedfsmmt;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import simplefsm.timedfsmmt.State;

@SuppressWarnings("all")
public interface FSM extends EObject {
  public abstract EList<State> getOwnedState();
  
  public abstract State getInitialState();
  
  public abstract void setInitialState(final State newInitialState);
  
  public abstract EList<State> getFinalState();
}
