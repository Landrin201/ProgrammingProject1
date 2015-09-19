import edu.kzoo.grid.Location;
/**
 * This mouse teleports directly to the cheese.
 * 
 * @author Roderick Vogel 
 * @version 5/26/2015
 */
public class TeleportingMouse extends Mouse
{
   
    /**
     * Constructor which takes no parameters
     */
    public TeleportingMouse()
    {
        //Construct the patent class        
        super();
    }
    /**
     * Replace the cheese at the end location with the mouse.
     */
    public Location nextLocation()
    {
        Location nextLoc= maze().getFinishLoc();
        return nextLoc;
    }
}
