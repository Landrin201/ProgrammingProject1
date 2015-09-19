import edu.kzoo.grid.Location;
/**
    Project Name: Bingo Game Lab <br>
    This class defines how a player can win by filling up one column with called numbers. The player cannot
    win with the free space.
    <br> <br>
    Created: <br>
        May 8 2015,  Marc Kuniansky
    <br> <br>
    Modifications: <br>
        May 8 2015, Marc Kuniansky, Modified to implement the WinningStrategy interface. Added
                                    the columnChecker and equals methods.<br>
  
    @author Marc Kuniansky
    @version May 8 2015, Version 1
 **/
public class HardColumnWinner implements WinningStrategy
{ //Begin class
    
    /**
       This returns the description of how to win using the HardColumnWinner strategy.
     */
    public String description()
    { //Begin description
        //Print a description of how to win using this strategy
        return "Win if you fill up one vertical column with called numbers. You cannot win using the free space.";
    } //End description
    
    /**
       Returns <code>true</code> if all of the values in any column are marked and the column does not contain
       the free space.
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
       Returns <code>false</code> if any of the values in any column are not marked or if the 
       free space is in the column.
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
            //Get the location of the free  space, which is located at the center of the board.
            Location centerLocation = new Location(bingoCard.numRows()/2, bingoCard.numCols()/2);
            //If the free space is in the column, the card does not win.
            if(cell.location()==centerLocation)
                return false;
        } //end for loop
        //If all of the cells in a column are marked, return true.
        return true;
    } //End columnChecker
    
    /**
       Returns a <code>String</code> to tell the user how they won the game.
     */
    public String winningStatement()
    { //Begin winning statement
        return "You filled in a column without using the free space.";
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