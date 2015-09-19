// Class: AbstractPercolator
//
// Author: Alyce Brady
//
// License Information:
//   This class is free software; you can redistribute it and/or modify
//   it under the terms of the GNU General Public License as published by
//   the Free Software Foundation.
//
//   This class is distributed in the hope that it will be useful,
//   but WITHOUT ANY WARRANTY; without even the implied warranty of
//   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//   GNU General Public License for more details.

import java.util.ArrayList;

import edu.kzoo.grid.GridObject;
import edu.kzoo.util.Debug;
import edu.kzoo.grid.Location;
import edu.kzoo.grid.Grid;
import java.util.ArrayList;

/**
 *  Percolation Program:<br>
 *
 *    An <code>AbstractPercolator</code> object represents a percolating
 *    substance in a porous material.
 *
 *  @author Alyce Brady
 *  @version 8 February 2009
 */
public abstract class AbstractPercolator extends GridObject
{
    // State (instance variables): all state is inherited from GridObject.

    // Constructor(s):

    /** Constructs an abstract percolator (not yet in a grid).
     */
    public AbstractPercolator()
    { //Begin constructor
        // Initialize the GridObject aspects of this Percolator.
        super();
    } //End constructor

    // Redefined method from GridObject:

   /**
     * This method calls the other methods in the class to percolate.
     */
    public void act()
    { //Begin act
        Debug.println("Percolator " + location() + " about to act...");
        // Figure out where to percolate or spread to.
        ArrayList<Location> locationList = getPercolationLocations();
        // Percolate there.
        while(!locationList.isEmpty())
        {
            for(Location location: locationList)
            {
                Debug.println("Should percolate to: " + location);
                this.percolateTo(location);
            }
            locationList.clear();
        }
    } //End act

    // New methods:
    /**
     * Abstract method for getting the percolation locations. Different for 
     * each percolation type.
     * 
     * This method needs to return only valid locations, locations which are empty
     * and inside of the grid.
     */
    protected abstract ArrayList getPercolationLocations();
    
    /**
     * Abstract method for duplicating the object to percolate
     */
    protected abstract AbstractPercolator duplicate();
    
    /**
     * Add a new percolating block to the grid in the desired location.
     * 
     * @param  location must be a <code>Location</code> object.
     */
    protected void percolateTo(Location location)
    { //Begin percolateTo
        Debug.println("Should now percolate to somewhere...");
        Grid theGrid = this.grid(); //Need the grid the object is in
        //Check to see if the new location is inside the grid and is empty//Percolate to the next spot downward only if the space is empty and inside the grid
        AbstractPercolator newPercolator = duplicate();
        theGrid.add(newPercolator, location);
        PercolationController.getController().notePercolationTo(newPercolator);
    } //End percolateTo

}
