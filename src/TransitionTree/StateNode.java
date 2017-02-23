/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package TransitionTree;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link TransitionTree.StateNode#getStateObj <em>State Obj</em>}</li>
 *   <li>{@link TransitionTree.StateNode#getTransitions <em>Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see TransitionTree.TransitionTreePackage#getStateNode()
 * @model
 * @generated
 */
public interface StateNode extends EObject {
	/**
	 * Returns the value of the '<em><b>State Obj</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Obj</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Obj</em>' attribute.
	 * @see #setStateObj(Object)
	 * @see TransitionTree.TransitionTreePackage#getStateNode_StateObj()
	 * @model
	 * @generated
	 */
	Object getStateObj();

	/**
	 * Sets the value of the '{@link TransitionTree.StateNode#getStateObj <em>State Obj</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Obj</em>' attribute.
	 * @see #getStateObj()
	 * @generated
	 */
	void setStateObj(Object value);

	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' attribute.
	 * @see #setTransitions(Object)
	 * @see TransitionTree.TransitionTreePackage#getStateNode_Transitions()
	 * @model
	 * @generated
	 */
	Object getTransitions();

	/**
	 * Sets the value of the '{@link TransitionTree.StateNode#getTransitions <em>Transitions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transitions</em>' attribute.
	 * @see #getTransitions()
	 * @generated
	 */
	void setTransitions(Object value);

} // StateNode
