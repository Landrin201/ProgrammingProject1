import java.util.ArrayList;

import edu.kzoo.grid.Grid;
import edu.kzoo.grid.GridObject;
import edu.kzoo.grid.Location;

/**
 *  A <code>SlowPercolationController</code> controls the running of a
 *  percolation application by looking through every location in the grid
 *  in every step and asking each object that it finds to act.
 * 
 * @author Alyce Brady 
 * @version 23 April 2009
 */
public class SlowPercolationController extends PercolationController
{
    private boolean stepIncludedSomePercolation;

    /** Constructs a SlowPercolationController object, initializing both the
     *  inherited and the newly introduced instance variables.
     */
    public SlowPercolationController()
    {
        super();
        stepIncludedSomePercolation = false;
    }

    /** Advances the application one step. */
    public void step()
    {
        // Note that a new step is beginning, controlled by this controller.
        setController(this);    // inherited method
        stepIncludedSomePercolation = false;  // no percolation in this step yet!

        // Get all the objects in the grid.
        Grid g = getGrid();
        ArrayList<GridObject> list = new ArrayList<GridObject>();
        for ( int row = 0; row < g.numRows(); row++ )
            for ( int col = 0; col < g.numCols(); col++ )
            {
                GridObject obj = g.objectAt(new Location(row, col));
                if ( obj != null )
                    list.add(obj);
            }

        // Ask all the objects to act.
        for ( GridObject obj : list )
            obj.act();    
    }

    /** Takes note of the fact that the material has percolated,
     *  creating the given new percolation material object.
     */
    public void notePercolationTo(GridObject newObj)
    {
        // Indicate that percolation is still making progress.
        stepIncludedSomePercolation = true;
    }

    /** Determines whether a running application has reached
     *  a desired stopping state.  In this case, stop if the
     *  latest step did not include any new percolation.
     *    @return <code>true</code> if the application should stop 
     **/
    public boolean hasReachedStoppingState()
    { 
        return ! stepIncludedSomePercolation;
    }
}
