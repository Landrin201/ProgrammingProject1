import java.util.ArrayList;
/**
 Class: SubstringAndLocations <br>
	Description: TheSubstringAndLocations class takes a list of DNASequence objects and a specific subString and searches
				 the DNASequences for the subString. This class keeps track of the location of the subString within the 
				 DNASequence and the substring that it searches.
	<br> <br>
   Author:  Marc Kuniansky <br>
      Creation date:  May 26, 2015
      <br> <br>

   Modifications: <br>
        Date   		 Name    		Reason <br>
        ----   		 ----    		------ <br>
 	   May 25, 2015, Marc Kuniansky, Implemented the constructor and the getSubsequence and searchSequence 
 	   								 methods. <br>
	   May 26, 2015, Marc Kuniansky, Implemented the toString method. Modified the gerSubsequence method to return a list of
	   								 Location objects rather than String objects. Modified the constuctor to only take two
	   								 parameters.<br>
 	   <br>
 	   
   @author Marc Kuniansky
   @version May 26, 2015
 */
public class SubstringAndLocations 
{ //Begin SubstringAndLocations class
	
	//Instance Variables
	
	//Array list of DNA sequences
	private ArrayList<DNASequence> sequenceList;
	//The sub-sequence to be searched for
	private String subSequence;
	//Array list of locations. Initially this must be empty.
	private ArrayList<Location> substringLocationList;
	
	/**
	 * Constructor that takes two parameters: an <code>ArrayList</code> of DNASequence objects and the subSequence to be
	 * searched for.
	 * 
	 * @param listOfSequences must be a valid <code>ArrayList</code> of DNASequence objects.
	 * @param theSubeSquence must be a valid <code>Strung</code>.
	 */
	public SubstringAndLocations(ArrayList<DNASequence> listOfSequences, String theSubSequence)
	{ //Begin constructor
		//Initialize instance variables
		sequenceList = listOfSequences;
		subSequence = theSubSequence;
		substringLocationList = new ArrayList<Location>();
	} //End constructor
	
	
	/**
	 * Returns the substring being examined.
	 * 
	 * @return A subSequence as a <code>String</code>.
	 */
	public String getSubSequence()
	{ //Begin getSubSequence
		//This method only needs to return the subSequence of interest.
		Debug.println(subSequence);
		return subSequence;
	} //End getSubSequence
	
	
	/**
	 * Returns a string of all the locations at which a subSequence appears, formatted in the following way:
	 * sumSequence: Location1 Location2 Location3... where each location is a valid Location object. <br>
	 * 
	 * Precondition: The searchSequence method has already been called, so substringStartLocationList is not empty.
	 * @return A <code>String</code> which contains the subSequence and all of the locations at which it appears.
	 */
	public String toString()
	{ //Begin toString
		String s = "";
		//Loop through all of the locations in the list and add them to the string.
		for(Location location: substringLocationList)
			s += " " + location.toString();
		Debug.println(subSequence + ":" + s);
		return subSequence + ":" + s;
	} //End toString
	
	
	public void searchForSubstring()
	{
		substringLocationList = this.searchSequence();
	}
	
	/**
	 * Searches the sequences in a DNASequence object for a specified subSequence.
	 * 
	 * @return An array list of starting locations of the specified subSequence
	 */
	private ArrayList<Location> searchSequence()
	{ //Begin searchSequence
		Debug.println("In searchSequence \n");
		Debug.println("Substring length: " + subSequence.length());
		
		//Ensure that the substringStartLocationList is empty before doing anything else
		ArrayList<Location> substringStartLocationList = new ArrayList<Location>();
		substringStartLocationList.clear();
		
		//Run through all of the sequences in the sequence list
		for(DNASequence sequence: sequenceList)
		{ //Begin for loop
			//Get the sequence and index number for each DNA sequence in the sequenceList
			Debug.println("Checking the for loop for repetition.");
			String indexNumber = sequence.getIndexNumber();
			String theSequence = sequence.getSequence();
			Debug.println("Current index: " + indexNumber);
			
			//Set the location equal to 0 for the first location. 
			int currentLocation = 0;
		
			//As long as the current location is a value less than the length of the sequence being searched,
			//continue searching for the substring.
			while(currentLocation<theSequence.length())
			{ //Begin while statement
				//Debug.println("Current Location: " + currentLocation);
				Debug.println("Checking the while loop for repetition.");
				//Search the DNA Sequence for the sub sequence for the first time and add the location to the array list
				
				//The indexOf method stops after it finds one instance of the substring, so currentLocation needs to be
				//incremented later
				int substringStartLocation = theSequence.indexOf(subSequence, currentLocation);
				//If substringStartLocation is greater than 0, then create a location object and add it to an array list.
				if(substringStartLocation>=0)
				{ //Begin if statement
					//Make the full location, formatted like this: (indexNumber, startingLocation).
					Location fullLocation = new Location(indexNumber, substringStartLocation);
					Debug.println("Full Location: " + substringStartLocationList.contains(fullLocation));
					Debug.println("List: " + substringStartLocationList);
					if(substringStartLocationList.contains(fullLocation)==false)
					{ //Begin if statment
						//Add the location to the location list
						Debug.println("Location: " + fullLocation);
						substringStartLocationList.add(fullLocation);
					} //End if statement
						//Increment the current location.
					currentLocation++;
				} //End if statement
				else
				{ //Begin else
					//indexOf returns -1 when it does not find the specified substring. Prevent the while loop from becoming 
					//infinite by forcing it to stop if substringStartLocation is -1.
					break;
				} //End else
			} //End while statement
		} //End for loop
		
		//If the subSequence never appears in this DNA sequence, tell the user.
		if(substringStartLocationList.isEmpty())
			System.out.println("This sub sequence is not in the DNA sequence.");
		else
		{ //Begin else
			//If the subSequence does appear in any of the sequences, do nothing.
			Debug.println("Number of times the substring appears: " + substringStartLocationList.size());
		} //End else
		
		//Return the array list.
		return substringStartLocationList;
	} //End searchSequence
	
} //End SubstringAndLocations class
