package TreeGen;
import TransitionTree.Tree;

import javax.naming.spi.StateFactory;

import org.eclipse.uml2.uml.internal.impl.PseudostateImpl;
import org.eclipse.uml2.uml.internal.impl.StateImpl;

import TransitionTree.StateNode;
import TransitionTree.TransitionNode;
import TransitionTree.TransitionTreePackage;
import TransitionTree.TransitionTreeFactory;
import TransitionTree.impl.TransitionTreeFactoryImpl;
import TransitionTree.impl.TransitionTreePackageImpl;
public class TreeGen {
	private TransitionTreeFactory factory;
	private Tree myTT;
	public TreeGen()
	{
		//TransitionTreePackage.eINSTANCE;
		factory= TransitionTreeFactory.eINSTANCE;
		myTT=factory.createTree();
	}
	public Object propagateTree(Object state)
	{
		if(state instanceof StateImpl)
		{
			return state;
		}
		return state;
	}
}
