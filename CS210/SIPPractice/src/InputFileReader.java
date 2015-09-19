/*
 * Author: Marc Kuniansky
 * Date Created: June 18, 2015
 * Modifications:
 * 			Date			Author					Reason
 * 		June 18 2015, Marc Kuniansky, 	Implemented the constructor which takes a file input as a variable.
 * 										Implemented the readFile method, which prints all lines in a text file.
 * 										Implemented the writeToFile method, which allows the user to write text to the file.
 * 										All methods currently do not return anything.
 * 
 * 		July 2 2015, Marc Kuniansky,    Modified the readFile method to work properly with the FileCreator class- as originally written,
 * 											files created by the FileCreator would not be properly read. Renamed method to PrintLinesOfFile(). 
 * 										Implemented the NumberLines method to return the number of lines in a file.
 * 										Implemented the LinesToArray() method, which adds each of the lines of the file and adds them to an array list.
 * 										This allows them to be easily manipulated.
 */

import java.io.*;
import java.util.ArrayList;

/**
 * Takes a file and allows the user to read information from the file.
 * @author Marc Kuniansky
 * @version July 2, 2015
 *
 */
public class InputFileReader 
{ //Begin class
	//Instance Variables
	private File file;
	//Need the name of the file to be used
	private String fileName;
	//ValidatedInputReader to take user input
	//ValidatedInputReader inputReader;
	
	/**
	 * Constructor which takes a file name as a parameter. The file must currently be a text file.
	 * @param name Must be a valid string and a valid file path
	 */
	public InputFileReader(String name, String extention)
	{ //Begin constructor with two parameters
		//Initialize instance variables
		fileName = name;
		file = new File(extention + "/"+name);
		//inputReader = new ValidatedInputReader();
	} //End constructor with two parameters.
	
	//Methods
	
	/**
	 * Reads all lines in a file and prints them.
	 */
	public void PrintLinesOfFile()
	{ //Begin readFile
		String line;
		try(
				FileReader theReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(theReader))
		{ //Begin try
			Debug.println("Inside InputFileReader try statement.");
			while((line = bufferedReader.readLine()) !=null)
			{ //Begin while
				System.out.println(""+line);
			} //End while
			bufferedReader.close();
		} //End try
		catch(FileNotFoundException ex)
		{ //Begin catch
			System.out.println("Unable to open file" + fileName
					+ ". File not found.");
		} //End catch
		catch(IOException e)
		{ //Begin catch
			System.out.println("Error - " + e.toString());
		} //End catch
	} //End readFile
	
	/**
	 * Adds each line of the file to its own index in an array list. All of the lines are stored as strings. 
	 * @return An array list of strings.
	 */
	public ArrayList<String> LinestoArray()
	{ //Begin linesToArray
		//Define local variables
		
		//Need a string to hold the current line
		String line;
		//Need an array list to add the lines to
		ArrayList<String> lineList = new ArrayList<String>();
		
		try(
				FileReader theReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(theReader))
		{ //Begin try
			Debug.println("Inside InputFileReader try statement.");
			while((line = bufferedReader.readLine()) !=null)
			{ //Begin while
				lineList.add(line);
			} //End while
			bufferedReader.close();
		} //End try
		catch(FileNotFoundException ex)
		{ //Begin catch
			System.out.println("Unable to open file" + fileName
					+ ". File not found.");
		} //End catch
		catch(IOException e)
		{ //Begin catch
			System.out.println("Error - " + e.toString());
		} //End catch
		
		//Return the array list
		return lineList;
	} //End linesToArray
	
	
	//Private methods

	/**
	 * This counts the number of lines in a file and returns it.
	 * @return An integer- the number of lines in the file
	 */
	public int numberLines(FileReader reader) throws IOException
	{ //Begin numberOfLines
		if(file.exists())
		{
			LineNumberReader lineNumberReader = new LineNumberReader(reader);
			
			//Initialize the number of lines
			int lineNumber = 0;
			
			while(lineNumberReader.readLine()!=null)
			{
				lineNumber ++;
			}
			lineNumberReader.close();
			Debug.println("Number of Lines: " + lineNumber);
			return lineNumber;
		}
		else
		{
			System.out.println("Line does not exist.");
			return -1;
		}
	} //End NumberOfLines
} //End class
