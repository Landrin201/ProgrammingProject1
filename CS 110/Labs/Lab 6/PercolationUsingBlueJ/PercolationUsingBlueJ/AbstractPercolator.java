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
    {
        // Initialize the GridObject aspects of this Percolator.
        super();
    }

    // Redefined method from GridObject:

    /** Acts (percolates) for one step in the percolation simulation.
     */
    public void act()
    {
        Debug.println("Percolator " + location() + " about to act...");
    }

    // New methods:

}
