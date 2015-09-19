import java.util.ArrayList;

import edu.kzoo.grid.Grid;
import edu.kzoo.grid.GridObject;
import edu.kzoo.grid.Location;

/**
 *  A <code>ListPercolationController</code> controls the running of a
 *  percolation application by listing the objects representing percolating
 *  material and then telling each of them to percolate.  As they do so, they
 *  create a new list of the next objects to percolate in the next step.
 * 
 * @author Alyce Brady 
 * @version 23 April 2009
 */
public class ListPercolationController extends PercolationController
{
    ArrayList<GridObject> processThisStep;
    ArrayList<GridObject> processNextStep;

    /** Constructs a ListPercolationController object. */
    public ListPercolationController()
    {
        //CONSTRUCTOR NEEDS TO BE COMPLETED
    }

    /** Re-initializes anything that is necessary when the grid changes
     *  (called by <code>setGrid</code> and <code>randomlyFillGrid</code>).
     */
    protected void adjustToNewGrid()
    {
        //THIS WILL CALLED WHEN THE GRID IS CHANGED BY THE USER 
        //OR BY THE START OF A NEW SIMULATION
        
        //NEED TO ADD CODE HERE TO CLEAR OUT THE LISTS OF MATERIAL
        //THAT WERE BEING PROCESSED.  THEY MAY NO LONGER MATCH 
        //TRUE CONTENTS OF THE GRID.
    }


    /** Advances the application one step. 
     **/
    public void step()
    {
        // Note that a new step is beginning, controlled by this controller.
        setController(this);    // inherited method

        System.out.println("Step method not yet implemented for ListPercolationController");
   
        //STEP METHOD NEEDS TO BE COMPLETED...
        
        // IF THIS IS THE BEGINNING OF THE PROCESS, 
        //     PUT ALL OF THE ITEMS IN THE GRID INTO THE LIST OF ITEMS 
        //     TO BE PROCESSED IN THIS STEP ("processThisStep")
 
        // OTHERWISE, THE LIST OF ITEMS TO BE PROCESSED IN THIS STEP
        //     COMES FROM THE "processNextStep" LIST THAT WAS SET UP DURING THE 
        //     PREVIOUS STEP.
    
        
        // CREATE A NEW EMPTY LIST OF ITEMS TO BE PROCESSED IN THE NEXT STEP.
     

        // PROCESS ALL OF THE ITEMS IN "processThisStep"
        // AS A RESULT "processNextStep" should be populated.
        
      
    }

    /** Takes note of the fact that the material has percolated,
     *  creating the given new percolation material object.
     */
    public void notePercolationTo(GridObject newObj)
    {
        // ADD THE NEW MATERIAL TO THE LIST OF ITEMS TO BE PROCESSED 
        // IN THE NEXT STEP
    }

    /** Determines whether a running application has reached a desired
     *  stopping state.  In this case, stop if there are no percolation
     *  material objects needing to percolate in next step.
     *    @return <code>true</code> if the application should
     *             stop 
     **/
    public boolean hasReachedStoppingState()
    { 
        //THIS NEEDS TO BE MODIFIED TO RETURN TRUE ONLY WHEN THERE 
        //IS NO MORE MATERIAL TO PROCESS
        return true;
    }
}
