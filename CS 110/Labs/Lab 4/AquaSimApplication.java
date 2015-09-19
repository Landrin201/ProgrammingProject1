import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

/** Aquarium Lab Series: <br>    
       The AquaSimApplication class contains the main function that will
       run the Aquarium Simulation. The main function creates an aquarium, 
       adds fish to it, creates a GUI to allow the user to see the fish and
       define certain parameters, and makes the fish move. 
       
       <br> <br>
 
  Modifications: <br>
    23 March 2008,  Alyce Brady,   Created skeleton main that constructs and
                                   displays an empty aquarium. <br>
                                   
    3 April 2015, Marc Kuniansky,  Added several fish to the aquarium and 
                                   added code to make them move forward. 
                                   Created a new method, autoChangeDir, to
                                   make the fish automatically change 
                                   direction if they encounter the wall while
                                   moving. <br>
                                   
    10 April 2015, Marc Kuniansky, Modified to add a for loop which made the 
                                   fish in the aquarium move however many times 
                                   the user dictates. <br>
                                   
    15 April 2015, Marc Kuniansky, Added code to create an array list to 
                                   store many fish in, allowing the user
                                   to determine how many fish are to be
                                   added. This allowed the code to be 
                                   greatly simplified. Much of the old
                                   code was incorporated into the newly 
                                   created for loops. The old code was 
                                   cleaned up and some unnescessary code 
                                   was removed.
    20 April 2015, Marc Kuniansky, Move much of the code from the main function
                                   to the newly created Simulation class. 
   <br> <br>
 
   @author  Marc Kuniansky
   @version 20 April 2015, Version 4
   @see AquariumController
 **/
public class AquaSimApplication
{
    /**
       This is the main function.  It tells the user how to use the simulation
       and calls on the simulation class to create and run the simulation.
       
       If no width and height are specified by the user, the default setting 
       is 640x480. The default number of fish is 10, and the default number
       of steps is 15.
       @param    String args[] is never used
     **/
    public static void main(String args[])
    { //Begin main
        //Tell the user that the simulation has started.
        System.out.println("Welcome to the aquarium! \n Press the Start button to start the simulation. \n To change the length of the simulation, change the number of steps. \n To change the number of fish, change the number of fish.");
        //Tell the user how to start the aquarium simulation nd how to change the length and numbef of fish.
        //System.out.println(" Press the Start button to start the simulation. \n To change the length of the simulation, change the number of steps. \n To change the number of fish, change the number of fish.");
        //Construct the simulation.
        Simulation theSimulation = new Simulation();
        //Run the simulation.
        theSimulation.run();
    } //End main

}//end class
