
/**
  Talking Robot Lab:Lab 2: A Talking Robot
  
  The RobotLabApp class contains the main method for the Talking Robot
  Program for Lab 2. It will construct a robot and have it say time-specific
  phrases. The robot will also answer questions which are asked of it. Currently, 
  the questions are randomly selected from a list and are not based on user-imput. 
  <br> <br>
  The main method first constructs a clock which generates a random time between 0 and 23.
  It then constructs a talking robot. It then calls on several functions from the TalkingRobot 
  class, which will print several things. First, the time is printed, as is a time-specific
  phrase. Then, 3 questions are printed, as are their generated answers.
  <br> <br>
  Please note that some of the questions only have one answer! For some questions, such as
  "Where are you from," it didn't make sense to give the robot multiple answers.
  Created: <br>
    2 April,  Alyce Brady
    <br> <br>
  Modifications: <br>
    7 April 2015, Marc Kuniansky, Modified to say time specific phrases based on a randomly generated time. <br>
    12 April 2015 Marc Kuniansky, Modified to answer randomly generated questions. <br>
  @author Marc Kuniansky (with assistance from)
  @version Version 2, 12 April 2015
  **/
public class RobotLabApp
{ //Begin class
    /**
       This is the main function that starts the execution of the
       Talking Robot program, which will say several different things.
       <br>
       It constructs a robot, and tells it to say
       a time-specific phrase. It then has the robot answer three
       randomly selected questions.
       @param    String[] args is not used in this program
     **/
    public static void main(String[] args)
    { //Begin main
        //Print a greeting to the user.
        System.out.println ("Welcome to Ryan Bot.");
        //Create a talking robot and store it as a variable
        TalkingRobot ryanBot = new TalkingRobot();
        
        //This line is just here to make it look nice in the display window.
        System.out.println("__________________________________________________________");
        //Have the robot say a phrase
        ryanBot.sayAPhrase();
        
        //Add a separator line, to make it look nicer.
        
        System.out.println("__________________________________________________________");
        
        //Question part
        int numberQuestions = 15;
        for(int i=0; i<numberQuestions; i++)
            {
                ryanBot.respondTo();
            }
        //Add another separator line, again to make it look nicer.
        System.out.println("__________________________________________________________");
            //Print a message to the user to show that the program has finished.
        System.out.println ("Is that all?");
    }  // End main
} //End class
