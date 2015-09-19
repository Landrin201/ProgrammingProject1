// Class: GridPlotter
//
// Author: Your Name Here
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

import edu.kzoo.grid.ColorBlock;
import edu.kzoo.grid.Grid;
import edu.kzoo.grid.Location;
import edu.kzoo.grid.gui.GridChangeListener;
import edu.kzoo.grid.gui.nuggets.ColorChoiceMenu;

import java.awt.Color;

import javax.swing.JOptionPane;

/**
 *  Grid Plotter:<br>
 *
 *    The GridPlotter class provides methods for drawing in
 *    a grid by placing color blocks in its cells.
 *    Each drawing method should take zero arguments, should
 *    have a void return type, and should have a name that conforms
 *    to the on...ButtonClick format.  (This restriction allows the
 *    GridPlotterGUI to recognize drawing methods, for which
 *    it automatically generates buttons.)
 *    <br> <br>
 *    Modifications: <br>
 *    April 22 2015, Marc Kuniansky, Added several new functions- onReverseRowMajorFillButtonClick,
 *                                   onReverseColumnMajorFillButtonClick, onDiagonalButtonClick,
 *                                   onClearGridButtonClick, onReverseDiagonalButtonClick, onTriangleButtonClick,
 *                                   onSquareButtonClick, and onDrawXButtonClick. Also added
 *                                   the functions needed for onSurpriseButtonClick.
 *   
 *
 *  @author Marc Kuniansky (based on a template provided by Alyce Brady), with assistance from Pam Cutter
 *  @version Version 1, April 21 2015
 **/

public class GridPlotter implements GridChangeListener
{
  //Instance Variables: Encapsulated data for EACH GridPlotter object
    private Grid theGrid = null;
    private GridPlotterGUI display = null;
    private ColorChoiceMenu drawingColorChooser = null;

  //Constructors and initialization

    /** Constructs an object that could draw in a grid.
     *      @param disp    an object that knows how to display a grid
     *      @param colorChooser  a menu for choosing the color block color
     **/
    public GridPlotter(GridPlotterGUI disp,
                       ColorChoiceMenu colorChooser)
    {
        this.display = disp;
        this.drawingColorChooser = colorChooser;
    }

    /** Sets the grid in which to draw.
     **/
    public void reactToNewGrid(Grid grid)
    {
        theGrid = grid;
    }

  //Drawing methods

    /** 
       Removes all objects from the grid.
     **/
    public void onClearGridButtonClick()
    { //Begin clear grid
        //Get the row and column location of each block in the grid
        for(int row=0; row<theGrid.numRows(); row++)
        {
            for(int column=0; column<theGrid.numCols(); column++)
            {
                Location currentLocation = new Location(row, column); //Specify the current location
                theGrid.remove(currentLocation); //Remove the color block at the current location if there is one
            }
        }
        display.showGrid(); //Display the grid after removing all of the objects.
        //Whebn the grid is empty, generate a message and tell the user
        JOptionPane.showMessageDialog(null, "The grid is empty.");
    } //End clear grid

    /** 
       Fills in all the cells of the grid using a row-major traversal.
     **/
    public void onRowMajorFillButtonClick()
    {
        for ( int row = 0; row < theGrid.numRows(); row++ )
        {
            for ( int column = 0; column < theGrid.numCols(); column++ )
            {
                placeColorBlock(row, column);
            }
        }
    }
    
    /**
       Fills in all of the cells on the grid by row starting in the bottom right corner.
     */
    public void onReverseRowMajorFillButtonClick()
    { //Begin reverse fill row
        //Because we want to start in the bottom right corner, we need to start at the
        //macimum row number and column number.
        for(int row=theGrid.numRows()-1; row>=0; row--)
        {
            for(int column=theGrid.numCols()-1; column>=0; column--)
            {
                placeColorBlock(row, column);
            }
        }
    } //End reverse fill row
    
    /** 
       Fills in all the cells of the grid using a column-major traversal.
     **/
    public void onColMajorFillButtonClick()
    { //Begin Major Fill Column
        //This does exactly the same thing as the onRowMajorFillButtonClick() class, except it fills in order of 
        //column instead of by row.
        for(int column=0; column<theGrid.numCols(); column++)
        {
            for(int row=0; row<theGrid.numRows(); row++)
            {
                placeColorBlock(row, column); //Place a color block on each spot in the grid
            }
        }
    } //End Major Fill Column
    
