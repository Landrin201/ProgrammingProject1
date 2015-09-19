import java.awt.Color;
import java.util.Random;

/** Aquarium Lab Series: <br>    
 *      The AquaSimApplication class contains the main function that will
 *      run the Aquarium Simulation. (This description should be updated
 *      when the behavior of the program changes.)<br>
 *
 * Modifications: <br>
 *   23 March 2008,  Alyce Brady,  Created skeleton main that constructs and
 *                                 displays an empty aquarium.<br>
 *   (date), (your name), Modified to .... <br>
 *
 *  @author  Alyce Brady  (should be Your Name)
 *  @version 23 March 2008  (should be today's date)
 *  @see AquariumController
 **/
public class AquaSimApplication
{
    /**
     *  This is the main function.  It executes the program.
     *  @param    String args[] is never used
     **/
    public static void main(String args[])
    {
        System.out.println("Welcome to the aquarium!");

        // CONSTRUCT OBJECTS NEEDED FOR THE AQUARIUM SIMULATION.

        // Construct the aquarium.  Specify its dimensions when creating it.
            Aquarium aqua;                 // create reference to an Aquarium ...
            aqua = new Aquarium(600, 480); // ... object that has now been created

        // Construct fish.
            AquaFish sturgeon = new AquaFish(aqua); //Construct the first fish
            Color gold = new Color(255, 215, 0); //I want to make a goldfish, so I need toi make the color gold
            AquaFish goldfish = new AquaFish(aqua, gold); //Make a goldfish
            Color salmonColor = new Color(250, 128, 114); //Make the salmon color
            AquaFish salmon = new AquaFish(aqua, salmonColor); //Make a salmon
            Color blueColor = new Color(0.0f, .6f, 1.0f); //Make camo color. I want this fish to be hiding, so the color is identical to the background
            AquaFish camoFish = new AquaFish(aqua, blueColor); //Make a camoflauged fish
        //Add fish to the aquarium
            aqua.add(sturgeon); //Add the sturgeon
            aqua.add(goldfish); //Add the goldfish
            aqua.add(salmon); //Add the salmon
            aqua.add(camoFish); //Add the camoFish
        
        // Construct a graphical user interface (GUI) to display and control
        // the simulation.  The user interface needs to know about the
        // aquarium, so we pass aqua to the user interface constructor.
        AquaSimGUI userInterface;              // create reference to GUI ...
        userInterface = new AquaSimGUI(aqua);  // ... and then GUI itself
        
        //Make the fish move around. 
            sturgeon.moveForward(); //Make the Sturgeon move forward
            goldfish.moveForward(); //Make the goldfish move forward
            salmon.moveForward(); //Make the slamon move forward
            camoFish.moveForward(); //Make the camoFish move forward
                userInterface.showAquarium(); //Re-display the aquarium to show the new locations of the fish.
           
        // Tell the user how to start the aquarium simulation.
        System.out.println("Press the Start button to start the simulation.");

        // Now wait for the user to press the start button.
        userInterface.waitForStart();

        // Draw the initial view of the aquarium and its contents.
        userInterface.showAquarium();


        // RUN THE AQUARIUM SIMULATION.

        // Make the fish move and redisplay.
        //      CODE MISSING HERE!


        // WRAP UP.

        // Remind user how to quit application.
        userInterface.println ("Close GUI display window to quit.");

    }//end main

}//end class
