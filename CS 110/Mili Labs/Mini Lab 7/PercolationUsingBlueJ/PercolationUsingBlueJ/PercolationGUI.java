// Class PercolationGUI
//
// Author: Alyce Brady
//
// This class is based on the College Board's MBSGUIFrame class,
// as allowed by the GNU General Public License.  MBSGUIFrame
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

import java.util.Random;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import edu.kzoo.grid.BoundedGrid;
import edu.kzoo.grid.Grid;
import edu.kzoo.grid.GridObject;
import edu.kzoo.grid.Location;
import edu.kzoo.grid.gui.ControlButton;
import edu.kzoo.grid.gui.EnabledDisabledStates;
import edu.kzoo.grid.gui.GridDataFileHandler;
import edu.kzoo.grid.gui.SteppedGridAppController;
import edu.kzoo.grid.gui.SteppedGridAppFrame;
import edu.kzoo.grid.gui.nuggets.BasicGridFileMenu;
import edu.kzoo.grid.gui.nuggets.BGColorChoiceMenu;
import edu.kzoo.grid.gui.nuggets.ColorChoiceMenu;

/**
 *  Percolation Program:<br>
 *
 *  An <code>PercolationGUI</code> is a window containing the graphical
 *  display of a grid with a slider, and a menu that allows the
 *  user to create or read in new grids representing a porous material.
 *
 *  @author Alyce Brady
 *  @version 8 February 2009
 **/
public class PercolationGUI extends SteppedGridAppFrame
{
    private static final boolean REDISPLAY = true;
    private static final String densityClarification =
            "Density percentage must be a valid integer between 0 and 100:";

    private PercolationFileMenuActionHandler menuActionHandler;

    // Keep track of background color chooser menu for redefined
    // constructWindowContents method.
    private ColorChoiceMenu bgColorChooser;

    // Other instance variables.
    private Class[] controllers;
    private Class[] percolationTypes;
    private int density = 30;   // Provide 30 as initial suggestion
    private int numRuns = 100;
    private JComboBox controllerComboBox;
    private JComboBox percTypeComboBox;
//     private Timer runNTimesTimer;

    /** Instantiates a new controller. */
    private static PercolationController newController(Class controllerClass)
    {
        return (PercolationController)newObject(controllerClass, "controller");
    }

    /** Instantiates a new object. */
    private static Object newObject(Class c, String type)
    {
        String exceptionMsg = "Could not instantiate " + type;
        try { return c.newInstance(); }
        catch (Exception e) { throw new RuntimeException(exceptionMsg); }
    }

  // constructors and initialization methods

