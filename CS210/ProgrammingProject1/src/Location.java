/**
 	Class: SubstringAndLocations <br>
 	Description: TheSubstringAndLocations class takes a list of DNASequence objects and a specific subString and searches
				 the DNASequences for the subString. This class keeps track of the location of the subString within the 
				 DNASequence and the substring that it searches.
	<br> <br>
  	Author:  Marc Kuniansky <br>
      Creation date:  May 25, 2015
      <br> <br>

   	Modifications: <br>
        Date   		 Name    		Reason <br>
        ----   		 ----    		------ <br>
 	   May 25, 2015, Marc Kuniansky, Implemented the constructors and the toString method.<br>
 	   May 27, 2015, Marc Kuniansky, 
 	   <br>
 	   
   	@author Marc Kuniansky, with assistance from Pamela Cutter.
   	@version May 27, 2015
 */
public class Location 
{ //Begin Location class
	
	//Instance Variables
	private int indexNumber;
	private int substringStartLocationNum;
	
	//Constructors- there are 4 constructors, to allow users to create Location objects with any combination
	//of strings or ints are parameters.
	
	/**
	 * First constructor, where both parameters are <code>int</code>s.
	 * 
	 * The first parameter is an <code>int</code> corresponding to the index number of the DNASequence
	 * and the second parameter is an <code>int</code> corresponding to the location of the first character of the subSequence.
	 * 
	 * @param sequence Must be a valid <code>int</code>.
	 * @param substringLocation Must be a valid <code>int</code>.
	 */
	public Location(int indexNum, int substringLocation)
	{ //Begin first constructor
		//Initialize instance variables
		indexNumber = indexNum;
		substringStartLocationNum = substringLocation;
	} //End first constructor
	
	/**
	 * Second constructor, where both parameters are <code>String</code>s.
	 * 
	 * The first parameter is a <code>String</code> corresponding to the index number of the DNASequence
	 * and the second parameter is an <code>String</code> corresponding to the location of the first character of the subSequence.
	 * 
	 * @param sequenceNumber Must be a <code>String</code> which contains <b>only</b> numbers.
	 * @param substringLocation Must be a <code>String</code> which contains <b>only</b> numbers
	 */
	public Location(String indexNum, String substringLocation)
	{ //Begin second constructor
		//Initialize instance variables
		//Because indexNumber is a string, it must be converted to an int
		indexNumber= Integer.parseInt(indexNum);
		//Because substringLocation is a string, it must be converted to an int.
		substringStartLocationNum = Integer.parseInt(substringLocation);
	} //End second constructor
	
	
	/**
	 * Third constructor, where the first parameter is a <code>String</code> and the second parameter is an <code>int</code>.
	 * 
	 * The first parameter is a <code>String</code> corresponding to the index number of the DNASequence
	 * and the second parameter is an <code>int</code> corresponding to the location of the first character of the subSequence.
	 * 
	 * @param indexNumber Must be a valid <code>String</code> object which contains <b>only</b> numbers.
	 * @param substringLocation Must be a valid <code>int</code>.
	 */
	public Location(String indexNum, int substringLocation)
	{ //Begin third constructor
		//Initialize instance variables
		//Because indexNumber is a string, it must be converted to an int.
		indexNumber = Integer.parseInt(indexNum);
		substringStartLocationNum = substringLocation;
	} //End third constructor
	
	/**
	 * Fourth constructor, where the first parameter is an <code>int</code> and the second parameter is a <code>String</code>. 
	 * 
	 * The first parameter is an <code>int</code> corresponding to the index number of the DNASequence
	 * and the second parameter is a <code>String</code> corresponding to the location of the first character of the subSequence.
	 * 
	 * @param indexNumber Must be a valid <code>int</code>.
	 * @param substringLocation Must be a valid <code>String</code> object which contains <b>only</b> numbers.
	 */
	public Location(int indexNum, String substringLocation)
	{ //Begin fourth constructor
		//Initialize instance variables.
		indexNumber = indexNum;
		//Because substringLocation is a string, it must be converted to an int.
		substringStartLocationNum = Integer.parseInt(substringLocation);
	} //End fourth constructor
	
	
	
	//Methods
	/**
	 * Getter method used to get the index number of a location
	 * @return Returns the index number of the locaton as an <code>int</code>.
	 */
	public int getIndexNumber()
	{ //Begin getIndexNumber
		//All this needs to do is return the index number of the location.
		Debug.println("Index Number: " + indexNumber);
		return indexNumber;
	} //End getIndexNumber
	
	/**
	 * Getter method used to get the starting location number from a location object.
	 * 
	 * @return An <code>int</code> starting location.
	 */
	public int getStartLocation()
	{ //Begin getStartLocation
		Debug.print("Start Location: " + substringStartLocationNum);
		return substringStartLocationNum;
	} //End getStartLocation
	
	/**
	 * Returns a location string with the following format: (indexNumber, subSequenceStartLocation) where the index number
	 * is the index number from the DNASequence object.
	 * 
	 * @return A location as a string.
	 */
	public String toString()
	{ //Begin toString
		//Format the location to display properly.
		String location = new String("(" + indexNumber + "," + substringStartLocationNum + ")");
		//Return the formatted string.
		return location;
	} //End toString
	
	/**
	 * Used to identify whether one location object is equal to another.
	 * 
	 * @param obj must be a valid Location object.
	 * @return Returns true if both the index number and starting location are equal.
	 */
	public boolean equals(Object obj)
	{ //Begin equals
		//Get the index and location of the location provided
		Location location = (Location)obj;
		int indexNum = location.getIndexNumber();
		int locationNum = location.getStartLocation();
		//If both values are equal to this location's values, return true.
		if(indexNum==indexNumber && locationNum==substringStartLocationNum)
			return true;
		else
			return false;
	} //End equals
	
} //End Location class
