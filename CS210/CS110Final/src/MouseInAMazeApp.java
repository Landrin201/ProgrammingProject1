// Class: MouseInAMazeApp
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

import edu.kzoo.grid.display.ColorBlockDisplay;
import edu.kzoo.grid.display.DisplayMap;

/**
 *  Mouse in a Maze Program:<br>
 *    The MouseInAMazeApp class constructs a graphical user interface
 *    for a mouse-in-a-maze program.  Once the graphical user interface
 *    has been constructed, all program control originates from there.
 *
 *  @author Marc Kuniansky, Roderick Vogel, with assistance from Alyce Brady and Pamela Cutter
 *  @version 9 June 2015
 **/
public class MouseInAMazeApp
{
    /** Start the Mouse in a Maze program.
     *  The String arguments (args) are not used in this application.
     **/
    public static void main(String[] args)
    {
        // Specify classes that know how to draw various objects in a maze;
        // in other words, map grid object classes (like Mouse, Cheese) to
        // display objects (like ColorBlockDisplay objects).
        DisplayMap.associate("edu.kzoo.grid.ColorBlock",
                             new ColorBlockDisplay());

        // Specify the types of mouse supported by the program.
        ArrayList mouseTypes = new ArrayList();
        //Add the different mice to the array list
        mouseTypes.add(ShortSightedMouse.class);
        mouseTypes.add(TeleportingMouse.class);
        mouseTypes.add(LSMouse.class);
        mouseTypes.add(CluelessMouse.class);

        // Construct the mouse-in-a-maze frame.
        MouseMazeGUI gui = new MouseMazeGUI(mouseTypes);
        
        
    }

}
