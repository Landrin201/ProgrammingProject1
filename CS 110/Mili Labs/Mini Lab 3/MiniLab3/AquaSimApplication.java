import java.awt.Color;
import java.util.Random;

/** Aquarium Lab Series: <br>    
       The AquaSimApplication class contains the main function that will
       run the Aquarium Simulation. The main function creates an aquarium, 
       adds fish to it, creates a GUI to allow the user to see the fish, and 
       makes the fish move. 
       
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
                                   the user dictates.
   <br> <br>
 
   @author  Marc Kuniansky
   @version 10 April 2015, Version 3
   @see AquariumController
 **/
public class AquaSimApplication
{
    /**
       This is the main function.  It first creates an aquarium of
       a specified width and height. It then adds several fish, creates
       the GUI, and tells the fish to move around.
       
       If no width and height are specified by the user, the default setting 
       is 640x480.
       @param    String args[] is never used
     **/
    public static void main(String args[])
    {
        System.out.println("Welcome to the aquarium!");

        // CONSTRUCT OBJECTS NEEDED FOR THE AQUARIUM SIMULATION.

        // Construct the aquarium.  Specify its dimensions when creating it.
            Aquarium aqua;  // create reference to an Aquarium ...
            aqua = new Aquarium(600, 480); // ... object that has now been created
        
        //CONSTRUCT THE FISH
        //Random number generators for colors, to make a fish of random color.
            Random blueGenerator = new Random(); //Generate and store a random number
                int randomBlue = blueGenerator.nextInt(255); //Make the random number pick another new random number
            Random redGenerator = new Random();
                int randomRed = redGenerator.nextInt(255);
            Random greenGenerator = new Random();
                int randomGreen = greenGenerator.nextInt(255);
            //Construct a fish which will randomly be one of the colors of the rainbow
            Random colorGenerator = new Random();
                int randomRainbowColor = colorGenerator.nextInt(7);
            AquaFish rainbowFish;
            if(randomRainbowColor == 0)
                {
                    rainbowFish = new AquaFish(aqua, Color.RED);
                }
            else if(randomRainbowColor==1)
                {
                    rainbowFish = new AquaFish(aqua, Color.ORANGE);
                }
            else if(randomRainbowColor==2)
                {
                    rainbowFish = new AquaFish(aqua, Color.YELLOW);
                }
                else if(randomRainbowColor==3)
                {
                    rainbowFish = new AquaFish(aqua, Color.GREEN);
                }
                else if(randomRainbowColor==4)
                {
                    rainbowFish = new AquaFish(aqua, Color.BLUE);
                }
                else if(randomRainbowColor==5)
                {
                    Color indigo = new Color(57, 100, 195);
                    rainbowFish = new AquaFish(aqua, indigo);
                }
                else // if(randomRainbowColor==6)
                {
                    Color violet = new Color(102, 51, 153);
                    rainbowFish = new AquaFish(aqua, violet);
                }
            
            
                //Construct fish
            Color randomColor = new Color(randomRed, randomBlue, randomGreen);
                AquaFish randomFish = new AquaFish(aqua, randomColor);
            Color gold = new Color(255, 215, 0); //I want to make a goldfish, so I need toi make the color gold
                AquaFish goldfish = new AquaFish(aqua, gold); //Make a goldfish
            Color salmonColor = new Color(250, 128, 114); //Make the salmon color
                AquaFish salmon = new AquaFish(aqua, salmonColor); //Make a salmon
            Color blueColor = new Color(0.0f, .6f, 1.0f); //Make camo color. I want this fish to be hiding, so the color is identical to the background
                AquaFish camoFish = new AquaFish(aqua, blueColor); //Make a camoflauged fish
            //Add fish to the aquarium
            aqua.add(goldfish); //Add the goldfish
            aqua.add(salmon); //Add the salmon
            aqua.add(camoFish); //Add the camoFish
            aqua.add(randomFish); //Add a fish of truly random color
            aqua.add(rainbowFish);
            
        //CONSTRUCT GUI
        // Construct a graphical user interface (GUI) to display and control
        // the simulation.  The user interface needs to know about the
        // aquarium, so we pass aqua to the user interface constructor.
        AquaSimGUI userInterface;              // create reference to GUI ...
        userInterface = new AquaSimGUI(aqua, true);  // ... and then GUI itself.
           
        // Tell the user how to start the aquarium simulation.
        System.out.println(" Press the Start button to start the simulation. \n To change the length of the simulation, change the number of steps.");
            // Now wait for the user to press the start button.
            userInterface.waitForStart();
        // Draw the initial view of the aquarium and its contents.
        userInterface.showAquarium();

        // RUN THE AQUARIUM SIMULATION.
        //MAKE FISH DO THINGS
        //The user inputs the number of steps. Get the number of steps.
        int numberOfSteps = userInterface.getNumberOfSteps();
        //Make the fish move around and automatically change direction when they hit the wall.
        for(int i = 0; i<numberOfSteps; i++)
        { //Begin a for loop which will make all of the fish move a total of 10 times.
            //autoChangeDir is a new method created in the AquaFish class. It will check whether the fish 
            //is at the wall, and if it is it turns the fish around. It will
            //also change the direction of the fish at random.
            //In all cases it moves the fish forward.
            salmon.autoChangeDir();
            goldfish.autoChangeDir();
            camoFish.autoChangeDir();
            randomFish.autoChangeDir();
            rainbowFish.autoChangeDir();
            userInterface.showAquarium(); //Re-display the aquarium to show the new locations of the fish.
        } //End for loop
        
        // WRAP UP.

        // Remind user how to quit application.
        userInterface.println ("Close GUI display window to quit.");

    }//end main

}//end class
