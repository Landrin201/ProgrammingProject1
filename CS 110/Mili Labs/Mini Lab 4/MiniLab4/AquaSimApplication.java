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
   <br> <br>
 
   @author  Marc Kuniansky
   @version 15 April 2015, Version 4
   @see AquariumController
 **/
public class AquaSimApplication
{
    /**
       This is the main function.  It first creates an aquarium of
       a specified width and height. It then adds several fish, creates
       the GUI, and tells the fish to move around.
       
       If no width and height are specified by the user, the default setting 
       is 640x480. The default number of fish is 10, and the default number
       of steps is 15.
       @param    String args[] is never used
     **/
    public static void main(String args[])
    {
        System.out.println("Welcome to the aquarium!");
        //Tell the user how to start the aquarium simulation nd how to change the length and numbef of fish.
            System.out.println(" Press the Start button to start the simulation. \n To change the length of the simulation, change the number of steps. \n To change the number of fish, change the number of fish.");

        // CONSTRUCT OBJECTS NEEDED FOR THE AQUARIUM SIMULATION
        // Construct the aquarium.  Specify its dimensions when creating it.
        Aquarium aqua = new Aquarium(600, 480); 
        
        //Construct a graphical user interface (GUI) to display and control
        //the simulation.  The user interface needs to know about the
        //aquarium, so we pass aqua to the user interface constructor.
        //We also want the user to be able to determine the number of 
        //steps (default is 15), so we pass the first boolean to the GUI 
        //constructor. The second boolean statement tells the GUI to let the user
        //determine the number of fish (default is 7)
        AquaSimGUI userInterface = new AquaSimGUI(aqua, true, true);
        //Get the desired number of fish and store it in a variable
        int numberOfFish= userInterface.getNumberOfFish();
        
        //CONSTRUCT THE FISH
        //First, construct several colors. I wanted some specific colors for my fish.
        Color gold = new Color(255, 215, 0); //I want to make a goldfish, so I need to make the color gold
        Color salmonColor = new Color(250, 128, 114); //Make the salmon color
        Color blueColor = new Color(0.0f, .6f, 1.0f); //Make camo color. I want this fish to be hiding, so the color is identical to the background. All that will be visible of this fish is its eye.

        //First construct an array list to store all of the fish in.
        ArrayList<AquaFish> fishyList = new ArrayList<AquaFish>();
        //Add the specified number of fish to the aquarium. If 4 fish are requested, 4 fish are added.
        for(int i=0; i<=numberOfFish; i++)
            { //Begin the fish creator
                //Random number generators for colors, to make a fish of random color.
                Random blueGenerator = new Random(); //Generate and store a random number
                    int randomBlue = blueGenerator.nextInt(255); //Make the random number pick another new random number between 0 and 255
                Random redGenerator = new Random(); //Repeat for red and green values
                    int randomRed = redGenerator.nextInt(255);
                Random greenGenerator = new Random();
                        int randomGreen = greenGenerator.nextInt(255);
                //Make a new color for a crazy colored fish whose color will be different every time, using the above RBG values
                Color randomColor = new Color(randomRed, randomBlue, randomGreen);
                //Because I am rather attached to my original fish, I am making them the default three fish to be added.
                if(i==0)
                    { //Begin add goldfish
                        fishyList.add(new AquaFish(aqua, gold));
                    } //End add goldfish
                else if(i==1)
                    { //Begin add salmon
                        fishyList.add(new AquaFish(aqua, salmonColor));
                    } //End add salmon
                else if(i==2)
                    { //Begin add hiding fish
                        fishyList.add(new AquaFish(aqua, blueColor));
                    } //End add hiding fish
                else if(i==3)
                    { //Begin making a rainbow fish
                        //Construct a fish which will randomly be one of the colors of the rainbow
                        Random colorGenerator = new Random();
                        //There are 7 colors of the rainbow, so have the generator choose between 7 random numbers
                        int randomRainbowColor = colorGenerator.nextInt(7);
                        AquaFish rainbowFish; //Initialize the rainbowFish variable
                        //The if statements below contain the code to create a fish of a certain color based on a random number
                        if(randomRainbowColor == 0)
                            { //Begin make a red fish if random number=0
                                    rainbowFish = new AquaFish(aqua, Color.RED);
                            } //End make a red fish if random number=0
                        else if(randomRainbowColor==1)
                            { //Begin make an orange fish if random number=1
                                rainbowFish = new AquaFish(aqua, Color.ORANGE);
                            } //End make an orange fish if random number=1
                        else if(randomRainbowColor==2)
                            { //Begin make a yellow fish if random number=2
                                rainbowFish = new AquaFish(aqua, Color.YELLOW);
                            } //End make a yellow fish if random number=2
                        else if(randomRainbowColor==3)
                            { //Begin make a green fish if random number=3
                                rainbowFish = new AquaFish(aqua, Color.GREEN);
                            } //End make a green fish if random number=3
                        else if(randomRainbowColor==4)
                            { //Begin make a blue fish if random number=4
                                rainbowFish = new AquaFish(aqua, Color.BLUE);
                            } //End make a blue fish if random number=4
                        else if(randomRainbowColor==5)
                            { //Begin make an indigo fish if random number=5
                                Color indigo = new Color(57, 100, 195); //I looked up the RBG value of indigo on the internet so I could make an indigo fish.
                                rainbowFish = new AquaFish(aqua, indigo);
                            } //End make an indigo fish if random number=5
                        else
                            { //Begin make a violet fish if random number=6
                                Color violet = new Color(102, 51, 153); //I looked up the RBG value for violet on the internet so I could make a violet fish
                                rainbowFish = new AquaFish(aqua, violet);
                            } //End make a violet fish if random number=6
                    }//End making a rainbow fish
                else
                    { //Begin making a random color fish
                        fishyList.add(new AquaFish(aqua, randomColor));
                    } //End making a random color fish
            } //End the fish creator
       
       //Add the fish from the array list to the aquarium
        for(AquaFish allFish : fishyList)
            { //Begin adding fish
                aqua.add(allFish);
            } //End adding fish
            
        // Now wait for the user to press the start button before showing the aquarium.
        userInterface.waitForStart();
        //Draw the initial view of the aquarium and its contents.
        userInterface.showAquarium();
          
        //MAKE THE FISH DO THINGS
        //The user inputs the number of steps. Get the number of steps.
        int numberOfSteps = userInterface.getNumberOfSteps();
        //Make all of the fish move
        for(int s=0; s<numberOfSteps; s++)
            { //Begin making fish move a certain number of times
                for(AquaFish moveFish : fishyList)
                    { //Begin the for loop to move all of the fish
                        //autoChangeDir is a new method in the AquaFish class which 
                        //determines whether or not a fish is at the wall and if it
                        //is forces it to turn around. It also will randomly have
                        //fish change direction. No matter what, it moves the fish
                        //forward one step.
                        moveFish.autoChangeDir();
                    }
                userInterface.showAquarium();
            }// End making the fish move
            
        // Remind user how to quit application.
        userInterface.println ("Close GUI display window to quit.");
    }//end main

}//end class