    /** 
       Fills in all the cells of the grid using a column-major traversal.
     **/
    public void onReversColMajorFillButtonClick()
    { //Begin Major Fill Column
        //This does exactly the same thing as the onreverse RowMajorFillButtonClick() class, except it fills in order of 
        //column instead of by row.
        for(int column=theGrid.numCols()-1; column>=0; column--)
        {
            for(int row=theGrid.numRows()-1; row>=0; row--)
            {
                placeColorBlock(row, column); //Place a color block on each spot in the grid
            }
        }
    } //End Major Fill Column
  
    /**
       Creates a diagonal line across the grid starting in the top left corner,
       (0,0). The diagonal line will always start there, regardless of the size
       of the grid. 
     */
    public void onDiagonalButtonClick()
    { //Begin diagonal
        for(int row=0; row<theGrid.numRows(); row++)
        { //Begin for rows
            for(int column=0; column<theGrid.numCols(); column++)
            { //Begin for columns
                if(row==column)
                    placeColorBlock(row, column); //Place a block in all places where the row and column have the same value (0,0 1,1 2,2 etc)
            } //End for columns
        } //End for rows
    } //End diagonal
    
    /**
       Creates a diagonal line starting at the top right corner. The line is drawn from
       right to left, exactly the opposite of the onDiagonalButtonClick method.
     */
    public void onReverseDiagonalButtonClick()
    { //Begin reverse diagonal
        for(int row=0; row<theGrid.numRows(); row++)
        {
            for(int column=theGrid.numCols()-1; column>=0; column--)
            {
                int numColumns=theGrid.numCols()-1; //I need the location of the last column
                if(numColumns==row+column) //Add the row and column location. If this is equal to the total number of columns I need a square there.
                placeColorBlock(row, column);
            }
        }
    } //End reverse diagonal
   
    /**
       Draws a triangle when the button is clicked. The triangle is only a triangle
       if the grid is a square, otherwise it turns into a weirdly shaped object. This
       is essentially a diagonal line where all of the squares below it are filled in.
     */
    public void onTriangleButtonClick()
    { //Begin triangle
     for(int row=0; row<theGrid.numRows(); row++)
        { //Begin for rows
            for(int column=0; column<theGrid.numCols(); column++)
            { //Begin for columns
                if(row>=column)
                    placeColorBlock(row, column); //Place a block in all places where the row hs a larger or equal value than the column
            } //End for columns
        } //End for rows
    } //End triangle
    
    /**
       This draws two intersecting diagonal lines in opposite directions to form an X
       on the grid.
     */
    public void onDrawXButtonClick()
    { //Begin draw x
        this.onDiagonalButtonClick();
        this.onReverseDiagonalButtonClick();
    } //End draw x
   
    public void onDrawSquareButtonClick()
    { //Begin draw square
        for(int row=theGrid.numRows()-1; row>=0; row--)
        {
            for(int column=theGrid.numCols()-1; column>=0; column--)
            {
                if(row==0||column==0)
                    placeColorBlock(row, column);
                else if(row==theGrid.numRows()-1 || column==theGrid.numCols()-1)
                    placeColorBlock(row, column);
                else
                    {
                        //Do nothing for all other squares
                    }
            }
        }
    } //End draw square
   
    /**
       This method draws a cake. When drawing a cake it is best to use a square grid,
       or it looks really weird. But its your cake.
       
       Use in conjunction with "candles" and "lies"
     */
    public void onCakeButtonClick()
    { //Begin draw cake
        for(int row=0; row<theGrid.numRows(); row++)
        {
            for(int column=0; column<theGrid.numCols(); column++)
            {
                if(row>=2*(theGrid.numRows()/3))
                    placeColorBlock(row, column);
            }
        }
    } //End draw cake
    
    /**
       This works best in conjunction with the onCakeButtonClick() function. Best used
       on a square grid. It draws candles for the cake. I also recommend changing the
       color of the candles for the best looking results.
     */
    public void onCandlesButtonClick()
    { //Begin draw candles
       for(int row=0; row<theGrid.numRows(); row++)
       {
            int counter=0; //I only want 3 candles in specific places, so I need a counter
            for(int column=0; column<theGrid.numCols(); column++)
            {
                counter++;
                int theColumn= theGrid.numCols()-1;
                if(row<=2*(theGrid.numRows()/3)&& row>=(theGrid.numRows()/3)) //Candles only sit in the middle third of the grid
                {    
                    if(counter==(theColumn/3) || counter==2*(theColumn/3) || counter==3*(theColumn/3))
                        placeColorBlock(row, column);
                }
            }
       } 
    } //End draw candles
    
