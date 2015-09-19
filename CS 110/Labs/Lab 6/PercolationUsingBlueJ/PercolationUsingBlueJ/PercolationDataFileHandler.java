// Class PercolationDataFileHandler
//
// Author: Alyce Brady
//
// This class is based on the College Board's MBSDataFileHandler class,
// as allowed by the GNU General Public License.  MBSDataFileHandler
// is a black-box class within the AP(r) CS Marine Biology Simulation
// case study (once available at www.collegeboard.com/ap/students/compsci).
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

import java.awt.Color;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import edu.kzoo.grid.BoundedGrid;
import edu.kzoo.grid.Grid;
import edu.kzoo.grid.GridObject;
import edu.kzoo.grid.Location;
import edu.kzoo.grid.gui.GridDataFileHandler;

/**
 *  Percolation Program:<br>
 *
 *  A <code>PercolationDataFileHandler</code> object reads information
 *  from a data file about a vertical slice of a porous material, including
 *  the dimensions of the slice and the locations of solid cells in its
 *  structure.
 *
 *  <p>
 *  The first line of the input file should contain the dimensions of
 *  the vertical slice.  Subsequent lines should specify the locations of
 *  solid cells in the structure of the material.  The file format is:
 *  <pre>
 *     rows columns             (dimensions)
 *     row-pos col-pos          (solid cells ... )
 *     row-pos col-pos
 *     row-pos col-pos
 *     ...
 *     row-pos col-pos
 *  </pre>
 *  where <code>rows</code> and <code>columns</code> are integers
 *  indicating the number of rows and columns to represent the vertical
 *  slice and the <code>row-pos</code> and <code>col-pos</code> lines
 *  indicate the row and column positions of solid cells in the slice.
 *
 *  @author Alyce Brady (based on MBSDataFileHandler)
 *  @version 8 February 2009
 **/
public class PercolationDataFileHandler implements GridDataFileHandler
{
    // Encapsulated data used to read/write info from a file
    private LineNumberReader inputReader;  	// buffered input w/ line number
    private StringTokenizer tokenizer;   	// parses tokens from a line


    /** Reads information about a vertical slice of a porous material from
     *  an initial configuration data file.
     *  @param  file       java.io.File object from which to read
     *  @throws java.io.FileNotFoundException if file cannot be opened
     *  @throws RuntimeException   if invalid information is read from file
     **/
    public Grid readGrid(File file)
        throws java.io.FileNotFoundException
    {
        // Open the file for reading.
        inputReader = new LineNumberReader(new FileReader(file));

        // Read vertical slice dimensions and construct grid.
        Grid grid = buildGrid();

        // Read solid cell locations.
        readSolidCellLocs(grid);

        return grid;
    }

    /** Reads vertical slice specifications and constructs grid.
     *  @throws RuntimeException  if invalid information is read
     **/
    private Grid buildGrid()
    {
        int numRows, numCols;

        try
        {
            // Read the vertical slice dimensions.
            numRows = readInt();
            numCols = readInt();
        }
        catch (Exception e)
        { 
            throw new RuntimeException("Error reading dimensions of vertical slice "
                                       + "(line " 
                                       + inputReader.getLineNumber() + ")");
        }

        // Validate vertical slice dimensions.
        if ( numRows <= 0 || numCols <= 0 )
            throw new RuntimeException("Dimensions must be positive (line "
                                       + inputReader.getLineNumber() + ")");

        // Construct the appropriate bounded grid.
        Grid newGrid = new BoundedGrid(numRows, numCols);
        return newGrid;
    }

    /** Reads location information for the solid cells in the porous material
     *  and represent them in the grid.
     *  @param grid   the grid in which solid cells should be created
     *  @throws RuntimeException   if invalid location information is read
     **/
    private void readSolidCellLocs(Grid grid)
    {
        // Read solid cell locations until there aren't any more, construct
        // each solid cell, and add it to the grid.
        Location loc;
        while ( (loc = readLocation(grid)) != null )
        {
            GridObject solidCell = new SolidCell(Color.BLACK);
			grid.add(solidCell, loc);
        }
    }

    /** Reads in a Location object (must be a valid location in
     *  <code>grid</code>).
     *  @param grid      grid in which location must be valid
     *  @return  the newly created Location object
     *  @throws RuntimeException   if invalid location information is read
     **/
    private Location readLocation(Grid grid)
    {
        int row, col;
        try
        {
            // Read the location.
            row = readInt();
            col = readInt();
        }
        catch (java.io.EOFException e)
        {
            // Reached end of file
            return null;
        }
        catch (Exception e)
        {
            // Convert reading exceptions to MBSException.
            throw new RuntimeException("Error reading location (line " 
                                       + inputReader.getLineNumber() + ")"); 
        }
        Location loc = new Location(row, col);
        
        // Verify that location is valid in this grid.
        if ( grid.isValid(loc) )
            return loc;
        else
            throw new RuntimeException("Location " +  loc +
                                       " is not valid in this grid (line " 
                                        + inputReader.getLineNumber() + ")"); 
    }

    /** Returns the next token in the file as an integer.
     *  @return    an int containing the next number in the file
     *  @throws    java.io.EOFException if EOF
     *  @throws    java.lang.NumberFormatException if next token is not an int
     *  @throws    java.io.IOException if another type of input error occurs
     **/
    private int readInt()
        throws java.io.IOException
    {
        // Read in number as string, then convert to integer.
        String token = readString();
        if ( token == null )
            throw new java.io.EOFException();
        return Integer.parseInt(token);
    }

    /** Returns the next token in the file as a string.
     *  @return     a String containing the next token in the file; or null
     *              if end of file is encountered
     *  @throws     java.io.IOException if an input error occurs
     **/
    private String readString()
        throws java.io.IOException
    {
        // Read in a new line if there are no more tokens in current line.
        while ( tokenizer == null || ! tokenizer.hasMoreTokens() )
        {
            String line = inputReader.readLine();

            // Did we encounter end of file?
            if ( line == null )
                return null;
            tokenizer = new StringTokenizer(line);
        }

        // Return next token.
        return tokenizer.nextToken();
    }

    /** Writes information about a vertical slice of a porous material into
     *  a data file, including the material's dimensions and the locations of
     *  the solid cells.
     *  @param  grid   grid to write to file
     *  @param  file   java.io.File object to which to write
     *  @throws java.io.FileNotFoundException if file cannot be opened
     *  @throws java.io.IOException if error writing to file
     **/
    public void writeGrid(Grid grid, File file)
        throws java.io.IOException
    {
        PrintWriter out = new PrintWriter(new FileWriter(file));

        // Save grid dimensions.
        out.println(grid.numRows() + " " + grid.numCols());
            
        // Save the locations of all the solid cells.
        GridObject[] objList = grid.allObjects();
        for ( int index = 0; index < objList.length; index++ )
        {
            if ( objList[index] instanceof SolidCell )
            {
                int row = objList[index].location().row();
                int col = objList[index].location().col();
                out.println(row + " " + col);
            }
        }
        out.close();
    }

}
