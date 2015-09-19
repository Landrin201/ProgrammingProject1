import java.util.Random;
/**
  Assignment Name: Lab 2: A Talking Robot
  
  This class contains methods for constructing a robot
  which will say time-specific phrases.
  
  The robot has eight time blocks for which it has unique phrases: <br>
  Between 0 and 6 the robot will say phrases which are annoyed, as this is the middle of the night. <br>
  Between 6 aand 8 the robot will say phrases related to waking up and getting ready for work. <br>
  Between 8 and 9 the robot will assume the person is late to work, and say phrases related to this scenario. <br>
  Between 9 and 11 the person is presumably at work, so the robot will say phrases related to this. <br>
  Between 11 and 13 it is assumed the person has a lunch break at some point, so the robot say lunch related phrases. <br>
  Between 13 and 17 it is assumed the person is hard at work. Robot says related phrases. <br>
  Between 17 and 20 the person would probably have dinner at some point, so the robot says phraases related to eating dinner. <br>
  Between 20 and 0 the robot tries to get the person to sleep. <br>
  Within each time block there are 4 phrases that the robot can say. It selects a phrase based on a random number generator, which picks a number
  between 0 and 3 at random each time the program is run. This keeps the robot from being too repetative. More phrases can easily be added. 
  <br> <br>
  The text the robot will produce is mostly taken or adapted from
  the video game Bioshock. 
  
  <br> <br>
  Created: <br>
    7 April 2015,  Marc Kuniansky
    <br> <br>
  Modifications: <br>
    7 April 215, Marc Kuniansky, Modified to function as intended. These initial
                 modifications formed the program itself. 
    <br>
  
  @author Marc Kuniansky, (with assistance from)
  @version Version 1, 7 April 2015
  **/
public class TalkingRobot
{ //Begin class

