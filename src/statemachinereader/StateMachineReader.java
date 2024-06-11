package statemachinereader;
import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import java.io.ObjectInputStream.GetField;
import java.security.Guard;
import java.security.MessageDigest;

import javax.print.attribute.Attribute;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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

import TransitionTree.Tree;

/**
 * A class that Reads UML State Machine
 * Dependency: EMF_Libs, LoadUMLModel.java By Hassan Sartaj
 * 
 * @author Abbas Khan
 * @version 1.0
 */

public class StateMachineReader extends Frame implements ActionListener,WindowListener {
	static Tree tree_generator=null;
	private Label lblLink;    // Declare a Label component 
	private TextField tfLink; // Declare a TextField component 
	private Button btnLoad;   // Declare a Button component
	private Button btnATC;
	private Label lblGenerate;
	private Button btnallRoundTrip;
	private Button btnsneakPath;
	//private int count = 0;     // Counter's value
	public StateMachineReader()
	{
		setLayout(new FlowLayout());
        // "super" Frame (a Container) sets its layout to FlowLayout, which arranges
        // the components from left-to-right, and flow to next row from top-to-bottom.

	     lblLink = new Label("Model Link:");  // construct the Label component
	     add(lblLink);                    // "super" Frame adds Label
	
	     tfLink = new TextField("Models/StateMachine.uml", 30); // construct the TextField component
	     tfLink.setEditable(false);       // set to read-only
	     add(tfLink);                     // "super" Frame adds TextField
	
	     btnLoad = new Button("Load and Generate Tree");   // construct the Button component
	     add(btnLoad);                    // "super" Frame adds Button
	     btnLoad.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent evt) {
	            if(loadModel(tfLink.getText()))
	            {
	            	btnLoad.setEnabled(false);
		            tfLink.setEnabled(false);
		    	 	btnATC.setEnabled(true);
		    	 	btnallRoundTrip.setEnabled(false);
		    	 	btnsneakPath.setEnabled(true);
		    	 	JOptionPane.showMessageDialog(null, "Model Loaded, Transition Tree Generated and Printed to Console.", "Loaded", JOptionPane.INFORMATION_MESSAGE);
	            }
	            else
	            {
	            	JOptionPane.showMessageDialog(null, "ERROR! While loading the model.", "ERROR", JOptionPane.ERROR_MESSAGE);
	            	//System.exit(0);....
	            }
	         }
	      });
	     btnLoad.addActionListener(this);
	     
	     
	     
	     lblGenerate = new Label("Generate:\n");  // construct the Label component
	     add(lblGenerate); 
	     btnATC = new Button("All Transitions coverage Suite");   // construct the Button component
	     add(btnATC);                    // "super" Frame adds Button
	     btnATC.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent evt) {
	        	 allTC();
	        	 JOptionPane.showMessageDialog(null, "Please Refresh the Package SUT.tests", "Generated", JOptionPane.INFORMATION_MESSAGE);
	        	 //JOptionPane.showMessageDialog(null, "Not yet Implemented (ATC)", "Message", JOptionPane.INFORMATION_MESSAGE);
	            //loadModel(tfLink.getText());
	         }
	      });
	     btnATC.addActionListener(this);
	     
	     
	     
	     btnallRoundTrip = new Button("All Round-Trip Coverage");   // construct the Button component
	     add(btnallRoundTrip);                    // "super" Frame adds Button
	     btnallRoundTrip.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent evt) {
	        	 allRTP();
	        	 JOptionPane.showMessageDialog(null, "Not yet Implemented (ARTC)", "Message", JOptionPane.INFORMATION_MESSAGE);
	            //loadModel(tfLink.getText());
	         }
	      });
	    btnallRoundTrip.addActionListener(this);
	     
	     
	     
	    
	    
	    
	    
	    //sneakpath code starts here
	     btnsneakPath = new Button("Sneak Path Suite");   // construct the Button component
	     add(btnsneakPath);                    // "super" Frame adds Button
	     btnsneakPath.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent evt) {
	        	 	try {
						allSP();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	 JOptionPane.showMessageDialog(null, "SneakPath Suite Generated!", "Message", JOptionPane.INFORMATION_MESSAGE);
	            
	        	 loadModel(tfLink.getText());
	         }
	      });
	     btnsneakPath.addActionListener(this);
	     
	     
	     
	    //btnLoad.setEnabled(false);   // Declare a Button component
	 	btnATC.setEnabled(false);
	 	btnallRoundTrip.setEnabled(false);
	 	btnsneakPath.setEnabled(false);
	        // btnCount is the source object that fires ActionEvent when clicked.
	        // The source add "this" instance as an ActionEvent listener, which provides
	        //  an ActionEvent handler called actionPerformed().
	        // Clicking btnCount invokes actionPerformed().
	     addWindowListener(this);
	
	     setTitle("StateBasedTestCaseGenerator");  // "super" Frame sets its title
	     setSize(500, 150);        // "super" Frame sets its initial window size
	
	     // For inspecting the components/container objects
	     // System.out.println(this);
	     // System.out.println(lblCount);
	     // System.out.println(tfCount);
	     // System.out.println(btnCount);
	
	     setVisible(true);         // "super" Frame shows
	
	     // System.out.println(this);
	     // System.out.println(lblCount);
	     // System.out.println(tfCount);
	     // System.out.println(btnCount);
	}
	public static void main(String[] args) {
		//loadModel();
		StateMachineReader smr= new StateMachineReader();
	}// main end
	public static boolean loadModel(String umlFilePath)
	{
		// TODO Auto-generated method stub
				LoadUMLModel umlModel = new LoadUMLModel();
				//String umlFilePath = "Models/StateMachine.uml";

				String uri = null;
				Object objModel=null;
				try {
					uri = umlModel.getFileURI(umlFilePath);
					objModel= umlModel.loadModel(umlFilePath);
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
				
				Model sourceModel;
				//String box="Not Set";
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
				printWhileReading(sourcePackagedElements); //print the SM and call the Tree
				return true;
				//System.out.println("Box: "+ box);
	}
	private static void printWhileReading(EList<PackageableElement> sourcePackagedElements) {
		
		for(PackageableElement pe:sourcePackagedElements)
		{
			//System.out.println(pe.getClass().toString());
			System.out.println(pe.getLabel());
			tree_generator=new Tree(pe.getLabel());
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
								tree_generator.initiateTree((PseudostateImpl)ee);
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
		System.out.println("\n\n------------------ Transition Tree ------------------");
		tree_generator.printTree();
	}// printWhileReading ended
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
			if(t.getEffect()!=null) // if there are actions
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
			if(t.getEffect()!=null) // if there are actions
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
	public void allTC()
	{
		tree_generator.allTransitionsSuite();
		//tree_generator.generateTreePaths();
	}
	
	public void allSP() throws Exception
	{
		tree_generator.allSneakPathSuite();
		//tree_generator.generateTreePaths();
	}
	public void allRTP()
	{
		tree_generator.allRoundTripPathsSuite();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);  // Terminate the program
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
