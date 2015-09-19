import java.awt.Color;
import edu.kzoo.grid.ColorBlock;
import edu.kzoo.util.Debug;
import edu.kzoo.grid.Location;
import edu.kzoo.grid.Grid;

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
  
  @author Marc Kuniansky (with assistance from)
  @version May 12, 2015
 **/
public class VerticalPercolator extends ColorBlock
{ //Begin class
    // Instance variables

    /**
     * Constructor with no parameters.
     */
    public VerticalPercolator()
    { //Begin constructor
        // initialise
        super(Color.BLACK);
    } //End constructor
    
    /**
     * This method is here for debugging purposes
     */
    public void act()
    { //Begin act
        Debug.println("Percolator " + location() + " about to act...");
        
        // Figure out where to percolate or spread to.
        Location location = this.getPercolationLocation();
        Debug.println("Should percolate to: " + location);

        // Percolate there.
        this.percolateTo(location);
    } //End act
    
    /** 
     * Get the location of the block to percolate to
     */
    protected Location getPercolationLocation()
    { //Begin getPercolationLocation
        //Declare nescessary variables
        Location currentLocation = this.location(); //Need the current location of the block
        int currentRow = currentLocation.row(); //Need the current row
        int nextRow = currentRow + 1; //Need the new row, one row down
        Location newLocation = new Location(nextRow,currentLocation.col()); //The new location is one spot down on the grid
        return newLocation;
    } //End getPercolationLocation
    
    /**
     * Add a new block to the block below the initial percolator, assuming it is empty and
     * inside of the grid.
     * 
     * @param  location must be a <code>Location</code> object.
     */
    protected void percolateTo(Location location)
    { //Begin percolateTo
        Debug.println("Should now percolate to somewhere...");
        int nextRow = location.row();
        Grid theGrid = this.grid(); //Need the grid the object is in
        //Check to see if the new location is inside the grid and is empty
        boolean isValid = false;
        if(nextRow<theGrid.numRows()&& theGrid.isEmpty(location))
        {
            isValid = true;
        }
        //Percolate to the next spot only if the space is empty and inside the grid
        if(isValid==true)
        {
            VerticalPercolator newPercolator = new VerticalPercolator();
            theGrid.add(newPercolator, location);
            PercolationController.getController().notePercolationTo(newPercolator);
        }
    } //End percolateTo()
} //End class