    /** Outputs a random phrase, depending on the time of day
       (at different times of day a different set of random
       phrases are used). <br>
       The time blocks are: <br>
       0-6, 6-8, 8-9, 9-11, 11-13, 13-17, 17-20, and 20-23. <br>
       To add more statements, edit the nested if/else statements. 
       Remember to add more numbers to the random number generator, or 
       the newly added phrases will never display!
       @param  clock   an object that provides the time of day
     **/
    public void sayAPhrase(Clock clock)
    { //Begin sayAPhrase
        //Have the robot identify what time it is and store it as a variable
        int time = clock.getHour();
        //Say what time it is, so that we can be sure the correct phrase is being used.
        System.out.println(time);
        //Construct and store a random number generator
        Random randomGenerator = new Random();
            //Tell the random number generate to generate a number between 0 and 3. This will be used to randomize the phrases used by the robot in each time block, to keep him from being repetative.
            int randomNumber = randomGenerator.nextInt(3);
        //Have the robot determine the time and say phrases based on what time it is.
        //Between midnight and 6am:
        if(time>0 && time<6)
            { //Begin if for 0-6, assume everyone is asleep. Robot doesn't want to be disturbed.
                //Several phrases which will be said if the random number generator generates certain values
                if(randomNumber==0)
                   { //Begin if for random==0
                       System.out.println("Would you kindly not wake me up in the middle of the night?"); //0-6 Phrase 1
                   }//Begin if for random==0
                else if(randomNumber==1)
                    { //Begin if for random==1
                        System.out.println("Go away."); //0-6 Phrase 2
                    } //End if for random==1
                else
                    { //Begin if for random>=2
                        System.out.println("Zzzzzzzzzzzzzzzzzzzzzzz"); //0-6 Phrase 3
                    } //End if for random>=2
            } //End if for 0-06
            
        //Between 6am and 8am, assume the person is waking up and preparing to leave
        else if(time>=6 && time<8)
            { //Begin if for 6-8
                if(randomNumber==0)
                    { //Begin if for random==0
                        System.out.println("Would you kindly wake up and get out of bed?"); //6-8 Phrase 1
                    } //End if for random==0
                else if(randomNumber==1)
                    { //Begin if for random==1
                        System.out.println("Would you kindly make me food, human?"); //6-8 Phrase 2
                    } //End if for random==1
                else if(randomNumber==2)
                    { //Begin if for random==2
                        System.out.println("Would you kindly hurry up and shower? I'm hungry."); //6-8 Phrase 3
                    } //End if for random==2
                else 
                    { //Begin if for random>=3
                        System.out.println("Would you kindly stop doing that and make breakfast? I have important things to do."); //6-8 Phrase 4
                    } //End if for random>=3
            } //End if for 6-8
        
        //Between 8 and 9, assume the person is late for work.
        else if(time>=8 && time<9) 
            { //Begin if for 8-9
                if(randomNumber==0)
                    { //Begin if for random==0
                        System.out.println("We all make choices, but in the end our choices make us... late. Would you kindly hury up?"); //8-9 Phrase 1
                    } //End if for random==0
                else if(randomNumber==1)
                    { //Begin if for random==1
                        System.out.println("Would you kindly stop looking at Facebook and take me to work, human?"); //8-9 Phrase 2
                    } //End if for random==1
                else if(randomNumber==2)
                    { //Begin if for random==2
                        System.out.println("What is the greatest lie ever created? You telling yourself you have ten more minutes."); //8-9 Phrase 3
                    } //End if for random==2
                else 
                    { //Begin if for random>=3
                        System.out.println("How many great catastrophies were launched with the words 'think of yourself?' Think of yourself, you are late."); //8-9 Phrase 4
                    } //End if for random>=3
             } //End if for 8-9
             
        //Between 0 and 11, assume the person is at work. 
        else if(time>=9 && time<11) 
            { //Begin if for 9-11
                if(randomNumber==0)
                    { //Begin if for random==0
                        System.out.println("You are my greatest disappointment."); //10-11 Phrase 1
                    } //End if for random==0
                else if(randomNumber==1)
                    { //Begin if for random==1
                        System.out.println("Would you kindly head to Ryan's office? You have a meeting today."); //9-11 Phrase 2
                    } //End if for random==1
                else if(randomNumber==2)
                    { //Begin if for random==2
                        System.out.println("Even in a book of lies you sometimes find truth."); //9-11 Phrase 3
                    } //End if for random==2
                else 
                    { //Begin if for random>=3
                        System.out.println("OBEY!"); //9-11 Phrase 4
                    } //End if for random>=3
             } //End if for 9-11
             
        //Between 11 and 13 assume the personj is at some point allowed a lunch break. Lunch related phrases.
        else if(time>=11 && time<13) 
            { //Begin if for 11-13
                if(randomNumber==0)
                    { //Begin if for random==0
                        System.out.println("I remember when we put Sauerkraut on that sub. That was the ace in the hole."); //11-13 Phrase 1
                    } //End if for random==0
                else if(randomNumber==1)
                    { //Begin if for random==1
                        System.out.println("Well... breathe deep, so later you might remember the taste."); //11-13 Phrase 2
                    } //End if for random==1
                else if(randomNumber==2)
                    { //Begin if for random==2
                        System.out.println("Would you kindly get me lunch, human? I am hungry."); //11-13 Phrase 3
                    } //End if for random==2
                else 
                    { //Begin if for random>=3
                        System.out.println("I am hungry. We need to eat."); //11-13 Phrase 4
                    } //End if for random>=3
             } //End if for 11-13
             
        //Between 13 and 17 assume the person is working hard.
        else if(time>=13 && time<17) 
            { //Begin if for 13-17
                if(randomNumber==0)
                    { //Begin if for random==0
                        System.out.println("On the surface, I once bought a forest."); //13-17 Phrase 1
                    } //End if for random==0
                else if(randomNumber==1)
                    { //Begin if for random==1
                        System.out.println("When congress moved to nationalize my forest, I burned it to the ground."); //13-17 Phrase 2
                    } //End if for random==1
                else if(randomNumber==2)
                    { //Begin if for random==2
                        System.out.println("God did not plant the seeds of Arcadia. I did."); //13-17 Phrase 3
                    } //End if for random==2
                else 
                    { //Begin if for random>=3
                        System.out.println("The assassin has overcome my final line of defense, and now he plans to murder me."); //13-17 Phrase 4
                    } //End if for random>=3
             } //End if for 13-17
             
        //Between 17 and 18 assume the person is stuck in traffic going home.
        else if(time>=17 && time<18) 
            { //Begin if for 17-18
                if(randomNumber==0)
                    { //Begin if for random==0
                        System.out.println("There's two ways to deal with mystery- uncover it, or eliminate it."); //17-18 Phrase 1
                    } //End if for random==0
                else if(randomNumber==1)
                    { //Begin if for random==1
                        System.out.println("Would you kindly change the station? This song is horrible."); //17-18 Phrase 2
                    } //End if for random==1
                else if(randomNumber==2)
                    { //Begin if for random==2
                        System.out.println("A season for all things... this one happens to be for traffic."); //17-18 Phrase 3
                    } //End if for random==2
                else 
                    { //Begin if for random>=3
                        System.out.println("Would you kindly listen to me tomorrow when I say we need to leave? Traffic is truly awful this time of day."); //17-18 Phrase 4
                    } //End if for random>=3
             } //End if for 17-18
             
        //Between 18 and 20 assume the person will make dinner at some point.
        else if(time>=18 && time<20) 
            { //Begin if for 18-20
                if(randomNumber==0)
                    { //Begin if for random==0
                        System.out.println("Would you kindly make dinner? I'm hungry."); //18-20 Phrase 1
                    } //End if for random==0
                else if(randomNumber==1)
                    { //Begin if for random==1
                        System.out.println("Would you kindly turn off the television and cook? I am hungry, human."); //18-20 Phrase 2
                    } //End if for random==1
                else if(randomNumber==2)
                    { //Begin if for random==2
                        System.out.println("Would you kindly put me down? No, I am not going to shut up. We need food."); //18-20 Phrase 3
                    } //End if for random==2
                else 
                    { //Begin if for random>=3
                        System.out.println("You do realize that there is no off switch? I am part of you. Now go make dinner."); //18-20 Phrase 4
                    } //End if for random>=3
             } //End if for 18-20
             
        //Between 20 and 23 assume the person is preparing for sleep and relaxing before bed.
        else 
            { //Begin if for 20-0
                if(randomNumber==0)
                    { //Begin if for random==0
                        System.out.println("Would you kindly go to sleep? I am tired."); //20-0 Phrase 1
                    } //End if for random==0
                else if(randomNumber==1)
                    { //Begin if for random==1
                        System.out.println("Keeping me awake will not sink Rapture. I can deal with sleep deprivation."); //20-0 Phrase 2
                    } //End if for random==1
                else if(randomNumber==2)
                    { //Begin if for random==2
                        System.out.println("I came to this place to build the impossible. You came to rob me of sleep."); //20-0 Phrase 3
                    } //End if for random==2
                else 
                    { //Begin if for random>=3
                        System.out.println("Sleep."); //20-0 Phrase 4
                    } //End if for random>=3
             } //End if for 20-0
    } //End sayAPhrase
    
    
    /** Outputs a random phrase, depending on the question.
       (For each possible question, a different set of random
       phrases are used).
       @param  question the question asked by the user to which
                           the robot should respond
     **/
    public void respondTo(String question)
    { //Begin respondTo
       //DO NOT MODIFY THIS METHOD DURING LAB!  YOU WILL
       //COMPLETE IT FOR PP#2.
    } //End respondTo
    
}