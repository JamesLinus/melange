package simplefsmtest.fsm.adapters.fsmmt.fsm;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import simplefsmtest.fsm.adapters.fsmmt.FsmMTAdaptersFactory;
import simplefsmtest.fsmmt.fsm.FSM;
import simplefsmtest.fsmmt.fsm.FsmFactory;
import simplefsmtest.fsmmt.fsm.FsmPackage;
import simplefsmtest.fsmmt.fsm.State;
import simplefsmtest.fsmmt.fsm.Transition;

@SuppressWarnings("all")
public class FsmFactoryAdapter extends EFactoryImpl implements FsmFactory {
  private FsmMTAdaptersFactory adaptersFactory = simplefsmtest.fsm.adapters.fsmmt.FsmMTAdaptersFactory.getInstance();
  
  private fsm.FsmFactory fsmAdaptee = fsm.FsmFactory.eINSTANCE;
  
  @Override
  public FSM createFSM() {
    return adaptersFactory.createFSMAdapter(fsmAdaptee.createFSM(), null);
  }
  
  @Override
  public State createState() {
    return adaptersFactory.createStateAdapter(fsmAdaptee.createState(), null);
  }
  
  @Override
  public Transition createTransition() {
    return adaptersFactory.createTransitionAdapter(fsmAdaptee.createTransition(), null);
  }
  
  @Override
  public EPackage getEPackage() {
    return getFsmPackage();
  }
  
  public FsmPackage getFsmPackage() {
    return simplefsmtest.fsmmt.fsm.FsmPackage.eINSTANCE;
  }
}
