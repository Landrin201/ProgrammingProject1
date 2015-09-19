import java.util.Random;

import edu.kzoo.grid.Grid;
import edu.kzoo.grid.GridObject;
import edu.kzoo.grid.Location;
import edu.kzoo.grid.gui.SteppedGridAppController;

/**
 *  A <code>PercolationController</code> controls the running of a
 *  percolation application.
 * 
 * @author Alyce Brady 
 * @version 23 April 2009
 */
public abstract class PercolationController extends SteppedGridAppController
{
    
    // Class variable that keeps track of which specific controller is being used.
    private static PercolationController theController;

    /** Instantiates a new object. */
    protected static Object newObject(Class c, String type)
    {
        String exceptionMsg = "Could not instantiate " + type;
        try { return c.newInstance(); }
        catch (Exception e) { throw new RuntimeException(exceptionMsg); }
    }

    /** Notes which controller is being used.
     */
    protected static void setController(PercolationController c)
    {
        theController = c;
    }

    /** Returns which controller is being used.
     */
    protected static PercolationController getController()
    {
        return theController;
    }

    /** Sets the application's grid.
     *  (Precondition: grid is not null.)
     *    @param grid the Grid to act on
     **/
    public void setGrid(Grid grid)
    {
        // Redefined from superclass in case controller needs
        // to do some additional processing when the grid changes.
        super.setGrid(grid);
        adjustToNewGrid();
    }

   
    /** Re-initializes anything that is necessary when the grid changes
     *  (called by <code>setGrid</code> and <code>randomlyFillGrid</code>).
     */
    protected void adjustToNewGrid()
    {
        // Controller might not have to do anything additional when the grid changes.
    }

    /** Populates the grid with random solid cells based on a
     *  porousness/density factor and fills in the top row with a percolating
     *  material of the given type.
     *    @param  density  percentage of grid that should be filled with solid cells
     *    @param  percType  type of percolating material to put in top row
     */
    public void randomlyFillGrid(int density, Class percType)
    {
        Grid grid = getGrid();
        grid.removeAll();
      
        // The probability of any given cell having a solid cell is given
        // by the percentage given in the density parameter.
        Random randomNumGen = new Random();
        for ( int row = 0; row < grid.numRows(); row++ )
            for ( int col = 0; col < grid.numCols(); col++ )
                if ( randomNumGen.nextInt(100) < density )
                    grid.add(new SolidCell(), new Location(row, col));

        // Fill the top row of the grid with the current percolation type.
        if ( percType != null )
            fillTopRow(percType);
            
        adjustToNewGrid();
    }

    /** Populates the top row with the current percolation type.
     *    @param  percType  type of percolating material to put in top row
     */
    protected void fillTopRow(Class percType)
    {
        Grid grid = getGrid();
        for ( int col = 0; col < grid.numCols(); col++ )
        {
            Location loc = new Location(0, col);
            if ( grid.isEmpty(loc) )
                grid.add((AbstractPercolator)newObject(percType, "percolation type"),
                         loc);
        }
    }

    /** Takes note of the fact that the material has percolated,
     *  creating the given new percolation material object.
     */
    public abstract void notePercolationTo(GridObject newObj);

    /** Run a series of density experiments. */
    public void runExperiments(Class currentPercType)
    {
    }

    /** Run a series of density experiments, running the simulation
     *  <code>numRuns</code> times with each of a variety of densities, from
     *  <code>minDensity</code> to <code>maxDensity</code>, incrementing the
     *  density percentage by <code>increment</code> between each set of runs.
     *    @param numRuns          how many times to run the simulation with each
     *                              density
     *    @param minDensity       minimum density to test with a set of runs
     *    @param maxDensity       maximum density to test with a set of runs
     *    @param increment        the increment to use
     *    @param currentPercType  current percolation type to use
     */
    public void runExperiments(int numRuns, int minDensity, int maxDensity,
                               int increment, Class currentPercType)
    {
    }

    /** Runs the percolation simulation multiple times, keeping track of
     *  the number of times the percolation material percolated to the bottom.
     *    @param numTimes         how many times to run the simulation with the
     *                              given density
     *    @param density          density to use for this set of runs
     *    @param currentPercType  current percolation type to use
     */
    public void runNTimes(int numTimes, int density, Class currentPercType)
    {
    }

    /** Complete a run of the percolation simulation without involving the
     *  graphical user interface (no display between steps).
     */
    protected void invisibleRun()
    {
        do
        {
            step();
        }
        while ( ! hasReachedStoppingState() );
    }

    /** Advances the application one step. */
    public abstract void step();

    /** Determines whether a running application has reached
     *  a desired stopping state.
     *    @return <code>true</code> if the application should stop 
     **/
    public abstract boolean hasReachedStoppingState();

    /** Returns true if the percolating material percolated to the bottom. */
    protected boolean percolatedToBottom()
    {
        Grid g = getGrid();
        int row = g.numRows() - 1;
        for ( int col = 0; col < g.numCols(); col++ )
        {
            GridObject obj = g.objectAt(new Location(row, col));
            if ( obj != null && ! (obj instanceof SolidCell) )
                return true;
        }
        return false;
    }

}
