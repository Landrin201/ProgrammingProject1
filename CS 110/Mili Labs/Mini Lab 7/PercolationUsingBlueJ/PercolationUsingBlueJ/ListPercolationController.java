import java.util.ArrayList;

import edu.kzoo.grid.Grid;
import edu.kzoo.grid.GridObject;
import edu.kzoo.grid.Location;

/**
 *  A <code>ListPercolationController</code> controls the running of a
 *  percolation application by listing the objects representing percolating
 *  material and then telling each of them to percolate.  As they do so, they
 *  create a new list of the next objects to percolate in the next step.
 * <br> <br>
 * Modifications: <br>
 * May 17 2015, Marc Kuniansky, Modified to impliment the code outlined by the skeleton.
 * <br> <br>
 * @author Marc Kuniansky
 * @version May 17 2015
 */
public class ListPercolationController extends PercolationController
{
    private ArrayList<GridObject> processThisStep;
    private ArrayList<GridObject> processNextStep;
    //private boolean stepIncludedSomePercolation;
    /** 
     * Constructs a ListPercolationController object. 
     */
    public ListPercolationController()
    {
        // Initialize the instance variables
        processThisStep = new ArrayList<GridObject>();
        processNextStep = new ArrayList<GridObject>();
        //stepIncludedSomePercolation = false;
    }

    /** 
     * Re-initializes anything that is necessary when the grid changes
     *  (called by <code>setGrid</code> and <code>randomlyFillGrid</code>).
     */
    protected void adjustToNewGrid()
    {
        //THIS WILL CALLED WHEN THE GRID IS CHANGED BY THE USER 
        //OR BY THE START OF A NEW SIMULATION
        
        //NEED TO ADD CODE HERE TO CLEAR OUT THE LISTS OF MATERIAL
        //THAT WERE BEING PROCESSED.  THEY MAY NO LONGER MATCH 
        //TRUE CONTENTS OF THE GRID.
        processThisStep.clear();
        processNextStep.clear();
    }


    /** 
     * Advances the application one step. 
     **/
    public void step()
    {
        // Note that a new step is beginning, controlled by this controller.
        setController(this);    // inherited method
        // = false;
   
        //STEP METHOD NEEDS TO BE COMPLETED...
        Grid grid = getGrid();
        // IF THIS IS THE BEGINNING OF THE PROCESS, 
        //     PUT ALL OF THE ITEMS IN THE GRID INTO THE LIST OF ITEMS 
        //     TO BE PROCESSED IN THIS STEP ("processThisStep")
        if(processThisStep.isEmpty()&& processNextStep.isEmpty())
        {
            for(int row=0; row<grid.numRows(); row++)
            {
                for(int column=0; column<grid.numCols(); column++)
                {
                    Location location = new Location(row, column);
                    GridObject object = grid.objectAt(location);
                    if(object instanceof AbstractPercolator && object!=null)
                    {
                       processThisStep.add(object);
                    }
                }
            }
        }
 
        // OTHERWISE, THE LIST OF ITEMS TO BE PROCESSED IN THIS STEP
        //     COMES FROM THE "processNextStep" LIST THAT WAS SET UP DURING THE 
        //     PREVIOUS STEP.
        else
        {
            //System.out.println("Before");
            processThisStep.addAll(processNextStep);
            processNextStep.clear();
            //System.out.println("After");
            /*
            processThisStep.clear();
            while(!processNextStep.isEmpty())
            {
                GridObject percolator=processNextStep.get(0);
                processThisStep.add(percolator);
                processNextStep.remove(percolator);
            }
            */
        }
        
        // CREATE A NEW EMPTY LIST OF ITEMS TO BE PROCESSED IN THE NEXT STEP.
        for(GridObject percolator: processThisStep)
        {
            percolator.act();
            //System.out.println("Acted");
        }
      
    }
    
    /** 
     * Takes note of the fact that the material has percolated,
     *  creating the given new percolation material object.
     *  @param GridObject must be an abstract percolator
     */
    public void notePercolationTo(GridObject newObj)
    {
        processNextStep.add(newObj);
        if(newObj == null)
           {
           }
        //stepIncludedSomePercolation = true;
    }

    /** 
     *  Determines whether a running application has reached a desired
     *  stopping state.  In this case, stop if there are no percolation
     *  material objects needing to percolate in next step.
     *    @return <code>true</code> if the application should
     *             stop 
     **/
    public boolean hasReachedStoppingState()
    { 
        //THIS NEEDS TO BE MODIFIED TO RETURN TRUE ONLY WHEN THERE 
        //IS NO MORE MATERIAL TO PROCESS
        return(processNextStep.isEmpty());
    }
}
