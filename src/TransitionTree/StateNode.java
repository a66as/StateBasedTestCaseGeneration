package TransitionTree;

import org.eclipse.emf.common.util.EList;

public class StateNode{
	public Object stateObj;
	public String name;
	EList<TransitionNode> transitions;
	public StateNode(Object o, String n, EList<TransitionNode> ts)
	{
		this.stateObj=o;
		this.name=n;
		this.transitions=ts;
	}
}