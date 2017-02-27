/**
 * Feb 25, 2017
 * Tree.java
 * Abbas Khan
 */
package TransitionTree;

import java.util.Stack;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BodyOwner;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.internal.impl.FinalStateImpl;
import org.eclipse.uml2.uml.internal.impl.PseudostateImpl;
import org.eclipse.uml2.uml.internal.impl.StateImpl;

import SUT.ThreePlayerGame;
import Templates.SuiteTemplate;
import Templates.TestCaseTemplate;
/**
 * @author Abbas Khan
 *
 */
public class Tree {
	public StateNode root;
	private String CUT;
	EList<StateNode> visited=new BasicEList<StateNode>();
	Stack<TransitionNode> nodesStack=new Stack<TransitionNode>();
	EList<StateNode> visited2=new BasicEList<StateNode>();
	public Tree(String cls)
	{
		CUT=cls;
		//new Templates.SuiteTemplate();
		
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
		if(stateObj.getOutgoings().size()==0 || isVisited(s) || inTree(s))
		{
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
		for(TransitionNode tn:s.transitions){
			growTheTree(tn.target);
			visited2.add(tn.target);
		}
			
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
	public boolean inTree(StateNode s)
	{
		for(StateNode q:visited2)
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
				System.out.println("|__"+t.name+"/"+t.effect+"--"+"-->"+t.target.name);
			else
				System.out.println("|__"+t.name+"/"+t.effect+"--"+t.guardBody.replace("\n", " ")+"--> *"+t.target.name);
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
				System.out.println("|__"+t.name+"/"+t.effect+"--"+"-->"+t.target.name);//+"[size:"+t.target.transitions.size());
			else
				System.out.println("|__"+t.name+"/"+t.effect+"--"+t.guardBody.replace("\n", " ")+"--> *"+t.target.name);//+"[size:"+t.target.transitions.size());
		}
		for(TransitionNode t:s.transitions)
			printNode(t.target);
		
	}
	public void allTransitionsSuite()
	{
		StateNode r=root;
		int testCaseCount=1;
		visited=null;
		visited= new BasicEList<StateNode>();
		TestCaseTemplate tc1= new TestCaseTemplate(CUT, "testCase"+testCaseCount++);
		tc1.body.add("ThreePlayerGame sut= new ThreePlayerGame(); // alpha is already made");
		tc1.body.add("@Test");
		tc1.body.add("public void testCase"+testCaseCount+"() {");
		if(root.transitions.size()==1)
		{
			TransitionNode temp=root.transitions.get(0);
			tc1.body.add("assertEquals(\""+temp.target.name+"\", "+"sut.stateReporter());");
			//nodesStack.push(temp);
			growTheTest(temp.target, tc1);
		}
		else{
			for(TransitionNode t:root.transitions)
			{
				
				tc1.body.add("sut."+t.effect+";");
				
				tc1.body.add("assertEquals(\""+t.target.name+"\", "+"sut.stateReporter());");
				growTheTest(t.target, tc1);
			}
		}
		tc1.body.add("}");
		tc1.generateTemplateFile();
	}
	public void growTheTest(StateNode s, TestCaseTemplate tc)
	{
		if(s.transitions.size()==0)
		{
			tc.body.add("\n /********** TC Completed *************/\n");
			//tc.body.add("}");
			return;
		}
		visited.add(s);
		for(TransitionNode t:s.transitions)
		{
			if(!t.isGuarded)
			{
				tc.body.add("sut."+t.name+";");
				tc.body.add("assertEquals(\""+t.target.name+"\", "+"sut.stateReporter());");
				growTheTest(t.target, tc);
			}
			else
			{
				tc.body.add("/* for Guard false */");
				tc.body.add("sut."+t.name+";");
				tc.body.add("assertEquals(\""+s.name+"\", "+"sut.stateReporter()); // should be in same state");
				tc.body.add("/* for Guard True please DIY, Satisfy the guard '"+t.guard+"' with body: "+t.guardBody +"*/");
				growTheTest(t.target, tc);
			}
		}
	}
}
