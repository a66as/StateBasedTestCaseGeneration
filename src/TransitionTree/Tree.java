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
 * A representation of the model object '<em><b>Tree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link TransitionTree.Tree#getRoot <em>Root</em>}</li>
 *   <li>{@link TransitionTree.Tree#getNodes <em>Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see TransitionTree.TransitionTreePackage#getTree()
 * @model
 * @generated
 */
public interface Tree extends EObject {
	/**
	 * Returns the value of the '<em><b>Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' attribute.
	 * @see #setRoot(Object)
	 * @see TransitionTree.TransitionTreePackage#getTree_Root()
	 * @model
	 * @generated
	 */
	Object getRoot();

	/**
	 * Sets the value of the '{@link TransitionTree.Tree#getRoot <em>Root</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' attribute.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(Object value);

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference.
	 * @see #setNodes(StateNode)
	 * @see TransitionTree.TransitionTreePackage#getTree_Nodes()
	 * @model containment="true" upper="-2"
	 * @generated
	 */
	StateNode getNodes();

	/**
	 * Sets the value of the '{@link TransitionTree.Tree#getNodes <em>Nodes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nodes</em>' containment reference.
	 * @see #getNodes()
	 * @generated
	 */
	void setNodes(StateNode value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String toString();

} // Tree
