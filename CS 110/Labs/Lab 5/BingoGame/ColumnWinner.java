
/**
    Project Name: Bingo Game Lab <br>
    This class defines how a player can win by filling up one column with called numbers. 
    <br> <br>
    Created: <br>
        May 5 2015,  Marc Kuniansky
    <br> <br>
    Modifications: <br>
        May 5 2015, Marc Kuniansky, Modified to implement the WinningStrategy interface. Added
                                    the columnChecker and equals methods.<br>
  
    @author Marc Kuniansky
    @version May 5 2015, Version 1
 **/
public class ColumnWinner implements WinningStrategy
{ //Begin class
    
    /**
       This returns the description of how to win using the ColumnWinner strategy.
     */
    public String description()
    { //Begin description
        //Print a description of how to win using this strategy
        return "Win if you fill up one vertical column with called numbers.";
    } //End description
    
    /**
       Returns <code>true</code> if all of the values in any column are marked.
       Returns <code>false</code> if none of the columns are filled.
     */
    public boolean isWinner(BingoCard bingoCard)
    { //Begin isWinner
        int numCols = bingoCard.numCols(); //Get the number of columns in the bingo card
        for(int column=0; column<numCols; column++)
        {
            if(columnChecker(column, bingoCard)==true)
            {
                return true; //If all 5 numbers in a row are filled, then return that the card has a winner.
            }
        }
        return false;
    } //End isWinner
    
    /**
       Returns <code>false</code> if any of the values in any column are not marked.
       If all values in a column are marked, returns <code>true</code>.
     */
    private boolean columnChecker(int columnNumber, BingoCard bingoCard)
    { //Begin columnChecker
        int numRows = bingoCard.numRows(); //Get the number of rows in the bingo card
        for(int row=1; row<numRows; row++)
        { //Begin for loop
            //Get information from insidde of the cell at the desired (row, column) location.
            BingoValueCell cell = bingoCard.getCellAt(row,columnNumber);
            //If any of the cells in a column are not marked, return false.
            if(cell.isMarked()==false)
                return false;
        } //End for loop
        //If all of the cells in a column are marked, return true.
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