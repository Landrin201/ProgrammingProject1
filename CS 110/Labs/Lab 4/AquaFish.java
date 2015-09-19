
import java.awt.Color;
import java.util.Random;


/**
  Aquarium Lab Series: <br>
       The AquaFish class defines a fish in an aquarium.  A fish of this
  class can move in the aquarium (always staying fully within the aquarium),
  and can report its color, dimensions, and location, for the purpose of
  the display.
  
  <br> <br>
  
  Created: <br>
    10 July 2002,  Alyce Brady
    <br> <br>
  Modifications: <br>
     2008-2009, Alyce Brady,         Simplified by replacing two classes
                                     (AquaPoint and Direction) with single
                                     NavigationAide class. <br>
                                
      3 April 2015, Marc Kuniansky,  Added method autoChangeDir(), which
                                     which makes a fish turn around if it
                                     gets to within a certain distance of
                                     the wall while moving. <br>
      10 April 2015, Marc Kuniansky, Modified autoChangeDir() to have it randomly
                                     change the direction of the fish, even when
                                     they are not at the wall. <br>
      20 April 2015, Marc Kuniansky, Added two new functions, ascend and descend.
                                     Modified the autoChangeDir function to include
                                     these new functions and to change the vertical 
                                     location of the fish based on where it is in
                                     relation to the top or bottom of the aquarium,
                                     and renamed autoChangeDir() to autoMove(). Also
                                     changed the constructor to make fish that are
                                     randomly colored.
   <br> <br>
  
  @author Marc Kuniansky
  @version 20 April 2015, Version 4
  @see Aquarium
 **/
public class AquaFish
{
    // STATE

    // Named constants that specify how far a fish may move in one timestep
    public static final int MIN_DISTANCE = 10;
    public static final int MAX_DISTANCE = 70;

    // Class Variables: Shared among ALL fish
    private static int nextAvailableID = 1;   // next avail unique identifier
    private static Random generator = new Random(); // random number generator

    // Instance Variables: Encapsulated data for EACH fish
    private Aquarium theAquarium;    // aquarium in which this fish is swimming
    private int uniqueID;            // unique identifier for this fish
    private Color color;             // fish's color
    private boolean facingRight;     // whether fish is facing right or left
    private NavigationalAide aide;   // object that keeps track of this fish's
                                     //    size, location, and direction.
    
    // OPERATIONS (constructor and methods)
    /**
     *  The AquaFish constructor sets properties of the AquaFish.
     *  This constructor creates a randomly colored fish.
     *  Precondition: the aquarium must be big enough to accommodate
     *  the biggest fish (currently 75 pixels long and 30 pixels high)
     *  plus 10 pixels of padding in all four directions.
     *  @param    aqua   the Aquarium in which the fish will live
     **/
    public AquaFish(Aquarium aqua)
    {
        // Use the two-parameter constructor for the real initialization,
        // specifying that the default color should be a random color.
        this(aqua, new Color(generator.nextInt(255), generator.nextInt(255), generator.nextInt(255)));
    }

    /**
     *  The AquaFish constructor sets properties of the AquaFish.
     *  Precondition: the aquarium must be big enough to accommodate
     *  the biggest fish (currently 75 pixels long and 30 pixels high)
     *  plus 10 pixels of padding in all four directions.
     *  @param    aqua   the Aquarium in which the fish will live
     *  @param    newColor  the color for the new fish
     **/
    public AquaFish(Aquarium aqua, Color newColor)
    {
        // Keep track of the aquarium and initialize ID.
        this.theAquarium = aqua;
        this.uniqueID = nextAvailableID;
        nextAvailableID++;

        // Initialize fish's size, location, and direction.
        this.aide = new NavigationalAide(this);
        this.facingRight = true;

        // Initialize this fish's color.
        this.color = newColor;
    }

    /**
     *  Gets the aquarium in which this fish lives.
     *  @return  the aquarium in which this fish exists
     */
    public Aquarium aquarium()
    {
        return this.theAquarium;
    }

    /**
     *  Gets the unique identifier for this fish.
     *  @return    the ID of the fish
     **/
    public int id()
    {
        return this.uniqueID;
    }

