package TreeGen;
import TransitionTree.Tree;

import java.util.ArrayList;
import java.util.Collection;

import javax.naming.spi.StateFactory;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.ECrossReferenceEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BodyOwner;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ParameterSet;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.internal.impl.PseudostateImpl;
import org.eclipse.uml2.uml.internal.impl.StateImpl;

import TransitionTree.StateNode;
import TransitionTree.TransitionNode;
import TransitionTree.TransitionTreePackage;
import TransitionTree.TransitionTreeFactory;
import TransitionTree.impl.TransitionNodeImpl;
import TransitionTree.impl.TransitionTreeFactoryImpl;
import TransitionTree.impl.TransitionTreePackageImpl;
public class TreeGen {
	private TransitionTreeFactory factory;
	private Tree myTT;
	//private TransitionNodeImpl b;
	public TreeGen()
	{
		//TransitionTreePackage.eINSTANCE;
		factory= TransitionTreeFactory.eINSTANCE;
		myTT=factory.createTree();
	}
	public Object propagateTree(Object state)// will recursively propagate the tree..
	{
		if(state instanceof PseudostateImpl && ((PseudostateImpl)state).getKind()==PseudostateKind.INITIAL_LITERAL)
		{ // that means the function is being called with an Alpha State!
			System.out.println("*** I am being called with initial node ***");
			StateNode temp=factory.createStateNode(); // let the meta model's factory create the node
			temp.setStateObj((PseudostateImpl)state);  // let the value be the entire object
			// converting the traditional transitions to the TransitionNode Objs
			EList<TransitionNode> trans=new BasicEList<TransitionNode>();
			for(Transition t: ((PseudostateImpl)state).getOutgoings())
			{
				TransitionNodeImpl x=(TransitionNodeImpl) factory.createTransitionNode();
				x.setLable(t.getLabel());
				if(t.getEffect()!=null) // getting action if any
				{
					x.setAction(t.getEffect().getLabel()); // setting action name
					Behavior a =t.getEffect();
					if(a instanceof BodyOwner)   // setting action body
					{
						x.setActionBody(((BodyOwner) a).getBodies().toString());
					}
				}
				if(t.getGuard()!=null) // getting guard if any
				{
					x.setGuard(t.getGuard().getLabel()); // setting guard label
					for(Element g:t.getGuard().allOwnedElements()) // getting guard body if any
					{
						if(g instanceof BodyOwner)
						{
							x.setGuardBody(((BodyOwner) g).getBodies().toString()); // setting guard body
						}
					}
				}
				if(t.getTarget()!=null) // setting target as dest in my meta model
				{
					StateImpl v = (StateImpl)t.getTarget();
					StateNode temps=factory.createStateNode();
					temps.setStateObj(v);
					x.setDest(temps);
				}
				trans.add(x);
			}// for each transition end
			temp.setTransitions(trans);
			myTT.setRoot(temp);
			System.out.println(myTT.toString());
			return state;
		}
		return state;
	}
}
