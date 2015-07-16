/**
 */
package fr.inria.diverse.melange.metamodel.melange.impl;

import fr.inria.diverse.melange.metamodel.melange.Aspect;
import fr.inria.diverse.melange.metamodel.melange.Language;
import fr.inria.diverse.melange.metamodel.melange.MelangePackage;
import fr.inria.diverse.melange.metamodel.melange.Metamodel;
import fr.inria.diverse.melange.metamodel.melange.ModelType;
import fr.inria.diverse.melange.metamodel.melange.Operator;
import fr.inria.diverse.melange.metamodel.melange.ResourceType;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Language</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.melange.metamodel.melange.impl.LanguageImpl#getOperators <em>Operators</em>}</li>
 *   <li>{@link fr.inria.diverse.melange.metamodel.melange.impl.LanguageImpl#getExactType <em>Exact Type</em>}</li>
 *   <li>{@link fr.inria.diverse.melange.metamodel.melange.impl.LanguageImpl#getImplements <em>Implements</em>}</li>
 *   <li>{@link fr.inria.diverse.melange.metamodel.melange.impl.LanguageImpl#getRequires <em>Requires</em>}</li>
 *   <li>{@link fr.inria.diverse.melange.metamodel.melange.impl.LanguageImpl#getSyntax <em>Syntax</em>}</li>
 *   <li>{@link fr.inria.diverse.melange.metamodel.melange.impl.LanguageImpl#getSemantics <em>Semantics</em>}</li>
 *   <li>{@link fr.inria.diverse.melange.metamodel.melange.impl.LanguageImpl#getExactTypeName <em>Exact Type Name</em>}</li>
 *   <li>{@link fr.inria.diverse.melange.metamodel.melange.impl.LanguageImpl#getExactTypeUri <em>Exact Type Uri</em>}</li>
 *   <li>{@link fr.inria.diverse.melange.metamodel.melange.impl.LanguageImpl#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link fr.inria.diverse.melange.metamodel.melange.impl.LanguageImpl#getResourceUri <em>Resource Uri</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LanguageImpl extends ModelingElementImpl implements Language {
	/**
	 * The cached value of the '{@link #getOperators() <em>Operators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperators()
	 * @generated
	 * @ordered
	 */
	protected EList<Operator> operators;

	/**
	 * The cached value of the '{@link #getExactType() <em>Exact Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExactType()
	 * @generated
	 * @ordered
	 */
	protected ModelType exactType;

	/**
	 * The cached value of the '{@link #getImplements() <em>Implements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplements()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelType> implements_;

	/**
	 * The cached value of the '{@link #getRequires() <em>Requires</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequires()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelType> requires;

	/**
	 * The cached value of the '{@link #getSyntax() <em>Syntax</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSyntax()
	 * @generated
	 * @ordered
	 */
	protected Metamodel syntax;

	/**
	 * The cached value of the '{@link #getSemantics() <em>Semantics</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemantics()
	 * @generated
	 * @ordered
	 */
	protected Aspect semantics;

	/**
	 * The default value of the '{@link #getExactTypeName() <em>Exact Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExactTypeName()
	 * @generated
	 * @ordered
	 */
	protected static final String EXACT_TYPE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExactTypeName() <em>Exact Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExactTypeName()
	 * @generated
	 * @ordered
	 */
	protected String exactTypeName = EXACT_TYPE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getExactTypeUri() <em>Exact Type Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExactTypeUri()
	 * @generated
	 * @ordered
	 */
	protected static final String EXACT_TYPE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExactTypeUri() <em>Exact Type Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExactTypeUri()
	 * @generated
	 * @ordered
	 */
	protected String exactTypeUri = EXACT_TYPE_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getResourceType() <em>Resource Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceType()
	 * @generated
	 * @ordered
	 */
	protected static final ResourceType RESOURCE_TYPE_EDEFAULT = ResourceType.MELANGE;

	/**
	 * The cached value of the '{@link #getResourceType() <em>Resource Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceType()
	 * @generated
	 * @ordered
	 */
	protected ResourceType resourceType = RESOURCE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getResourceUri() <em>Resource Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceUri()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOURCE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResourceUri() <em>Resource Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceUri()
	 * @generated
	 * @ordered
	 */
	protected String resourceUri = RESOURCE_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LanguageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MelangePackage.Literals.LANGUAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Operator> getOperators() {
		if (operators == null) {
			operators = new EObjectContainmentEList<Operator>(Operator.class, this, MelangePackage.LANGUAGE__OPERATORS);
		}
		return operators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelType getExactType() {
		if (exactType != null && exactType.eIsProxy()) {
			InternalEObject oldExactType = (InternalEObject)exactType;
			exactType = (ModelType)eResolveProxy(oldExactType);
			if (exactType != oldExactType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MelangePackage.LANGUAGE__EXACT_TYPE, oldExactType, exactType));
			}
		}
		return exactType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelType basicGetExactType() {
		return exactType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExactType(ModelType newExactType, NotificationChain msgs) {
		ModelType oldExactType = exactType;
		exactType = newExactType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MelangePackage.LANGUAGE__EXACT_TYPE, oldExactType, newExactType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExactType(ModelType newExactType) {
		if (newExactType != exactType) {
			NotificationChain msgs = null;
			if (exactType != null)
				msgs = ((InternalEObject)exactType).eInverseRemove(this, MelangePackage.MODEL_TYPE__EXTRACTED, ModelType.class, msgs);
			if (newExactType != null)
				msgs = ((InternalEObject)newExactType).eInverseAdd(this, MelangePackage.MODEL_TYPE__EXTRACTED, ModelType.class, msgs);
			msgs = basicSetExactType(newExactType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MelangePackage.LANGUAGE__EXACT_TYPE, newExactType, newExactType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelType> getImplements() {
		if (implements_ == null) {
			implements_ = new EObjectResolvingEList<ModelType>(ModelType.class, this, MelangePackage.LANGUAGE__IMPLEMENTS);
		}
		return implements_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelType> getRequires() {
		if (requires == null) {
			requires = new EObjectResolvingEList<ModelType>(ModelType.class, this, MelangePackage.LANGUAGE__REQUIRES);
		}
		return requires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Metamodel getSyntax() {
		return syntax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSyntax(Metamodel newSyntax, NotificationChain msgs) {
		Metamodel oldSyntax = syntax;
		syntax = newSyntax;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MelangePackage.LANGUAGE__SYNTAX, oldSyntax, newSyntax);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSyntax(Metamodel newSyntax) {
		if (newSyntax != syntax) {
			NotificationChain msgs = null;
			if (syntax != null)
				msgs = ((InternalEObject)syntax).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MelangePackage.LANGUAGE__SYNTAX, null, msgs);
			if (newSyntax != null)
				msgs = ((InternalEObject)newSyntax).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MelangePackage.LANGUAGE__SYNTAX, null, msgs);
			msgs = basicSetSyntax(newSyntax, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MelangePackage.LANGUAGE__SYNTAX, newSyntax, newSyntax));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Aspect getSemantics() {
		if (semantics != null && semantics.eIsProxy()) {
			InternalEObject oldSemantics = (InternalEObject)semantics;
			semantics = (Aspect)eResolveProxy(oldSemantics);
			if (semantics != oldSemantics) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MelangePackage.LANGUAGE__SEMANTICS, oldSemantics, semantics));
			}
		}
		return semantics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Aspect basicGetSemantics() {
		return semantics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemantics(Aspect newSemantics) {
		Aspect oldSemantics = semantics;
		semantics = newSemantics;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MelangePackage.LANGUAGE__SEMANTICS, oldSemantics, semantics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExactTypeName() {
		return exactTypeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExactTypeName(String newExactTypeName) {
		String oldExactTypeName = exactTypeName;
		exactTypeName = newExactTypeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MelangePackage.LANGUAGE__EXACT_TYPE_NAME, oldExactTypeName, exactTypeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExactTypeUri() {
		return exactTypeUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExactTypeUri(String newExactTypeUri) {
		String oldExactTypeUri = exactTypeUri;
		exactTypeUri = newExactTypeUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MelangePackage.LANGUAGE__EXACT_TYPE_URI, oldExactTypeUri, exactTypeUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceType getResourceType() {
		return resourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceType(ResourceType newResourceType) {
		ResourceType oldResourceType = resourceType;
		resourceType = newResourceType == null ? RESOURCE_TYPE_EDEFAULT : newResourceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MelangePackage.LANGUAGE__RESOURCE_TYPE, oldResourceType, resourceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResourceUri() {
		return resourceUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceUri(String newResourceUri) {
		String oldResourceUri = resourceUri;
		resourceUri = newResourceUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MelangePackage.LANGUAGE__RESOURCE_URI, oldResourceUri, resourceUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MelangePackage.LANGUAGE__EXACT_TYPE:
				if (exactType != null)
					msgs = ((InternalEObject)exactType).eInverseRemove(this, MelangePackage.MODEL_TYPE__EXTRACTED, ModelType.class, msgs);
				return basicSetExactType((ModelType)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MelangePackage.LANGUAGE__OPERATORS:
				return ((InternalEList<?>)getOperators()).basicRemove(otherEnd, msgs);
			case MelangePackage.LANGUAGE__EXACT_TYPE:
				return basicSetExactType(null, msgs);
			case MelangePackage.LANGUAGE__SYNTAX:
				return basicSetSyntax(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MelangePackage.LANGUAGE__OPERATORS:
				return getOperators();
			case MelangePackage.LANGUAGE__EXACT_TYPE:
				if (resolve) return getExactType();
				return basicGetExactType();
			case MelangePackage.LANGUAGE__IMPLEMENTS:
				return getImplements();
			case MelangePackage.LANGUAGE__REQUIRES:
				return getRequires();
			case MelangePackage.LANGUAGE__SYNTAX:
				return getSyntax();
			case MelangePackage.LANGUAGE__SEMANTICS:
				if (resolve) return getSemantics();
				return basicGetSemantics();
			case MelangePackage.LANGUAGE__EXACT_TYPE_NAME:
				return getExactTypeName();
			case MelangePackage.LANGUAGE__EXACT_TYPE_URI:
				return getExactTypeUri();
			case MelangePackage.LANGUAGE__RESOURCE_TYPE:
				return getResourceType();
			case MelangePackage.LANGUAGE__RESOURCE_URI:
				return getResourceUri();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MelangePackage.LANGUAGE__OPERATORS:
				getOperators().clear();
				getOperators().addAll((Collection<? extends Operator>)newValue);
				return;
			case MelangePackage.LANGUAGE__EXACT_TYPE:
				setExactType((ModelType)newValue);
				return;
			case MelangePackage.LANGUAGE__IMPLEMENTS:
				getImplements().clear();
				getImplements().addAll((Collection<? extends ModelType>)newValue);
				return;
			case MelangePackage.LANGUAGE__REQUIRES:
				getRequires().clear();
				getRequires().addAll((Collection<? extends ModelType>)newValue);
				return;
			case MelangePackage.LANGUAGE__SYNTAX:
				setSyntax((Metamodel)newValue);
				return;
			case MelangePackage.LANGUAGE__SEMANTICS:
				setSemantics((Aspect)newValue);
				return;
			case MelangePackage.LANGUAGE__EXACT_TYPE_NAME:
				setExactTypeName((String)newValue);
				return;
			case MelangePackage.LANGUAGE__EXACT_TYPE_URI:
				setExactTypeUri((String)newValue);
				return;
			case MelangePackage.LANGUAGE__RESOURCE_TYPE:
				setResourceType((ResourceType)newValue);
				return;
			case MelangePackage.LANGUAGE__RESOURCE_URI:
				setResourceUri((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MelangePackage.LANGUAGE__OPERATORS:
				getOperators().clear();
				return;
			case MelangePackage.LANGUAGE__EXACT_TYPE:
				setExactType((ModelType)null);
				return;
			case MelangePackage.LANGUAGE__IMPLEMENTS:
				getImplements().clear();
				return;
			case MelangePackage.LANGUAGE__REQUIRES:
				getRequires().clear();
				return;
			case MelangePackage.LANGUAGE__SYNTAX:
				setSyntax((Metamodel)null);
				return;
			case MelangePackage.LANGUAGE__SEMANTICS:
				setSemantics((Aspect)null);
				return;
			case MelangePackage.LANGUAGE__EXACT_TYPE_NAME:
				setExactTypeName(EXACT_TYPE_NAME_EDEFAULT);
				return;
			case MelangePackage.LANGUAGE__EXACT_TYPE_URI:
				setExactTypeUri(EXACT_TYPE_URI_EDEFAULT);
				return;
			case MelangePackage.LANGUAGE__RESOURCE_TYPE:
				setResourceType(RESOURCE_TYPE_EDEFAULT);
				return;
			case MelangePackage.LANGUAGE__RESOURCE_URI:
				setResourceUri(RESOURCE_URI_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MelangePackage.LANGUAGE__OPERATORS:
				return operators != null && !operators.isEmpty();
			case MelangePackage.LANGUAGE__EXACT_TYPE:
				return exactType != null;
			case MelangePackage.LANGUAGE__IMPLEMENTS:
				return implements_ != null && !implements_.isEmpty();
			case MelangePackage.LANGUAGE__REQUIRES:
				return requires != null && !requires.isEmpty();
			case MelangePackage.LANGUAGE__SYNTAX:
				return syntax != null;
			case MelangePackage.LANGUAGE__SEMANTICS:
				return semantics != null;
			case MelangePackage.LANGUAGE__EXACT_TYPE_NAME:
				return EXACT_TYPE_NAME_EDEFAULT == null ? exactTypeName != null : !EXACT_TYPE_NAME_EDEFAULT.equals(exactTypeName);
			case MelangePackage.LANGUAGE__EXACT_TYPE_URI:
				return EXACT_TYPE_URI_EDEFAULT == null ? exactTypeUri != null : !EXACT_TYPE_URI_EDEFAULT.equals(exactTypeUri);
			case MelangePackage.LANGUAGE__RESOURCE_TYPE:
				return resourceType != RESOURCE_TYPE_EDEFAULT;
			case MelangePackage.LANGUAGE__RESOURCE_URI:
				return RESOURCE_URI_EDEFAULT == null ? resourceUri != null : !RESOURCE_URI_EDEFAULT.equals(resourceUri);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (exactTypeName: ");
		result.append(exactTypeName);
		result.append(", exactTypeUri: ");
		result.append(exactTypeUri);
		result.append(", resourceType: ");
		result.append(resourceType);
		result.append(", resourceUri: ");
		result.append(resourceUri);
		result.append(')');
		return result.toString();
	}

} //LanguageImpl