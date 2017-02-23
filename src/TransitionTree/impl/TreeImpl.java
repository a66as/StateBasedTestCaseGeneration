/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package TransitionTree.impl;

import TransitionTree.StateNode;
import TransitionTree.TransitionTreePackage;
import TransitionTree.Tree;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tree</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link TransitionTree.impl.TreeImpl#getRoot <em>Root</em>}</li>
 *   <li>{@link TransitionTree.impl.TreeImpl#getNodes <em>Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TreeImpl extends EObjectImpl implements Tree {
	/**
	 * The default value of the '{@link #getRoot() <em>Root</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoot()
	 * @generated
	 * @ordered
	 */
	protected static final Object ROOT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRoot() <em>Root</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoot()
	 * @generated
	 * @ordered
	 */
	protected Object root = ROOT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected StateNode nodes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TreeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TransitionTreePackage.Literals.TREE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRoot() {
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoot(Object newRoot) {
		Object oldRoot = root;
		root = newRoot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransitionTreePackage.TREE__ROOT, oldRoot, root));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateNode getNodes() {
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNodes(StateNode newNodes, NotificationChain msgs) {
		StateNode oldNodes = nodes;
		nodes = newNodes;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TransitionTreePackage.TREE__NODES, oldNodes, newNodes);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodes(StateNode newNodes) {
		if (newNodes != nodes) {
			NotificationChain msgs = null;
			if (nodes != null)
				msgs = ((InternalEObject)nodes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TransitionTreePackage.TREE__NODES, null, msgs);
			if (newNodes != null)
				msgs = ((InternalEObject)newNodes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TransitionTreePackage.TREE__NODES, null, msgs);
			msgs = basicSetNodes(newNodes, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransitionTreePackage.TREE__NODES, newNodes, newNodes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String toString() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		//throw new UnsupportedOperationException();
		return "TODO: implement this method";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TransitionTreePackage.TREE__NODES:
				return basicSetNodes(null, msgs);
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
			case TransitionTreePackage.TREE__ROOT:
				return getRoot();
			case TransitionTreePackage.TREE__NODES:
				return getNodes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TransitionTreePackage.TREE__ROOT:
				setRoot(newValue);
				return;
			case TransitionTreePackage.TREE__NODES:
				setNodes((StateNode)newValue);
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
			case TransitionTreePackage.TREE__ROOT:
				setRoot(ROOT_EDEFAULT);
				return;
			case TransitionTreePackage.TREE__NODES:
				setNodes((StateNode)null);
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
			case TransitionTreePackage.TREE__ROOT:
				return ROOT_EDEFAULT == null ? root != null : !ROOT_EDEFAULT.equals(root);
			case TransitionTreePackage.TREE__NODES:
				return nodes != null;
		}
		return super.eIsSet(featureID);
	}

} //TreeImpl
