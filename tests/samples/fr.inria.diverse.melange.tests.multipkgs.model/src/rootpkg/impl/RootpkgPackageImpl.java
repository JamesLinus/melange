/**
 */
package rootpkg.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import root.RootPackage;

import rootpkg.NewClass;
import rootpkg.RootpkgFactory;
import rootpkg.RootpkgPackage;

import toppkg.ToppkgPackage;

import toppkg.subpkg2.Subpkg2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RootpkgPackageImpl extends EPackageImpl implements RootpkgPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newClassEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see rootpkg.RootpkgPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RootpkgPackageImpl() {
		super(eNS_URI, RootpkgFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link RootpkgPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RootpkgPackage init() {
		if (isInited) return (RootpkgPackage)EPackage.Registry.INSTANCE.getEPackage(RootpkgPackage.eNS_URI);

		// Obtain or create and register package
		RootpkgPackageImpl theRootpkgPackage = (RootpkgPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RootpkgPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RootpkgPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		RootPackage.eINSTANCE.eClass();
		ToppkgPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theRootpkgPackage.createPackageContents();

		// Initialize created meta-data
		theRootpkgPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRootpkgPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RootpkgPackage.eNS_URI, theRootpkgPackage);
		return theRootpkgPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewClass() {
		return newClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNewClass_ToSubpkg2Class1() {
		return (EReference)newClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootpkgFactory getRootpkgFactory() {
		return (RootpkgFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		newClassEClass = createEClass(NEW_CLASS);
		createEReference(newClassEClass, NEW_CLASS__TO_SUBPKG2_CLASS1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		RootPackage theRootPackage = (RootPackage)EPackage.Registry.INSTANCE.getEPackage(RootPackage.eNS_URI);
		Subpkg2Package theSubpkg2Package = (Subpkg2Package)EPackage.Registry.INSTANCE.getEPackage(Subpkg2Package.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		newClassEClass.getESuperTypes().add(theRootPackage.getClass_());

		// Initialize classes, features, and operations; add parameters
		initEClass(newClassEClass, NewClass.class, "NewClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNewClass_ToSubpkg2Class1(), theSubpkg2Package.getSubpkg2Class1(), null, "toSubpkg2Class1", null, 0, 1, NewClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //RootpkgPackageImpl
