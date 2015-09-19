import java.awt.Color;
import edu.kzoo.grid.ColorBlock;
import edu.kzoo.util.Debug;

/**
  Project Name: Percolator Lab
  <br>
  This adds a solid block to the percolater.
  <br> <br>
  Created: <br>
    May 12,  Marc Kuniansky
    <br> <br>
  Modifications: <br>
    May 12, Marc Kuniansky, Modified to implement both constructors and the act method. <br>
  
  @author Marc Kuniansky (with assistance from)
  @version May 12, 2015
 **/
public class SolidCell extends ColorBlock
{ //Begin class
    // Instance variables

    /**
     * Constructor with no parameters.
     */
    public SolidCell()
    { //Begin constructor
        // Constructs a black color block.
        super(Color.BLACK);
    } //End constructor
    
    /** 
     * Constructor with color as a parameter
     * 
     * @param color Must be passed as a color object, not a RGB value.
     */
    public SolidCell(Color color)
    { //Begin constructor
        super(color);
    } //End constructor
    
    /**
     * This method is here for debugging purposes.
     */
    public void act()
    { //Begin act
        Debug.println("Solid Cell " + location() + " not acting.");
    } //End act
} //End class
