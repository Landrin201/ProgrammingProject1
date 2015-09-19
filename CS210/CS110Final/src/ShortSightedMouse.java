import edu.kzoo.grid.Grid;
import edu.kzoo.grid.Location;
import java.util.ArrayList;
import java.util.Random;
/*
 * Modifications:
 * May 25 2015, Marc Kuniansky, Implemented the constructor and move methods and the possibleLocations and look methods. 
 * June 2 2015, Marc Kuniansky, Refactored the move method into the Mouse class, and renamed the current move method to 
 * 								nextLocation. Also added a randomizeLocations method to generate a random location from a 
 * 								list.
 * June 9 2015, Marc Kuniansky, changed some of the implementation of the possibleLocations and nextLocation methods
 * 								to make them easier to look at. Functionality was not changed.
 */

/**
 *  Mouse in a Maze Program: ShortSightedMouse <br>
 *
 *    A short-sighted mouse can see 3 blocks ahead of itself. If it
 *    sees the cheese in either of those blocks, it goes to it. If not, it randomly moves to another block.
 *
 *  @author Marc Kuniansky, with assistance from Pamela Cutter and Alyce Brady
 *  @version 2 June 2015
 **/
public class ShortSightedMouse extends Mouse
{  //Begin class
    //Instance variables
	//Need an array list to store the possible locations
	protected ArrayList<Location> possibleMoveLocationList;
	
    /**
     * Constructs a mouse.
     **/
    public ShortSightedMouse()
    { //Begin constructor
    	//Construct the parent class
        super();
        //Initialize instance variables
        possibleMoveLocationList = new ArrayList<Location>();
    } //End constructor
    
    //Methods
    