    /** Gets fish's color.
     *  @return        the color of this fish
     **/
    public Color color()
    {
        return this.color;
    }

    /**
     *  Gets this fish's x coordinate in the aquarium.
     *  @return    the x coordinate in the aquarium of the fish's centerpoint
     **/
    public int xCoord()
    {
        return this.aide.centerpointX();
    }

    /**
     *  Gets this fish's y coordinate in the aquarium.
     *  @return    the y coordinate in the aquarium of the fish's centerpoint
     **/
    public int yCoord()
    {
        return this.aide.centerpointY();
    }

    /**
     *  Determines whether this fish is facing right.
     *  @return     <code>true</code> if fish is facing right;
     *              <code>false</code> otherwise
     **/
    public boolean isFacingRight()
    {
        return this.facingRight;
    }

    /**
     *  Determines whether this fish is facing left.
     *  @return     <code>true</code> if fish is facing left;
     *              <code>false</code> otherwise
     **/
    public boolean isFacingLeft()
    {
        return ! isFacingRight();
    }

    /**
     *  Determine whether this fish is at a wall.
     *  A fish is considered at a wall if it cannot move forward; in other
     *  words, if the distance from the fish to the wall it faces is less
     *  than the minimum distance that a fish can move forward.
     *  @returns    <code>true</code> if fish is at a wall;
     *              <code>false</code> otherwise
     **/
    private boolean atWall()
    {
        return (this.aide.fishDistanceToWall() <= MIN_DISTANCE);
    }

    /** Gets the length of this fish.
     *  @return   fish length
     **/
    public int length()
    {
        return this.aide.fishLength();
    }

    /** Gets the height of this fish.
     *  @return    fish height
     **/
    public int height()
    {
        return this.aide.fishHeight();
    }

    /**
     *  This function is provided primarily for debugging purposes.
     *  @return    a string representation of a fish
     **/
    public String toString()
    {
        String s = new String();
        s += this.uniqueID + this.aide.toString();
        return s;
    }
    
    /**
     *  Moves forward horizontally by random increments, staying
     *  within the aquarium.
     **/
    protected void moveForward()
    {
        // First get random number in range [0, MAX_DISTANCE-MIN_DISTANCE],
        // then shift to [MIN_DISTANCE, MAX_DISTANCE].  If moving that
        // far would mean swimming out of the aquarium, only move to edge
        // of aquarium.  Adjust fish's x coordinate by a positive or 
        // negative amount, depending on whether fish is facing right or left.
        int moveAmt = generator.nextInt(MAX_DISTANCE - MIN_DISTANCE + 1);
        moveAmt += MIN_DISTANCE;
        if ( moveAmt >= this.aide.fishDistanceToWall() )
            moveAmt = this.aide.fishDistanceToWall();
        if ( this.isFacingRight() )
            this.aide.moveFishRight(moveAmt);
        else
            this.aide.moveFishLeft(moveAmt);
    }
    
    /** 
        Moves the fish up by random increments, staying in the aquarium. 
        
        Structured in the same way as the moveForward method.
     */
    private void ascend()
    { //Begin ascend
        //Make an integer that will randomly determine how far the fish moves up
        int moveAmt = generator.nextInt(MAX_DISTANCE - MIN_DISTANCE + 1);
        //If moving the distance selected will make the fish go out of the water,
        //only move it to the surface.
        //The method fishDistancetoSurface was created as a design choice to simlify the
        //code of this function. It computes the distance between the fish and the 
        //surface of the aquarium. The source code can be found in the 
        //NavigationalAide class. Verified by Alyse Brady, April 20 2015.
        if(moveAmt >=this.aide.fishDistanceToSurface())
        { //Begin if move amound is larger than the distance between the fish and the surface
            moveAmt = this.aide.fishDistanceToSurface(); 
        } //End if move amound is larger than the distance between the fish and the surface
        if(this.aide.fishAtSurface() == false)
        { //Begin if fish is not at the surface
            this.aide.raiseFish(moveAmt);
        } //End if fish is not at the surface
    } //End ascend
    
