/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package TransitionTree.impl;

import TransitionTree.StateNode;
import TransitionTree.TransitionTreePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link TransitionTree.impl.StateNodeImpl#getStateObj <em>State Obj</em>}</li>
 *   <li>{@link TransitionTree.impl.StateNodeImpl#getTransitions <em>Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateNodeImpl extends EObjectImpl implements StateNode {
	/**
	 * The default value of the '{@link #getStateObj() <em>State Obj</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateObj()
	 * @generated
	 * @ordered
	 */
	protected static final Object STATE_OBJ_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStateObj() <em>State Obj</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateObj()
	 * @generated
	 * @ordered
	 */
	protected Object stateObj = STATE_OBJ_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransitions() <em>Transitions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitions()
	 * @generated
	 * @ordered
	 */
	protected static final Object TRANSITIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitions()
	 * @generated
	 * @ordered
	 */
	protected Object transitions = TRANSITIONS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TransitionTreePackage.Literals.STATE_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getStateObj() {
		return stateObj;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateObj(Object newStateObj) {
		Object oldStateObj = stateObj;
		stateObj = newStateObj;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransitionTreePackage.STATE_NODE__STATE_OBJ, oldStateObj, stateObj));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getTransitions() {
		return transitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransitions(Object newTransitions) {
		Object oldTransitions = transitions;
		transitions = newTransitions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransitionTreePackage.STATE_NODE__TRANSITIONS, oldTransitions, transitions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TransitionTreePackage.STATE_NODE__STATE_OBJ:
				return getStateObj();
			case TransitionTreePackage.STATE_NODE__TRANSITIONS:
				return getTransitions();
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
			case TransitionTreePackage.STATE_NODE__STATE_OBJ:
				setStateObj(newValue);
				return;
			case TransitionTreePackage.STATE_NODE__TRANSITIONS:
				setTransitions(newValue);
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
			case TransitionTreePackage.STATE_NODE__STATE_OBJ:
				setStateObj(STATE_OBJ_EDEFAULT);
				return;
			case TransitionTreePackage.STATE_NODE__TRANSITIONS:
				setTransitions(TRANSITIONS_EDEFAULT);
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
			case TransitionTreePackage.STATE_NODE__STATE_OBJ:
				return STATE_OBJ_EDEFAULT == null ? stateObj != null : !STATE_OBJ_EDEFAULT.equals(stateObj);
			case TransitionTreePackage.STATE_NODE__TRANSITIONS:
				return TRANSITIONS_EDEFAULT == null ? transitions != null : !TRANSITIONS_EDEFAULT.equals(transitions);
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
		result.append(" (stateObj: ");
		result.append(stateObj);
		result.append(", transitions: ");
		result.append(transitions);
		result.append(')');
		return result.toString();
	}

} //StateNodeImpl
