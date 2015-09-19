import edu.kzoo.grid.BoundedGrid;
import edu.kzoo.grid.Location;
/**
  Project Name: <br>
  This constructs a maze for a mouse to navigate.
  <br> <br>
  Created: <br>
    May 17 2015,  Marc Kuniansky
    <br> <br>
  Modifications: <br>
    May 17 2015, Marc Kuniansky, Modified to .... <br>
  
  @author Marc Kuniansky, with assistance from Alyce Brady and Pamela Cutter
  @version May 17 2015
 **/
 
public class Maze extends BoundedGrid
{ //Begin class
    //Instance Variables
    protected Location mouseStartingLocation;
    protected Location cheeseLocation;
    //BoundedGrid grid;
    
    /**
     * Constructor for Maze
     */
    public Maze(int rows, int columns)
    { //Begin constructor
        super(rows, columns);
        mouseStartingLocation = new Location(0,0);
        cheeseLocation = new Location(1,1);
    } //End constructor
    
    /**
     * Sets the starting location for the mouse in the specified location
     * @param startLocation Must be a valid, empty location in the grid
     */
    public void setStartLoc(Location startLocation)
    { //Begin setStartLoc
    	//Set the initial location of the mouse
        mouseStartingLocation = startLocation;
    } //End setStartLoc
    
    /**
     * Sets the location for the cheese (end of the maze) in the specified location
     * @param endLocation Must be a valid, empty location in the grid
     */
    public void setFinishLoc(Location endLocation)
    { //Begin setFinishLoc
    	//Set the location of the cheese
        cheeseLocation = endLocation;
    } //End setFinishLoc
    
    /**
     * Returns the starting location of the mouse. 
     * @return The location of the mouse
     */
    public Location getStartLoc()
    { //Begin getStartLoc
    	//Return the starting location of the mouse
        return mouseStartingLocation;
    } //End getStartLoc
    
    /**
     * Returns the location of the cheese, which is the end of the maze. 
     * @return The location of the cheese
     */
    public Location getFinishLoc()
    { //Begin getFinishLoc
    	//Return the location of the cheese, which is the end of the maze
        return cheeseLocation;
    } //End getFinishLoc
} //End class
