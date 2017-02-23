/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package TransitionTree;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see TransitionTree.TransitionTreePackage
 * @generated
 */
public interface TransitionTreeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TransitionTreeFactory eINSTANCE = TransitionTree.impl.TransitionTreeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Tree</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tree</em>'.
	 * @generated
	 */
	Tree createTree();

	/**
	 * Returns a new object of class '<em>State Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Node</em>'.
	 * @generated
	 */
	StateNode createStateNode();

	/**
	 * Returns a new object of class '<em>Transition Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transition Node</em>'.
	 * @generated
	 */
	TransitionNode createTransitionNode();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TransitionTreePackage getTransitionTreePackage();

} //TransitionTreeFactory
