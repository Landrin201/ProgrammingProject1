import java.util.ArrayList;
import java.awt.*;

/*
 * Author: Marc Kuniansky
 * Date Created: June 18, 2015
 * Modifications:
 * 			Date				Author			Reason
 * 		August 14 2015, 	Marc Kuniansky, Refactored main method here.
 * 		August 20 2015, 	Marc Kuniansky, Added two new instance variables, inclFile2 and inclFile 3, as well 
 * 											as two new public methods used to set these values to true. This 
 * 											allows the user to select which optional files they wish to include in 
 * 											application.ini. Modified method execute to work with the UI.
 * 		September 15 2015, 	Marc Kuniansky, Refactored the Execute method to make it work better with the GUI. First,
 * 											created the changeLines() method, which gets input from the user on which files
 * 											to include. Then, implemented the changeLines() method, which allows the user to 
 * 											create names for the user roles. Added the OtherFiles() and Finalize methods. Added 
 * 											the FinalStringCreator method.
 */

/**
 * Does most of the work in creating, writing to, and initializing application.ini
 * @author Marc Kuniansky
 */
public class Initializer 
{ //Begin class
	//Instance Variables
	//Validated Input Reader
	public ValidatedInputReader inputReader;
	//Need the extension to be used
	private String extension;
	//Need to get all of the files that will be needed
	private InputFileReader RampBasics;
	private InputFileReader RampDefaults;
	private InputFileReader RampDemo;
	//Need a file to write everything to
	private FileCreator Applicationini;
	//Booleans for including files
	private Boolean inclFile2;
	private Boolean inclFile3;
	//Construct the GUI that will be used to accept user input.
	private GUI theGUI;
	//Variable to pause the program while waiting for the GUI
	public Boolean gotInput;
	
	private ArrayList<String> linesToAdd;
	
	//Constructor
	/**
	 * Constructor with one variable
	 * 
	 * @param desiredLocationOfAppini is a full file location at which 'application.ini' will be saved.
	 */
	public Initializer(String desiredLocationOfAppini, GUI GUI)
	{ //Begin constructor
		inputReader = new ValidatedInputReader();
		extension = System.getProperty("user.dir");
		RampBasics = new InputFileReader("ramp_basics.ini", extension);
		RampDefaults = new InputFileReader("ramp_defaults.ini", extension);
		RampDemo = new InputFileReader("ramp_demo.ini", extension);
		Applicationini = new FileCreator(desiredLocationOfAppini, "application.ini");
		
		//File 1 must be included. Files 2 and 3 are optional.
		inclFile2=false;
		inclFile3=false;
		
		theGUI = GUI;
		gotInput = false;
		linesToAdd = new ArrayList<String>();
		
		Debug.println("Constructed Initializer");
	} //End constructor
	
	//Methods 
	
	/**
	 * Executing this method includes file 2 in application.ini
	 */
	public void IncludeFileTwo()
	{
		inclFile2 = true;
	}
	
	/**
	 * Executing this method includes file 3 in application.ini
	 */
	public void IncludeFileThree()
	{
		inclFile3 = true;
	}
	
	
	public void select()
	{ //Begin Execute
		//Print out the file location being used
		System.out.println(System.getProperty("user.dir"));
		
		//Have the GUI take user input on what to include
		theGUI.FileSelectorGUI(this);
		
	}
	
	public void changeLines()
	{
		//Start with RampBasics, as it forms the basis of both Ramp and Smart.
		//Set the lines of RampBasics to an array list
		ArrayList<String> file1Lines = RampBasics.LinestoArray();
		//Add the lines of file 1 to the new file
		for(String s: file1Lines)
			linesToAdd.add(s);
		//Now show the GUI for file selection, and let the user select which files to include.
		ArrayList<String> otherLines = OtherFiles();
		for(String s: otherLines)
			linesToAdd.add(s);
		
		theGUI.roleNameGUI();
	}
	
	public void finalize(TextField tb1, TextField tb2)
	{
		ArrayList<String> finalFile = listOfLines;
		//User input
		finalFile.set(76, "ramp.aclNonGuestRole.ramp_user = UserInput");
		finalFile.set(77, "ramp.aclNonGuestRole.ramp_dba = UserInput");
		return(finalFile);
		//Write the new array list to a file.
		Applicationini.writeToFile(linesToAdd);
	} //End Execute
	
	//Helper Methods for Execute
	
	private ArrayList<String> OtherFiles()
	{ //Begin OtherFiles
		//Build the array list to be return
		ArrayList<String> optionalLinesToAdd = new ArrayList<String>();
		
		//Have the GUI take user input on what to include
		//theGUI.FileSelectorGUI(this);
		

		//Include the files selected by the user in the GUI
		if(inclFile2 == true)
		{ //Begin file 2
			//Make the lines of file 2 into an array list
			ArrayList<String> file2Lines = RampDefaults.LinestoArray();
			//Add the array list of file 2's lines to the new file
			for(String s: file2Lines)
				optionalLinesToAdd.add(s);
		} //End file 2

		if(inclFile3)
		{ //Begin for file 3
			//Make the lines of file 3 an array list
			ArrayList<String> file3Lines = RampDemo.LinestoArray();
			//Add the lines of file 3 to the new file
			for(String s: file3Lines)
				optionalLinesToAdd.add(s);
		} //End if for file 3
		return(optionalLinesToAdd);
	} //End OtherFiles
	
	/**
	 * Takes a text field and returns the data inside of it as a string.
	 * @param tb1 valid text field
	 * @return String of the following format: ramp.aclNonGuestRole.ramp_user = UserInput
	 */
	public String finalStringCreator(TextField tb1)
	{ //Begin finalStringCreator
		//Save the text stored in the text field into a variable
		String name1 = tb1.getText();
		//Append the text stored to the appropriate location in the code
		String finalText = new String("ramp.aclNonGuestRole.ramp_user = "+ name1);
		return finalText;
	} //End final string creator
} //End class