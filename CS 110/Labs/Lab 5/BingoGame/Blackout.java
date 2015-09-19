
/**
    Project Name: Bingo Game Lab <br>
    This class defines how a player can win by filling up the entire card with 
    marked numbers.
    <br> <br>
    Created: <br>
        May 8 2015,  Marc Kuniansky
    <br> <br>
    Modifications: <br>
        May 8 2015, Marc Kuniansky, Modified to implement the WinningStrategy interface. Added
                                    the blackoutChecker and equals methods.<br>
  
    @author Marc Kuniansky
    @version May 8 2015, Version 1
 **/
public class Blackout implements WinningStrategy
{ //Begin class
    
    /**
       This returns the description of how to win using the Blackout strategy.
     */
    public String description()
    { //Begin description
        //Print a description of how to win using this strategy
        return "Win if you fill up your entire card with called numbers.";
    } //End description
    
    /**
       Returns <code>false</code> if any of the values on the card are not marked.
       If all values on the board are marked, returns <code>true</code>.
     */
    public boolean isWinner(BingoCard bingoCard)
    { //Begin isWinner
        //If the board is completely filled, return true
        if(blackoutChecker(bingoCard)==true)
        {
            return true; //If all 5 numbers in a row are filled, then return that the card has a winner.
        }
        //If any spaces on the board are not filled, return false.
        return false;
    } //End isWinner
    
    /**
       Returns <code>false</code> if any of the values on the board are not marked.
       If all values on the board are marked, returns <code>true</code>.
     */
    private boolean blackoutChecker(BingoCard bingoCard)
    { //Begin columnChecker
        for(int row=1; row<bingoCard.numRows(); row++)
        { //Begin for rows loop
            for(int column=0; column<bingoCard.numCols(); column++)
            { //Begin for columns loop
                //Get information from insidde of the cell at the desired (row, column) location.
                BingoValueCell cell = bingoCard.getCellAt(row,column);
                //If any of the cells on the board are not marked, return false.
                if(cell.isMarked()==false)
                    return false;
            } //End for columns loop
        } //End for rows loop
        //If all of the cells on the board are marked, return true.
        return true;
    } //End columnChecker
    
    /**
       Returns a <code>String</code> to tell the user how they won the game.
     */
    public String winningStatement()
    { //Begin winning statement
        return "You filled in a column.";
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