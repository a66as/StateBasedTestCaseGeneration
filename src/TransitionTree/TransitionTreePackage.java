/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package TransitionTree;

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
 * @see TransitionTree.TransitionTreeFactory
 * @model kind="package"
 * @generated
 */
public interface TransitionTreePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "TransitionTree";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "a66askhan.github.io";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "TT";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TransitionTreePackage eINSTANCE = TransitionTree.impl.TransitionTreePackageImpl.init();

	/**
	 * The meta object id for the '{@link TransitionTree.impl.TreeImpl <em>Tree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TransitionTree.impl.TreeImpl
	 * @see TransitionTree.impl.TransitionTreePackageImpl#getTree()
	 * @generated
	 */
	int TREE = 0;

	/**
	 * The feature id for the '<em><b>Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__ROOT = 0;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__NODES = 1;

	/**
	 * The number of structural features of the '<em>Tree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link TransitionTree.impl.StateNodeImpl <em>State Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TransitionTree.impl.StateNodeImpl
	 * @see TransitionTree.impl.TransitionTreePackageImpl#getStateNode()
	 * @generated
	 */
	int STATE_NODE = 1;

	/**
	 * The feature id for the '<em><b>State Obj</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_NODE__STATE_OBJ = 0;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_NODE__TRANSITIONS = 1;

	/**
	 * The number of structural features of the '<em>State Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_NODE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link TransitionTree.impl.TransitionNodeImpl <em>Transition Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TransitionTree.impl.TransitionNodeImpl
	 * @see TransitionTree.impl.TransitionTreePackageImpl#getTransitionNode()
	 * @generated
	 */
	int TRANSITION_NODE = 2;

	/**
	 * The feature id for the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_NODE__ACTION = 0;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_NODE__GUARD = 1;

	/**
	 * The feature id for the '<em><b>Action Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_NODE__ACTION_BODY = 2;

	/**
	 * The feature id for the '<em><b>Dest</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_NODE__DEST = 3;

	/**
	 * The feature id for the '<em><b>Guard Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_NODE__GUARD_BODY = 4;

	/**
	 * The number of structural features of the '<em>Transition Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_NODE_FEATURE_COUNT = 5;


	/**
	 * Returns the meta object for class '{@link TransitionTree.Tree <em>Tree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tree</em>'.
	 * @see TransitionTree.Tree
	 * @generated
	 */
	EClass getTree();

	/**
	 * Returns the meta object for the attribute '{@link TransitionTree.Tree#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Root</em>'.
	 * @see TransitionTree.Tree#getRoot()
	 * @see #getTree()
	 * @generated
	 */
	EAttribute getTree_Root();

	/**
	 * Returns the meta object for the containment reference '{@link TransitionTree.Tree#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Nodes</em>'.
	 * @see TransitionTree.Tree#getNodes()
	 * @see #getTree()
	 * @generated
	 */
	EReference getTree_Nodes();

	/**
	 * Returns the meta object for class '{@link TransitionTree.StateNode <em>State Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Node</em>'.
	 * @see TransitionTree.StateNode
	 * @generated
	 */
	EClass getStateNode();

	/**
	 * Returns the meta object for the attribute '{@link TransitionTree.StateNode#getStateObj <em>State Obj</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State Obj</em>'.
	 * @see TransitionTree.StateNode#getStateObj()
	 * @see #getStateNode()
	 * @generated
	 */
	EAttribute getStateNode_StateObj();

	/**
	 * Returns the meta object for the attribute '{@link TransitionTree.StateNode#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transitions</em>'.
	 * @see TransitionTree.StateNode#getTransitions()
	 * @see #getStateNode()
	 * @generated
	 */
	EAttribute getStateNode_Transitions();

	/**
	 * Returns the meta object for class '{@link TransitionTree.TransitionNode <em>Transition Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition Node</em>'.
	 * @see TransitionTree.TransitionNode
	 * @generated
	 */
	EClass getTransitionNode();

	/**
	 * Returns the meta object for the attribute '{@link TransitionTree.TransitionNode#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action</em>'.
	 * @see TransitionTree.TransitionNode#getAction()
	 * @see #getTransitionNode()
	 * @generated
	 */
	EAttribute getTransitionNode_Action();

	/**
	 * Returns the meta object for the attribute '{@link TransitionTree.TransitionNode#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Guard</em>'.
	 * @see TransitionTree.TransitionNode#getGuard()
	 * @see #getTransitionNode()
	 * @generated
	 */
	EAttribute getTransitionNode_Guard();

	/**
	 * Returns the meta object for the attribute '{@link TransitionTree.TransitionNode#getActionBody <em>Action Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action Body</em>'.
	 * @see TransitionTree.TransitionNode#getActionBody()
	 * @see #getTransitionNode()
	 * @generated
	 */
	EAttribute getTransitionNode_ActionBody();

	/**
	 * Returns the meta object for the reference '{@link TransitionTree.TransitionNode#getDest <em>Dest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dest</em>'.
	 * @see TransitionTree.TransitionNode#getDest()
	 * @see #getTransitionNode()
	 * @generated
	 */
	EReference getTransitionNode_Dest();

	/**
	 * Returns the meta object for the attribute '{@link TransitionTree.TransitionNode#getGuardBody <em>Guard Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Guard Body</em>'.
	 * @see TransitionTree.TransitionNode#getGuardBody()
	 * @see #getTransitionNode()
	 * @generated
	 */
	EAttribute getTransitionNode_GuardBody();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TransitionTreeFactory getTransitionTreeFactory();

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
		 * The meta object literal for the '{@link TransitionTree.impl.TreeImpl <em>Tree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TransitionTree.impl.TreeImpl
		 * @see TransitionTree.impl.TransitionTreePackageImpl#getTree()
		 * @generated
		 */
		EClass TREE = eINSTANCE.getTree();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE__ROOT = eINSTANCE.getTree_Root();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE__NODES = eINSTANCE.getTree_Nodes();

		/**
		 * The meta object literal for the '{@link TransitionTree.impl.StateNodeImpl <em>State Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TransitionTree.impl.StateNodeImpl
		 * @see TransitionTree.impl.TransitionTreePackageImpl#getStateNode()
		 * @generated
		 */
		EClass STATE_NODE = eINSTANCE.getStateNode();

		/**
		 * The meta object literal for the '<em><b>State Obj</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE_NODE__STATE_OBJ = eINSTANCE.getStateNode_StateObj();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE_NODE__TRANSITIONS = eINSTANCE.getStateNode_Transitions();

		/**
		 * The meta object literal for the '{@link TransitionTree.impl.TransitionNodeImpl <em>Transition Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TransitionTree.impl.TransitionNodeImpl
		 * @see TransitionTree.impl.TransitionTreePackageImpl#getTransitionNode()
		 * @generated
		 */
		EClass TRANSITION_NODE = eINSTANCE.getTransitionNode();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION_NODE__ACTION = eINSTANCE.getTransitionNode_Action();

		/**
		 * The meta object literal for the '<em><b>Guard</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION_NODE__GUARD = eINSTANCE.getTransitionNode_Guard();

		/**
		 * The meta object literal for the '<em><b>Action Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION_NODE__ACTION_BODY = eINSTANCE.getTransitionNode_ActionBody();

		/**
		 * The meta object literal for the '<em><b>Dest</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION_NODE__DEST = eINSTANCE.getTransitionNode_Dest();

		/**
		 * The meta object literal for the '<em><b>Guard Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION_NODE__GUARD_BODY = eINSTANCE.getTransitionNode_GuardBody();

	}

} //TransitionTreePackage
