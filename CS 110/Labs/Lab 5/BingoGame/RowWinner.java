
/**
  Project Name: Bingo Game Lab <br>
  This class defines how a player can win by filling up one row with called numbers. 
  <br> <br>
  Created: <br>
    May 5 2015,  Marc Kuniansky
    <br> <br>
  Modifications: <br>
    May 5 2015, Marc Kuniansky, Modified to implement the WinningStrategy interface. Added
                                the rowChecker and equals methods.<br>
  
  @author Marc Kuniansky
  @version May 5 2015, Version 1
 **/
public class RowWinner implements WinningStrategy
{ //Begin class
    
    /**
       This returns the description of how to win using the RowWinner strategy.
     */
    public String description()
    { //Begin description
        //Print a description of how to win using this strategy
        return "Win if you fill up one horizontal row with called numbers.";
    } //End description
    
    /**
       Returns <code>true</code> if all of the values in any row are marked.
     */
    public boolean isWinner(BingoCard bingoCard)
    { //Begin isWinner
        int numRows=bingoCard.numRows();
        for(int row=1; row<numRows; row++)
        { //Begin for rows loop
            if(rowChecker(row, bingoCard)==true)
            { //Begin if statement
                return true; //If all 5 numbers in a row are filled, then return that the card has a winner.
            } //End if statement
        } //End for rows loop
        return false; //If all 5 numbers are not filled, return false.
    } //End isWinner
    
    /**
       Return <code>false</code> if any of the cells in a row are not marked.
       Returns <code> true</code> if all cells in a row are marked.
     */
    private boolean rowChecker(int rowNumber, BingoCard bingoCard)
    { //Begin row checker
        //Get the number of columns
        int numCols = bingoCard.numCols();
        for(int column=0; column<numCols; column++)
        { //Begin for columns loop
            //Get the cell at the (row, column) desired.
            BingoValueCell cell = bingoCard.getCellAt(rowNumber,column);
            //If any cell in a row is not marked, return false.
            if(cell.isMarked()==false)
                return false;
        } //End for columns loop
        //If all of the cells in a row are marked, return true.
        return true;
    } //End row checker
    
    /**
       Returns a <code>String</code> to tell the user how they won.
     */
    public String winningStatement()
    { //Begin winning statement
        return "You filled in a row.";
    } //End winning statement
    
    /**
       This method will cause any two objects of this strategy class to be treated as equal.
     */
    public boolean equals(Object obj)
    { //Begin equals
        if (obj instanceof RowWinner)
            return true;
        return false;
    } //End equals
} //End class