    /** Creates a window in which to run an obstacle race.
     *    @param controllers  non-empty array of controller classes that
     *                        should be made available to the user
     *    @param percTypes    non-empty array of percolation type classes that
     *                        should be made available to the user
     */
    public PercolationGUI(Class[] controllers, Class[] percTypes)
    {
        // This is an active grid frame with Step, N Steps,
        // Run and Stop buttons, but not a Restart button.
        super(newController(controllers[0]), REDISPLAY);
        this.controllers = controllers;
        this.percolationTypes = percTypes;
        PercolationController controller = (PercolationController)getController();

        GridDataFileHandler fileHandler = new PercolationDataFileHandler();
        menuActionHandler = new PercolationFileMenuActionHandler(this,
                                                                fileHandler);
        includeMenu(new BasicGridFileMenu(this, menuActionHandler,
                                          fileHandler));

        controllerComboBox = makeClassChoiceComponent(controllers, "Use ");
        controllerComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
                { chooseControllerType(); }});
        includeControlComponent(controllerComboBox,
                        EnabledDisabledStates.NEEDS_APP_WAITING);

        includeControlComponent(new JLabel(""),
                        EnabledDisabledStates.ALWAYS_DISABLED);

        includeControlComponent(
              new ControlButton(this, "New Grid", REDISPLAY)
                  { public void act() 
                    {   menuActionHandler.createNewGrid();
                    }},
              EnabledDisabledStates.NEEDS_APP_WAITING);

        includeControlComponent(
              new ControlButton(this, "Manually Populate Grid", REDISPLAY)
                  { public void act() { invokeEditor(); }},
              EnabledDisabledStates.NEEDS_GRID_AND_APP_WAITING);

        includeControlComponent(
              new ControlButton(this, "Automatically Populate Grid", REDISPLAY)
                  { public void act() { randomlyFillGrid(); }},
              EnabledDisabledStates.NEEDS_GRID_AND_APP_WAITING);

        if ( percolationTypes.length != 0 )
        {
            percTypeComboBox = makeClassChoiceComponent(percolationTypes, "Using ");
            includeControlComponent(percTypeComboBox,
                            EnabledDisabledStates.NEEDS_GRID_AND_APP_WAITING);
        }

        includeControlComponent(new JLabel(""),
                        EnabledDisabledStates.ALWAYS_DISABLED);

                        includeStepOnceButton();
        includeStepNTimesButton();
        includeRunButton();
        includeStopButton(REDISPLAY);

        // Include a Run Density Experiments button.
        if ( percolationTypes.length != 0 )
        {
            JButton nRunsButton = 
                new ControlButton(this, "Run N Times", false)
                    {  public void act() { nRuns(); } };
            includeControlComponent(nRunsButton,
                                EnabledDisabledStates.NEEDS_GRID_AND_APP_WAITING);

            JButton densityExperimentsButton = 
                new ControlButton(this, "Run Density Experiments", false)
//                     {  public void act() { runDensityExperiments(); } };
                    {  public void act() { runCustomizedDensityExperiments(); } };
            includeControlComponent(densityExperimentsButton,
                                EnabledDisabledStates.NEEDS_GRID_AND_APP_WAITING);

//             // Define timer used by run-multiple-times buttons.
//             runNTimesTimer = new Timer(0,
//                               new ActionListener()
//                               {   public void actionPerformed(ActionEvent evt)
//                                   {   runNTimes();   }
//                               });
        }

        includeSpeedSlider();
    }


  // redefined methods from GridAppFrame

    /* Inherit description from GridAppFrame. */
    public void constructWindowContents(String title,
                                        int viewingWidth, int viewingHeight,
                                        int minCellSize)
    { 
        constructWindowContents(title, bgColorChooser.currentColor(),
                                viewingWidth, viewingHeight,
                                minCellSize);

        // Tool tips should show object info, not just location.
        getDisplay().makeToolTipsReportObject();
    }

    /** Makes the controller type choice combo box.
     **/
    protected JComboBox makeClassChoiceComponent(Class[] classList, String prefix)
    {
        JComboBox comboBox = new JComboBox();
        for ( Class c : classList )
            comboBox.addItem(new ClassChoice(c, prefix));
        comboBox.setAlignmentX(LEFT_ALIGNMENT);
        return comboBox;
    }

    /** Nested class used to hold the per-item information for the 
     *  entries in the combo box of controller or percolation type choices.
     *  Each item represents a choice which is a Controller or percolator class.
     */
    protected class ClassChoice extends JLabel
    {
        private Class cls;
        private String prefix;
      
        public ClassChoice(Class c, String prefix)
            { super(c.getName());
              cls = c;
              this.prefix = prefix;
            }

        public Class getAssocClass() { return cls; }
        public String toString() { return prefix + cls.getName(); }
    }

    /** Follows up when the user picks a new choice from the
     *  grid object combo box (specified listener action).
     **/
    protected void chooseControllerType()
    {
        PercolationController controller = newController(currentControllerClass());
        controller.setGrid(getGrid());
        setController(controller);
    }

    /** Returns the currently selected controller class.
     **/
    protected Class currentControllerClass()
    {
        return ((ClassChoice)controllerComboBox.getSelectedItem()).getAssocClass();
    }

    /** Sets the controller being used to control the application.
     *  (Precondition: controller is not null.)
     *    @param controller the new PercolationController to use
     **/
    public void setController(PercolationController controller)
    {
        appController = controller;
        PercolationController.setController(controller);
    }

    /** Returns the currently selected percolating type.
     **/
    protected Class getCurrentPercType()
    {
        if ( percolationTypes.length == 0 )
            return null;
        return ((ClassChoice)percTypeComboBox.getSelectedItem()).getAssocClass();
    }

    /** Sets the Grid being displayed.
     *  (Precondition: grid is not null.)
     *    @param grid the Grid to display
     **/
    public void setGrid(Grid grid)
    {
        super.setGrid(grid);
        showGrid();
    }


  // methods that implement button actions

    /** Invokes the percolation editor for placing solid cells and percolating
     *  material.
     */
    protected void invokeEditor()
    {
        new PercolationMaterialEditor(this);
    }

    /** Populates the grid with random solid cells based on a
     *    porousness/density factor.
     */
    protected void randomlyFillGrid()
    {
        PercolationController controller = (PercolationController)getController();

        // Fill the grid at the appropriate density/porousness level.
        density = promptUserForDensity();
        if ( density > Integer.MIN_VALUE )
        {
            controller.randomlyFillGrid(density, getCurrentPercType());
        }

    }

    /** Runs a dialog asking the user to input a density percentage
     *  for the material through which to percolate. If successful,
     *  updates density and returns it, else returns a negative number.
     **/
    private int promptUserForDensity() 
    {
        int suggested = (0 <= density && density <= 100) ? density : 30;
        return promptUserForValueInRange(
                   "Enter density (percentage of material to fill):",
                   densityClarification, 0, 100, suggested);
    }

    /** Runs a dialog asking the user to input a desired integer value
     *  in a given range.  (Precondition: minValue must be greater than
     *  <code>Integer.MIN_VALUE</code>.)
     *    @param prompt          the prompt for the desired value
     *    @param clarification   a string that describes a valid value
     *    @param minValue        the minimum valid value
     *    @param maxValue        the maximum valid value (not checked if
     *                              maxValue if less than or equal to minValue)
     *    @param suggestedValue  a suggested valid value that will serve as a default
     *    @return    the user-provided value if a valid value is provided;
     *               <code>Integer.MIN_VALUE</code> otherwise
     **/
    private int promptUserForValueInRange(String prompt, String clarification,
                                     int minValue, int maxValue, int suggestedValue) 
    {
        int value;
        String response = (String)JOptionPane.showInputDialog(this, prompt,
                                "Input", JOptionPane.QUESTION_MESSAGE, null, null,
                                "" + suggestedValue);

        while (response != null)
            try
            {
                int userEntered = Integer.parseInt(response.trim());
                if ( userEntered < minValue || 
                      (maxValue > minValue && userEntered > maxValue) )
                    throw new NumberFormatException();
                value = userEntered;
                return value;
            } 
            catch (NumberFormatException ex)
            {   response = (String)JOptionPane.showInputDialog(this, prompt,
                                "Input", JOptionPane.QUESTION_MESSAGE, null, null,
                                "" + suggestedValue);
            }
            catch (Exception ex)
            {   Toolkit.getDefaultToolkit().beep();   }
        return Integer.MIN_VALUE;
    }

    /** Run percolation simulation N times with the current density. */
    public void nRuns()
    {
        // Determine how many times to run the simulation.
        numRuns = promptUserForRunCount("Enter number of times to run the simulation:");
        if ( numRuns == Integer.MIN_VALUE )
            return;

        // Save current state information.
        boolean savedDisplayInfo = displayAfterEachStep;
        showDisplayAfterEachStep(false);

        PercolationController controller = (PercolationController)getController();
        controller.runNTimes(numRuns, density, getCurrentPercType());

        showDisplayAfterEachStep(savedDisplayInfo);
    }

    /** Runs a dialog asking the user to input a density percentage
     *  for the material through which to percolate. If successful,
     *  updates density and returns it, else returns a negative number.
     *    @param prompt  the prompt to use
     **/
    private int promptUserForRunCount(String prompt) 
    {
        int suggested = numRuns > 0 ? numRuns : 100;
        return promptUserForValueInRange(prompt,
                   "Number of run times must be a valid, positive integer:",
                   1, 0, suggested);
    }

    /** Run density experiments. */
    public void runDensityExperiments()
    {
        // Save current state information.
        boolean savedDisplayInfo = displayAfterEachStep;
        showDisplayAfterEachStep(false);

        PercolationController controller = (PercolationController)getController();
        controller.runExperiments(getCurrentPercType());

        showDisplayAfterEachStep(savedDisplayInfo);
    }

    /** Run density experiments. */
    public void runCustomizedDensityExperiments()
    {
        int minDensity = promptUserForValueInRange(
                            "Enter the lowest density to test:",
                            densityClarification, 0, 99, 5);
        if ( minDensity == Integer.MIN_VALUE )
            return;
        int maxDensity = promptUserForValueInRange(
                            "Enter the highest density to test:",
                            densityClarification, 1, 100, 100);
        if ( maxDensity == Integer.MIN_VALUE )
            return;
        int increment = promptUserForValueInRange(
                            "Enter the density increment from test to test:",
                            densityClarification, 1, 100, 5);
        if ( increment == Integer.MIN_VALUE )
            return;
        numRuns = promptUserForRunCount(
            "Enter number of times to run the simulation at each density level:");
        if ( numRuns == Integer.MIN_VALUE )
            return;

        // Save current state information.
        boolean savedDisplayInfo = displayAfterEachStep;
        showDisplayAfterEachStep(false);

        PercolationController controller = (PercolationController)getController();
        controller.runExperiments(numRuns, minDensity, maxDensity, increment,
                                  getCurrentPercType());

        showDisplayAfterEachStep(savedDisplayInfo);
    }

