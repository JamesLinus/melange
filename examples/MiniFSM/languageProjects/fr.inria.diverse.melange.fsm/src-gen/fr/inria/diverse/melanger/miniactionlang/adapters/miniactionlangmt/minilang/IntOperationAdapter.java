package fr.inria.diverse.melanger.miniactionlang.adapters.miniactionlangmt.minilang;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import fr.inria.diverse.melanger.miniactionlang.adapters.miniactionlangmt.MiniActionLangMTAdaptersFactory;
import fr.inria.diverse.melanger.miniactionlang.minilang.IntOperation;
import fr.inria.diverse.melanger.miniactionlangmt.minilang.Context;
import fr.inria.diverse.melanger.miniactionlangmt.minilang.IntExpression;
import org.eclipse.emf.ecore.EClass;

@SuppressWarnings("all")
public class IntOperationAdapter extends EObjectAdapter<IntOperation> implements fr.inria.diverse.melanger.miniactionlangmt.minilang.IntOperation {
  private MiniActionLangMTAdaptersFactory adaptersFactory;
  
  public IntOperationAdapter() {
    super(fr.inria.diverse.melanger.miniactionlang.adapters.miniactionlangmt.MiniActionLangMTAdaptersFactory.getInstance());
    adaptersFactory = fr.inria.diverse.melanger.miniactionlang.adapters.miniactionlangmt.MiniActionLangMTAdaptersFactory.getInstance();
  }
  
  @Override
  public IntExpression getRight() {
    return (IntExpression) adaptersFactory.createAdapter(adaptee.getRight(), eResource);
  }
  
  @Override
  public void setRight(final IntExpression o) {
    if (o != null)
    	adaptee.setRight(((fr.inria.diverse.melanger.miniactionlang.adapters.miniactionlangmt.minilang.IntExpressionAdapter) o).getAdaptee());
    else adaptee.setRight(null);
  }
  
  @Override
  public IntExpression getLeft() {
    return (IntExpression) adaptersFactory.createAdapter(adaptee.getLeft(), eResource);
  }
  
  @Override
  public void setLeft(final IntExpression o) {
    if (o != null)
    	adaptee.setLeft(((fr.inria.diverse.melanger.miniactionlang.adapters.miniactionlangmt.minilang.IntExpressionAdapter) o).getAdaptee());
    else adaptee.setLeft(null);
  }
  
  @Override
  public int eval(final Context ctx) {
    return fr.inria.diverse.melanger.miniactionlang.aspects.IntExpressionAspect.eval(adaptee, ((fr.inria.diverse.melanger.miniactionlang.adapters.miniactionlangmt.minilang.ContextAdapter) ctx).getAdaptee()
    );
  }
  
  @Override
  public EClass eClass() {
    return fr.inria.diverse.melanger.miniactionlangmt.minilang.MinilangPackage.eINSTANCE.getIntOperation();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case fr.inria.diverse.melanger.miniactionlangmt.minilang.MinilangPackage.INT_OPERATION__RIGHT:
    		return getRight();
    	case fr.inria.diverse.melanger.miniactionlangmt.minilang.MinilangPackage.INT_OPERATION__LEFT:
    		return getLeft();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case fr.inria.diverse.melanger.miniactionlangmt.minilang.MinilangPackage.INT_OPERATION__RIGHT:
    		return getRight() != null;
    	case fr.inria.diverse.melanger.miniactionlangmt.minilang.MinilangPackage.INT_OPERATION__LEFT:
    		return getLeft() != null;
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case fr.inria.diverse.melanger.miniactionlangmt.minilang.MinilangPackage.INT_OPERATION__RIGHT:
    		setRight(
    		(fr.inria.diverse.melanger.miniactionlangmt.minilang.IntExpression)
    		 newValue);
    		return;
    	case fr.inria.diverse.melanger.miniactionlangmt.minilang.MinilangPackage.INT_OPERATION__LEFT:
    		setLeft(
    		(fr.inria.diverse.melanger.miniactionlangmt.minilang.IntExpression)
    		 newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
