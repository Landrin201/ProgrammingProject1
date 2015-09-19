import edu.kzoo.grid.Location;
import java.util.ArrayList;
import java.util.Random;

/**
 * This mouse moves randomly around until it reaches the cheese.
 * 
 * @author Roderick Vogel
 * @version 5/26/2015
 */
public class CluelessMouse extends Mouse
{ //Begin class
	//Instance Variables
	
	//Need an array list to hold the locations that the mouse can move to
    protected ArrayList<Location> empty;
    
    //Constructor
    /**
     * Constructor to initialize instance variables and super.
     *  
     *  For now, the mouse is always a blue color block.
     */
    public CluelessMouse()
    { //Begin constructor
        //Construct parent class
        super();
      //Initialize instance variables
        empty = new ArrayList<Location>();
    } //End constructor
    
    //Methods
    
    /**
     * Moves the mouse to a new space in a random direction provided that the new location does not have an object in it.
     * If the next location has the cheese in it, the mouse will go there and the program will end.
     * when reaches cheese removes the cheese
     * 
     * @ return A location object, the new location of the mouse.
     */
    public Location nextLocation()
    { //Begin nextLocation
    	//Empty the array list
        empty.removeAll(empty);
        //Get the grid that the mouse is in
        Maze grid= (Maze)this.grid();
        //Get the current location of the mouse
        Location loc = this.location();
        
        //Get the possible columns and rows that the mouse can go to
        int down =loc.row()+1;
        int up =loc.row()-1;
        int col= loc.col();
        int row =loc.row();
        int right= loc.col()+1;
        int left= loc.col()-1;
        
        //Make the locations that the mouse can go to
        Location Down= new Location(down,col);
        Location Right= new Location(row,right);
        Location Left= new Location(row,left);
        Location Up= new Location(up,col);
        
        //Check all possible locations to see if they are empty
        if( grid.isEmpty(Down) || grid.getFinishLoc().equals(Down))
        empty.add(Down);
        if( grid.isEmpty(Right)|| grid.getFinishLoc().equals(Right))
        empty.add(Right);
        if( grid.isEmpty(Left)|| grid.getFinishLoc().equals(Left))
        empty.add(Left);
        if( grid.isEmpty(Up)|| grid.getFinishLoc().equals(Up))
        empty.add(Up);
        
        //This mouse moves randomly, so we need to make a random number generator.
        Random gen= new Random();
        //Pick a random number that is no bigger than the size of the array list of possible locations
        int random= gen.nextInt(empty.size());
        
        //Return the next location
        return empty.get(random);
    } //End nextLocation
} //End class
