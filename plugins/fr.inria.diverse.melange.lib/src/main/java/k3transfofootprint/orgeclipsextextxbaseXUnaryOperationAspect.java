package k3transfofootprint;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import k3transfofootprint.K3TransfoFootprint;
import k3transfofootprint.__SlicerAspect__;
import k3transfofootprint.orgeclipsextextxbaseXAbstractFeatureCallAspect;
import k3transfofootprint.orgeclipsextextxbaseXUnaryOperationAspectXUnaryOperationAspectProperties;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XUnaryOperation;

@Aspect(className = XUnaryOperation.class, with = { orgeclipsextextxbaseXAbstractFeatureCallAspect.class })
@SuppressWarnings("all")
public class orgeclipsextextxbaseXUnaryOperationAspect extends orgeclipsextextxbaseXAbstractFeatureCallAspect {
  @OverrideAspectMethod
  public static void reinit(final XUnaryOperation _self) {
    _self_ = k3transfofootprint.orgeclipsextextxbaseXUnaryOperationAspectXUnaryOperationAspectContext.getSelf(_self);
    	    
    	      if (_self instanceof org.eclipse.xtext.xbase.XUnaryOperation){
    	      k3transfofootprint.orgeclipsextextxbaseXUnaryOperationAspect._privk3_reinit((org.eclipse.xtext.xbase.XUnaryOperation)_self);
    	     } else  if (_self instanceof org.eclipse.xtext.xbase.XAbstractFeatureCall){
    	      k3transfofootprint.orgeclipsextextxbaseXAbstractFeatureCallAspect._privk3_reinit((org.eclipse.xtext.xbase.XAbstractFeatureCall)_self);
    	     } else  if (_self instanceof java.lang.Object){
    	      k3transfofootprint.__SlicerAspect__._privk3_reinit((java.lang.Object)_self);
    	     } else  { throw new IllegalArgumentException("Unhandled parameter types: " + java.util.Arrays.<Object>asList(_self).toString()); }
  }
  
  @OverrideAspectMethod
  public static void _visitToAddClasses(final XUnaryOperation _self, final K3TransfoFootprint theSlicer) {
    _self_ = k3transfofootprint.orgeclipsextextxbaseXUnaryOperationAspectXUnaryOperationAspectContext.getSelf(_self);
    	    
    	      if (_self instanceof org.eclipse.xtext.xbase.XUnaryOperation){
    	      k3transfofootprint.orgeclipsextextxbaseXUnaryOperationAspect._privk3__visitToAddClasses((org.eclipse.xtext.xbase.XUnaryOperation)_self,theSlicer);
    	     } else  if (_self instanceof org.eclipse.xtext.xbase.XAbstractFeatureCall){
    	      k3transfofootprint.orgeclipsextextxbaseXAbstractFeatureCallAspect._privk3__visitToAddClasses((org.eclipse.xtext.xbase.XAbstractFeatureCall)_self,theSlicer);
    	     } else  if (_self instanceof org.eclipse.xtext.xbase.XExpression){
    	      k3transfofootprint.orgeclipsextextxbaseXExpressionAspect._privk3__visitToAddClasses((org.eclipse.xtext.xbase.XExpression)_self,theSlicer);
    	     } else  if (_self instanceof java.lang.Object){
    	      k3transfofootprint.__SlicerAspect__._privk3__visitToAddClasses((java.lang.Object)_self,theSlicer);
    	     } else  { throw new IllegalArgumentException("Unhandled parameter types: " + java.util.Arrays.<Object>asList(_self).toString()); }
  }
  
  @OverrideAspectMethod
  public static void _visitToAddRelations(final XUnaryOperation _self, final K3TransfoFootprint theSlicer) {
    _self_ = k3transfofootprint.orgeclipsextextxbaseXUnaryOperationAspectXUnaryOperationAspectContext.getSelf(_self);
    	    
    	      if (_self instanceof org.eclipse.xtext.xbase.XUnaryOperation){
    	      k3transfofootprint.orgeclipsextextxbaseXUnaryOperationAspect._privk3__visitToAddRelations((org.eclipse.xtext.xbase.XUnaryOperation)_self,theSlicer);
    	     } else  if (_self instanceof org.eclipse.xtext.xbase.XAbstractFeatureCall){
    	      k3transfofootprint.orgeclipsextextxbaseXAbstractFeatureCallAspect._privk3__visitToAddRelations((org.eclipse.xtext.xbase.XAbstractFeatureCall)_self,theSlicer);
    	     } else  if (_self instanceof org.eclipse.xtext.xbase.XExpression){
    	      k3transfofootprint.orgeclipsextextxbaseXExpressionAspect._privk3__visitToAddRelations((org.eclipse.xtext.xbase.XExpression)_self,theSlicer);
    	     } else  if (_self instanceof java.lang.Object){
    	      k3transfofootprint.__SlicerAspect__._privk3__visitToAddRelations((java.lang.Object)_self,theSlicer);
    	     } else  { throw new IllegalArgumentException("Unhandled parameter types: " + java.util.Arrays.<Object>asList(_self).toString()); }
  }
  
  public static orgeclipsextextxbaseXUnaryOperationAspectXUnaryOperationAspectProperties _self_;
  
  private static void super_reinit(final XUnaryOperation _self) {
     k3transfofootprint.orgeclipsextextxbaseXAbstractFeatureCallAspect._privk3_reinit(_self);
  }
  
  protected static void _privk3_reinit(final XUnaryOperation _self) {
    orgeclipsextextxbaseXUnaryOperationAspect.super_reinit(_self);
    XExpression _operand = _self.getOperand();
    if (_operand!=null) {
      __SlicerAspect__.reinit(_operand);
    }
  }
  
  private static void super__visitToAddClasses(final XUnaryOperation _self, final K3TransfoFootprint theSlicer) {
     k3transfofootprint.orgeclipsextextxbaseXAbstractFeatureCallAspect._privk3__visitToAddClasses(_self,theSlicer);
  }
  
  protected static void _privk3__visitToAddClasses(final XUnaryOperation _self, final K3TransfoFootprint theSlicer) {
    orgeclipsextextxbaseXUnaryOperationAspect.super__visitToAddClasses(_self, theSlicer);
    XExpression _operand = _self.getOperand();
    if (_operand!=null) {
      __SlicerAspect__.visitToAddClasses(_operand, theSlicer);
    }
  }
  
  private static void super__visitToAddRelations(final XUnaryOperation _self, final K3TransfoFootprint theSlicer) {
     k3transfofootprint.orgeclipsextextxbaseXAbstractFeatureCallAspect._privk3__visitToAddRelations(_self,theSlicer);
  }
  
  protected static void _privk3__visitToAddRelations(final XUnaryOperation _self, final K3TransfoFootprint theSlicer) {
    orgeclipsextextxbaseXUnaryOperationAspect.super__visitToAddRelations(_self, theSlicer);
    XExpression _operand = _self.getOperand();
    boolean _tripleNotEquals = (_operand != null);
    if (_tripleNotEquals) {
      XExpression _operand_1 = _self.getOperand();
      __SlicerAspect__.visitToAddRelations(_operand_1, theSlicer);
      boolean _and = false;
      boolean _sliced = __SlicerAspect__.sliced(_self);
      if (!_sliced) {
        _and = false;
      } else {
        XExpression _operand_2 = _self.getOperand();
        boolean _sliced_1 = __SlicerAspect__.sliced(_operand_2);
        _and = _sliced_1;
      }
      if (_and) {
        XExpression _operand_3 = _self.getOperand();
        theSlicer.onoperandSliced(_self, _operand_3);
      }
    }
  }
}
