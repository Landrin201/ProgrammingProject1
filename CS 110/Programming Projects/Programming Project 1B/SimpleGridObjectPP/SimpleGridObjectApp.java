// Class: SimpleGridObjectApp
//
// Author:  Marc Kuniansky
//
// Created on 8 January, 2009
// Modifications:
//    Date        Name            Reason
//    ----        ----            ------
//    8 Jan 2009  Kelly & Alyce  Created original version
//    4 Apr 2015  Marc Kuniansky     Added several new objects to the grid.
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

import edu.kzoo.grid.Location;
import edu.kzoo.grid.ColorBlock;
import edu.kzoo.grid.PictureBlock;
import edu.kzoo.grid.TextCell;

/**
 *  Simple Grid Object Programming Project:<br>
 *
 *  A SimpleGridObjectApp object represents an application with a simple
 *  grid in one may put basic grid objects, such as TextCell, ColorBlock,
 *  or PictureBlock objects.
 *  
 *  The main method will first construct a grid 6 blocks wide and 5 high. 
 *  It will then add several things to specific blocks in the grid and will
 *  display the grid. 3 Pictures will be displayed, as will three colored blocks
 *  and the word "BINGO" in big letters across the top of the grid.
 *
 *  @author Marc Kuniansky
 *  @version 4 April 215
 */
public class SimpleGridObjectApp
{

    /** The main method represents the starting point of the application.
     *    @param args   (unused)
     */
    public static void main(String[] args)
    {
        // Create and initialize the grid.
        SimpleGrid grid = new SimpleGrid(6, 5);

        // Create graphical user interface capable of displaying
        // the grid.
        SimpleGridObjectGUI display = new SimpleGridObjectGUI(grid,
                                            "John Doe", "Alyce Brady",
                                            "9 January 2009");


        // Place several PictureBlock objects in the grid.
        PictureBlock firstPictureBlock = new PictureBlock("images/Cactus.jpg",
                                                          "This cactus is green.");
        grid.add(firstPictureBlock, 2, 0);
        display.showGrid();

        PictureBlock secondPictureBlock = new PictureBlock("images/Skier.jpg",
                                                           "This skiier appears to be floating.");
        grid.add(secondPictureBlock, 5, 4);
        display.showGrid();
        
        PictureBlock thirdPictureBlock = new PictureBlock("images/Balloon.jpg", "This is a hot-air balloon.");
        grid.add(thirdPictureBlock, 4, 3);
        display.showGrid();
        
        //Make text cells that spell out the word "Bingo"
        TextCell bingoB = new TextCell("B", Color.WHITE);
        TextCell bingoI = new TextCell("I", Color.WHITE);
        TextCell bingoN = new TextCell("N", Color.WHITE);
        TextCell bingoG = new TextCell("G", Color.WHITE);
        TextCell bingoO = new TextCell("O", Color.WHITE);
        //Add the text cells to the top row so that the top row spells "Bingo"
        grid.add(bingoB, 0, 0);
        grid.add(bingoI, 0, 1);
        grid.add(bingoN, 0, 2);
        grid.add(bingoG, 0, 3);
        grid.add(bingoO, 0, 4);
        display.showGrid();
        
        //Add a different colored block to the grid
        ColorBlock blockOne = new ColorBlock(Color.RED);
        grid.add(blockOne, 1, 0);
        ColorBlock blockTwo = new ColorBlock(Color.GREEN);
        grid.add(blockTwo, 3, 2);
        ColorBlock blockThree = new ColorBlock(Color.YELLOW);
        grid.add(blockThree, 2, 3);
        display.showGrid();

        System.out.println("Done.");
    }

}
