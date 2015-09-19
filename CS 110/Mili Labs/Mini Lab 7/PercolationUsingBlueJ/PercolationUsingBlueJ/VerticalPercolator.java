import java.awt.Color;
import edu.kzoo.grid.ColorBlock;
import edu.kzoo.util.Debug;
import edu.kzoo.grid.Location;
import edu.kzoo.grid.Grid;
import java.util.ArrayList;

/**
  Project Name: Percolator Lab
  <br>
  This adds a solid block to the percolater.
  <br> <br>
  Created: <br>
    May 12,  Marc Kuniansky
    <br> <br>
  Modifications: <br>
    May 12, Marc Kuniansky, Created the constructor and the three methods act, 
                            getPercolationLocation, and percolateTo. <br>
    May 13, Marc Kuniansky, Edited the getPercolationLocation method to return
                            an array list of locations rather than a single location.
    <br> <br>
  
  @author Marc Kuniansky (with assistance from)
  @version May 13, 2015
 **/
public class VerticalPercolator extends AbstractPercolator
{ //Begin class
    // Instance variables

    /**
     * Constructor with no parameters.
     */
    public VerticalPercolator()
    { //Begin constructor
        // initialise
        super();
    } //End constructor
    
    /**
     * Create a new vertical percolator to add to the grid.
     */
    protected AbstractPercolator duplicate()
    { //Begin duplicate
        VerticalPercolator newPercolator = new VerticalPercolator();
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
        int nextRow = currentRow + 1; //Need the new row, one row down
        Location nextLocation = new Location(nextRow, currentLocation.col());
        if(nextRow<theGrid.numRows()&& theGrid.isEmpty(nextLocation))
        { //Begin if statement for going down
            //The new location is one spot down on the grid
            locationList.add(nextLocation); 
        } //End if statement for going down
        return locationList;
    } //End getPercolationLocation
} //End class

