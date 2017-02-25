/**
 * Feb 25, 2017
 * Tree.java
 * Abbas Khan
 */
package TransitionTree;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BodyOwner;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.internal.impl.FinalStateImpl;
import org.eclipse.uml2.uml.internal.impl.PseudostateImpl;
import org.eclipse.uml2.uml.internal.impl.StateImpl;

/**
 * @author Abbas Khan
 *
 */
public class Tree {
	public StateNode root;
	private String CUT;
	EList<StateNode> visited=new BasicEList<StateNode>();
	public Tree(String cls)
	{
		CUT=cls;
	}
	public void initiateTree(PseudostateImpl s)
	{
		root=new StateNode(s, s.getLabel(), new BasicEList<TransitionNode>());
		EList<TransitionNode> tns=new BasicEList<TransitionNode>();
		visited.add(root);
		for(Transition t: s.getOutgoings())
		{
			boolean isGuarded=false;
			String guard=null;
			String effect=null;
			String guardBody=null;
			String effectBody=null;
			StateNode target=null;
			String name=t.getLabel();
			if(t.getGuard()!=null)
			{
				isGuarded=true;
				guard=t.getGuard().getLabel();
				for(Element g:t.getGuard().allOwnedElements())
				{
					if(g instanceof BodyOwner)
					{
						guardBody=((BodyOwner) g).getBodies().toString();
					}
				}
			}
			if(t.getEffect()!=null) // if there are actions :/
			{
				effect=t.getEffect().getLabel();
				Behavior a =t.getEffect();
				if(a instanceof BodyOwner)
				{
					effectBody=((BodyOwner) a).getBodies().toString();
				}
			}
			StateImpl dest=(StateImpl) t.getTarget();
			target=new StateNode(dest, dest.getLabel(), new BasicEList<TransitionNode>());
			TransitionNode tn=new TransitionNode(isGuarded, guard, guardBody, effect, effectBody, target, name);
			tns.add(tn);
		} // for each transition ended
		root.transitions=tns;
		for(TransitionNode tn:root.transitions)
			growTheTree(tn.target);
	}
	public void growTheTree(StateNode s)
	{
		StateImpl stateObj=(StateImpl)(s.stateObj);
		if(stateObj.getOutgoings().size()==0)
			return;
		if(isVisited(s))
		{
			StateNode temp=new StateNode(s.stateObj, s.name, new BasicEList<TransitionNode>());
			//s.transitions.add(new TransitionNode(false, "", "", "", "", temp, "Repeated"));
			return;
		}
		EList<TransitionNode> transitions=s.transitions;
		for(Transition t: stateObj.getOutgoings())
		{
			boolean isGuarded=false;
			String guard=null;
			String effect=null;
			String guardBody=null;
			String effectBody=null;
			StateNode target=null;
			String name=t.getLabel();
			if(t.getGuard()!=null)
			{
				isGuarded=true;
				guard=t.getGuard().getLabel();
				for(Element g:t.getGuard().allOwnedElements())
				{
					if(g instanceof BodyOwner)
					{
						guardBody=((BodyOwner) g).getBodies().toString();
					}
				}
			}
			if(t.getEffect()!=null) // if there are actions :/
			{
				effect=t.getEffect().getLabel();
				Behavior a =t.getEffect();
				if(a instanceof BodyOwner)
				{
					effectBody=((BodyOwner) a).getBodies().toString();
				}
			}
			StateImpl dest=(StateImpl) t.getTarget();
			target=new StateNode(dest, dest.getLabel(), new BasicEList<TransitionNode>());
			TransitionNode tn=new TransitionNode(isGuarded, guard, guardBody, effect, effectBody, target, name);
			transitions.add(tn);
		} // for each transition ended
		s.transitions=transitions;
		visited.add(s);
		for(TransitionNode tn:s.transitions)
			growTheTree(tn.target);
	}
	public boolean isVisited(StateNode s)
	{
		for(StateNode q:visited)
		{
			if(q.name==s.name)
				return true;
		}
			
		return false;
	}
	public void printTree()
	{
		System.out.println(root.name);
		EList<TransitionNode> newts=root.transitions;
		for(TransitionNode t:root.transitions)
		{
			if(!t.isGuarded)
				System.out.println("|__"+t.name+"--"+"-->"+t.target.name);
			else
				System.out.println("|__"+t.name+"--"+t.guardBody.replace("\n", " ")+"--> *"+t.target.name);
		}
		for(TransitionNode t:newts)
			printNode(t.target);
	}
	public void printNode(StateNode s)
	{
		
		if(s.transitions.size()==0)
			return;
		System.out.println(s.name);
		for(TransitionNode t:s.transitions)
		{
			if(!t.isGuarded)
				System.out.println("|__"+t.name+"--"+"-->"+t.target.name);
			else
				System.out.println("|__"+t.name+"--"+t.guardBody.replace("\n", " ")+"--> *"+t.target.name);
		}
		for(TransitionNode t:s.transitions)
			printNode(t.target);
		
	}
}
