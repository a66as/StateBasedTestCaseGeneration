/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package TransitionTree.impl;

import TransitionTree.StateNode;
import TransitionTree.TransitionNode;
import TransitionTree.TransitionTreePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link TransitionTree.impl.TransitionNodeImpl#getAction <em>Action</em>}</li>
 *   <li>{@link TransitionTree.impl.TransitionNodeImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link TransitionTree.impl.TransitionNodeImpl#getActionBody <em>Action Body</em>}</li>
 *   <li>{@link TransitionTree.impl.TransitionNodeImpl#getDest <em>Dest</em>}</li>
 *   <li>{@link TransitionTree.impl.TransitionNodeImpl#getGuardBody <em>Guard Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransitionNodeImpl extends EObjectImpl implements TransitionNode {
	/**
	 * The default value of the '{@link #getAction() <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected String action = ACTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getGuard() <em>Guard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuard()
	 * @generated
	 * @ordered
	 */
	protected static final String GUARD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGuard() <em>Guard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuard()
	 * @generated
	 * @ordered
	 */
	protected String guard = GUARD_EDEFAULT;

	/**
	 * The default value of the '{@link #getActionBody() <em>Action Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionBody()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTION_BODY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getActionBody() <em>Action Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionBody()
	 * @generated
	 * @ordered
	 */
	protected String actionBody = ACTION_BODY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDest() <em>Dest</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDest()
	 * @generated
	 * @ordered
	 */
	protected StateNode dest;

	/**
	 * The default value of the '{@link #getGuardBody() <em>Guard Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuardBody()
	 * @generated
	 * @ordered
	 */
	protected static final String GUARD_BODY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGuardBody() <em>Guard Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuardBody()
	 * @generated
	 * @ordered
	 */
	protected String guardBody = GUARD_BODY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TransitionTreePackage.Literals.TRANSITION_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(String newAction) {
		String oldAction = action;
		action = newAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransitionTreePackage.TRANSITION_NODE__ACTION, oldAction, action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGuard() {
		return guard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuard(String newGuard) {
		String oldGuard = guard;
		guard = newGuard;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransitionTreePackage.TRANSITION_NODE__GUARD, oldGuard, guard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getActionBody() {
		return actionBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionBody(String newActionBody) {
		String oldActionBody = actionBody;
		actionBody = newActionBody;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransitionTreePackage.TRANSITION_NODE__ACTION_BODY, oldActionBody, actionBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateNode getDest() {
		if (dest != null && dest.eIsProxy()) {
			InternalEObject oldDest = (InternalEObject)dest;
			dest = (StateNode)eResolveProxy(oldDest);
			if (dest != oldDest) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TransitionTreePackage.TRANSITION_NODE__DEST, oldDest, dest));
			}
		}
		return dest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateNode basicGetDest() {
		return dest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDest(StateNode newDest) {
		StateNode oldDest = dest;
		dest = newDest;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransitionTreePackage.TRANSITION_NODE__DEST, oldDest, dest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGuardBody() {
		return guardBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuardBody(String newGuardBody) {
		String oldGuardBody = guardBody;
		guardBody = newGuardBody;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransitionTreePackage.TRANSITION_NODE__GUARD_BODY, oldGuardBody, guardBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TransitionTreePackage.TRANSITION_NODE__ACTION:
				return getAction();
			case TransitionTreePackage.TRANSITION_NODE__GUARD:
				return getGuard();
			case TransitionTreePackage.TRANSITION_NODE__ACTION_BODY:
				return getActionBody();
			case TransitionTreePackage.TRANSITION_NODE__DEST:
				if (resolve) return getDest();
				return basicGetDest();
			case TransitionTreePackage.TRANSITION_NODE__GUARD_BODY:
				return getGuardBody();
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
			case TransitionTreePackage.TRANSITION_NODE__ACTION:
				setAction((String)newValue);
				return;
			case TransitionTreePackage.TRANSITION_NODE__GUARD:
				setGuard((String)newValue);
				return;
			case TransitionTreePackage.TRANSITION_NODE__ACTION_BODY:
				setActionBody((String)newValue);
				return;
			case TransitionTreePackage.TRANSITION_NODE__DEST:
				setDest((StateNode)newValue);
				return;
			case TransitionTreePackage.TRANSITION_NODE__GUARD_BODY:
				setGuardBody((String)newValue);
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
			case TransitionTreePackage.TRANSITION_NODE__ACTION:
				setAction(ACTION_EDEFAULT);
				return;
			case TransitionTreePackage.TRANSITION_NODE__GUARD:
				setGuard(GUARD_EDEFAULT);
				return;
			case TransitionTreePackage.TRANSITION_NODE__ACTION_BODY:
				setActionBody(ACTION_BODY_EDEFAULT);
				return;
			case TransitionTreePackage.TRANSITION_NODE__DEST:
				setDest((StateNode)null);
				return;
			case TransitionTreePackage.TRANSITION_NODE__GUARD_BODY:
				setGuardBody(GUARD_BODY_EDEFAULT);
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
			case TransitionTreePackage.TRANSITION_NODE__ACTION:
				return ACTION_EDEFAULT == null ? action != null : !ACTION_EDEFAULT.equals(action);
			case TransitionTreePackage.TRANSITION_NODE__GUARD:
				return GUARD_EDEFAULT == null ? guard != null : !GUARD_EDEFAULT.equals(guard);
			case TransitionTreePackage.TRANSITION_NODE__ACTION_BODY:
				return ACTION_BODY_EDEFAULT == null ? actionBody != null : !ACTION_BODY_EDEFAULT.equals(actionBody);
			case TransitionTreePackage.TRANSITION_NODE__DEST:
				return dest != null;
			case TransitionTreePackage.TRANSITION_NODE__GUARD_BODY:
				return GUARD_BODY_EDEFAULT == null ? guardBody != null : !GUARD_BODY_EDEFAULT.equals(guardBody);
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
		result.append(" (action: ");
		result.append(action);
		result.append(", guard: ");
		result.append(guard);
		result.append(", actionBody: ");
		result.append(actionBody);
		result.append(", guardBody: ");
		result.append(guardBody);
		result.append(')');
		return result.toString();
	}

} //TransitionNodeImpl
