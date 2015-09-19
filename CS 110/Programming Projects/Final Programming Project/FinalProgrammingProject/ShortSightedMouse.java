import java.awt.Color;
import edu.kzoo.grid.Grid;
import edu.kzoo.grid.ColorBlock;
import edu.kzoo.util.NamedColor;
import edu.kzoo.grid.GridObject;
import edu.kzoo.grid.Location;
import java.util.ArrayList;

/**
 *  Mouse in a Maze Program: ShortSightedMouse <br>
 *
 *    A short-sighted mouse can see 3 blocks ahead of itself. If it
 *    sees the cheese in either of those blocks, it goes to it.
 *
 *  @author Marc Kuniansky
 *  @version 29 May 2015
 **/
public class ShortSightedMouse extends Mouse
{ 
    //Constuctor
    /**
     * Constructs a mouse.
     *  
     *  For now, the mouse is always a blue color block.
     **/
    public ShortSightedMouse()
    {
        super();
    }
    
    //Methods
    /**
     * Abstract move method, tells the mouse to move.
     */
    public void move()
    {
        //Get the current location of the mouse. Look at the 
        //adjascent squares, and see if they are empty. Try to move
        //Forward first, then right, then left.
        //Get the grid we are in
        Grid theGrid = this.grid();
        //First, get the current location
        Location currentLocation = this.location();
        //Then, get all of the locations to which the mouse could possibly move
        ArrayList<Location> possibleMoveLocationList = possibleLocations(currentLocation);
        ArrayList<Location> validMoveLocationList = new ArrayList<Location>();
        //See if the locations it could move to are empty. If a location
        //is not empty, remove it from the list.
        int sizeOfLocations = possibleMoveLocationList.size();
        for(Location location: possibleMoveLocationList)
        {
            if(theGrid.isEmpty(location))
            {
                validMoveLocationList.add(location);
            }
            else
            {
            }
        }
        //Next, look around and see if the mouse sees the cheese.
        for(Location location: validMoveLocationList)
        {
            //If the cheese is seen, move to it.
            if(look(location))
            {
                //If the cheese is seen, remove it from the grid and
                //put the mouse where it was.
                this.grid().remove(Maze.getFinishLoc());
                this.grid().add(this, Maze.getFinishLoc());
            }
            else 
            {
                //Do nothing if the mouse does not see the cheese.
            }
        }
        
        if(this.getLocation().equals(currentLocation))
        {
            //Then, have the mouse move to the first available space. 
            this.grid().add(this, validMoveLocationList.get(0));
            this.grid().remove(currentLocation);
            possibleMoveLocationList.clear();
            validMoveLocationList.clear();
        }
    }
    
    //Private helper methods
    /**
     * Returns an array list which contains all of the possible locations
     * to which the mouse can move, whether or not they are empty.
     * 
     * @param currentLocation must be a valid Location object
     * @return Retrns an array list of Location objects
     */
    private ArrayList<Location> possibleLocations(Location currentLocation)
    {
        //Make the array list to return
        ArrayList<Location> possibleLocationList = new ArrayList<Location>();
        
        //Get the current row and column
        int currentRow = currentLocation.row();
        int currentColumn = currentLocation.col();
        
        //Get the four adjascent locations to the mouse
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
        if(currentColumn+1<=this.grid().numCols())
            possibleLocationList.add(forwardOneColumn);
        if(currentRow+1<=this.grid().numCols())
            possibleLocationList.add(forwardOneRow);
        if(currentRow-1>=0)
            possibleLocationList.add(backOneRow);
        if(currentColumn-1>=0)
            possibleLocationList.add(backOneColumn);
        
        //Return the array list
        return possibleLocationList;
    }
    
    private boolean look(Location nextLocation)
    {
        //Get the grid we are in
        Grid theGrid = this.grid();
        //Get the location of the cheese
        Location cheeseLocation = Maze.getFinishLoc();
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
        if(rowDirection>0)
        {
            //If rowDirection is>0, then the mouse is moving forward one row
            //And is not changing its column location
            Location newLocation= new Location(nextRow+1, nextColumn);
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
            Location newLocation= new Location(nextRow-1, nextColumn);
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
            Location newLocation= new Location(nextRow, nextColumn+1);
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
            Location newLocation= new Location(nextRow, nextColumn+1);
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
    }

}