    /**
     * Returns the next location to which the mouse should move
     * @return Location object, the next location to which the mouse moves
     */
    public Location nextLocation()
    { //Begin nextLocation
    	//Clear the array list of possible locations
    	possibleMoveLocationList.clear();
    	
        //First, get the current location
        Location currentLocation = this.location();
        
        //Then, get all of the locations to which the mouse could possibly move
        possibleLocations(currentLocation);
        
        //Next, look around and see if the mouse sees the cheese by looking through all possible locations
        for(Location location: possibleMoveLocationList)
        { //Begin look loop
            //If the cheese is seen, move to it.
            if(look(location))
            { //If the mouse sees the cheese...
                //If the cheese is seen, return the location of the cheese.
                return(maze().getFinishLoc());
            } //End if statement
            else 
            { //Begin else
                //Do nothing if the mouse does not see the cheese.
            } //End else
        } //End look loop
        
        //Randomize the possible locations whenever the mouse does not see the cheese in any of the possible locations
    	Location nextLocation = randomizeLocations(possibleMoveLocationList);
    	return nextLocation;
    } //End nextLocation
    
    
    //Private helper methods
    /**
     * Returns an array list which contains all of the possible locations
     * to which the mouse can move, whether or not they are empty.
     * 
     * @param currentLocation must be a valid Location object
     * @return Returns an array list of Location objects
     */
    private void possibleLocations(Location currentLocation)
    { //Begin possibleLocations
        //Make the array list to return
    	possibleMoveLocationList = new ArrayList<Location>();
        
        //Get the end location of the maze
        Location cheeseLocation = maze().getFinishLoc();
        
        //Get the current row and column
        int currentRow = currentLocation.row();
        int currentColumn = currentLocation.col();
        
        //Get the grid, and the number of rows and columns
        Grid grid = this.grid();
        int numberRows = grid.numRows();
        int numberColumns = grid.numCols();
        
        //Get the four adjacent locations to the mouse
        //Moving forward one column moves the mouse right
        Location forwardOneColumn = new Location(currentRow, currentColumn+1);
        //Moving forward one row moves the mouse down
        Location forwardOneRow = new Location(currentRow+1, currentColumn);
        //Moving back one row moves the mouse up
        Location backOneRow = new Location(currentRow-1, currentColumn);
        //Moving back one column moves the mouse left
        Location backOneColumn = new Location(currentRow, currentColumn-1);
        
        //Always add the locations in this order: forward one column, forward one row,
        //back one row, back one column.
        //Ensure that the locations generated are valid (in the grid) and empty.
        if(currentColumn+1<=numberColumns && grid.isEmpty(forwardOneColumn) || forwardOneColumn.equals(cheeseLocation))
            possibleMoveLocationList.add(forwardOneColumn);
        if(currentRow+1<=numberRows && grid.isEmpty(forwardOneRow) || forwardOneRow.equals(cheeseLocation))
            possibleMoveLocationList.add(forwardOneRow);
        if(currentRow-1>=0 && grid.isEmpty(backOneRow) || backOneRow.equals(cheeseLocation))
            possibleMoveLocationList.add(backOneRow);
        if(currentColumn-1>=0 && grid.isEmpty(backOneColumn) || backOneColumn.equals(cheeseLocation))
            possibleMoveLocationList.add(backOneColumn);
        
        //Return the array list
        //return possibleMoveLocationList;
    } //End possibleLocations
    
    
    /**
     * Returns a location at random from a list of locations
     * @param locationList must be a valid location list. Precondition: The list can't contain more than 4 locations
     * @return A location object
     */
    private Location randomizeLocations(ArrayList<Location> locationList)
    { //Begin randomize locations
    	//Make a random number generator and generate a random number no larger than the size of the list
    	Random generator = new Random();
    	int randomNumber = generator.nextInt(locationList.size());
    	
    	//Return the next location based on the random number
    	return locationList.get(randomNumber);
    } //End randomize locations
    
    
    /**
     * Has the mouse look ahead two spaces and see if it sees cheese. If it does, it returns true.
     * @param nextLocation must be a valid Location
     * @return True if the cheese is within 3 spaces of the current location, false if not.
     */
    private boolean look(Location nextLocation)
    { //Begin Look
        //Get the grid we are in
        Grid theGrid = this.grid();
        //Get the location of the cheese
        Location cheeseLocation = maze().getFinishLoc();
        
        //Get the row and column of the next location
        int nextRow = nextLocation.row();
        int nextColumn = nextLocation.col();
        //Get the current location, row, and column
        Location currentLocation = this.location();
        int currentRow = currentLocation.row();
        int currentColumn = currentLocation.col();
        
        //Figure out which direction the mouse is moving by using a bit of 
        //math. Compare the current row and column with the next row
        //and column, and figure out what changes.
        int rowDirection = nextRow-currentRow;
        int columnDirection = nextColumn-currentColumn;
        //See if the cheese is anywhere near the mouse
        Location newLocation;
        if(rowDirection>0)
        {
            //If rowDirection is>0, then the mouse is moving forward one row
            //And is not changing its column location
            newLocation= new Location(nextRow+1, nextColumn);
            if(theGrid.isEmpty(newLocation))
            { 
                newLocation = new Location(nextRow+2, nextColumn);
                if(theGrid.isEmpty(newLocation))
                {
                    //If the location two spaces ahead of the next location
                    //is empty, return false, the cheese is not there
                    return false;
                }
                else if(newLocation.equals(cheeseLocation))
                {
                    //If the object two spaces away is cheese, return true
                    return true;
                }
            }
            else if(newLocation.equals(cheeseLocation))
            {
                return true;
            }
        }
        else if(rowDirection<0)
        {
            //If rowDirection is>0, then the mouse is moving forward one row
            //And is not changing its column location
            newLocation= new Location(nextRow-1, nextColumn);
            if(theGrid.isEmpty(newLocation))
            {
                newLocation = new Location(nextRow-2, nextColumn);
                if(theGrid.isEmpty(newLocation))
                {
                    //If the location two spaces ahead of the next location
                    //is empty, return false, the cheese is not there
                    return false;
                }
                else if(newLocation.equals(cheeseLocation))
                {
                    //If the object two spaces away is cheese, return true
                    return true;
                }
            }
            else if(newLocation.equals(cheeseLocation))
            {
                return true;
            }
        }
        else if(columnDirection>0)
        {
            //If rowDirection is>0, then the mouse is moving forward one row
            //And is not changing its column location
            newLocation= new Location(nextRow, nextColumn+1);
            if(theGrid.isEmpty(newLocation))
            {
                newLocation = new Location(nextRow, nextColumn+2);
                if(theGrid.isEmpty(newLocation))
                {
                    //If the location two spaces ahead of the next location
                    //is empty, return false, the cheese is not there
                    return false;
                }
                else if(newLocation.equals(cheeseLocation))
                {
                    //If the object two spaces away is cheese, return true
                    return true;
                }
            }
            else if(newLocation.equals(cheeseLocation))
            {
                return true;
            }
        }
        else if(columnDirection<0)
        {
            //If rowDirection is>0, then the mouse is moving forward one row
            //And is not changing its column location
            newLocation= new Location(nextRow, nextColumn+1);
            if(theGrid.isEmpty(newLocation))
            {
                newLocation = new Location(nextRow, nextColumn+2);
                if(theGrid.isEmpty(newLocation))
                {
                    //If the location two spaces ahead of the next location
                    //is empty, return false, the cheese is not there
                    return false;
                }
                else if(newLocation.equals(cheeseLocation))
                {
                    //If the object two spaces away is cheese, return true
                    return true;
                }
            }
            else if(newLocation.equals(cheeseLocation))
            {
                return true;
            }
        }
        else
            return false;
        return false;
    } //End Look

} //End class