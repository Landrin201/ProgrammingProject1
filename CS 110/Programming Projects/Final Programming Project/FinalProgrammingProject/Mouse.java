import java.awt.Color;

import edu.kzoo.grid.ColorBlock;
import edu.kzoo.util.NamedColor;
import edu.kzoo.grid.GridObject;
import edu.kzoo.grid.Location;

/**
 *  Mouse in a Maze Program: Mouse <br>
 *
 *    Abstract mouse object to help create several mice.
 *
 *  @author Marc Kuniansky
 *  @version 18 May 2015
 **/
public abstract class Mouse extends ColorBlock
{
    //Constuctor
    /**
     * Constructs a mouse.
     *  
     *  For now, the mouse is always a blue color block.
     **/
    public Mouse()
    {
        super(new NamedColor(Color.BLUE));
    }
    
    //Methods
    /**
     * Abstract move method, tells the mouse to move.
     */
    public abstract void move();
    
    /**
     * Returns the current location of the mouse.
     * 
     * @return A Location object showing where the mouse is.
     */
    public Location getLocation()
    {
        //Because mouse extends ColorBlock, the location() method is inherited
        //and can be used t oget the mouse's location.
        return this.location();
    }

}