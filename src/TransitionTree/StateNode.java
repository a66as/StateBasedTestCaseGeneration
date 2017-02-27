package TransitionTree;

import org.eclipse.emf.common.util.EList;

public class StateNode{
	public Object stateObj; // the state object
	public String name; // the name of the state
	EList<TransitionNode> transitions; // the list of possible transitions
	public StateNode(Object o, String n, EList<TransitionNode> ts) //constructor.
	{
		this.stateObj=o;
		this.name=n;
		this.transitions=ts;
	}
}