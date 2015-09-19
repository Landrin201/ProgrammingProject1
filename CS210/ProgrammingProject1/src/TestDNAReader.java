/**
   Class: Test DNA Reader <br>
   Description: This class contains the main method for the app.
   <br> <br>
   Author:  Marc Kuniansky <br>
      Creation date:  May 20, 2015
	<br> <br>

   Modifications: <br>
        Date   		 Name    		Reason <br>
        ----   		 ----    		------ <br>
 	   May 20, 2015, Marc Kuniansky, Implemented the <code>main</code> method, having it construct
       							 	 a ValidatedInputReader and DNADataReader. <br>
	   May 23, 2015, Marc Kuniansky, Moified the main method to construct an <code>Array List</code> of DNASequence objects, 
	   								 and print their information. The DNASequence class was created to do this, and the debug
	   								 statements that printed the information obtained from the file in theDNADataReader class 
	   								 were commented out. <br>
	   May 25, 2015, Marc Kuniansky, Modified the main method to construct a SubstringAndLocations object to allow the program
	   								 to search the DNASequence objects for a specific string. The SubstringAndLocations and
							 		 Location class were created to fulfil this purpose. <br>
	   May 27, 2015, Marc Kuniansky, Modified the main method to implement the new Indexer class, refactoring most of the code
	   								 out of main.
	   <br> <br>
	   @author Marc Kuniansky
	   @version May 27, 2015
*/
public class TestDNAReader 
{

	/**
	 * Main method.
	 * @param args is not used
	 */
	public static void main(String[] args) 
	{ //Begin main
		Debug.turnOn();
		Debug.println("Main Started \n");
		
		//Make a new Indexer object, which will do most of the work
		Indexer indexer = new Indexer();
		Debug.println("Indexer creator made. \n");
		//Have the indexer print the sequence data for the file
		indexer.printSequenceData();
		//Make an array list to catch the sub sequence locations
		//ArrayList<SubstringAndLocations> subsequenceLocations = 
		indexer.run();
	} //End main

}
