/**
  The TicTacToeBoardPrinter class will generate a 4x4 tic tac toe board with text characters. 
  <br> <br>
  Created: 
  <br>
    31 March 2015,  Marc Kuniansky
    <br> <br>
  Modifications: 
  <br>
    31 March 2015, Marc Kuniansky, modified to print a message on the screen. 
    <br>
  @author Marc Kuniansky. Message is a quote from the film V for Vendetta.
  @version 31 March 2015
 */

public class TicTacToeBoardPrinter
{ //Begin class
    /**
       This is the main function for TicTacToeBoardPrinter, 
       which prints a 5 square by 5 square tic tac toe board. It prints the board 
       by printing individua lines of text, which correspond 
       to the horizontal and vertical lines of the board.
       @param    String args[] is never used
     */
    public static void main(String[] args)
    { //Begin main
        //Add first row, establishing corners and the size of the squares.
        System.out.println("+---+---+---+---+---+");
        //Add the vertical component to the boxes.
        System.out.println("|   |   |   |   |   |");
        //Repeat until done.
        System.out.println("+---+---+---+---+---+");
        System.out.println("|   |   |   |   |   |");
        System.out.println("+---+---+---+---+---+");
        System.out.println("|   |   |   |   |   |");
        System.out.println("+---+---+---+---+---+");
        System.out.println("|   |   |   |   |   |");
        System.out.println("+---+---+---+---+---+");
        System.out.println("|   |   |   |   |   |");
        System.out.println("+---+---+---+---+---+");
    }//End main

} //End class
