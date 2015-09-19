// Class: HistogramApp
//
// Author:  Marc Kuniansky
//
// Created on 8 January, 2009
// Modifications:
//    Date        Name            Reason
//    ----        ----            ------
//    8 Jan 2009  Kelly & Alyce  Created original version
//    14 April 2015  Marc Kuniansky   Modified to flip a coin, change the location of an
//                                    object based on the result of the flip, and to count
//                                    the number of times the object is in a certain 
//                                    position. Then, produce a histogram in a grid
//                                    to show how many times the object landed in each
//                                    position.   
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
   Histogram Project:<br>
 
  The HistogramLab class flips a goin, then changes the location of an object based on the
  result of the coin flip. It counts the number of times the object is in a certain position,
  and produces to show how many times the object lands in each possible position.
  <br> <br>
  Created: <br>
    4 Jan 2003,  Alyce Brady
    <br> <br>
  Modifications: <br>
    1 Jan 2004,  Kelly Schultz, Changed to use DisplayableTable<br>
    9 Apr 2009,  Kelly Schultz, changed to use SimpleGrid<br>
    14 April 2015, Marc Kuniansky, Modified to flip a coin, change the location of an
                                    object based on the result of the flip, and to count
                                    the number of times the object is in a certain 
                                    position. Then, produce a histogram in a grid
                                    to show how many times the object landed in each
                                    position.
    <br> <br>
  
  @author Marc Kuniansky, with assistance from Alyce Brady
  @version Version 1, 14 April 2015
 */
public class HistogramLab
{
    // Specify how many times to run the experiment whose results
    // will be plotted in the histogram.
    private static final int NUM_ITERATIONS = 2000;

    /**
       Start the Histogram program.
       The String arguments (args) are not used in this application.
     **/
    public static void main(String[] args)
    {
        System.out.println("This will be a program that draws a histogram.");
        //Create and flip a coin. Also, get the result of the flip (heads or tails)
        Coin theCoin = new Coin(); //Create the coin to be used
        //Initialize variables in which to store the count for the number of times the object is in a certain position
        int minusSixCount = 0;
        int minusFourCount = 0;
        int minusTwoCount = 0;
        int zeroCount = 0;
        int twoCount = 0;
        int fourCount = 0;
        int sixCount = 0;
        
        
        //Flip the coin, and
        //get whether the coin is heads or tails
        for(int i=0; i<NUM_ITERATIONS; i++)
        {
            int location = 0;
            for(int j=0; j<6; j++)
                {
                    theCoin.toss();
                    if(theCoin.tails()==true)
                    { //Begin for flip is tails
                        //System.out.println("Tails"); //Print "Tails" if tails
                        location--; //Subtract one from location if the coin lands on tails
                    } //End for flip is tails
                    else //if(theCoin.heads()==true)
                    { //Begin for flip is heads
                        //System.out.println("Heads"); //Print "Heads" if heads
                        location++; //Add one to location if the coin lands on heads
                    } //Begin for flip is tails
                }
            //Change the values of the counters depending on the location of the object
            if(location==-6)
                minusSixCount++;
            else if(location==-4)
                minusFourCount++;
            else if(location==-2)
                minusTwoCount++;
            else if(location==0)
                zeroCount++;
            else if(location==2)
                twoCount++;
            else if(location==4)
                fourCount++;
            else
                sixCount++;  
        }
         
        //Print the number of times the coin landed in each possible position
        System.out.println("-6 Count = " + minusSixCount);
        System.out.println("-4 Count = " + minusFourCount);
        System.out.println("-2 Count = " + minusTwoCount);
        System.out.println("0 Count = " + zeroCount);
        System.out.println("2 Count = " + twoCount);
        System.out.println("4 Count = " + fourCount);
        System.out.println("6 Count = " + sixCount);
        
        
         // Create and initialize the grid.
         SimpleGrid grid = new SimpleGrid(8, NUM_ITERATIONS);
 
         // Create graphical user interface capable of displaying
         // the grid.
         SimpleGridObjectGUI display = new SimpleGridObjectGUI(grid,
                                             "Marc Kuniansky", "Kelly Schultz",
                                             "14 April 2015");


         // Place a label on each row
         TextCell firstLabel = new TextCell("-6");
         grid.add(firstLabel, 0, 2);
         
         TextCell secondLabel = new TextCell("-4");
         grid.add(secondLabel, 1, 2);
         
         TextCell thirdLabel = new TextCell("-2");
         grid.add(thirdLabel, 2, 2);
         
         TextCell fourthLabel = new TextCell("0");
         grid.add(fourthLabel, 3, 2);
         
         TextCell fifthLabel = new TextCell("2");
         grid.add(fifthLabel, 4, 2);
         
         TextCell sixthLabel = new TextCell("4");
         grid.add(sixthLabel, 5, 2);
         
         TextCell seventhLabel = new TextCell("6");
         grid.add(seventhLabel, 6, 2);
 
        //Place one block per column for each number in the count for all of the counts
        for(int q=0; q<=minusSixCount; q++)
            {
                // Create a color block to place in the grid
                ColorBlock redBlock = new ColorBlock(Color.RED);
                grid.add(redBlock, 0, q+4);
            }
        for(int q=0; q<=minusFourCount; q++)
            {
                // Create a color block to place in the grid
                ColorBlock redBlock = new ColorBlock(Color.RED);
                grid.add(redBlock, 1, q+4);
            }
        for(int q=0; q<=minusTwoCount; q++)
            {
                // Create a color block to place in the grid
                ColorBlock redBlock = new ColorBlock(Color.RED);
                grid.add(redBlock, 2, q+4);
            }
        for(int q=0; q<=zeroCount; q++)
            {
                // Create a color block to place in the grid
                ColorBlock redBlock = new ColorBlock(Color.RED);
                grid.add(redBlock, 3, q+4);
            }
        for(int q=0; q<=twoCount; q++)
            {
                // Create a color block to place in the grid
                ColorBlock redBlock = new ColorBlock(Color.RED);
                grid.add(redBlock, 4, q+4);
            }
        for(int q=0; q<=fourCount; q++)
            {
                // Create a color block to place in the grid
                ColorBlock redBlock = new ColorBlock(Color.RED);
                grid.add(redBlock, 5, q+4);
            }
        for(int q=0; q<=sixCount; q++)
            {
                // Create a color block to place in the grid
                ColorBlock redBlock = new ColorBlock(Color.RED);
                grid.add(redBlock, 6, q+4);
            }
        
         //Display the grid when done
         display.showGrid();

        System.out.println("Done.");
    }

}
