/**
 * Feb 25, 2017
 * Tree.java
 * Abbas Khan
 */
package TransitionTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BodyOwner;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Transition;

import org.eclipse.uml2.uml.internal.impl.PseudostateImpl;
import org.eclipse.uml2.uml.internal.impl.StateImpl;



import SUT.ThreePlayerGame;
import Templates.SuiteTemplate;
import Templates.TestCaseTemplate;
import utils.ConditionParser;

public class Tree {
	public StateNode root;
	private String CUT;
	int count=1;
	//keyValue Pair to keep the state and all legal actions from that state 
	KeyValuePair1 pairs=new KeyValuePair1();
	EList<StateNode> visited=new BasicEList<StateNode>();
	org.eclipse.core.internal.jobs.Queue x= new org.eclipse.core.internal.jobs.Queue();
	EList<StateNode> visited2=new BasicEList<StateNode>();
	EList<StateNode> discovered= new BasicEList<StateNode>();
	// List to maintain all the visited states
	List<String> visited3= new ArrayList<String>();
	Set<String> uniqueActions = new HashSet<>();
	
	
	
	
	
	
	int countr=0;
	
	
	
	
	
	
    List<List<String>> statePaths;
    List<List<String>> transitionPaths;
	
	
	
	
	
	
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
			if(t.getEffect()!=null) // if there are actions 
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
		if(stateObj.getOutgoings().size()==0 || isVisited(s) )//|| inTree(s)
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
			if(t.getEffect()!=null) // if there are actions 
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
		//visited2.add(s);
		for(TransitionNode tn:s.transitions){
			//visited2.add(tn.target);
			x.enqueue(tn.target);
		}
		while(!x.isEmpty())
		{
			growTheTree((StateNode)x.dequeue());
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
	public void printTree()
	{
		System.out.println(root.name);
		EList<TransitionNode> newts=root.transitions;
		for(TransitionNode t:root.transitions)
		{
			
			if(!t.isGuarded)
				System.out.println("|__"+t.name+"/"+t.effect+"--"+"-->"+t.target.name+"[further nodes:"+t.target.transitions.size()+"]");
			else
				System.out.println("|__"+t.name+"/"+t.effect+"--"+t.guardBody.replace("\n", " ")+"--> *"+t.target.name+"[further nodes:"+t.target.transitions.size()+"]");
		}
		for(TransitionNode t:newts) {
			printNode(t.target);
			countr++;
		}
			
	}
	public void printNode(StateNode s)
	{
		
		if(s.transitions.size()==0)
			return;
		System.out.println(s.name);
		for(TransitionNode t:s.transitions)
		{
			pairs.addValue(s.name,t.name );
			if(!t.isGuarded)
				System.out.println("|__"+t.name+"/"+t.effect+"--"+"-->"+t.target.name+"[further nodes:"+t.target.transitions.size()+"]");
			else
				System.out.println("|__"+t.name+"/"+t.effect+"--"+t.guardBody.replace("\n", " ")+"--> *"+t.target.name+"[further nodes:"+t.target.transitions.size()+"]");
		}
		for(TransitionNode t:s.transitions)
			printNode(t.target);
		
	}

	
	
	

	
	
	
	
	
//	
//
    public List<List<List<String>>> getAllLegalPaths() {
        List<List<String>> allStatePaths = new ArrayList<>();
        List<List<String>> allTransitionPaths = new ArrayList<>();
        List<List<String>> allGuardPaths = new ArrayList<>();
        List<String> currentStatePath = new ArrayList<>();
        List<String> currentTransitionPath = new ArrayList<>();
        List<String> currentGuardPath = new ArrayList<>();
        traverseTree(root, currentStatePath, currentTransitionPath, currentGuardPath, allStatePaths, allTransitionPaths, allGuardPaths);
        return Arrays.asList(allStatePaths, allTransitionPaths, allGuardPaths);
    }

    private void traverseTree(StateNode currentNode, List<String> currentStatePath, List<String> currentTransitionPath, List<String> currentGuardPath, List<List<String>> allStatePaths, List<List<String>> allTransitionPaths, List<List<String>> allGuardPaths) {
        currentStatePath.add(currentNode.name);
        if (currentNode.transitions.isEmpty()) {
            allStatePaths.add(new ArrayList<>(currentStatePath));
            allTransitionPaths.add(new ArrayList<>(currentTransitionPath));
            allGuardPaths.add(new ArrayList<>(currentGuardPath));
        } else {
            for (TransitionNode transition : currentNode.transitions) {
                currentTransitionPath.add(transition.name);
                if (transition.isGuarded) {
                    currentGuardPath.add(transition.guardBody);
                } else {
                    currentGuardPath.add("0"); // Placeholder for no guard
                }
                traverseTree(transition.target, currentStatePath, currentTransitionPath, currentGuardPath, allStatePaths, allTransitionPaths, allGuardPaths);
                currentGuardPath.remove(currentGuardPath.size() - 1);
                currentTransitionPath.remove(currentTransitionPath.size() - 1);
            }
        }
        currentStatePath.remove(currentStatePath.size() - 1);
    }

    public void allTransitionsSuite() {
        List<List<String>> statePaths = getAllLegalPaths().get(0);
        List<List<String>> transitionPaths = getAllLegalPaths().get(1);
        List<List<String>> guardPaths = getAllLegalPaths().get(2);

        count =0;
		TestCaseTemplate conformance= new TestCaseTemplate(CUT, "AllTransitionsTestSuite");
		conformance.body.add(CUT+" sut;"); // alpha is already made");
        for (int i = 0; i < statePaths.size(); i++) {
            List<String> statePath = statePaths.get(i);
            List<String> transitionPath = transitionPaths.get(i);
            List<String> guardPath = guardPaths.get(i);

            
			conformance.body.add("@Test(timeout = 1000)");
			conformance.body.add("public void testForPath"+count+"() {");
			conformance.body.add("sut=new "+CUT+"();");
			count++;
            
            
            for (int j = 1; j < statePath.size(); j++) {
                System.out.print(statePath.get(j));
                conformance.body.add("_131231assertEquals(\""+statePath.get(j)+"\", sut.stateReporter()); ");
				

				

                if (j < transitionPath.size()) {
                    System.out.print(" (" + transitionPath.get(j) + ")");
                    
                    if (!"0".equals(guardPath.get(j))) {
                        System.out.print(" [" + guardPath.get(j) + "]");
                    	try {
							String [] splitedCondition=ConditionParser.parseCondition(guardPath.get(j));
							String code="";
							code="/*TODO: check if the guard could be satisfied by the following generated code.*/\n";
							String not="";
							if(splitedCondition[1].equals("=="))
								not="!";
							
							
							int correction=0;
							if(splitedCondition[1].equals("<")) {
								correction++;
							}
							else if(splitedCondition[1].equals(">")) {
								correction--;
							}
							
							code+="while("+not+"("+splitedCondition[0]+splitedCondition[1]+((Integer.valueOf(splitedCondition[2])-correction)) +")) {\n";
							code+="sut."+transitionPath.get(j)+";";		
							code+="\n}";
							conformance.body.add(code);
						}
						catch(Exception ex) {
							conformance.body.add("/* Please DIY satisfy the guard */");
							
						}
                    }else {
                    conformance.body.add("sut."+transitionPath.get(j)+";");}
                }
                if (j < statePath.size() - 1) {
                    System.out.print(" -> ");
                }
               // conformance.body.add("_131231sut."+transitionPath.get(j)+"; ");
                
            }
            conformance.body.add("}");
            System.out.println();
        }
        
        
        
		conformance.generateTemplateFile();
		// once the testcases are generated filter out all non SneakPath testcases 
		conformance.filterTestCases();
        
    }
	
	
	
	
	
	
	//Now doing sneak path
    
    
	
    public void allSneakPathSuite() {
        List<List<String>> statePaths = getAllLegalPaths().get(0);
        List<List<String>> transitionPaths = getAllLegalPaths().get(1);
        List<List<String>> guardPaths = getAllLegalPaths().get(2);

        getUniqueTransactionsWrapper();
        
        
        count =0;
		TestCaseTemplate conformance= new TestCaseTemplate(CUT, "SneakPathTestSuit");
		conformance.body.add(CUT+" sut;"); // alpha is already made");
        for (int i = 0; i < statePaths.size(); i++) {
            
        	List<String> statePath = statePaths.get(i);
            List<String> transitionPath = transitionPaths.get(i);
            List<String> guardPath = guardPaths.get(i);

            
			conformance.body.add("@Test(timeout = 1000)");
			conformance.body.add("public void testForPath"+count+"() {");
			conformance.body.add("sut=new "+CUT+"();");
			count++;
            
            
            for (int j = 1; j < statePath.size(); j++) {
            	
              
            	
            	System.out.print(statePath.get(j));
                conformance.body.add("assertEquals(\""+statePath.get(j)+"\", sut.stateReporter()); ");

                if(addAllSneakPathsToSUT(statePath.get(j),conformance,statePath.get(j))) {
                	 
                	
                	
                	
                	conformance.body.add("}");
                	 System.out.println();
                	 conformance.body.add("@Test(timeout = 1000)");
         			conformance.body.add("public void testForPath"+count+"() {");
         			conformance.body.add("sut=new "+CUT+"();");
         			count++;
                     
                	 j--;
                	continue;
                }
                
              
                if (j < transitionPath.size()) {
                	
                    System.out.print(" (" + transitionPath.get(j) + ")");
                    
                    if (!"0".equals(guardPath.get(j))) {
                        System.out.print(" [" + guardPath.get(j) + "]");
                    	try {
							String [] splitedCondition=ConditionParser.parseCondition(guardPath.get(j));
							String code="";
							code="/*TODO: check if the guard could be satisfied by the following generated code.*/\n";
							String not="";
							if(splitedCondition[1].equals("=="))
								not="!";
							
							
							int correction=0;
							if(splitedCondition[1].equals("<")) {
								correction++;
							}
							else if(splitedCondition[1].equals(">")) {
								correction--;
							}
							
							code+="while("+not+"("+splitedCondition[0]+splitedCondition[1]+((Integer.valueOf(splitedCondition[2])-correction)) +")) {\n";
							code+="sut."+transitionPath.get(j)+";";		
							code+="\n}";
							conformance.body.add(code);
						}
						catch(Exception ex) {
							conformance.body.add("/* Please DIY satisfy the guard */");
							
						}
                    }else {
                    conformance.body.add("sut."+transitionPath.get(j)+";");}
                }
                if (j < statePath.size() - 1) {
                    System.out.print(" -> ");
                }
               // conformance.body.add("_131231sut."+transitionPath.get(j)+"; ");
                
           
            
            }
                
            conformance.body.add("}");
            System.out.println();
        }
        
        
        
		conformance.generateTemplateFile();
		// once the testcases are generated filter out all non SneakPath testcases 
		conformance.filterTestCases();
        
    }

	
	
	
	
	
	

	public void allRoundTripPathsSuite()
	{
		count=1;
		visited=null;
		visited= new BasicEList<StateNode>();
		TestCaseTemplate tc1= new TestCaseTemplate(CUT, "AllRoundTripPathsSuite");
		tc1.body.add("ThreePlayerGame sut= new ThreePlayerGame(); // alpha is already made");
		tc1.body.add("@Test(timeout = 1000)");
		tc1.body.add("public void testForRoundTripPath"+count+"() {");
		count++;
		if(root.transitions.size()==1)
		{
			TransitionNode temp=root.transitions.get(0);
			//tc1.body.add("assertEquals(\""+temp.target.name+"\", "+"sut.stateReporter());");
			//nodesStack.push(temp);
			growTheRoundTripTest(temp.target, tc1);
		}
		else{
			for(TransitionNode t:root.transitions)
			{
				
				tc1.body.add("sut."+t.effect+";");
				
				//tc1.body.add("assertEquals(\""+t.target.name+"\", "+"sut.stateReporter());");
				growTheRoundTripTest(t.target, tc1);
			}
		}
		tc1.body.add("}");
		tc1.generateTemplateFile();
	}
	public void growTheRoundTripTest(StateNode s, TestCaseTemplate tc)
	{
		if(s.transitions.size()==0)
		{
			return;
		}
		if(isVisited(s))
		{
			tc.body.add("assertEquals(\""+s.name+"\", "+"sut.stateReporter());");;
			tc.body.add("}");
			tc.body.add("@Test(timeout = 1000)");
			tc.body.add("public void testForPath"+count+"() {");
			count++;
			return;
		}
		
		for(TransitionNode t:s.transitions)
		{
			if(!t.isGuarded)
			{
				tc.body.add("sut."+t.name+";");
				//tc.body.add("assertEquals(\""+t.target.name+"\", "+"sut.stateReporter());");
				growTheRoundTripTest(t.target, tc);
			}
			else
			{
				tc.body.add("/* for Guard false */");
				tc.body.add("sut."+t.name+";");
				//tc.body.add("assertEquals(\""+s.name+"\", "+"sut.stateReporter()); // should be in same state");
				tc.body.add("/* for Guard True please DIY, Satisfy the guard '"+t.guard+"' with body: "+t.guardBody +"*/");
				growTheRoundTripTest(t.target, tc);
			}
			visited.add(t.target);
		}
	}
	
	
	
	
	
	
	
	
	
	
	// generating the test suit from tree

	
	
	
	
	
	
	
	//geting unique transactions
	public void getUniqueTransactionsWrapper()
	{
	//	System.out.println(root.name);
		EList<TransitionNode> newts=root.transitions;
		for(TransitionNode t:root.transitions)
		{
			uniqueActions.add(t.name);
		}
		for(TransitionNode t:newts)
			getUniqueTransactions(t.target);
	}
	public void getUniqueTransactions(StateNode s)
	{
		
		if(s.transitions.size()==0)
			return;
		
		for(TransitionNode t:s.transitions)
		{
		uniqueActions.add(t.name);
		}
		for(TransitionNode t:s.transitions)
			getUniqueTransactions(t.target);
		
	}
	
	
	
	
	
	
	public boolean alreadyExplored(StateNode n) {
		
		return false;
	}
	
	
	
	public boolean addAllSneakPathsToSUT(String s, TestCaseTemplate tc,String lastState) {

			
			//make sure that the node is not visited
			boolean flg=true;
			boolean checkFlag=false;
			for(String n : visited3) {
				
				if(n.equals(s)) {
					flg=false;
					
				}
				
			}
			// if node is not visited
			if(flg) {
				//add the previous testcases
				
				//adding this state to the visited array
				visited3.add(s);
				
				List<String> currentNodeActions = new ArrayList<>();
				
				Set<String> uniqueActionsForCurrentState = new HashSet<>(uniqueActions);
				
				try {
					//getting the list of actions for this state
					for(String x:pairs.getValues(lastState)) {
						currentNodeActions.add(x);			
					}	
				}
				
				//if the action is not available in the keyvalue pair get it from current node
				catch(Exception e) {
				
					
				}
				
				
				
				// All illegal actions are stored here for this state i.e. AllUniqueActionsInSystem - currentNodeAction
				uniqueActionsForCurrentState.removeAll(currentNodeActions);
//				Remove Constructor
				uniqueActionsForCurrentState.remove("ThreePlayerGame()");
//				Remove distructor
				uniqueActionsForCurrentState.remove("dtor()");
				
				for(String x:uniqueActionsForCurrentState)
				{
					
					

					
					
						tc.body.add("_131231sut."+x+"; ") ;
						tc.body.add("_131231assertEquals(\""+lastState+"\", sut.stateReporter()); ");
					

				}
				
				checkFlag=true;
			}
			
			
			
			
		
			
		
		return checkFlag;
	}
	
	
	
	
	
	
	
	
}