package k3transfofootprint;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import k3transfofootprint.K3TransfoFootprint;
import k3transfofootprint.orgeclipsextextcommontypesJvmTypeConstraintAspect;
import k3transfofootprint.orgeclipsextextcommontypesJvmUpperBoundAspectJvmUpperBoundAspectProperties;
import org.eclipse.xtext.common.types.JvmUpperBound;

@Aspect(className = JvmUpperBound.class, with = { orgeclipsextextcommontypesJvmTypeConstraintAspect.class })
@SuppressWarnings("all")
public class orgeclipsextextcommontypesJvmUpperBoundAspect extends orgeclipsextextcommontypesJvmTypeConstraintAspect {
  @OverrideAspectMethod
  public static void _visitToAddClasses(final JvmUpperBound _self, final K3TransfoFootprint theSlicer) {
    _self_ = k3transfofootprint.orgeclipsextextcommontypesJvmUpperBoundAspectJvmUpperBoundAspectContext.getSelf(_self);
    	    
    	      if (_self instanceof org.eclipse.xtext.common.types.JvmUpperBound){
    	      k3transfofootprint.orgeclipsextextcommontypesJvmUpperBoundAspect._privk3__visitToAddClasses((org.eclipse.xtext.common.types.JvmUpperBound)_self,theSlicer);
    	     } else  if (_self instanceof org.eclipse.xtext.common.types.JvmTypeConstraint){
    	      k3transfofootprint.orgeclipsextextcommontypesJvmTypeConstraintAspect._privk3__visitToAddClasses((org.eclipse.xtext.common.types.JvmTypeConstraint)_self,theSlicer);
    	     } else  if (_self instanceof java.lang.Object){
    	      k3transfofootprint.__SlicerAspect__._privk3__visitToAddClasses((java.lang.Object)_self,theSlicer);
    	     } else  { throw new IllegalArgumentException("Unhandled parameter types: " + java.util.Arrays.<Object>asList(_self).toString()); }
  }
  
  @OverrideAspectMethod
  public static void _visitToAddRelations(final JvmUpperBound _self, final K3TransfoFootprint theSlicer) {
    _self_ = k3transfofootprint.orgeclipsextextcommontypesJvmUpperBoundAspectJvmUpperBoundAspectContext.getSelf(_self);
    	    
    	      if (_self instanceof org.eclipse.xtext.common.types.JvmUpperBound){
    	      k3transfofootprint.orgeclipsextextcommontypesJvmUpperBoundAspect._privk3__visitToAddRelations((org.eclipse.xtext.common.types.JvmUpperBound)_self,theSlicer);
    	     } else  if (_self instanceof org.eclipse.xtext.common.types.JvmTypeConstraint){
    	      k3transfofootprint.orgeclipsextextcommontypesJvmTypeConstraintAspect._privk3__visitToAddRelations((org.eclipse.xtext.common.types.JvmTypeConstraint)_self,theSlicer);
    	     } else  if (_self instanceof java.lang.Object){
    	      k3transfofootprint.__SlicerAspect__._privk3__visitToAddRelations((java.lang.Object)_self,theSlicer);
    	     } else  { throw new IllegalArgumentException("Unhandled parameter types: " + java.util.Arrays.<Object>asList(_self).toString()); }
  }
  
  public static orgeclipsextextcommontypesJvmUpperBoundAspectJvmUpperBoundAspectProperties _self_;
  
  private static void super__visitToAddClasses(final JvmUpperBound _self, final K3TransfoFootprint theSlicer) {
     k3transfofootprint.orgeclipsextextcommontypesJvmTypeConstraintAspect._privk3__visitToAddClasses(_self,theSlicer);
  }
  
  protected static void _privk3__visitToAddClasses(final JvmUpperBound _self, final K3TransfoFootprint theSlicer) {
    orgeclipsextextcommontypesJvmUpperBoundAspect.super__visitToAddClasses(_self, theSlicer);
  }
  
  private static void super__visitToAddRelations(final JvmUpperBound _self, final K3TransfoFootprint theSlicer) {
     k3transfofootprint.orgeclipsextextcommontypesJvmTypeConstraintAspect._privk3__visitToAddRelations(_self,theSlicer);
  }
  
  protected static void _privk3__visitToAddRelations(final JvmUpperBound _self, final K3TransfoFootprint theSlicer) {
    orgeclipsextextcommontypesJvmUpperBoundAspect.super__visitToAddRelations(_self, theSlicer);
  }
}
