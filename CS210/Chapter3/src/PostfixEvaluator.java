import java.util.Stack;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Represents an integer evaluator of postfix expressions. Assumes 
 * the operands are constants.
 *
 * @author Lewis and Chase
 * @version 4.0
 */
public class PostfixEvaluator
{
    private final static char ADD = '+';
    private final static char SUBTRACT = '-';
    private final static char MULTIPLY = '*';
    private final static char DIVIDE = '/';

    private Stack<Integer> stack;

    /**
     * Sets up this evaluator by creating a new stack.
     */
    public PostfixEvaluator()
    {
        stack = new Stack<Integer>();
    }

    /**
     * Evaluates the specified postfix expression. If an operand is
     * encountered, it is pushed onto the stack. If an operator is
     * encountered, two operands are popped, the operation is
     * evaluated, and the result is pushed onto the stack.
     * @param expr string representation of a postfix expression
     * @return value of the given expression
     */
    public int evaluate(String expr)
    {	
    	if(testInput(expr)==false);
    	{
    		System.out.println("Invalid input");
    		//return 0;
    	}
    	
    	int op1, op2, result = 0;
    	String token;
    	Scanner parser = new Scanner(expr);

    	while (parser.hasNext())
    	{
    		token = parser.next();

    		if (isOperator(token))
    		{
    			op2 = (stack.pop()).intValue();
    			op1 = (stack.pop()).intValue();
    			result = evaluateSingleOperator(token.charAt(0), op1, op2);
    			stack.push(new Integer(result));
    		}
    		else
    			stack.push(new Integer(Integer.parseInt(token)));
    	}
    	return result;
    }

    /**
     * Determines if the specified token is an operator.
     * @param token the token to be evaluated 
     * @return true if token is operator
     */
    private boolean isOperator(String token)
    {
        return ( token.equals("+") || token.equals("-") ||
                 token.equals("*") || token.equals("/") );
    }

    /**
     * Peforms integer evaluation on a single expression consisting of 
     * the specified operator and operands.
     * @param operation operation to be performed
     * @param op1 the first operand
     * @param op2 the second operand
     * @return value of the expression
     */
    private int evaluateSingleOperator(char operation, int op1, int op2)
    {
        int result = 0;

        switch (operation)
        {
            case ADD:
                result = op1 + op2;
                break;
            case SUBTRACT:
                result = op1 - op2;
                break;
            case MULTIPLY:
                result = op1 * op2;
                break;
            case DIVIDE:
                result = op1 / op2;
        }

        return result;
    }
    
    private boolean testInput(String input)
    {
    	//Get the length of the string input
    	int length = input.length();
    	
    	//Make sure that if there are any characters in the string, they are lower case
    	input.toLowerCase();
    	//Convert the sting to a character array so we can look at each individual character
    	char[] theChars = input.toCharArray();
    	//Make a variable to increment
    	int spot = 0;
    	//Check every variable to make sure it can be converted to an integer. If it
    	//cannot, then check if it is one of the four operators. If not, return false.
    	while(spot<length-1)
    	{
    		//Get the character from the array at the current spot
    		char currentChar = theChars[spot];
    		//See if the character is a number. If it is, do nothing. If it is one of the defined
    		//characters at the top of the page, do nothing. If it is a letter, return false.
    		if(currentChar==1||currentChar==2 || currentChar==3 || currentChar==4 || currentChar==5 || currentChar==6 || currentChar==7 || currentChar==8 || currentChar==9 || currentChar==0)
    		{
    			//Do nothing in this case
    		}
    		else if(currentChar == ADD)
    		{
    			//Do nothing here
    		}
    		
    		else if(currentChar == SUBTRACT)
    		{
    			//Do nothing here
    		}
    		else if(currentChar == MULTIPLY)
    		{
    			//Do nothing here
    		}
    		else if(currentChar == DIVIDE)
    		{
    			//Do nothing here
    		}
    		else
    			return false;
    			
    		spot++;
    	}
    	
    	return true;
    }
}
