import java.awt.Color;
import edu.kzoo.grid.ColorBlock;
import edu.kzoo.util.NamedColor;
import edu.kzoo.grid.Location;
/*
 * Modifications:
 * 18 May 2015, Marc Kuniansky, Implemented the constructor and getLocation methods. Created the abstract move method.
 * June 2, 2015, Roderick Vogel (with assistance from Alyce Brady), implemented a new abstract method, called nextLocation. 
 * 								Removed the abstract label from the move method, and implemented it.
 */

/**
 *  Mouse in a Maze Program: Mouse <br>
 *
 *    Abstract mouse object to help create several mice.
 *
 *  @author Marc Kuniansky and Roderick Vogel, with assistance from Alyce Brady and Pamela Cutter
 *  @version 2 June 2015
 **/
public abstract class Mouse extends ColorBlock
{ //Begin class

    //Constuctor
    /**
     * Constructs a mouse.
     *  
     *  For now, the mouse is always a blue color block.
     **/
    public Mouse()
    { //Begin constructor
    	//Construct a color block object, default color blue
        super(new NamedColor(Color.BLUE));
    } //End constructor
    
    /**
     * Returns a maze object, allowing the user to get information about the maze which the mouse is in
     * @return
     */
    public Maze maze()
    { //Begin maze
    	//Get the grid the mouse is in and return it as a Maze object
    	return (Maze)grid();
    } //End maze
    
    //Methods
    /**
     * Moves the mouse to the next location
     */
    public void move()
    { //Begin move
    	//Get the next location to which the mouse should move
    	Location nextLoc = this.nextLocation();
    	//If the next location is the location of the cheese, remove the cheese
    	if(maze().getFinishLoc().equals(nextLoc))
    		maze().remove(maze().getFinishLoc());
    	//Move the mouse to the location
    	changeLocation(nextLoc);
    } //End move
    
    /**
     * Abstract Location changing method
     */
    public abstract Location nextLocation();
    
    /**
     * Returns the current location of the mouse.
     * 
     * @return A Location object showing where the mouse is.
     */
    public Location getLocation()
    { //Begin getLocation
        //Because mouse extends ColorBlock, the location() method is inherited
        //and can be used to get the mouse's location.
        return this.location();
    } //End getLocation

} //End class