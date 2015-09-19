import edu.kzoo.grid.display.DisplayMap;
import edu.kzoo.grid.display.ScaledImageDisplay;
import edu.kzoo.grid.gui.GridAppFrame;
import edu.kzoo.grid.gui.GridPkgFactory;
import edu.kzoo.grid.gui.nuggets.BasicHelpMenu;

import edu.kzoo.util.Debug;

// Class PercolationApp
//
// Author: Alyce Brady
//
// This class is based on the College Board's MBSGUI class,
// as allowed by the GNU General Public License.  MBSGUI
// is a black-box class within the AP(r) CS Marine Biology Simulation
// case study (see www.collegeboard.com/ap/students/compsci).
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
 *  Percolation Program:<br>
 *
 *  The <code>PercolationApp</code> class provides a main method
 *  for a version of the Percolation program with a graphical
 *  user interface.
 *
 *  @author Alyce Brady
 *  @version 8 February 2009
 *  @see DisplayMap
 *  @see GridPkgFactory
 *  @see PercolationGUI
 *  @see ScaledImageDisplay
 **/
public class PercolationApp
{

    /** Start the Percolation program by creating its graphical user
     *  interface.  The user will control all actions after that point.
     *    @param args  not used in this application
     **/
    public static void main(String[] args)
    {
        // Turn on debugging messages.
         Debug.turnOn();

        // Specify which types of objects can be placed in the grid. 
        // This array is used to provide a choice of object types in the
        // pull-down menu when manually placing objects into the grid.
        String[] editableTypes = {
                                   "VerticalPercolator",
//                                   "GravitationalPercolator",
//                                   "AllDirectionPercolator",
                                  "SolidCell"};
        GridPkgFactory.addGridObjClassNames(editableTypes);

        // Specify which controller(s) can be used to control percolation. 
        // This array is used to provide a choice of object types in a
        // pull-down menu on the main control panel..
        Class[] controllers = {SlowPercolationController.class,
                               ListPercolationController.class};

        // Specify which percolating materials can be used in density
        // experiments. This array is used to provide a choice in a
        // pull-down menu on the main control panel..
        Class[] percTypes = {
//                              VerticalPercolator.class,
//                              GravitationalPercolator.class,
//                              AllDirectionPercolator.class
                            };

        // Specify classes that know how to draw various grid objects;
        // in other words, map grid object classes (like SimpleRacer) to
        // display objects (like RacerDisplay or ScaledImageDisplay objects).
        DisplayMap.associate("SolidCell",
              new ScaledImageDisplay("../images/marb1.gif"));
        DisplayMap.associate("VerticalPercolator",
              new ScaledImageDisplay("../images/arrow.big.down.gif"));
//         DisplayMap.associate("GravitationalPercolator",
//                      new ScaledImageDisplay("../images/Bluehorz.jpg"));
//         DisplayMap.associate("AllDirectionPercolator",
//                      new ScaledImageDisplay("../images/abst.jpg"));

        // Create and show the window containing the graphical user interface.
        GridAppFrame window = new PercolationGUI(controllers, percTypes);

        window.includeMenu(new BasicHelpMenu("Percolation", "Your Name Here",
                                "with assistance from (whom?)",
                                "version date", "file:PercolationHelp.html"));

        window.constructWindowContents("Percolation Simulation", null, 0, 0, 0);
    }
}

