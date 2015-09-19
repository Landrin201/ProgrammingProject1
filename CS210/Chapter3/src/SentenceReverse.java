
import jsjf.ArrayStack;
import jsjf.exceptions.*;
import java.util.Scanner;


/*
 * Modifications: June 11 2015, Marc Kuniansky, implemented all methods
 */

/**
 * Takes a user-input sentence and prints it backwards
 * @author Marc Kuniansky
 *
 */
public class SentenceReverse 
{

	/**
	 * Asks for the user to input a sequence of characters and reverses them.
	 * @param args Not used
	 */
	public static void main(String[] args) 
	{
		PostfixEvaluator test = new PostfixEvaluator();
		//Make a scanner to be used for asking for user input
		Scanner scan = new Scanner(System.in);
		
		//Make an array stack to rearrange the letters
		ArrayStack stack = new ArrayStack();
		//Tell the user what to do
		System.out.println("Please input a statement.\n");
		
		//Ask user for input
		String input = scan.nextLine();
		test.evaluate(input);
		System.out.println("Original: " + input + "\n");
		
		char currentChar;
		for(int spot=0; spot<input.length(); spot++)
		{
			currentChar = input.charAt(spot);
			stack.push(currentChar);
		}
		
		System.out.println("Reversed: "+stack.toString());
	}

}
