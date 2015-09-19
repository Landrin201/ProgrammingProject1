/*
 * Author: Marc Kuniansky
 * Date Created: June 18, 2015
 * Modifications:
 * 			Date			Author			Reason
 * 		August 15 2015, 	Marc Kuniansky, Implemented basic code for the GUI. Thanks to 
 * 											https://www3.ntu.edu.sg/home/ehchua/programming/java/J4a_GUI.html
 * 											for the easy to follow tutorial on how to implement a GUI.
 * 											The code written today did not serve a function, but everything showed up.
 * 		August 20 2015, 	Marc Kuniansky, Implemented the purpose for the code. Added the Button Press Listener
 * 											nested class, which allows the user to tell the program they have 
 * 											selected which optional files they want.
 * 		August 28 2015, 	Marc Kuniansky, Changed the layout of the pane from Flow to Box. 
 * 		September 15 2015	Marc Kuniansky, Modified the BtnPresListener method to allow the initializer to wait for user
 * 											input. Implemented the roleNameGUI() method to allow the user to specify desired
 * 											names for the roles to be implemented.
 */
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

/**
 * @author Marc
 *
 */
public class GUI extends JFrame implements ActionListener, WindowListener
{ //Begin class
	//Instance variables
	private Label lbl;
	private Label lbl2;
	private Label lbl3;
	private Label lbl4;
	private Label lbl5;
	private Button button;
	private Checkbox box1;
	private Checkbox box2;
	private Checkbox box3;
	private Checkbox box4;
	
	private Initializer initializer;
	
	
	//Constructor to set up the GUI components
	/**
	 * Constructs the GUI
	 */
	public GUI()
	{ //Begin constructor
		//This constructor does nothing- the methods handle variable declaration when needed, 
		//as many parts of the GUI take a name for the component in their declaration. 
	} //End constructor
	
	/**
	 * Displays a GUI window which allows the user to select optional files.
	 * @param ini a valid initializer object
	 */
	public void FileSelectorGUI(Initializer ini)
	{ //Begin FileSelectorGUI
		//Method Variables
		//Checkboxes
		initializer = ini; //The initializer is important here, as it is called when the button is pressed.
		//Everything here is being used to determine which optional files the user wants included in Application.ini.
		
		setTitle("File Selection"); //Set the name of the frame when displayed
		setSize(500, 275); //Set the size of the frame
		
		//Set the layout of the frame. I chose Box layout.
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		/* Add objects into the pane */
		
		//Construct and add the labels which instruct the user on what to do
		lbl = new Label("Please select the files you wish to include in application.ini.", Label.CENTER); //Set the text and location for the label
		this.add(lbl); //Add the label to the frame
		lbl2 = new Label("If you are installing Ramp, please select all files for ramp.", Label.CENTER);
		this.add(lbl2);
		lbl3 = new Label("If you are installing Smart, please select all files for Smart.", Label.CENTER);
		this.add(lbl3);
		lbl4 = new Label("If you are installing both Ramp and Smart, please select all files below.", Label.CENTER);
		this.add(lbl4);
		lbl5 = new Label("Close this window to cancel.", Label.CENTER);
		this.add(lbl5);
		
		//Construct and add the check-boxes. To add more boxes, continue the 
		box1 = new Checkbox("Ramp Defaults", false);
		this.add(box1);
		box2 = new Checkbox("Ramp Demo", false);
		this.add(box2);
		box3 = new Checkbox("Smart Defaults", false);
		this.add(box3);
		box4 = new Checkbox("Smart Demo", false);
		this.add(box4);
		
		//Construct and add a button
		button = new Button("Next"); //Construct a button
		this.add(button); //Add the button to the frame
		
		//Add listeners to listen for action events
		button.addActionListener(new BtnPressListener()); //Listens for a button press
		addWindowListener(this); //Listens for a closing window
		
		setVisible(true); //Make the frame visible
	} //End FileSelectorGUI
	
	
	@Override
	public void actionPerformed(ActionEvent evt)
	{ //Begin actionPerformed
		//Empty inherited method, implemented in a nested class below
	} //End actionPerformed
	
	
	public void roleNameGUI()
	{ //Begin RoleNameGUI
		//Method variables
		TextField tf1 = new TextField("Guest");
		TextField tf2 = new TextField("ramp_dba");
		
		//Construct the frame
		setTitle("File Selection"); //Set the name of the frame when displayed
		setSize(500, 275); //Set the size of the frame
		//Set the layout of the frame. I chose Box layout.
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		//Labels to instruct the user on what to do
		lbl = new Label("Please input your desired names for the default user roles and click next.", Label.CENTER);
		this.add(lbl);
		this.add(tf1);
		this.add(tf2);
		
		//Add the button 
		button= new Button("Next");
		this.add(button);
		button.addActionListener(new BtnPressListener2(tf1, tf2));
		addWindowListener(this);
		setVisible(true);
	} //End RoleNameGUI
	
	/* Window Event Handlers */
	
	//Allow window to be closed by clicking the close button
	@Override
	public void windowClosing(WindowEvent e)
	{
		System.exit(0); //Terminate the program
	}
	
	//Methods which are not used, but need to be implemented because this
	//class implements an interface
	@Override
	public void windowOpened(WindowEvent e){ }
	@Override
	public void windowClosed(WindowEvent e){ }
	@Override
	public void windowIconified(WindowEvent e){ }
	@Override
	public void windowDeiconified(WindowEvent e){ }
	@Override
	public void windowActivated(WindowEvent e){ }
	@Override
	public void windowDeactivated(WindowEvent e){ }
	
	/**
	 * BtnPressListener is a nested action listener which listens for 
	 * a button press. This is used for the file selector GUI
	 * @author Marc Kuniansky
	 */
	private class BtnPressListener implements ActionListener
	{ //Begin nested class
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(box1.getState()==true)
				initializer.IncludeFileTwo();
			if(box2.getState()==true)
				initializer.IncludeFileThree();
			initializer.changeLines();
			setVisible(false);
			//Some code will go here to check which checkboxes are marked true.
		}
	} //End nested class
	
	/**
	 * A nested action listener which listens for a button press. Used for the name creator GUI.
	 * @author Marc Kuniansky
	 *
	 */
	private class BtnPressListener2 implements ActionListener
	{ //Begin second button listener
		private TextField box1;
		private TextField box2;
		public BtnPressListener2(TextField tb1, TextField tb2)
		{
			box1 = tb1;
			box2 = tb2;
		}
		@Override
		public void actionPerformed(ActionEvent e)
		{
			//Get the name specified by the user and append it to the line needed in the code.
			initializer. finalStringCreator(box1);
			initializer. finalStringCreator(box2);
			dispose();
		} //End Action Performed
	} //End button press listener 2
	
} //End class