import java.util.ArrayList;
/**
   Class: Indexer <br>
	Description: The Indexer class is intended to run through all possible subsequences of a specified length and see how many 
	times each one appears in a sequence of DNA. 
	<br> <br>
   Author:  Marc Kuniansky <br>
      Creation date:  May 26, 2015
      <br> <br>

   Modifications: <br>
        Date   		 Name    		Reason <br>
        ----   		 ----    		------ <br>
 	   May 26, 2015, Marc Kuniansky, Implemented the constructor. <br>
 	   May 27, 20015 Marc Kuniansky, Implemented the run, setSubSequences, and printSequenceData methods. Refactored most of
 	   								 the code from the main method to this one. <br>
 	   <br>
 	   
   @author Marc Kuniansky
   @version May 26, 2015
**/
public class Indexer 
{ //Begin Indexer class
	
	//Instance Variables
	
	//The length of the desired subSequences
	private int subSequenceLength;
	//An array list to hold all of the DNA sequences that the DNADataReader produces
	private ArrayList<DNASequence> sequenceList;
	//An array list to hold all of the subSequences and their locations
	private ArrayList<SubstringAndLocations> subSequenceList;
	
	//Constructors
	/**
	 * Constructor with no parameters.
	 */
	public Indexer()
	{ //Begin constructor
		Debug.turnOff();
		//Ask the user for a file using a validated input reader
		ValidatedInputReader reader = new ValidatedInputReader();
		String fileName = reader.getString("File Name", "File Name");
		Debug.print("File: "+ fileName + "\n");
		DNADataReader dataReader = new DNADataReader(fileName);
		
		//Initialize instance variables
		subSequenceLength = reader.getInteger("Length of Sub-Sequence", 4, "Are you sure?");
		Debug.println("Length of subSequence: " + subSequenceLength + "\n");
		sequenceList = dataReader.readData();
		subSequenceList = new ArrayList<SubstringAndLocations>();
	} //End constructor
	
	//Methods
	
	/**
	 * This takes the data obtained from the user and generates a list of SubstringAndLocations objects
	 */
	public void run()
	{ //Begin run
		//First get all of the sub sequences in the data and add them to an array list.
		SubSequenceGenerator generator = new SubSequenceGenerator(subSequenceLength, sequenceList);
		ArrayList<String> subSequencesList = generator.generateSequences();
		
		//Capture the array list generated by setSubSequences in a variable
		ArrayList<SubstringAndLocations> subSequenceList = this.setSubSequences(subSequencesList);
		
		for(SubstringAndLocations subSequenceLocation: subSequenceList)
		{ //Begin for loop
			//Have each SubSequenceLocation object search its sub sequence
			subSequenceLocation.searchForSubstring();
			//Print the information stored in each object
			System.out.println(subSequenceLocation.toString());
		} //End for loop
	} //End run
	
	/**
	 * Returns an array list of SubstringAndLocations objects after having them all search through a list of DNASequence
	 * objects and obtaining their locations.
	 * 
	 * @param subSequencesList Must be a valid <code>ArrayList</code> of strings.
	 * @return An <code>ArrayList</code> of SubstringAndLocations objects.
	 */
	public ArrayList<SubstringAndLocations> setSubSequences(ArrayList<String> subSequencesList)
	{
		//Add each subsequence to an array list which holds all of the SubstringAndLocations objects.
				for(String subSequence: subSequencesList)
				{ //Begin forEach loop
					//Create a new SubstringAndLocations object from the subSequence
					SubstringAndLocations subSequenceObject = new SubstringAndLocations(sequenceList, subSequence);
					//Have each object search for its subsequence in the DNASequence objects
					subSequenceObject.searchForSubstring();
					//Add each object to the array list
					subSequenceList.add(subSequenceObject);
				} //End forEach loop
				return subSequenceList;
	}
	
	public void printSequenceData()
	{ //Begin printSequenceData
		//Print the string names, descriptions, and sequences for the file.
		Debug.println("Printing Sequences. \n");
		//Loop through the DNA sequences and call the toString method on each DNASequence object.
		for(DNASequence seq: sequenceList)
		{ //Begin for loop
			seq.toString();
		} //End for loop
	} //End printSequenceData
} //End Indexer class