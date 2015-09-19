import edu.kzoo.grid.Grid;
import edu.kzoo.grid.BoundedGrid;
import edu.kzoo.grid.Location;
/**
  Project Name: <br>
  This constructs a maze for a mouse to navigate.
  <br> <br>
  Created: <br>
    May 17 2015,  Marc Kuniansky
    <br> <br>
  Modifications: <br>
    May 17 2015, Marc Kuniansky, Modified to .... <br>
  
  @author Marc Kuniansky (with assistance from)
  @version May 17 2015
 **/
 
public class Maze extends BoundedGrid
{ //Begin class
    //Instance Variables
    protected Location mouseStartingLocation;
    protected static Location cheeseLocation;
    //BoundedGrid grid;
    
    /**
     * Constructor for Maze
     */
    public Maze(int rows, int columns)
    { //Begin constructor
        super(rows, columns);
        mouseStartingLocation = new Location(0,0);
        cheeseLocation = new Location(1,1);
    } //End constructor
    
    public void setStartLoc(Location startLocation)
    {
        mouseStartingLocation = startLocation;
    }
    
    public void setFinishLoc(Location endLocation)
    {
        cheeseLocation = endLocation;
    }
    
    public Location getStartLoc()
    {
        return mouseStartingLocation;
    }
    
    public static Location getFinishLoc()
    {
        return cheeseLocation;
    }
} //End class
