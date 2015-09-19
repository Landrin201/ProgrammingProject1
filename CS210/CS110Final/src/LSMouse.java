import edu.kzoo.grid.Location;
import java.util.ArrayList;
import java.util.Random;
import edu.kzoo.grid.Direction;

/**
 * This mouse moves randomly until in sight of the cheese, then it moves to the cheese. It sees the cheese if
 * it is on the same row or column as the cheese and there are no blocks blocking its view.
 * 
 * @author Roderick Vogel 
 * @version 6/2/2015
 */
public class LSMouse extends Mouse
{ //Begin class
	//Instance variables
	//Need an array list to hold the possible locations to which a mouse ccan move
    protected ArrayList<Location> empty;
    protected ArrayList<Direction> dir;
    /**
     *	Constructor that takes no parameters.
     */
    public LSMouse()
    { //Begin constructor
    	//Construct the parent class
        super();
        //Initialize instance variables
        dir= new ArrayList<Direction> ();
        empty = new ArrayList<Location>();
    } //End constructor

    /**
     * Moves the mouse in a random direction so long as the next location is empty. If any of the next locations contain the 
     * cheese the mouse will eat the cheese and the program will end. 
     * 
     * When the mouse can see the cheese in its row or column without obstruction, 
     * the mouse goes directly to the cheese
     * When the mouse reaches the cheese it removes the cheese
     * 
     * @ return A location object, the next location to which the mouse will move
     */
    public Location nextLocation()
    { //Begin nextLocation
    	//Clear the array list of possible locations to ensure it is empty.
        empty.removeAll(empty);
        
        //Get the maze that the mouse is in
        Maze grid= (Maze)this.grid();
        //Get the current location of the mouse
        Location loc = this.location();
        //Get the possible changes which can be made to the location of the mouse. Assume
        //The mouse can try to move left, right, up, and down.
        int down =loc.row()+1;
        int up =loc.row()-1;
        int col= loc.col();
        int row =loc.row();
        int right= loc.col()+1;
        int left= loc.col()-1;
        //Get the directions in which the mouse can move
        Location Down= new Location(down,col);
        Location Right= new Location(row,right);
        Location Left= new Location(row,left);
        Location Up= new Location(up,col);
        Direction North= new Direction(0);
        Direction East= new Direction( 90);
        Direction South= new Direction (180);
        Direction West= new Direction(270);
        
        //Checked to see if the possible locations are empty. If they are, add them to the array list
        if( grid.isEmpty(Down) || grid.getFinishLoc().equals(Down))
        {
            empty.add(Down);
            dir.add(South);
        }
        if( grid.isEmpty(Right)|| grid.getFinishLoc().equals(Right))
        {
            empty.add(Right);
            dir.add(East);
        }
        if( grid.isEmpty(Left)|| grid.getFinishLoc().equals(Left))
        {
            empty.add(Left);
            dir.add(West);
        }
        if( grid.isEmpty(Up)|| grid.getFinishLoc().equals(Up))
        {    
            empty.add(Up);
            dir.add(North);
        }    
        //Checks to see if any of the next locations are the cheese. If they are, go there.
        if(grid.getFinishLoc().equals(Down)||grid.getFinishLoc().equals(Right) 
        ||grid.getFinishLoc().equals(Left) ||grid.getFinishLoc().equals(Up))
        {  
            return maze().getFinishLoc();
        }        
        
        for( Direction s:dir)
        {
            Location temp= grid.getNeighbor(loc,s);
            while( grid.isEmpty(temp))  
                temp= grid.getNeighbor(temp,s);
            if(grid.getFinishLoc().equals(temp))
            {   
                return maze().getNeighbor(loc,s);
                //checks to see if direction in sight has cheese in it. 
                // if so moves towards cheese 
            }
        }
        Random gen= new Random();
        int random= gen.nextInt(empty.size());//creates random variable
        return empty.get(random); // return random location
        
    } //End nextLocation
} //End class
