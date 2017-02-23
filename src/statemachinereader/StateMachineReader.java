package statemachinereader;
import java.io.ObjectInputStream.GetField;
import java.security.Guard;

import javax.print.attribute.Attribute;

import org.eclipse.core.commands.State;
import org.eclipse.emf.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.*;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BodyOwner;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.internal.impl.ClassImpl;
import org.eclipse.uml2.uml.internal.impl.ConstraintImpl;
import org.eclipse.uml2.uml.internal.impl.EventImpl;
import org.eclipse.uml2.uml.internal.impl.FinalStateImpl;
import org.eclipse.uml2.uml.internal.impl.InitialNodeImpl;
import org.eclipse.uml2.uml.internal.impl.PseudostateImpl;
import org.eclipse.uml2.uml.internal.impl.RegionImpl;
import org.eclipse.uml2.uml.internal.impl.StateImpl;
import org.eclipse.uml2.uml.internal.impl.StateMachineImpl;
import org.eclipse.uml2.uml.internal.impl.StereotypeImpl;

/**
 * A class that Reads UML State Machine
 * Dependency: EMF_Libs, LoadUMLModel.java By Hassan Sartaj
 * 
 * @author Abbas Khan
 * @version 1.0
 */

public class StateMachineReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoadUMLModel umlModel = new LoadUMLModel();
		String umlFilePath = "Models/StateMachine.uml";

		String uri = null;
		try {
			uri = umlModel.getFileURI(umlFilePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Object objModel= umlModel.loadModel(umlFilePath);
		Model sourceModel;
		String box="Not Set";
		EList<PackageableElement> sourcePackagedElements = null;
		EList<RegionImpl> modelRegions=null;
		if (objModel instanceof Model) {
			sourceModel = (Model) objModel;
			sourcePackagedElements = sourceModel.getPackagedElements();
			//box=sourcePackagedElements.getClass().toString()+" is instance of Model.";
		} else if (objModel instanceof Package) {
			Package sourcePackage = (Package) objModel;
			sourcePackagedElements = sourcePackage.getPackagedElements();
			//box=sourcePackage.getLabel()+ " is instance of Package.";
			//sourcePackage.g
		}
		printWhileReading(sourcePackagedElements);
		//System.out.println("Box: "+ box);
	}// main end
	private static void printWhileReading(EList<PackageableElement> sourcePackagedElements) {
		
		for(PackageableElement pe:sourcePackagedElements)
		{
			//System.out.println(pe.getClass().toString());
			System.out.println(pe.getLabel());
			System.out.println("-------------------------------------");
			if(pe instanceof StateMachineImpl) // if is a state
			{
				//System.out.println("\n is a Region: "+ pe.getLabel()+" \n");
				StateMachineImpl x=(StateMachineImpl) pe;
				//System.out.println(x.getSubmachineStates().get(0).getLabel());
				EList<Element> e= x.allOwnedElements(); // get all internal elements as Element List
				for(Element ee: e) // for each element
				{
					if(ee instanceof StateImpl || ee instanceof PseudostateImpl)
					{
						if(ee instanceof PseudostateImpl)
						{
							
							if(((PseudostateImpl)ee).getKind()==PseudostateKind.INITIAL_LITERAL)
							{
								System.out.println(((PseudostateImpl) ee).getLabel()+" {ALPHA}");
								printTransition((PseudostateImpl) ee);
								//StateNode tree=new StateNode();
								//tree.propagate((PseudostateImpl) ee);
							}
							else if(((PseudostateImpl)ee).getKind()==PseudostateKind.TERMINATE_LITERAL)
							{
								System.out.println(((PseudostateImpl) ee).getLabel()+" {OMEGA}");
							}
							else if(((PseudostateImpl)ee).getKind()==PseudostateKind.CHOICE_LITERAL)
							{
								System.out.println(((PseudostateImpl) ee).getLabel()+" {CHOICE}");
								printTransition((PseudostateImpl) ee);
							}
						}// if is pseudo state
						else{
								if(ee instanceof FinalStateImpl)
								{
									System.out.println(((FinalStateImpl) ee).getLabel()+ " {OMEGA}");
								}
								else{
									System.out.println(((StateImpl) ee).getLabel());
									printTransitions((StateImpl)ee);
								}
						} // if is normal state
						
					}// if is a state ended
				}// for each state machine's elements
			}// if is StateMachine Ended
		} // foreach element loop ended
	}// pleaseDoTheRest ended
	private static void printTransitions(StateImpl s)
	{
		for(Transition t:(s).getOutgoings())
		{
			System.out.print("|__ "+ t.getLabel()+" ---> "+t.getTarget().getLabel() );
			
			if(t.getGuard()!=null)
			{
				System.out.print(" / ");
				for(Element g:t.getGuard().allOwnedElements())
				{
					if(g instanceof BodyOwner)
					{
						System.out.print("GUARD:"+((BodyOwner) g).getBodies().toString()+" / ");
					}
				}
				
			}
			else{
				System.out.print(" / ");
			}
			if(t.getEffect()!=null) // if there are actions :/
			{
				Behavior a =t.getEffect();
				if(a instanceof BodyOwner)
				{
					System.out.print("ACTION:"+((BodyOwner) a).getBodies().toString());
				}
			}
			System.out.println();
		}
	}
	private static void printTransition(PseudostateImpl s)
	{
		for(Transition t:(s).getOutgoings())
		{
			System.out.print("|__ "+ t.getLabel()+" ---> "+t.getTarget().getLabel() );
			
			if(t.getGuard()!=null)
			{
				System.out.print(" / ");
				for(Element g:t.getGuard().allOwnedElements())
				{
					if(g instanceof BodyOwner)
					{
						System.out.print("GUARD:"+((BodyOwner) g).getBodies().toString()+" / ");
					}
				}
			}
			else{
				System.out.print(" / ");
			}
			if(t.getEffect()!=null) // if there are actions :/
			{
				Behavior a =t.getEffect();
				if(a instanceof BodyOwner)
				{
					System.out.print("ACTION:"+((BodyOwner) a).getBodies().toString());
				}
			}
			System.out.println();
		}

	}
}
