
/**
  Talking Robot Lab:Lab 2: A Talking Robot
  
  The RobotLabApp class contains the main method for the Talking Robot
  Program for Lab 2. It will construct a robot and have it say time-specific
  phrases. <br>
  
  The main method first constructs a clock which generates a random time between 0 and 23.
  It then constructs a talking robot. The program prints the time,allowing us to see 
  that the time specific statements are working properly. It then has the robot say
  one of its time-specific statements based on the clock's time.
  <br> <br>
  Created: <br>
    2 April,  Alyce Brady
    <br> <br>
  Modifications: <br>
    7 April 2015, Marc Kuniansky, Modified to (do what? ....) <br>
  
  @author Marc Kuniansky (with assistance from)
  @version Version 1, 7 April 2017
  **/
public class RobotLabApp
{ //Begin class
    /**
       This is the main function that starts the execution of the
       Talking Robot program for Lab 2. <br>
       It first constructs a clock, then a robot, then uses the clock
       to tell the robot to say a phrase.
       @param    String[] args is not used in this program
     **/
    public static void main(String[] args)
    { //Begin main
        //Print a greeting to the user.
        System.out.println ("Welcome to Ryan Bot.");
        
        //Create a clock which will be used by the robot to tell time.
        Clock timeCheck = new Clock();
        //Create a talking robot and store it as a variable
        TalkingRobot bioBot = new TalkingRobot();
        
        //Have the robot say a phrase
        bioBot.sayAPhrase(timeCheck);
        
        //Print a message to the user to show that the program has finished.
        System.out.println ("Obey.");
    }  // End main
} //End class
