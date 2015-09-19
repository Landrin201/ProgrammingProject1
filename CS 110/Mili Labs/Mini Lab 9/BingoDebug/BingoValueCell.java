import java.awt.Color;

import edu.kzoo.grid.Grid;
import edu.kzoo.grid.GridObject;
import edu.kzoo.grid.Location;

// Class: BingoValueCell
//
// Author:  Alyce Brady
//
// Created on June 6, 2008
// Modifications:
//    Date      Name     Reason
//    ----      ----     ------
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

/**
 *  Bingo Game:<br>
 *
 * A BingoValueCell is a cell containing text (a column heading or the string
 * version of a number that can be played); the color can be changed when
 * the value in the cell is played.
 * 
 * @author Alyce Brady 
 * @version 6 June 2008
 */
public class BingoValueCell extends GridObject
{
    // Instance Variables: Encapsulated data for each Bingo value cell object
    private String theValue;      // the value to go in a cell in the grid
    private Color  theColor;      // the color of the text version of the value

    /**
     * Constructs objects of class BingoValueCell with the given value
     * and the "unmarked value" color (see BingoGUI.getUnmarkedColor()).
     */
    public BingoValueCell(int value)
    {
        this(value, BingoGUI.getUnmarkedColor());
    }

    /**
     * Constructs objects of class BingoValueCell with the given
     * value and text color.
     */
    public BingoValueCell(int value, Color textColor)
    {
        super();
        theValue = formatNumForCard(value);
        theColor = textColor;
    }

    /**
     * Constructs objects of class BingoValueCell with the given
     * value and text color.
     */
    public BingoValueCell(String value, Color textColor)
    {
        super();
        theValue = value;
        theColor = textColor;
    }

    /** Returns a formatted string version of the number
     *          specified as <code>num</code> suitable for placing in
     *          a cell on a bingo card.
     */
    private String formatNumForCard(int num)
    {
        return " " + num + " ";
    }

    /** Returns the value in this cell as a String.
     **/
    public String text()
    {
        return theValue;
    }

    /** Returns the value in this cell as an integer (if it is an integer).
     **/
    public int value()
    {
        return Integer.parseInt(theValue.trim());
    }

    /** Returns <code>true</code> if the text in this cell is equivalent
     *  to the formatted string version of the given <code>value</code>;
     *  returns <code>false</code> otherwise.
     **/
    public boolean textEqualsValue(int value)
    {
        return theValue.equals(formatNumForCard(value));
    }

    /** Gets color of value in this cell.
     **/
    public Color color()
    {
        return theColor;
    }

    /** Marks the value in this cell by changing the color of the value
     *  to the "marked value" color (see BingoGUI.getMarkedColor()).
     */
    public void mark()
    {
        theColor = BingoGUI.getMarkedColor();
    }

    /** Returns <code>true</code> if this cell has been marked;
     *          <code>false</code> otherwise.
     */
    public boolean isMarked()
    {
        return theColor.equals(BingoGUI.getMarkedColor());
    }
}
