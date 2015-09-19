
/**
    Project Name: Bingo Game Lab <br>
    This class defines how a player can win by filling up one diagonal with called numbers. 
    <br> <br>
    Created: <br>
        May 7 2015,  Marc Kuniansky
    <br> <br>
    Modifications: <br>
        May 7 2015, Marc Kuniansky, Modified to implement the WinningStrategy interface. Added
                                    the dorwardDiagonalChecker, reverseDiagonalChecker, and equals methods.<br>
  
    @author Marc Kuniansky
    @version May 7 2015, Version 1
 **/
public class DiagonalWinner implements WinningStrategy
{ //Begin class
    
    /**
       This returns the description of how to win using the DiagonalWinner strategy.
     */
    public String description()
    { //Begin description
        //Print a description of how to win using this strategy
        return "Win if you fill up one diagonal with called numbers.";
    } //End description
    
    /**
       Returns <code>true</code> if all of the values in any diagonal are marked.
       If any value in a diagonal is not marked, returns <code>false</code>.
     */
    public boolean isWinner(BingoCard bingoCard)
    { //Begin isWinner
        if(forwardDiagonalChecker(bingoCard)==true || reverseDiagonalChecker(bingoCard)==true)
        { //Begin boolean check
            return true; //If all 5 numbers in a diagonalare filled, then return that the card has a winner.
        } //End boolean check
        return false;
    } //End isWinner
    
    /**
       Returns <code>false</code> if any of the values in any forward diagonal are not marked.
       If all values in a forward diagonal are marked, returns <code>true</code>.
     */
    private boolean forwardDiagonalChecker(BingoCard bingoCard)
    { //Begin forward diagonal checker
        for(int row=1; row<bingoCard.numRows(); row++)
        { //Begin for rows
            for(int column=0; column<bingoCard.numCols(); column++)
            { //Begin for columns
                if((row-1)==column)
                { //Begin if statement
                    //Get the cell at the desired location
                    BingoValueCell cell = bingoCard.getCellAt(row, column);
                    //If the cell is not marked, return false.
                    if(cell.isMarked()==false)
                    { //Begin if CellIsMarked statement
                        return false;
                    } //End if CellIsMarked statment
                } //End if statement
            } //End for columns
        } //End for rows
        //If all values along the diagonal are marked, then return true
        return true;
    } //End forward diagonal checker
    
    /**
       Returns <code>false</code> if any of the values in any reverse diagonal are not marked.
       If all values in a reverse diagonal are marked, returns <code>true</code>.
     */
    private boolean reverseDiagonalChecker(BingoCard bingoCard)
    { //Begin reverse diagonal checker
        for(int row=1; row<bingoCard.numRows(); row++)
        { //Begin for rows loop
            for(int column=bingoCard.numCols()-1; column>=0; column--)
            { //Begin for columns loop
                int numColumns=bingoCard.numCols()-1; //I need the location of the last column
                if(numColumns==(row-1)+column)
                { //Begin if statement
                    //Get the cell at the desired location
                    BingoValueCell cell = bingoCard.getCellAt(row, column);
                    if(cell.isMarked()==false)
                    { //Begin if CellIsMarked statement
                        //Return false if any of the blocks on the diagonal are not marked.
                        return false;
                    } //End if CellIsMarked statment
                } //End if statement
            } //End for columns loop
        } //End for rows loop
        //If all values along the diagonal are marked, return true
        return true;
    } //End reverse diagonal checker
    
    /**
       Returns a <code>String</code> to tell the user how they won the game.
     */
    public String winningStatement()
    { //Begin winning statement
        return "You filled in a diagonal.";
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