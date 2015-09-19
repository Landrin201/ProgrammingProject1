
/**
 * Project Name: Bingo Game Lab <br>
 * This class defines how a player can win by filling up all four corners with 
 * called numbers. 
 * <br> <br>
 * Created: <br>
 * May 7 2015,  Marc Kuniansky
 * <br> <br>
 * Modifications: <br>
 * May 7 2015, Marc Kuniansky, Modified to implement the WinningStrategy interface. Added
 *                             the cornerChecker and equals methods.<br>

 * @author Marc Kuniansky
 * @version May 7 2015, Version 1
 **/
public class CornerWinner implements WinningStrategy
{ //Begin class
    /**
       This returns the description of how to win using the CornerWinner strategy.
     */
    public String description()
    { //Begin description
        //Print a description of how to win using this strategy
        return "Win if you fill up all four corners of the board with called numbers.";
    } //End description

    /**
       Returns <code>true</code> if the values in all four corners are not marked.
       If any value in any of the corners is not marked, returns <code>false</code>.
     */
    public boolean isWinner(BingoCard bingoCard)
    { //Begin isWinner
        //If the cell in each of the corners is marked, then return true.
        if(cornerChecker(bingoCard, 1, 0)==true && cornerChecker(bingoCard, 1, bingoCard.numCols()-1)==true && cornerChecker(bingoCard, bingoCard.numRows()-1, 0)==true && cornerChecker(bingoCard, bingoCard.numRows()-1, bingoCard.numCols()-1)==true)
        {
            return true; //If all 5 numbers in a row are filled, then return that the card has a winner.
        }
        return false;
    } //End isWinner

    /**
       Returns <code>false</code> if any of the values in a corner are not marked.
       If the value in a corner is marked, returns <code>true</code>.
     */
    private boolean cornerChecker(BingoCard bingoCard, int row, int column)
    { //Begin cornerChecker
        int numRows = bingoCard.numRows(); //Get the number of rows in the bingo card
        //Get the cell at the (row, column) desired.
        BingoValueCell cell = bingoCard.getCellAt(row,column);
        //If any cell in a row is not marked, return false.
        if(cell.isMarked()==false)
            return false;
        //If all of the corner cells are marked, return true
        return true;
    } //End cornerChecker

    /**
       Returns a statement to tell the user how they won the game.
     */
    public String winningStatement()
    { //Begin winning statement
        return "You filled in all of the corners.";
    } //End winning statement

    /**
       This method will cause any two objects of this strategy class to be treated as equal.
     */
    public boolean equals(Object obj)
    { //Begin equals
        if (obj instanceof ColumnWinner)
            return true;
        return false;
    } //End equals
} //End class