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
import java.util.ArrayList;
import edu.kzoo.grid.Location;
import edu.kzoo.grid.ColorBlock;
import edu.kzoo.grid.PictureBlock;
import edu.kzoo.grid.TextCell;

/**
   Histogram Project:<br>
 
  The HistogramLab class flips a coin, then changes the location of an object based on the
  result of the coin flip. It counts the number of times the object is in a certain position,
  produces a histogrm to show how many times the object lands in each possible position.
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
                                    position. </br>
    19 April 2015, Marc Kuniansky, Modified to simplify code by adding an array list 
                                   to store the number of times the object lands in 
                                   each location. Further simplified code by manipulating
                                   this array list. Also added code to allow the user
                                   to specify the number of iterations.
    <br> <br>
  
  @author Marc Kuniansky, with assistance from Alyce Brady and Natalie Davenport
  @version Version 1, 14 April 2015
 */
public class HistogramLab
{
    // Specify how many times to run the experiment whose results
    // will be plotted in the histogram.

    /**
       Start the Histogram program.
       The String arguments (args) are not used in this application.
     **/
public static void main(String[] args)
{
    System.out.println("This will be a program that draws a histogram.");
    //Create and flip a coin. Also, get the result of the flip (heads or tails)
    Coin theCoin = new Coin(); //Create the coin to be used
    //Create an array list which will hold the counters and initialize the counters to 0
    ArrayList<Integer> counterList = new ArrayList<Integer>();
    //Add numbers to the array list
    counterList.add(0); //Minus six count
    counterList.add(0); //Minis four count
    counterList.add(0); //Minus two count
    counterList.add(0); //Zero count
    counterList.add(0); //Two count
    counterList.add(0); //Four count
    counterList.add(0); //Six count
        
    //Prompt the user to specify the number of iterations
    int numIterations = ValidatedInputReader.getInteger("Please input the number of times the coin will be flipped.", 
                                                        0, Integer.MAX_VALUE, 2000, "Are you sure?");
    
    //Flip the coin, and get whether the coin is heads or tails. Count how many times it 
    //lands heads or tales over 6 tosses, and use this number to determine its "location."
    for(int i=0; i<numIterations; i++)
    { //Begin for loop for the number of iterations
        int location = 0;
        for(int j=0; j<6; j++)
        { //Begin for loop for tossing the coin
            theCoin.toss(); //Toss the coin
            if(theCoin.tails()==true)
            { //Begin for flip is tails
                location--; //Subtract one from location if the coin lands on tails
            } //End for flip is tails
            else //if(theCoin.heads()==true)
            { //Begin for flip is heads
                location++; //Add one to location if the coin lands on heads
            } //Begin for flip is tails
        } //End the for loop for tossing the coin
        int currentIndex = (location/2)+3; //Find the index of the location in the array list
        counterList.set(currentIndex, (counterList.get(currentIndex)+1)); //Set the value in the array list to reflect the correct number based on the coin flip
    }
    
    //Print how many times each location was incrimented
    for(int i=0; i<7; i++)
    { //Begin for loop for printing the counts
        int location=(i-3)*2;
        System.out.println(location +" Count = "+ counterList.get(i));
    } //End for loop for printing the counts
         
    // Create and initialize the grid.
    SimpleGrid grid = new SimpleGrid(16, numIterations);
 
    // Create graphical user interface capable of displaying
    // the grid.
    SimpleGridObjectGUI display = new SimpleGridObjectGUI(grid,
                            "Marc Kuniansky", "Kelly Schultz",
                                        "14 April 2015");

    // Place a label on each row to tell you which counter the row represents
    for(int i=0; i<7; i++)
    { //Begin loop for labelling rows
        int location= (i-3)*2;
        TextCell label = new TextCell(""+location);
        grid.add(label, i+1, 2);
    } //End loop for labelling rows
 
    //Add a number every tenth column, to help count how maany blocks are in each row
    for(int i=0; i<(numIterations/10); i++)
    { //Begin loop for labelling columns
        TextCell columnNumber = new TextCell(""+i*10);
        grid.add(columnNumber, 0, (i*10)+4);
    } //End loop for labelling columns
 
    //Add blocks to the histogram. Each location must have the same number of blocks as its number of iterations.
    for(int i=0; i<7; i++) //There are 7 possible locations, so I need to loop 7 times
    { //Begin for loop for adding blocks
        int indexNumber=counterList.get(i);
        for(int gridSpot=0; gridSpot<indexNumber; gridSpot++) //Now add blocks for the number of iterations of each location
        { //Begin for loop
            ColorBlock redBlock = new ColorBlock(Color.RED);
            grid.add(redBlock, i+1, gridSpot+4);
        } //End for loop
    } //End for loop for adding blocks
    
    //Display the grid when done
    display.showGrid();
    
    //Tell the user the program is complete.
    System.out.println("Done.");
} //End main
} //End class
