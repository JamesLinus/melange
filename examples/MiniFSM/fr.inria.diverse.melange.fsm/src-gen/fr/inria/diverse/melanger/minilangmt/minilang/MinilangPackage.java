/**
 */
package fr.inria.diverse.melanger.minilangmt.minilang;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.inria.diverse.melanger.minilangmt.minilang.MinilangFactory
 * @model kind="package"
 * @generated
 */
public interface MinilangPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "minilang";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://minilangmt/minilang/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "minilang";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MinilangPackage eINSTANCE = fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl.init();

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.IntExpressionImpl <em>Int Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.IntExpressionImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getIntExpression()
	 * @generated
	 */
	int INT_EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Int Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.IntegerImpl <em>Integer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.IntegerImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getInteger()
	 * @generated
	 */
	int INTEGER = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER__VALUE = INT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_FEATURE_COUNT = INT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.BooleanExpressionImpl <em>Boolean Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.BooleanExpressionImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getBooleanExpression()
	 * @generated
	 */
	int BOOLEAN_EXPRESSION = 17;

	/**
	 * The number of structural features of the '<em>Boolean Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.BooleanImpl <em>Boolean</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.BooleanImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getBoolean()
	 * @generated
	 */
	int BOOLEAN = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN__VALUE = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.IntOperationImpl <em>Int Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.IntOperationImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getIntOperation()
	 * @generated
	 */
	int INT_OPERATION = 3;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_OPERATION__RIGHT = INT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_OPERATION__LEFT = INT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Int Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_OPERATION_FEATURE_COUNT = INT_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.IntComparisonImpl <em>Int Comparison</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.IntComparisonImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getIntComparison()
	 * @generated
	 */
	int INT_COMPARISON = 16;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_COMPARISON__RIGHT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_COMPARISON__LEFT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Int Comparison</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_COMPARISON_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.EqualImpl <em>Equal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.EqualImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getEqual()
	 * @generated
	 */
	int EQUAL = 4;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL__RIGHT = INT_COMPARISON__RIGHT;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL__LEFT = INT_COMPARISON__LEFT;

	/**
	 * The number of structural features of the '<em>Equal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL_FEATURE_COUNT = INT_COMPARISON_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.GreaterImpl <em>Greater</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.GreaterImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getGreater()
	 * @generated
	 */
	int GREATER = 5;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER__RIGHT = INT_COMPARISON__RIGHT;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER__LEFT = INT_COMPARISON__LEFT;

	/**
	 * The number of structural features of the '<em>Greater</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_FEATURE_COUNT = INT_COMPARISON_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.GreaterOrEqualImpl <em>Greater Or Equal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.GreaterOrEqualImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getGreaterOrEqual()
	 * @generated
	 */
	int GREATER_OR_EQUAL = 6;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_OR_EQUAL__RIGHT = INT_COMPARISON__RIGHT;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_OR_EQUAL__LEFT = INT_COMPARISON__LEFT;

	/**
	 * The number of structural features of the '<em>Greater Or Equal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_OR_EQUAL_FEATURE_COUNT = INT_COMPARISON_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.LessImpl <em>Less</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.LessImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getLess()
	 * @generated
	 */
	int LESS = 7;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS__RIGHT = INT_COMPARISON__RIGHT;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS__LEFT = INT_COMPARISON__LEFT;

	/**
	 * The number of structural features of the '<em>Less</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_FEATURE_COUNT = INT_COMPARISON_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.LessOrEqualImpl <em>Less Or Equal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.LessOrEqualImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getLessOrEqual()
	 * @generated
	 */
	int LESS_OR_EQUAL = 8;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_OR_EQUAL__RIGHT = INT_COMPARISON__RIGHT;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_OR_EQUAL__LEFT = INT_COMPARISON__LEFT;

	/**
	 * The number of structural features of the '<em>Less Or Equal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_OR_EQUAL_FEATURE_COUNT = INT_COMPARISON_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.NotImpl <em>Not</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.NotImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getNot()
	 * @generated
	 */
	int NOT = 9;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__EXPRESSION = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Not</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.BooleanOperationImpl <em>Boolean Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.BooleanOperationImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getBooleanOperation()
	 * @generated
	 */
	int BOOLEAN_OPERATION = 18;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OPERATION__LEFT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OPERATION__RIGHT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Boolean Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OPERATION_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.OrImpl <em>Or</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.OrImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getOr()
	 * @generated
	 */
	int OR = 10;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__LEFT = BOOLEAN_OPERATION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__RIGHT = BOOLEAN_OPERATION__RIGHT;

	/**
	 * The number of structural features of the '<em>Or</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_COUNT = BOOLEAN_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.AndImpl <em>And</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.AndImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getAnd()
	 * @generated
	 */
	int AND = 11;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__LEFT = BOOLEAN_OPERATION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__RIGHT = BOOLEAN_OPERATION__RIGHT;

	/**
	 * The number of structural features of the '<em>And</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_COUNT = BOOLEAN_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.PlusImpl <em>Plus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.PlusImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getPlus()
	 * @generated
	 */
	int PLUS = 12;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS__RIGHT = INT_OPERATION__RIGHT;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS__LEFT = INT_OPERATION__LEFT;

	/**
	 * The number of structural features of the '<em>Plus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS_FEATURE_COUNT = INT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.MinusImpl <em>Minus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinusImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getMinus()
	 * @generated
	 */
	int MINUS = 13;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS__RIGHT = INT_OPERATION__RIGHT;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS__LEFT = INT_OPERATION__LEFT;

	/**
	 * The number of structural features of the '<em>Minus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS_FEATURE_COUNT = INT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.MultiplyImpl <em>Multiply</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MultiplyImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getMultiply()
	 * @generated
	 */
	int MULTIPLY = 14;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY__RIGHT = INT_OPERATION__RIGHT;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY__LEFT = INT_OPERATION__LEFT;

	/**
	 * The number of structural features of the '<em>Multiply</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY_FEATURE_COUNT = INT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.DivideImpl <em>Divide</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.DivideImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getDivide()
	 * @generated
	 */
	int DIVIDE = 15;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVIDE__RIGHT = INT_OPERATION__RIGHT;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVIDE__LEFT = INT_OPERATION__LEFT;

	/**
	 * The number of structural features of the '<em>Divide</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVIDE_FEATURE_COUNT = INT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.VariableRefImpl <em>Variable Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.VariableRefImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getVariableRef()
	 * @generated
	 */
	int VARIABLE_REF = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REF__NAME = 0;

	/**
	 * The number of structural features of the '<em>Variable Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REF_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.BooleanVariableRefImpl <em>Boolean Variable Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.BooleanVariableRefImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getBooleanVariableRef()
	 * @generated
	 */
	int BOOLEAN_VARIABLE_REF = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VARIABLE_REF__NAME = VARIABLE_REF__NAME;

	/**
	 * The number of structural features of the '<em>Boolean Variable Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VARIABLE_REF_FEATURE_COUNT = VARIABLE_REF_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.IntVariableRefImpl <em>Int Variable Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.IntVariableRefImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getIntVariableRef()
	 * @generated
	 */
	int INT_VARIABLE_REF = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_VARIABLE_REF__NAME = VARIABLE_REF__NAME;

	/**
	 * The number of structural features of the '<em>Int Variable Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_VARIABLE_REF_FEATURE_COUNT = VARIABLE_REF_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.StatementImpl <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.StatementImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getStatement()
	 * @generated
	 */
	int STATEMENT = 22;

	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.BooleanAssignemntImpl <em>Boolean Assignemnt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.BooleanAssignemntImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getBooleanAssignemnt()
	 * @generated
	 */
	int BOOLEAN_ASSIGNEMNT = 23;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ASSIGNEMNT__VARIABLE = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ASSIGNEMNT__VALUE = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Boolean Assignemnt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ASSIGNEMNT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.IntAssignementImpl <em>Int Assignement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.IntAssignementImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getIntAssignement()
	 * @generated
	 */
	int INT_ASSIGNEMENT = 24;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_ASSIGNEMENT__VARIABLE = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_ASSIGNEMENT__VALUE = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Int Assignement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_ASSIGNEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.PrintVarImpl <em>Print Var</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.PrintVarImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getPrintVar()
	 * @generated
	 */
	int PRINT_VAR = 25;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINT_VAR__VALUE = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Print Var</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINT_VAR_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.PrintStrImpl <em>Print Str</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.PrintStrImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getPrintStr()
	 * @generated
	 */
	int PRINT_STR = 26;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINT_STR__VALUE = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Print Str</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINT_STR_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.BlockImpl <em>Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.BlockImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getBlock()
	 * @generated
	 */
	int BLOCK = 27;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__STATEMENT = 0;

	/**
	 * The number of structural features of the '<em>Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.IfImpl <em>If</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.IfImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getIf()
	 * @generated
	 */
	int IF = 28;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__CONDITION = 0;

	/**
	 * The feature id for the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__THEN = 1;

	/**
	 * The feature id for the '<em><b>Else</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__ELSE = 2;

	/**
	 * The number of structural features of the '<em>If</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.WhileImpl <em>While</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.WhileImpl
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getWhile()
	 * @generated
	 */
	int WHILE = 29;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE__CONDITION = 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE__BODY = 1;

	/**
	 * The number of structural features of the '<em>While</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.IntExpression <em>Int Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Expression</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.IntExpression
	 * @generated
	 */
	EClass getIntExpression();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.Integer <em>Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.Integer
	 * @generated
	 */
	EClass getInteger();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.diverse.melanger.minilangmt.minilang.Integer#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.Integer#getValue()
	 * @see #getInteger()
	 * @generated
	 */
	EAttribute getInteger_Value();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.Boolean <em>Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.Boolean
	 * @generated
	 */
	EClass getBoolean();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.diverse.melanger.minilangmt.minilang.Boolean#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.Boolean#isValue()
	 * @see #getBoolean()
	 * @generated
	 */
	EAttribute getBoolean_Value();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.IntOperation <em>Int Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Operation</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.IntOperation
	 * @generated
	 */
	EClass getIntOperation();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.diverse.melanger.minilangmt.minilang.IntOperation#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.IntOperation#getRight()
	 * @see #getIntOperation()
	 * @generated
	 */
	EReference getIntOperation_Right();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.diverse.melanger.minilangmt.minilang.IntOperation#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.IntOperation#getLeft()
	 * @see #getIntOperation()
	 * @generated
	 */
	EReference getIntOperation_Left();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.Equal <em>Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equal</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.Equal
	 * @generated
	 */
	EClass getEqual();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.Greater <em>Greater</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Greater</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.Greater
	 * @generated
	 */
	EClass getGreater();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.GreaterOrEqual <em>Greater Or Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Greater Or Equal</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.GreaterOrEqual
	 * @generated
	 */
	EClass getGreaterOrEqual();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.Less <em>Less</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Less</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.Less
	 * @generated
	 */
	EClass getLess();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.LessOrEqual <em>Less Or Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Less Or Equal</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.LessOrEqual
	 * @generated
	 */
	EClass getLessOrEqual();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.Not <em>Not</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.Not
	 * @generated
	 */
	EClass getNot();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.diverse.melanger.minilangmt.minilang.Not#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.Not#getExpression()
	 * @see #getNot()
	 * @generated
	 */
	EReference getNot_Expression();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.Or <em>Or</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.Or
	 * @generated
	 */
	EClass getOr();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.And <em>And</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.And
	 * @generated
	 */
	EClass getAnd();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.Plus <em>Plus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plus</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.Plus
	 * @generated
	 */
	EClass getPlus();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.Minus <em>Minus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Minus</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.Minus
	 * @generated
	 */
	EClass getMinus();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.Multiply <em>Multiply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiply</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.Multiply
	 * @generated
	 */
	EClass getMultiply();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.Divide <em>Divide</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Divide</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.Divide
	 * @generated
	 */
	EClass getDivide();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.IntComparison <em>Int Comparison</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Comparison</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.IntComparison
	 * @generated
	 */
	EClass getIntComparison();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.diverse.melanger.minilangmt.minilang.IntComparison#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.IntComparison#getRight()
	 * @see #getIntComparison()
	 * @generated
	 */
	EReference getIntComparison_Right();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.diverse.melanger.minilangmt.minilang.IntComparison#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.IntComparison#getLeft()
	 * @see #getIntComparison()
	 * @generated
	 */
	EReference getIntComparison_Left();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.BooleanExpression <em>Boolean Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Expression</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.BooleanExpression
	 * @generated
	 */
	EClass getBooleanExpression();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.BooleanOperation <em>Boolean Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Operation</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.BooleanOperation
	 * @generated
	 */
	EClass getBooleanOperation();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.diverse.melanger.minilangmt.minilang.BooleanOperation#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.BooleanOperation#getLeft()
	 * @see #getBooleanOperation()
	 * @generated
	 */
	EReference getBooleanOperation_Left();

	/**
	 * Returns the meta object for the reference '{@link fr.inria.diverse.melanger.minilangmt.minilang.BooleanOperation#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.BooleanOperation#getRight()
	 * @see #getBooleanOperation()
	 * @generated
	 */
	EReference getBooleanOperation_Right();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.BooleanVariableRef <em>Boolean Variable Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Variable Ref</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.BooleanVariableRef
	 * @generated
	 */
	EClass getBooleanVariableRef();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.IntVariableRef <em>Int Variable Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Variable Ref</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.IntVariableRef
	 * @generated
	 */
	EClass getIntVariableRef();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.VariableRef <em>Variable Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Ref</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.VariableRef
	 * @generated
	 */
	EClass getVariableRef();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.diverse.melanger.minilangmt.minilang.VariableRef#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.VariableRef#getName()
	 * @see #getVariableRef()
	 * @generated
	 */
	EAttribute getVariableRef_Name();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.Statement
	 * @generated
	 */
	EClass getStatement();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.BooleanAssignemnt <em>Boolean Assignemnt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Assignemnt</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.BooleanAssignemnt
	 * @generated
	 */
	EClass getBooleanAssignemnt();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.diverse.melanger.minilangmt.minilang.BooleanAssignemnt#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.BooleanAssignemnt#getVariable()
	 * @see #getBooleanAssignemnt()
	 * @generated
	 */
	EReference getBooleanAssignemnt_Variable();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.diverse.melanger.minilangmt.minilang.BooleanAssignemnt#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.BooleanAssignemnt#getValue()
	 * @see #getBooleanAssignemnt()
	 * @generated
	 */
	EReference getBooleanAssignemnt_Value();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.IntAssignement <em>Int Assignement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Assignement</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.IntAssignement
	 * @generated
	 */
	EClass getIntAssignement();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.diverse.melanger.minilangmt.minilang.IntAssignement#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.IntAssignement#getVariable()
	 * @see #getIntAssignement()
	 * @generated
	 */
	EReference getIntAssignement_Variable();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.diverse.melanger.minilangmt.minilang.IntAssignement#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.IntAssignement#getValue()
	 * @see #getIntAssignement()
	 * @generated
	 */
	EReference getIntAssignement_Value();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.PrintVar <em>Print Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Print Var</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.PrintVar
	 * @generated
	 */
	EClass getPrintVar();

	/**
	 * Returns the meta object for the reference '{@link fr.inria.diverse.melanger.minilangmt.minilang.PrintVar#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.PrintVar#getValue()
	 * @see #getPrintVar()
	 * @generated
	 */
	EReference getPrintVar_Value();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.PrintStr <em>Print Str</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Print Str</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.PrintStr
	 * @generated
	 */
	EClass getPrintStr();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.diverse.melanger.minilangmt.minilang.PrintStr#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.PrintStr#getValue()
	 * @see #getPrintStr()
	 * @generated
	 */
	EAttribute getPrintStr_Value();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.Block <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.Block
	 * @generated
	 */
	EClass getBlock();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.inria.diverse.melanger.minilangmt.minilang.Block#getStatement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statement</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.Block#getStatement()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_Statement();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.If <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.If
	 * @generated
	 */
	EClass getIf();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.diverse.melanger.minilangmt.minilang.If#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.If#getCondition()
	 * @see #getIf()
	 * @generated
	 */
	EReference getIf_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.diverse.melanger.minilangmt.minilang.If#getThen <em>Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.If#getThen()
	 * @see #getIf()
	 * @generated
	 */
	EReference getIf_Then();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.diverse.melanger.minilangmt.minilang.If#getElse <em>Else</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.If#getElse()
	 * @see #getIf()
	 * @generated
	 */
	EReference getIf_Else();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.melanger.minilangmt.minilang.While <em>While</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>While</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.While
	 * @generated
	 */
	EClass getWhile();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.diverse.melanger.minilangmt.minilang.While#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.While#getCondition()
	 * @see #getWhile()
	 * @generated
	 */
	EReference getWhile_Condition();

	/**
	 * Returns the meta object for the reference '{@link fr.inria.diverse.melanger.minilangmt.minilang.While#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Body</em>'.
	 * @see fr.inria.diverse.melanger.minilangmt.minilang.While#getBody()
	 * @see #getWhile()
	 * @generated
	 */
	EReference getWhile_Body();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MinilangFactory getMinilangFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.IntExpressionImpl <em>Int Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.IntExpressionImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getIntExpression()
		 * @generated
		 */
		EClass INT_EXPRESSION = eINSTANCE.getIntExpression();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.IntegerImpl <em>Integer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.IntegerImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getInteger()
		 * @generated
		 */
		EClass INTEGER = eINSTANCE.getInteger();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER__VALUE = eINSTANCE.getInteger_Value();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.BooleanImpl <em>Boolean</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.BooleanImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getBoolean()
		 * @generated
		 */
		EClass BOOLEAN = eINSTANCE.getBoolean();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN__VALUE = eINSTANCE.getBoolean_Value();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.IntOperationImpl <em>Int Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.IntOperationImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getIntOperation()
		 * @generated
		 */
		EClass INT_OPERATION = eINSTANCE.getIntOperation();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INT_OPERATION__RIGHT = eINSTANCE.getIntOperation_Right();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INT_OPERATION__LEFT = eINSTANCE.getIntOperation_Left();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.EqualImpl <em>Equal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.EqualImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getEqual()
		 * @generated
		 */
		EClass EQUAL = eINSTANCE.getEqual();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.GreaterImpl <em>Greater</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.GreaterImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getGreater()
		 * @generated
		 */
		EClass GREATER = eINSTANCE.getGreater();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.GreaterOrEqualImpl <em>Greater Or Equal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.GreaterOrEqualImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getGreaterOrEqual()
		 * @generated
		 */
		EClass GREATER_OR_EQUAL = eINSTANCE.getGreaterOrEqual();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.LessImpl <em>Less</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.LessImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getLess()
		 * @generated
		 */
		EClass LESS = eINSTANCE.getLess();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.LessOrEqualImpl <em>Less Or Equal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.LessOrEqualImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getLessOrEqual()
		 * @generated
		 */
		EClass LESS_OR_EQUAL = eINSTANCE.getLessOrEqual();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.NotImpl <em>Not</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.NotImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getNot()
		 * @generated
		 */
		EClass NOT = eINSTANCE.getNot();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOT__EXPRESSION = eINSTANCE.getNot_Expression();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.OrImpl <em>Or</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.OrImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getOr()
		 * @generated
		 */
		EClass OR = eINSTANCE.getOr();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.AndImpl <em>And</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.AndImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getAnd()
		 * @generated
		 */
		EClass AND = eINSTANCE.getAnd();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.PlusImpl <em>Plus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.PlusImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getPlus()
		 * @generated
		 */
		EClass PLUS = eINSTANCE.getPlus();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.MinusImpl <em>Minus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinusImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getMinus()
		 * @generated
		 */
		EClass MINUS = eINSTANCE.getMinus();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.MultiplyImpl <em>Multiply</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MultiplyImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getMultiply()
		 * @generated
		 */
		EClass MULTIPLY = eINSTANCE.getMultiply();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.DivideImpl <em>Divide</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.DivideImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getDivide()
		 * @generated
		 */
		EClass DIVIDE = eINSTANCE.getDivide();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.IntComparisonImpl <em>Int Comparison</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.IntComparisonImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getIntComparison()
		 * @generated
		 */
		EClass INT_COMPARISON = eINSTANCE.getIntComparison();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INT_COMPARISON__RIGHT = eINSTANCE.getIntComparison_Right();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INT_COMPARISON__LEFT = eINSTANCE.getIntComparison_Left();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.BooleanExpressionImpl <em>Boolean Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.BooleanExpressionImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getBooleanExpression()
		 * @generated
		 */
		EClass BOOLEAN_EXPRESSION = eINSTANCE.getBooleanExpression();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.BooleanOperationImpl <em>Boolean Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.BooleanOperationImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getBooleanOperation()
		 * @generated
		 */
		EClass BOOLEAN_OPERATION = eINSTANCE.getBooleanOperation();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_OPERATION__LEFT = eINSTANCE.getBooleanOperation_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_OPERATION__RIGHT = eINSTANCE.getBooleanOperation_Right();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.BooleanVariableRefImpl <em>Boolean Variable Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.BooleanVariableRefImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getBooleanVariableRef()
		 * @generated
		 */
		EClass BOOLEAN_VARIABLE_REF = eINSTANCE.getBooleanVariableRef();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.IntVariableRefImpl <em>Int Variable Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.IntVariableRefImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getIntVariableRef()
		 * @generated
		 */
		EClass INT_VARIABLE_REF = eINSTANCE.getIntVariableRef();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.VariableRefImpl <em>Variable Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.VariableRefImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getVariableRef()
		 * @generated
		 */
		EClass VARIABLE_REF = eINSTANCE.getVariableRef();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_REF__NAME = eINSTANCE.getVariableRef_Name();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.StatementImpl <em>Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.StatementImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getStatement()
		 * @generated
		 */
		EClass STATEMENT = eINSTANCE.getStatement();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.BooleanAssignemntImpl <em>Boolean Assignemnt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.BooleanAssignemntImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getBooleanAssignemnt()
		 * @generated
		 */
		EClass BOOLEAN_ASSIGNEMNT = eINSTANCE.getBooleanAssignemnt();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_ASSIGNEMNT__VARIABLE = eINSTANCE.getBooleanAssignemnt_Variable();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_ASSIGNEMNT__VALUE = eINSTANCE.getBooleanAssignemnt_Value();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.IntAssignementImpl <em>Int Assignement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.IntAssignementImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getIntAssignement()
		 * @generated
		 */
		EClass INT_ASSIGNEMENT = eINSTANCE.getIntAssignement();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INT_ASSIGNEMENT__VARIABLE = eINSTANCE.getIntAssignement_Variable();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INT_ASSIGNEMENT__VALUE = eINSTANCE.getIntAssignement_Value();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.PrintVarImpl <em>Print Var</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.PrintVarImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getPrintVar()
		 * @generated
		 */
		EClass PRINT_VAR = eINSTANCE.getPrintVar();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRINT_VAR__VALUE = eINSTANCE.getPrintVar_Value();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.PrintStrImpl <em>Print Str</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.PrintStrImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getPrintStr()
		 * @generated
		 */
		EClass PRINT_STR = eINSTANCE.getPrintStr();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRINT_STR__VALUE = eINSTANCE.getPrintStr_Value();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.BlockImpl <em>Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.BlockImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getBlock()
		 * @generated
		 */
		EClass BLOCK = eINSTANCE.getBlock();

		/**
		 * The meta object literal for the '<em><b>Statement</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__STATEMENT = eINSTANCE.getBlock_Statement();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.IfImpl <em>If</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.IfImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getIf()
		 * @generated
		 */
		EClass IF = eINSTANCE.getIf();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF__CONDITION = eINSTANCE.getIf_Condition();

		/**
		 * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF__THEN = eINSTANCE.getIf_Then();

		/**
		 * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF__ELSE = eINSTANCE.getIf_Else();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.melanger.minilangmt.minilang.impl.WhileImpl <em>While</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.WhileImpl
		 * @see fr.inria.diverse.melanger.minilangmt.minilang.impl.MinilangPackageImpl#getWhile()
		 * @generated
		 */
		EClass WHILE = eINSTANCE.getWhile();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHILE__CONDITION = eINSTANCE.getWhile_Condition();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHILE__BODY = eINSTANCE.getWhile_Body();

	}

} //MinilangPackage
