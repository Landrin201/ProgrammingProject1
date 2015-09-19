import java.util.Random;

/**
 * Talking Robot Programming Project: <br>
 * The SpeechToTextStub class is a "stub" for a class that would
 * listen for questions from the user and convert them to <code>String</code>
 * objects.  This stub class does not do actual speech-to-text 
 * conversion; it actually just returns random questions.
 * <br> <br>
 * Created: <br>
 *   2 April,  Alyce Brady<br>
 * <br>
 * Modifications: <br>
 *   (date), (your name), Modified to (do what? ....) <br>
 * 
 * @author (your name) (with assistance from)
 * @version (a version number or a date)
 */
public class SpeechToTextStub
{// Begin class
    
    /** Returns a (random) question posed by the user.
       The questions generated try to simulate a broad range
       of questions that a real user may ask the robot. As 
       such, a large number of possiblities are available.
       */
    public String getQuestion()
    { //Begin getQuestion
        //Generate a random number between 1 and 25 and store it as a variable.
        Random randomNumber = new Random();
            int randomQuestion = randomNumber.nextInt(13);
        String response = "No Question Yet";
        //Use the random numbers to generate a random question
        //The first 4 questions are name questions.
        response= "No question yet.";
        if(randomQuestion==0)
            { //Begin if rQ==0
                response = "Who are you?";
            } //Begin if rQ==0
        else if(randomQuestion==1)
            { //Begin if rQ==1
                response = "What is your name?";
            } //End if rQ==1
        else if(randomQuestion==2)
            { //Begin if rQ==2
                response = "What did your parents call you?";
            } //End if rQ==2
        //the next ___ questions are "I" questions, where the user asks the robot a question about themselves.
        else if(randomQuestion==3)
            { //Begin if rQ==3
                response = "What is my name?";
            } //End if rQ==3
        else if(randomQuestion==4)
            { //Begin if rQ==4
                response = "What do you think of my clothes?"; //This is written to deliberately not generate an answer.
            } //End if rQ==4
        //The next few questions are about where the robot is from.
        else if(randomQuestion==5)
            { //Begin if rQ==5
                response = "Where are you from?";
            } //End if rQ==5
        else if(randomQuestion==6)
            { //Begin if rQ==6
                response = "Where do you come from?";
            } //End if rq==6
        else if(randomQuestion==7)
            { //Begin if rQ==7
                response = "Where were you born?";
            } //End if rq==7
        //the next set of questions are about the robot's lifestyle.
        else if(randomQuestion==8)
            { //Begin if rQ==8
                response = "Where do you live?";
            } //End if rq==8
        else if(randomQuestion==9)
            { //Begin if rQ==9
                response = "How much money do you have?";
            } //End if rq==9
        //the next questions concern the robots likes/dislikes.
        else if(randomQuestion==10)
            { //Begin if rQ==10
                response = "What is your favorite color?";
            } //End if rq==10
        else if(randomQuestion==11)
            { //Begin if rq==11
                response= "What is Rapture?";
            } //End if rq==11
        else if(randomQuestion==12)
            { //Begin if rQ==12
                response = "What do you do for fun?";
            } //End if rq==12
        else
            { //Begin if rQ==13
                response = "Why are you in a computer?"; //Right now the robot cannot answer this
            } //End if rQ==13
        //System.out.print(response);
        return response;
     } //End getQuestion
} //End class
