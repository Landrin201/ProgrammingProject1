//Import anything that the class needs.
import java.util.ArrayList;
/**
  The Simulation class contains all of the code nescessary for having the aquarium
  simulation progress through steps. It creates the aquarium, GUI, and fish, telling
  them what do do when the simulation is run.
  
  <br> <br>
  
  Created: <br>
    April 20, 2015,  Marc Kuniansky
    
    <br> <br>
    
  Modifications: <br>
    April 20, 2015, Marc Kuniansky, Constructed initial class, adding the
                                    constructor and two methods, "step" and "run."
    <br> <br>
  
  @author Marc Kuniansky
  @version Version 1, April 20, 2015
 **/
public class Simulation
{ //Begin Simulation class
    // Instance variables
    //Create the aquarium, user interface, and array list for the fish.
    private Aquarium aquarium = new Aquarium(600, 480);
    private AquaSimGUI userInterface = new AquaSimGUI(aquarium, true, true);
    private ArrayList<AquaFish> arrayListOfFish = new ArrayList<AquaFish>();
    
    //The user inputs the number of fish and the number of steps. Get them.
    private int numberOfFish = userInterface.getNumberOfFish();
    private int numberOfSteps = userInterface.getNumberOfSteps();
    /**
      Constructor for Simulation class.
     */
    public Simulation()
    { //Begin constructor
        //Code goes here to initialize instance variables
    } //End constructor

    /**
       The step method causes the fish to move around automatically by calling on 
       the autoChangeDir method from the AquaFish class. After having the fish move
       it automatically refreshes the user interface so that the user can see the
       changes in position.
       
       The number of steps is assigned by the user. The default number of steps
       is 15.
     */
    public void step()
    { //Begin step method
        //MAKE THE FISH DO THINGS
        //Make all of the fish move
        for(int s=0; s<numberOfSteps; s++)
        { //Begin making fish move a certain number of times
            for(AquaFish fishToMove : arrayListOfFish)
            { //Begin the for loop to move all of the fish
                fishToMove.autoMove();
            }
            userInterface.showAquarium(); //Refresh the aquarium after moving the fish
        }// End making the fish move
    } //End step method
    
    
    /**
      This method makes the aquarium simulation run. It constructs the fish, 
      adds them to an array list, adds all of the fish to the aqurium, and has 
      the fish move around as dictated by the step method above.
      
      The default number of fish is 7.
     */
    public void run()
    { //Begin run method
        //Add the appropriate number of fish to the aquarium
        for(int i=0; i<numberOfFish; i++)
        { //Begin the fish creator
            arrayListOfFish.add(new AquaFish(aquarium));
        } //End the fish creator
       
        //Add the fish from the array list to the aquarium
        for(AquaFish allFish : arrayListOfFish)
        { //Begin adding fish
            aquarium.add(allFish);
        } //End adding fish
        
        //Have the fish move around in the aquarium
        step();
        
        //Tell the user how to quit the simulation
        userInterface.println ("Close GUI display window to quit.");
    } //End run method
} //End Simultion class
