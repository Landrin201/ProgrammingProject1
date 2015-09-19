import java.util.ArrayList;

/**
   Class: SubSequenceGenerator <br>
	Description: The SubSequenceGenerator class takes a set of nucleotides (a, c, g, and t) and arranges them in all possible 
	orders given a certain length, returning all of the possible orders as an array list.
	<br> <br>
   Author:  Marc Kuniansky <br>
      Creation date:  May 27, 2015
      <br> <br>

   Modifications: <br>
        Date   		 Name    		Reason <br>
        ----   		 ----    		------ <br>
 	   May 27, 2015, Marc Kuniansky, Implemented the constructor and other methods. <br>
 	   <br>
 	   
   @author Marc Kuniansky
   @version May 27, 2015
**/
public class SubSequenceGenerator 
{ //Begin SubSequenceGenerator
	//Instance Variables
	private int subSequenceLength;
	private ArrayList<DNASequence> sequenceList;
	//Constructor
	
	/**
	 * Constructor which takes two variables, an <code>int</code> length and a <code>String</code>. <br>
	 * 
	 * The <code>int</code> refers to how long each subSequence should be, and the <code>string</code> holds the characters
	 * which will make up the subSequences. For DNA, these characters will be a, c, t, and g. <br>
	 * 
	 * @param specifiedLength Must be a valid <code>int</code>.
	 * @param SpecifiedSequenceList Must be a valid <code>ArrayList</code> containing only DNASequence objects.
	 */
	public SubSequenceGenerator(int specifiedLength, ArrayList<DNASequence> specifiedSequenceList)
	{ //Begin constructor
		subSequenceLength = specifiedLength;
		sequenceList = specifiedSequenceList;
	} //End constructor
	
	//Methods
	
	/**
	 * This goes through an <code>ArrayList</code> of DNASequence objects and gets the sequence stored in each one. Given
	 * a substring length, it then creates substrings of a specified length from all of the different 
	 * @return
	 */
	public ArrayList<String> generateSequences()
	{ //Begin generateSequences
		//Generate a new array list to hold all of the sub sequences
		ArrayList<String> subSequenceList = new ArrayList<String>();
		//Loop through all of the DNASequence objects and get their sequences
		for(DNASequence seq:sequenceList)
		{//Begin forEach loop
			//Get the DNA sequence of each DNASequence object
			String sequence = seq.getSequence();
			for(int i=0; i<sequence.length()-(subSequenceLength)+1; i++)
			{ //Begin for loop
				//Get the sub sequence of the specified length starting at i.
				String subSequence = sequence.substring(i, i+subSequenceLength);
				//Add the sub sequence to the list.
				if(!subSequenceList.contains(subSequence))
					subSequenceList.add(subSequence);
			} //End for loop
		} //End forEach loop
		//Return the array list
		return subSequenceList;
	} //End generateSequences
	
} //End SubSequenceGenerator