//     /** Runs the application N times (currently 1000, maybe in future where N is provided
//      *  by the user in a dialog box) in a separate thread.  It may stop
//      *  before the N steps have completed if the user clicks on the stop
//      *  button (if one is provided) or if the application controller
//      *  indicates that the application has reached a stopping state.
//      **/
//     public void nRuns()
//     {
//         // Save current state information.
//         savedDisplayInfo = displayAfterEachStep;
//         PercolationController controller = (PercolationController)getController();
// 
//         initStatsDisplay();
//         showDisplayAfterEachStep(false);
// 
//         controller.initDensity();
//         runningNSteps = false;
//         enterRunningMode();
//         runNTimesTimer.start();
//     }
// 
//     /** Runs the percolation simulation many times for a given density, then
//      *  changes the density level to prepare for the next set of runs.
//      */
//      public void runNTimes()
//      {
//         PercolationController controller = (PercolationController)getController();
//         
//         controller.randomlyFillGrid(density, getCurrentPercType());
//         controller.fillTopRow(getCurrentPercType());
//         controller.runExperiments(numRuns, density, promptUserForDensity(), 1, getCurrentPercType());
//         controller.runNTimes(getCurrentPercType());
//         displayStats();
//         controller.incrementDensity();
// 
//         if ( ! controller.moreDensitiesToTest() )
//             stopMultRuns();
//     }
// 
//     /** Stops the timer currently stepping the density experiments.
//      **/
//     public void stopMultRuns()
//     {
//         runNTimesTimer.stop();
// 
//         showDisplayAfterEachStep(savedDisplayInfo);
//         enterNotRunningMode();
//     }

    // Following methods have been replaced by similar functionality in controller.

//     /** Display column headings for stats display using <code>displayStats</code>. */
//     protected void initStatsDisplay()
//     {
//         System.out.println("Grid dimensions, density, # runs, " +
//                            "# times percolated, # times permeated");
//     }
// 
//     /** Display statistics for a set of runs at a particular density. */
//     protected void displayStats()
//     {
//         Grid g = getGrid();
//         PercolationController controller = (PercolationController)getController();
//         System.out.println(g.numRows() + ", " + g.numCols() + ", " + 
//                            controller.latestDensity() + ", " +
//                            controller.latestNumRuns() + ", " +
//                            controller.latestNumTimesPercolated() + ", " +
//                            controller.latestNumTimesPermeated());
//     }
}
