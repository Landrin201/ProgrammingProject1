import java.awt.Color;
import edu.kzoo.grid.ColorBlock;
import edu.kzoo.util.Debug;
import edu.kzoo.grid.Location;
import edu.kzoo.grid.Grid;
import java.util.ArrayList;

/**
  Project Name: Percolator Lab
  <br>
  This adds a percolating block to the percolater. The percolating block will percolate down as 
  far as it can. When it hits a solid block, it will move to the left and right if possible.
  <br> <br>
  Created: <br>
    May 12,  Marc Kuniansky
    <br> <br>
  Modifications: <br>
    May 13, Marc Kuniansky, Implemented the constructor, act, getPercolationLocations,
                            and percolateTo methods.
    <br> <br>
  
  @author Marc Kuniansky (with assistance from)
  @version May 13, 2015
 **/
public class GravitationalPercolator extends AbstractPercolator
{ //Begin class
    // Instance variables

    /**
     * Constructor with no parameters.
     */
    public GravitationalPercolator()
    { //Begin constructor
        // initialise
        super();
    } //End constructor
    
    /**
     * Create a new gravitational percolator to add to the grid.
     */
    protected AbstractPercolator duplicate()
    { //Begin duplicate
        GravitationalPercolator newPercolator = new GravitationalPercolator();
        return newPercolator;
    } //End duplicate
    
    /** 
     * Returns an array list of all of the locations to percolate to
     */
    protected ArrayList getPercolationLocations()
    { //Begin getPercolationLocation
        //Create an array list of locations
        ArrayList<Location> locationList = new ArrayList<Location>();
        //Declare nescessary variables
        Grid theGrid = this.grid();
        Location currentLocation = this.location(); //Need the current location of the block
        int currentRow = currentLocation.row(); //Need the current row
        int nextDownRow = currentRow + 1; //Need the new row, one row down
        int currentColumn = currentLocation.col();
        int nextColumn = currentColumn+1;
        int lastColumn = currentColumn-1;
        Location nextDownLocation = new Location(nextDownRow, currentLocation.col());
        Location nextRightLocation = new Location(currentRow, nextColumn);
        Location nextLeftLocation = new Location(currentRow,lastColumn);
        //First, add the location for the next location directly below the block.
        if(theGrid.isEmpty(nextDownLocation) && nextDownRow<theGrid.numRows())
        { //Begin if statement
            locationList.add(nextDownLocation); //The new location is one spot down on the grid
        } //End if statement
        //Then, add the location for the location to the right of the block if the grid is not empty in the next row
        if(theGrid.isEmpty(nextRightLocation) && nextColumn<theGrid.numCols())
        { //Begin if statement for going right
            locationList.add(nextRightLocation);
        } //End if statement for going right
        if(theGrid.isEmpty(nextLeftLocation) && lastColumn>=0)
        { //Begin if statement for going left 
            //Finally, add the location for the location to the left of the block.
            locationList.add(nextLeftLocation);
        } //End if statement for going left
        return locationList;
    } //End getPercolationLocation
} //End class

