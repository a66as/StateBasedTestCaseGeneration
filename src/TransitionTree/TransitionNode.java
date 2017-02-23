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
 * A representation of the model object '<em><b>Transition Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link TransitionTree.TransitionNode#getAction <em>Action</em>}</li>
 *   <li>{@link TransitionTree.TransitionNode#getGuard <em>Guard</em>}</li>
 *   <li>{@link TransitionTree.TransitionNode#getActionBody <em>Action Body</em>}</li>
 *   <li>{@link TransitionTree.TransitionNode#getDest <em>Dest</em>}</li>
 *   <li>{@link TransitionTree.TransitionNode#getGuardBody <em>Guard Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see TransitionTree.TransitionTreePackage#getTransitionNode()
 * @model
 * @generated
 */
public interface TransitionNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' attribute.
	 * @see #setAction(String)
	 * @see TransitionTree.TransitionTreePackage#getTransitionNode_Action()
	 * @model
	 * @generated
	 */
	String getAction();

	/**
	 * Sets the value of the '{@link TransitionTree.TransitionNode#getAction <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' attribute.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(String value);

	/**
	 * Returns the value of the '<em><b>Guard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard</em>' attribute.
	 * @see #setGuard(String)
	 * @see TransitionTree.TransitionTreePackage#getTransitionNode_Guard()
	 * @model
	 * @generated
	 */
	String getGuard();

	/**
	 * Sets the value of the '{@link TransitionTree.TransitionNode#getGuard <em>Guard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard</em>' attribute.
	 * @see #getGuard()
	 * @generated
	 */
	void setGuard(String value);

	/**
	 * Returns the value of the '<em><b>Action Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Body</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Body</em>' attribute.
	 * @see #setActionBody(String)
	 * @see TransitionTree.TransitionTreePackage#getTransitionNode_ActionBody()
	 * @model
	 * @generated
	 */
	String getActionBody();

	/**
	 * Sets the value of the '{@link TransitionTree.TransitionNode#getActionBody <em>Action Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Body</em>' attribute.
	 * @see #getActionBody()
	 * @generated
	 */
	void setActionBody(String value);

	/**
	 * Returns the value of the '<em><b>Dest</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dest</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dest</em>' reference.
	 * @see #setDest(StateNode)
	 * @see TransitionTree.TransitionTreePackage#getTransitionNode_Dest()
	 * @model required="true"
	 * @generated
	 */
	StateNode getDest();

	/**
	 * Sets the value of the '{@link TransitionTree.TransitionNode#getDest <em>Dest</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dest</em>' reference.
	 * @see #getDest()
	 * @generated
	 */
	void setDest(StateNode value);

	/**
	 * Returns the value of the '<em><b>Guard Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard Body</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard Body</em>' attribute.
	 * @see #setGuardBody(String)
	 * @see TransitionTree.TransitionTreePackage#getTransitionNode_GuardBody()
	 * @model
	 * @generated
	 */
	String getGuardBody();

	/**
	 * Sets the value of the '{@link TransitionTree.TransitionNode#getGuardBody <em>Guard Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard Body</em>' attribute.
	 * @see #getGuardBody()
	 * @generated
	 */
	void setGuardBody(String value);

} // TransitionNode
