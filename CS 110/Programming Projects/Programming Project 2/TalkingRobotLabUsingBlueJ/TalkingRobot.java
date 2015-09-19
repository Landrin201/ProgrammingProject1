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
  The robot has several categories of questions that it can answer, and they
  are context-based. It will first convert the string from the random question
  to lower-case characters, to make comparisons easier on the program. It then scans
  the question word (who, what, when, where, why, how) to see what kind of question
  it is dealing with, and selects an answer based on other keywords within the answer. <br>
  Please note that due to time constraints, the list of possible questions the robot 
  can answer is very limited. It can answer all of the questions from the list of 
  randomly generated questions.
  <br> <br>
  The text the robot will produce is mostly taken or adapted from
  the video game Bioshock. 
  
  <br> <br>
  Created: <br>
    7 April 2015,  Marc Kuniansky
    <br> <br>
  Modifications: <br>
    7 April 2015, Marc Kuniansky, Modified to say time-specific phrases. This was done by
                                  adding several if...else statements.
    12 April 2015, Marc Kuniansky, Modified to answer questions from a list of 
                                   randomly-selected questions.
    <br>
  
  @author Marc Kuniansky
  @version Version 2, 12 April 2015
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
        //Say what time it is, so that we can be sure the correct phrase is being used. I want it to look pretty, so I made it say the time as a phrase.
        if(time==1)
            {
                System.out.println("It is the "+time+"st hour of the day."); //Because english is weird.
            }
        else if(time==2)
            {
                System.out.println("It is the "+time+"nd hour of the day."); //Again, english is weird.
            }
        else if(time==3)
            {
                System.out.println("It is the "+time+"rd hour of the day."); //English is still weird
            }
        else
            {   
                System.out.println("It is the "+time+"th hour of the day."); //Now we are back to logic.
            }
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
       
       The possible answers are random where it makes sense, and not
       random where it does not (there is only one answer for "What is 
       your name?" for example). They are separated into nested if 
       statements, and the if statements are written to be somewhat 
       broad to avoid manipulation.
       
       @param  question the question asked by the user to which
                           the robot should respond
     **/
    public void respondTo(String question)
    { //Begin respondTo
        System.out.println(question);
        String theQuestion = question.toLowerCase(); //Make the question lower case to avoid confusion later, and store it to theQuestion.
        String theAnswer = "I have nothing to say to you."; //Make the variable theAnswer, where the answer will be stored.
        Random randomNumber = new Random(); //Make a random number which can be called on later for use in random responses. I define how many integer the generator can choose from within the if statements.
        //Right now there is only one super-specific answer which requires an exact question. It is the first answer, so that the program rules it out before doing anything else.
        if(theQuestion.equals("what is rapture?"))
            {//Begin one spcific answer
                theAnswer= "Rapture is my city, safe from the parasites of the overworld, hidden deep within the ocean to protect us from the bomb.";
            }//End one specific answer
        else if(theQuestion.contains("what "))
        {//Start if for keyword What
            if(theQuestion.contains(" your ") || theQuestion.contains(" you"))
                { //Start if for "what" questions about the robot.
                    if(theQuestion.contains(" name"))
                        { //Start if for questions about the robot's name.
                            int randomAnswer6= randomNumber.nextInt(3); //Make a random number to help select a random answer. This is contained in the if loop so that more numbers can be added to this section, but not effect other loops that rely on random numbers.
                            if(randomAnswer6==0)
                                { 
                                    theAnswer = "My name is Andrew Ryan.";
                                }
                            else if(randomAnswer6==1)
                                {
                                    theAnswer = "Some call me Andrew Ryan. Some call me Brilliant. Some have even called me god.";
                                }
                            else
                                {
                                    theAnswer = "You can call me Andrew Ryan.";
                                }
                        } //End if for name questions.
                     else if(theQuestion.contains(" called") || theQuestion.contains(" call "))
                        { //Begin if for more questions about the robot's name
                            theAnswer= "Andrew Ryan.";
                        } //End if for more questions about the robot's name
                     else if(theQuestion.contains(" favorite "))
                        {//Start if for favorite questions
                            if(theQuestion.contains(" color "))
                                {//Start if for questions about colors
                                    theAnswer = "What does it matter? In my city, you can make whatever colors you want.";
                                }//End if for color questions
                            else if(theQuestion.contains(" food") || theQuestion.contains(" eat") || theQuestion.contains(" dinner") ||theQuestion.contains(" breakfast") || theQuestion.contains(" lunch") || theQuestion.contains(" brunch"))
                                {//Begin answers for questions about food
                                    theAnswer = "All I need to consume is Adam, for science has made a compound which can help me transcend life.";
                                }//End answers for food questions
                            else if(theQuestion.contains(" band ") || theQuestion.contains(" music") || theQuestion.contains(" song") || theQuestion.contains(" album") || theQuestion.contains(" artist") || theQuestion.contains(" musician") ||theQuestion.contains(" instrument"))
                                { //Begin answers for questions about music
                                    theAnswer = "Music is a contemptible romanticism that has no place in a scientific society. Only the weak would ask such a question. And yet, even musicians are allowed in my city.";
                                } //End answers for questions about music
                        }//End favorite answers
                else if(theQuestion.contains(" fun"))
                    { //Begin for questions about what the robot does for fun
                        int randomAnswer= randomNumber.nextInt(3); //Random number for 3 possible random answers
                        if(randomAnswer==0)
                            {
                                theAnswer= "I pursue many projects in my spare time, one of which happens to be killing you, assassin.";
                            }
                        if(randomAnswer==1)
                            {
                                theAnswer= "I rather enjoy ballroom dancing and crusing Atlas's rebellion.";
                            }
                        if(randomAnswer==2)
                            {
                                theAnswer="I enjoy the social life of the city I created.";
                            }
                    } //End questions about what the robot does for fun
                else if(theQuestion.contains(" doing"))
                    { //Begin answers for what the robot is doing
                        int randomAnswer1 = randomNumber.nextInt(3); //Random number for 3 possible random answers
                        if(randomAnswer1==0)
                        { //Begin first random answer
                            theAnswer= "I am choosing how to deal with you. Would you kindly leave me be?";
                        } //End first random answer
                        else if(randomAnswer1==1)
                        { //Begin second random answer
                            theAnswer = "I an envisioning a country for men like me. Men who refuse to say yes to the parasites and doubters, men who believe that work is sacred and property rights inviolate.";
                        }//End second random answer
                        else
                        { //Begin third random answer
                            theAnswer = "I am trying to find Atlas, the one roach I can't seem to exterminate.";
                        } //End third random answer
                    }//End questions about what the robot is doing
                else if(theQuestion.contains(" me "))
                {//Eegin answers about the robot's relationship with the user
                    int randomAnswer2 = randomNumber.nextInt(4); //Random number for 4 possible random answers.
                    if(randomAnswer2==0)
                    {//Begin first random answer
                        theAnswer= "I have no opinion.";
                    }//end first random answer
                    else if(randomAnswer2==1)
                    { //Begin second random answer
                        theAnswer= "A man chooses. A slave obeys. Do you choose, or do you obey?";
                    } //End second random answer
                    else if(randomAnswer2==2)
                    { //Begin third random answer
                        theAnswer= "Are you a man? Or are you a parasite?";
                    } //End third random answer
                    else
                    { //Begin fourth random answer
                        theAnswer= "You are a horrible assassin.";
                    } //End fourth random answer
                }//End answers about the robots relationship with the user
            }//End answers to questions about the robot
            else if(theQuestion.contains(" my ") || theQuestion.contains(" mine ") || theQuestion.contains(" i ") || theQuestion.contains(" me "))
                { //Begin answers to questions about the user
                    if(theQuestion.contains(" think of "))
                        { //Begin answers to questions about what the robot thinks of the traits of the user
                                int randomAnswer3 = randomNumber.nextInt(3); //Random number for 3 possible random answers
                                if(randomAnswer3==0)
                                    { 
                                        theAnswer= "I have no opinion.";
                                    }
                                else if(randomAnswer3==1)
                                    {
                                        theAnswer= "I couldn't care less.";
                                    }
                                else
                                    {
                                        theAnswer= "Please stop asking me about yourself.";
                                    }
                        }//End answers to questions about what the robot thinks of the traits of the user
                    else if(theQuestion.contains(" want"))
                        {//Begin answers to questions about what the user wants
                            int randomAnswer4 = randomNumber.nextInt(2); //Random number for 2 possible random answers
                            if(randomAnswer4== 0)
                                {
                                    theAnswer= "How should I know what you desire?";
                                }
                            if(randomAnswer4==1)
                            {
                                theAnswer= "Would you knindly not ask me stupid questions? I tire of them.";
                            }
                        } //End answers to questions about what the user wants
                    else if(theQuestion.contains(" favorite"))
                        {
                            theAnswer= "I don't know you, human. You are a parasite to my vast intellect. Stop asking me stupid questions.";
                        }
                    else if(theQuestion.contains(" think"))
                        {
                            theAnswer= "You think you gave memories.";
                        }
                    if(theQuestion.contains(" name"))
                        {
                            theAnswer= "I do not know your name, nor do I care to.";
                        }
                } //End answers to questions about the user
            else
                { //Begin final else loop, for questions which do not have an answer as specified above to a "what" question
                    int randomRejection= randomNumber.nextInt(3); //Random number for 3 possible random answers
                    if(randomRejection==0)
                        {
                            theAnswer= "Would you kindly ask me a legitimate question?";
                        }
                    else if(randomRejection==1)
                        {
                            theAnswer = "Please stop wasting my time. I have important things to do. Ask me a real question or go away.";
                        }
                    else
                        {
                            theAnswer= "You are a parasite on my time. Your questions are pointless.";
                        }
                } //End answers for which the robot does not have an answer
        }//End "What" answers
        else if(theQuestion.contains("how "))
        {//Begin "How" answers
            if(theQuestion.contains(" are you "))
                {//Begin answers to "How are you?"
                    int randomAnswer5 = randomNumber.nextInt(3); //Random number for 3 possible random answers
                    if(randomAnswer5==0)
                        {
                            theAnswer= "I have no feelings. I have trancended such inferior mortality.";    
                        }
                    else if(randomAnswer5==1)
                        {
                            theAnswer= "I am.";
                        }
                    else
                        {
                            theAnswer= "My strength is not in steel and fire. This you will never understand.";
                        }
                } //End answers to "How are you?"
            else if(theQuestion.contains(" much"))
                { //Begin questions about how much of somethign the robot has
                    if(theQuestion.contains(" money"))
                        { //Begin answers to questions about money
                            int randomAnswer4 = randomNumber.nextInt(3); //Random number for 3 possible random answers
                            if(randomAnswer4==0)
                                {
                                    theAnswer= "Material wealth is nothing in my city. Each man gets what he needs... and creates what he wants." ;
                                }
                                    else if(randomAnswer4==1)
                                {
                                    theAnswer= "I need no money, for in Rapture all I need are my fellow scientists.";
                                }
                            else if(randomAnswer4==2)
                                {
                                    theAnswer= "Only the Bougouis would ask such an inconsequential question here, in my city of gods.";
                                }
                        } //End answers to questions about money
                }// End questions about how much of something the robot has
            else if(theQuestion.contains(" old ") && theQuestion.contains("you"))
                {// Begin answer about age
                    theAnswer= "Age is unimportant. But as it will shut you up, I am 114.";
                }//End answer about age
            else
                { //Begin final else loop, for questions which do not have an answer as specified above
                    int randomRejection= randomNumber.nextInt(3); //Random number for 3 possible random answers
                    if(randomRejection==0)
                        {
                            theAnswer= "Would you kindly ask me a legitimate question?";
                        }
                    else if(randomRejection==1)
                        {
                            theAnswer = "Please stop wasting my time. I have important things to do. Ask me a real question or go away.";
                        }
                    else
                        {
                            theAnswer= "You are a parasite on my time. Your questions are pointless.";
                        }
                } //End final else
        }//End "How" answers.
        
        else if(theQuestion.contains("when "))
        {//Begin "When" questions.
            if(theQuestion.contains(" you ") && theQuestion.contains("born"))
                { //Begin answer about when the robot was born
                    theAnswer="1911.";
                } //End answer about when the robot was born
            else if(theQuestion.contains(" build ") && theQuestion.contains(" rapture"))
                { //Begin answer about when Rapture was built
                    theAnswer="My great city was ready for uman habitation in 1946.";
                } //End answer about when Rapture was built
            else
                { //Begin final else loop, for questions which do not have an answer as specified above
                    int randomRejection= randomNumber.nextInt(3); //Random number for 3 possible random answers
                    if(randomRejection==0)
                        {
                            theAnswer= "Would you kindly ask me a legitimate question?";
                        }
                    else if(randomRejection==1)
                        {
                            theAnswer = "Please stop wasting my time. I have important things to do. Ask me a real question or go away.";
                        }
                    else
                        {
                            theAnswer= "You are a parasite on my time. Your questions are pointless.";
                        }
                } //End final else
        }//End "When" questions.
        
        else if(theQuestion.contains("where "))
        {//Begin "Where" questions
            if(theQuestion.contains(" you "))
                if(theQuestion.contains(" born"))
                    { //Begin answer for where the robot is from.
                        theAnswer= "I was born in Russia. I left shortly after the parasites took over. I went to America... to find the parasites there, too. So I built my own nation.";
                    } //End answer for where the robot is from.
                else if(theQuestion.contains(" you") && theQuestion.contains(" from"))
                {
                    theAnswer="I am from Russia.";
                }
                else if(theQuestion.contains(" live"))
                { //Begin the answer for where the robot lives
                    theAnswer= "I live in Rapture, a city that I built to be free of the bonds of other nations. A city of free men.";
                } //End answer for where the robot lives.
            else
                { //Begin final else loop, for questions which do not have an answer as specified above
                    int randomRejection= randomNumber.nextInt(3); //Random number for 3 possible random answers
                    if(randomRejection==0)
                        {
                            theAnswer= "Would you kindly ask me a legitimate question?";
                        }
                    else if(randomRejection==1)
                        {
                            theAnswer = "Please stop wasting my time. I have important things to do. Ask me a real question or go away.";
                        }
                    else
                        {
                            theAnswer= "You are a parasite on my time. Your questions are pointless.";
                        }
                } //End final else
        }
        else if(theQuestion.contains("who "))
        {//Begin "Who" questions
            if(theQuestion.contains("are you"))
                {
                    theAnswer="I am Andrew Ryan.";
                }
            else
                { //Begin final else loop, for questions which do not have an answer as specified above
                    int randomRejection= randomNumber.nextInt(3); //Random number for 3 possible random answers
                    if(randomRejection==0)
                        {
                            theAnswer= "Would you kindly ask me a legitimate question?";
                        }
                    else if(randomRejection==1)
                        {
                            theAnswer = "Please stop wasting my time. I have important things to do. Ask me a real question or go away.";
                        }
                    else
                        {
                            theAnswer= "You are a parasite on my time. Your questions are pointless.";
                        }
                } //End final else
        }//End "Who" questions.
        else //If a non valid question is asked, one of these three answers should be displayed. 
            { //Begin final else loop, for questions which do not have an answer as specified above
                int randomRejection= randomNumber.nextInt(3); //Random number ofr 3 possible random answers
                if(randomRejection==0)
                    {
                        theAnswer= "Would you kindly ask me a legitimate question?";
                    }
                else if(randomRejection==1)
                    {
                        theAnswer = "Please stop wasting my time. I have important things to do. Ask me a real question or go away.";
                    }
                else
                    {
                        theAnswer= "You are a parasite on my time. Your questions are pointless.";
                    }
            } //End final else
     System.out.println(theAnswer);
    } //End respondTo
    
}