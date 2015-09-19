/**
   Class: DNA Sequence <br>
   Description: Creates a DNA Sequence from a name, description, and sequence given.
   <br> <br>
   Author:  Marc Kuniansky <br>
      Creation date:  May 20, 2015
      <br> <br>
   Modifications: <br>
        Date   			 Name    			Reason <br>
        ----   			 ----    			------ <br>
 	   May 20, 2015, Marc Kuniansky, Implemented constructor and the IndexNumber, getDescription, getSequence, 
 	   								 and toString methods. <br>
 	   
 	   @author Marc Kuniansky
 	   @version May 20, 2015
*/
public class DNASequence 
{ //Begin DNASequence class
	//Instance Variables
	String indexNumber; //The name of the DNA Sequence
	String description; //the Description of the DNA Sequence
	String sequence; //The sequence that is stored
	
	/**
	 * Constructor for DNA Sequence
	 * 
	 * @param theName Must be a valid <code>String</code>
	 * @param theDescription Must be a valid <code>String</code>
	 * @param theSequence A <code>String</code> containing a DNA Sequence of a, g, t, and c.
	 */
	public DNASequence(String sequenceNumber, String theDescription, String theSequence)
	{
		//Initialize instance variables
		indexNumber = sequenceNumber;
		description = theDescription;
		sequence = theSequence;
	}
	
	//Methods
	
	/**
	 * Gives the name of the DNA sequence
	 * 
	 * @return The name of the sequence as a <code>String</code>.
	 */
	public String getIndexNumber()
	{ //Begin getIndexNumber
		Debug.println("Index Number: " + indexNumber);
		return(indexNumber);
	} //End getIndexNumber
	
	/**
	 * Gives the description of the DNA sequence
	 * 
	 * @return The description of the sequence as a <code>String</code>.
	 */
	public String getDescription()
	{ //Begin getDescription
		Debug.println("Description: " + description);
		return(description);
	} //End detDescription
	
	/**
	 * Returns the DNA sequence as a string.
	 * 
	 * @return The DNA Sequence as a <code>String</code>.
	 */
	public String getSequence()
	{ //Begin getSequence
		Debug.println("Sequence: " + sequence);
		return(sequence);
	} //End getSequence
	
	/**
	 * Prints and returns a <code>String</code> which is formatted to clearly display all of the information contained in the
	 * DNASequence object: the Index Number, the Description, and the DNA sequence.
	 * 
	 * @return A <code>String</code> containing all of the information contained in the class.
	 */
	public String toString()
	{ //Begin toString
		System.out.println("Index Number: "+ indexNumber +"\n"
							+ "Description:" + description + "\n"
							+ "Sequence: " + sequence + "\n");
		return("Index Number: "+ indexNumber +"\n"
							+ "Description:" + description + "\n"
							+ "Sequence: " + sequence + "\n");
	} //End toString
	
} //End DNASequence class