    /**
       This draws a box around the grid and draws an x through the middle of it. 
       It's supposed to sort of be like on of those "no ____" signs here, except
       with a full x instead of a slash. All of this needs to be a different color,
       so I made a modified placeColorBlock method to compensate for this and modified
       the code for the drawX and drawSquare functions within this method.
     */
    public void onLieButtonClick()
    { //Begin Lies
        Color color = new Color (255, 255, 0); //First make a color. The default is yellow.
        if(color==drawingColorChooser.currentColor()) //If the color is equal to the user defined color for other blocks, change the color to red.
            color=new Color(255, 0, 0);
        //Next, draw the X
        for(int row=0; row<theGrid.numRows(); row++)
        { //Begin for rows
            for(int column=0; column<theGrid.numCols(); column++)
            { //Begin for columns
                if(row==column)
                    placeSpecifiedColorBlock(row, column, color); //Place a block in all places where the row and column have the same value (0,0 1,1 2,2 etc)
            } //End for columns
        } //End for rows
        for(int row=0; row<theGrid.numRows(); row++)
        {
            for(int column=theGrid.numCols()-1; column>=0; column--)
            {
                int numColumns=theGrid.numCols()-1; //I need the location of the last column
                if(numColumns==row+column) //Add the row and column location. If this is equal to the total number of columns I need a square there.
                placeSpecifiedColorBlock(row, column, color);
            }
        }
        //Finally, draw the Square
        for(int row=theGrid.numRows()-1; row>=0; row--)
        {
            for(int column=theGrid.numCols()-1; column>=0; column--)
            {
                if(row==0||column==0)
                    placeSpecifiedColorBlock(row, column, color);
                else if(row==theGrid.numRows()-1 || column==theGrid.numCols()-1)
                    placeSpecifiedColorBlock(row, column, color);
                else
                    {
                        //Do nothing for all other squares
                    }
            }
        }
    } //End Lies
    
    /**
       This draws a cake and candles, waitd 4 seconds, then shows it's true meaning.
       
       This was made to simplify things; I felt that there were too many buttons.
     */
    public void onSurpriseButtonClick()
    { //Begin Surprise
            onCakeButtonClick();
            onCandlesButtonClick();
        try 
        {   
            Thread.sleep(4000); //This was way harder to do than it should have been.
        }
        catch (Exception e)
        {
            //do nothing?
        }
            onLieButtonClick();
        } //End Surprise
   
    //Helper methods that are called by other methods
    
    /** Ensures that the specified location is empty by removing the object
     *  there, if there is one.
     *      @param row      row number of location that should be empty
     *      @param column   column number of location that should be empty
     **/
    private void ensureEmpty(int row, int column)
    {
        // If the specified location in the grid is not empty,
        // remove whatever object is there.
        Location loc = new Location(row, column);
        if ( ! theGrid.isEmpty(loc) )
            theGrid.remove(theGrid.objectAt(loc));
    }
    
    /** Puts a color block in the specified location and redisplays the grid.
     *      @param row      row in which to place the new color block
     *      @param column   column in which to place the new color block
     **/
    private void placeColorBlock(int row, int column)
    {
        // First remove any color block that happens to be at this location.
        ensureEmpty(row, column);

        // Determine the color to use for this color block.
        Color color = drawingColorChooser.currentColor();

        // Construct the color block and add it to the grid at the
        // specificed location.  Then display the grid.
        Location loc = new Location(row, column);
        theGrid.add(new ColorBlock(color), loc);
        display.showLocation(loc);
    }
    
    /** Puts a color block in the specified location and redisplays the grid.
     *      @param row      row in which to place the new color block
     *      @param column   column in which to place the new color block
     **/
    private void placeSpecifiedColorBlock(int row, int column, Color userColor)
    {
        // First remove any color block that happens to be at this location.
        ensureEmpty(row, column);

        // Determine the color to use for this color block.
        Color color = userColor;

        // Construct the color block and add it to the grid at the
        // specificed location.  Then display the grid.
        Location loc = new Location(row, column);
        theGrid.add(new ColorBlock(color), loc);
        display.showLocation(loc);
    }
    
}
