/**
 */
package fr.inria.diverse.melange.metamodel.melange.impl;

import fr.inria.diverse.melange.metamodel.melange.Ecore;
import fr.inria.diverse.melange.metamodel.melange.MelangePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ecore</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.melange.metamodel.melange.impl.EcoreImpl#getEcoreUri <em>Ecore Uri</em>}</li>
 *   <li>{@link fr.inria.diverse.melange.metamodel.melange.impl.EcoreImpl#getGenmodelUris <em>Genmodel Uris</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EcoreImpl extends OperatorImpl implements Ecore {
	/**
	 * The default value of the '{@link #getEcoreUri() <em>Ecore Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcoreUri()
	 * @generated
	 * @ordered
	 */
	protected static final String ECORE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEcoreUri() <em>Ecore Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcoreUri()
	 * @generated
	 * @ordered
	 */
	protected String ecoreUri = ECORE_URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGenmodelUris() <em>Genmodel Uris</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenmodelUris()
	 * @generated
	 * @ordered
	 */
	protected EList<String> genmodelUris;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EcoreImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MelangePackage.Literals.ECORE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEcoreUri() {
		return ecoreUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEcoreUri(String newEcoreUri) {
		String oldEcoreUri = ecoreUri;
		ecoreUri = newEcoreUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MelangePackage.ECORE__ECORE_URI, oldEcoreUri, ecoreUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getGenmodelUris() {
		if (genmodelUris == null) {
			genmodelUris = new EDataTypeUniqueEList<String>(String.class, this, MelangePackage.ECORE__GENMODEL_URIS);
		}
		return genmodelUris;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MelangePackage.ECORE__ECORE_URI:
				return getEcoreUri();
			case MelangePackage.ECORE__GENMODEL_URIS:
				return getGenmodelUris();
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
			case MelangePackage.ECORE__ECORE_URI:
				setEcoreUri((String)newValue);
				return;
			case MelangePackage.ECORE__GENMODEL_URIS:
				getGenmodelUris().clear();
				getGenmodelUris().addAll((Collection<? extends String>)newValue);
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
			case MelangePackage.ECORE__ECORE_URI:
				setEcoreUri(ECORE_URI_EDEFAULT);
				return;
			case MelangePackage.ECORE__GENMODEL_URIS:
				getGenmodelUris().clear();
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
			case MelangePackage.ECORE__ECORE_URI:
				return ECORE_URI_EDEFAULT == null ? ecoreUri != null : !ECORE_URI_EDEFAULT.equals(ecoreUri);
			case MelangePackage.ECORE__GENMODEL_URIS:
				return genmodelUris != null && !genmodelUris.isEmpty();
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
		result.append(" (ecoreUri: ");
		result.append(ecoreUri);
		result.append(", genmodelUris: ");
		result.append(genmodelUris);
		result.append(')');
		return result.toString();
	}

} //EcoreImpl
