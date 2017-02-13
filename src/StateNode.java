import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.Transition;

/**
 * Feb 13, 2017
 * StateNode.java
 * Abbas Khan
 */

/**
 * @author Abbas Khan
 *
 */
public class StateNode {
	public EList<Transition> possibleTransitions;
	public String Title;
	public PseudostateKind type; // 0: Initial, 10: Final...
}
