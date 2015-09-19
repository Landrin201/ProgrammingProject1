
/**
 * Project Name: Bingo Game Lab <br>
 * This class defines how a player can win by filling up the perimeter with called numbers. 
 * <br> <br>
 * Created: <br>
 * May 8 2015,  Marc Kuniansky
 * <br> <br>
 * Modifications: <br>
 * May 8 2015, Marc Kuniansky, Modified to implement the WinningStrategy interface. Added
 *                             the rowChecker and equals methods.<br>

 * @author Marc Kuniansky
 * @version May 8 2015, Version 1
 **/
public class Perimeter implements WinningStrategy
{ //Begin class

    /**
     * This returns the description of how to win using the Perimeter strategy.
     */
    public String description()
    { //Begin description
        //Print a description of how to win using this strategy
        return "Win if you fill up all of the spaces allong the perimeter of your card row with called numbers.";
    } //End description

    /**
     * Returns <code>true</code> if all of the values in all of the values 
     * along the perimeter are marked.
     */
    public boolean isWinner(BingoCard bingoCard)
    { //Begin isWinner
        if(perimeterChecker(bingoCard)==true)
        { //Begin if statement
            //If all numbers on the perimeter are filled, then return that the card has a winner.
            return true; 
        } //End if statement
        return false; //If all 5 numbers are not filled, return false.
    } //End isWinner

    /**
     * Return <code>false</code> if any of the cells in a row are not marked.
     * Returns <code> true</code> if all cells in a row are marked.
     */
    private boolean perimeterChecker(BingoCard bingoCard)
    { //Begin row checker
        for(int row=1; row<bingoCard.numRows(); row++)
        { //Begin for rows loop
            for(int column=0; column<bingoCard.numCols(); column++)
            { //Begin for columns loop
                if(row==1)
                { //Begin if statement for top row
                    //Get the cell at the (row, column) desired.
                    BingoValueCell cell = bingoCard.getCellAt(row,column);
                    //If any cell in a row is not marked, return false.
                    if(cell.isMarked()==false)
                        return false;
                } //End if statement for top row
                if(row==bingoCard.numRows()-1)
                { //Begin if statement for bottom row
                    //Get the cell at the (row, column) desired.
                    BingoValueCell cell = bingoCard.getCellAt(row,column);
                    //If any cell in a row is not marked, return false.
                    if(cell.isMarked()==false)
                        return false;
                } //End if statement for bottom row
                if(column==0)
                { //Begin if statement for left column
                    //Get the cell at the (row, column) desired.
                    BingoValueCell cell = bingoCard.getCellAt(row,column);
                    //If any cell in a row is not marked, return false.
                    if(cell.isMarked()==false)
                        return false;
                } //End if statement for left column
                if(column==bingoCard.numCols()-1)
                { //Begin if statement for right column
                    //Get the cell at the (row, column) desired.
                    BingoValueCell cell = bingoCard.getCellAt(row,column);
                    //If any cell in a row is not marked, return false.
                    if(cell.isMarked()==false)
                        return false;
                } //End if statement for right column
            } //End for columns loop
        } //End for rows loop
        //If all of the cells in a row are marked, return true.
        return true;
    } //End row checker

    /**
     * Returns a <code>String</code> to tell the user how they won.
     */
    public String winningStatement()
    { //Begin winning statement
        return "You filled in the perimeter of your card.";
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