    /**
        Moves the fish up by random increments, staying in the aquarium. 
        Structured in the same way as the ascend method.
     */
    private void descend()
    {//Begin descend
        //Make an integer that will randomly determine how far the fish moves down
        int moveAmt = generator.nextInt(MAX_DISTANCE - MIN_DISTANCE + this.aide.halfFishHeight());
        //if moving the distance selected makes the fish go through the floor
        //of the aquarium, make the fish move to the floor of the aquarium.
        //The method fishDistancetoBottom was created as a design choice to simlify the
        //code of this function. It computes the distance between the fish and the 
        //surface of the aquarium. The source code can be found in the 
        //NavigationalAide class. Verified by Alyse Brady, April 20 2015.
        if(moveAmt >= this.aide.fishDistanceToBottom())
        { //Begin if the move amount is larger than the distance between the fish and the floor
            moveAmt = this.aide.fishDistanceToBottom();
        } //Begin if the move amount is larger than the distance between the fish and the floor
        if(this.aide.fishAtBottom()==false)
        { //Begin if fish is not at the bottom
            this.aide.sinkFish(moveAmt);
        } //End if fish is not at bottom
    }//End descend
    
    /**
     *  Reverses direction.
     **/
    protected void changeDir()
    {
        this.facingRight = ! this.facingRight;
    }
    
     /** 
      autoMove will check whether or not the fish is at the wall, and will 
      turn the fish around if it is. It will also randomly change the 
      direction of the fish, to make the simulation a little more 
      interesting. 
      It also tells the fish to move up or down at random, and if the fish it at the
      top or bottom of the aquarium it will make the fish ascend or descend a certain
      percentage of the time.
      No matter what happens, it moves the fish forward one step.
     **/
    public void autoMove()
    { //Begin autoMove
        boolean fishAtWall = this.atWall(); //Declare a variable to store the true/false value given by atWall().
        int randomDirChangeNumber = generator.nextInt(20); //Generate a random number to determine whether the fish will change direction.
        boolean randomChangeDir = false; //Default false
        
        //The following if loop will change the fish's direction if a random number is less than or equal to 2. This will happen regardless of the fish's location.
        if(randomDirChangeNumber<=2)
        { //Begin random selection for directional change
            randomChangeDir = true;
        } //End random selection for dirrectional change
        //Next, see if the fish is at the wall, or if the fish should randomly change directions.
        //If it is, then change its direction.
        if(fishAtWall==true || randomChangeDir==true)
        { //Begin if
            this.changeDir(); //Change the direction of the fish only if it is at the wall
        } //End if
        
        //MOVE THE FISH UP OR DOWN
        //Move the fish up 1/3 of the time, down 1/3 of the time, and stay at the same depth 1/3 of the time
        int randomUpDownNumber = generator.nextInt(2);
        if(randomUpDownNumber ==0)
        { //Begin if rand==0
            this.ascend(); //Ascend 1/3 of the time
        } //End if rand==0
        else if(randomUpDownNumber ==1)
        { //Begin if rand==1
            this.descend(); //Descend 1/3 of the time
        } //End if rand==2
        else
        { //Begin if rand==3
            //Stay at the same height, so there is no code here. Nothing happens if randomUpDownNumber==3.
        } //End if rand==3
        
        //If the fish is at the surface, it has a 2/3 chance of descending and a 1/3 chance of staying at the surface.
        if(this.aide.fishAtSurface() == true)
        {
            int randomStayAtSurface = generator.nextInt(2);
            if(randomStayAtSurface <=1)
                this.descend(); //Make the fish move down 2/3 of the time
            else
            {
                //Nothing happens when randomStayAtSurface==2, and the fish stays at the surface
            }
        }
        
        //If the fish is at the bottom of the aquarium, it has a 2/3 chance of ascending and a 1/3 chance of staying at the bottom.
        if(this.aide.fishAtBottom() == true)
        { //Begin if fish is at bottom
            int randomStayAtBottom = generator.nextInt(2);
            if(randomStayAtBottom <=1)
                this.ascend(); //Make the fish move up 2/3 of the time
            else
            {
                //Nothing happens when randomStayAtBottom==2, and the fish stays at the bottom.
            }
        } //End if fish is at bottom
        
        this.moveForward(); //Move the fish forward no matter what else happens to it.
    } //End autoMove

}


