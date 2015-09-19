/*
 * Author: Marc Kuniansky
 * Date Created: July 2, 2015
 * Modifications: 
 * 			Date			Author					         Reason
 * 		July 2 2015,   Marc Kuniansky, 	Implemented the constructor which takes a file extension and name as a file, and which creates a new file to modify.
 * 										Implemented the writeToFile method, which writes several default lines to the file.
 * 										At present, if a pre-existing file is used the data within the file is erased. 
 * 		July 15 2015,  Marc Kuniansky,  Modified the writeToFile method to take in an array list and write each item in that
 * 										list into the file as a line.
 * 		
 */

import java.io.BufferedWriter;
import java.io.*;
import java.util.ArrayList;

/**
 * Creates a new file and adds text to it. 
 * @author Marc Kuniansky
 * @version June 2, 2015
 *
 */
public class FileCreator
{ //Begin class
	//Instance variables
	private String fileName;
	private File file;
	
	//Constructor
	/**
	 * Constructor for FileWriter with no parameters. This creates a new file with the specified location and name.
	 */
	public FileCreator(String fileExtension, String nameOfFile)
	{
		fileName = nameOfFile;
		file = new File(fileExtension + "/"+fileName);
		//The constructor doesn't need to do anything- the writeToFile method creates a new file and writes to it.
	}
	
	/**
	 * Create a new text file, and write several lines to it.
	 */
	public void writeToFile(ArrayList<String> includeInFile)
	{ //Begin writeToFile
		Debug.println("File Name:" + file);
		try
		{ //Begin try
			Debug.println("Inside Try");
			
			//Make a new file writer object.
			FileWriter fileWriter = new FileWriter(file);
			Debug.println("Created File Writer");
			
			//Wrap the file writer in a buffered writer
			BufferedWriter writer = new BufferedWriter(fileWriter);
			Debug.println("Created Buffered Writer");
			
			//Access the array list and go through all items in it. Add each item to the file as a separate line
			for(String s: includeInFile)
			{ //Begin loop for adding lines to file
				writer.write(s);
				writer.newLine();
			} //End loop for adding lines to file
			
			//Always close files when finished.
			writer.close();
			fileWriter.close();

		} //End try
		catch(IOException e)
		{ //Begin catch
			System.out.println("Error - " + e.toString());
		} //End catch
	} //End writeToFile

} //End class
