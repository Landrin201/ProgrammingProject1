import java.awt.Color;
import java.util.Random;

import edu.kzoo.grid.BoundedGrid;
import edu.kzoo.grid.Location;
import edu.kzoo.grid.TextCell;

/**
 *  Bingo Game:<br>
 *
 *  A BingoCard object represents a card with random numbers (but no
 *  duplicates) that can be used for a game of bingo. 
 *  <br> <br>
 *  
 *  Modifications: <br>
 *  May 7 2015, Marc Kuniansky, Added code to add BINGO across the top of the card.
 *                              Implemented indicateCardWon(), and replced the stub
 *                              code in initiCol() and getUnusedRandomNumber() to 
 *                              function as intended. 
 *
 *  @author Marc Kuniansky, with assistance from Alyce Brady and Pam Cutter
 *  @version May 7, 2015
 */
public class BingoCard extends BoundedGrid
{
    // Private constants defined for use in this class.
    private static final String BINGO = "BINGO";
    private static final int NUMROWS = BINGO.length()+1;
    private static final int NUMCOLS = BINGO.length();

    // Instance variables: Encapsulated data for each BingoCard object
    private Random randNumGenerator; //Generates a random number
    private int max_value;
    private int subrange_size;
    private boolean[] numUsed;   // numUsed[i] = true indicates that i has
    //   been used already on this card;
    //   numUsed[0] is ignored because 0 is not
    //   a valid Bingo value.

    /** 
       Constructs a new BingoCard object containing numbers in
       the range of 1 -- max_value.
     */
    public BingoCard(int max_value)
    {
        super(NUMROWS, NUMCOLS);

        // Initialize instance variables.
        this.randNumGenerator = new Random();
        this.max_value = max_value;
        this.subrange_size = max_value / BINGO.length();

        // The numUsed array is initialized at the beginning of each round
        // of play, so is not initialized here.
    }

    /**
        Set up (or reset) the card with column headings
        and random Bingo values.
     */
    public void initialize()
    {
        // Clear the results from a previous game.
        removeAll();  // this method is inherited from BoundedGrid
        //Add the letters of BINGO to the top row of the grid.
        for(int i=0; i<BINGO.length(); i++)
        {
            //Get the letter to put into the i'th cell.
            String letter = BINGO.substring(i, i+1);
            //Make a new text cell with the letter inside of it
            TextCell theCell = new TextCell(letter, Color.WHITE);
            //Specify the location of the new cell
            Location location = new Location(0, i);
            //Add the cell to the grid.
            this.add(theCell, location);
        }
        // Set (or reset) the array used to check if a value has been used.
        // (Every value is initially set by default to false.)
        numUsed = new boolean[max_value+1];
        // Initialize numbers on the bingo card.
        // 1st column gets numbers 1 ... subrange_size,
        // next column gets subrange_size + 1 ... 2*subrange_size,
        // third column gets 2*subrange_size + 1 ... 3*subrange_size, etc.
        for ( int col = 0; col < numCols(); col++ )
            initCol(col, (col * subrange_size) + 1, (col + 1) * subrange_size, numUsed); 
        //Add a free space in the center space of the board
        Location centerCell = new Location(this.numRows()/2, this.numCols()/2);
        this.remove(centerCell);
        BingoValueCell freeSpace = new BingoValueCell("F", BingoGUI.getMarkedColor());
        this.add(freeSpace, centerCell);
    }

    /** 
        Initializes the cells in the given column with numbers from
        the given range.
        @param col  which column to initialize
        @param min  smallest valid number to appear this column
        @param max  largest valid number to appear in this column
     */
    private void initCol(int col, int min, int max, boolean[] numUsed)
    {
        // Replace following stub code with a loop to fill the entire
        // column with random numbers from getUnusedRandomNum.
        for(int row=1; row<this.numRows(); row++)
        {
            addCell(new BingoValueCell(getUnusedRandomNum(min, max, numUsed)), row, col);
        }
    }

    /**
       Returns <code>true</code> if the the given (row, col) location
       is empty; <code>false</code> otherwise.
     */
    private boolean isEmpty(int row, int col)
    {
        return isEmpty(new Location(row, col));
    }

    /** 
       Returns a random number in the range of min -- max (inclusive)
       that has not been returned before in this program run.
       (Precondition: there must be at least one value in
       the range that has not been previously returned.)
     */
    private int getUnusedRandomNum(int min, int max, boolean[] numUsed)
    {
        Random generator = new Random();

        while (true)
        {
            int randomNumber = min + generator.nextInt(max-min +1);
            if (!numUsed[randomNumber])
            {
                numUsed[randomNumber] = true;
                return randomNumber;
            }
        }
    }

    /** 
       Returns a random value in the range of min -- max (inclusive).
     */
    private int getRandomValue(int min, int max)
    {
        int rangeSize = max - min + 1;
        return min + randNumGenerator.nextInt(rangeSize);
    }

    /** 
        Adds the given Bingo value cell to this bingo
        card at the given (row, col) location.
     */
    private void addCell(BingoValueCell cell, int row, int col)
    {
        add(cell, new Location(row, col));
    }

    /** 
       If this bingo card contains numToPlay, marks it as found.
       @param numToPlay  the number to play (mark if found)
     */
    public void playNumber(int numToPlay)
    {
        BingoValueCell cell = findCellContaining(numToPlay);
        if ( cell != null )
            changeCellColor(cell, BingoGUI.getMarkedColor());  // Might re-mark a cell, but is still more efficient
        // than always checking first.
    }

    /** 
        Change the color of a cell on the bingo card by replacing the cell.
        @param cell      the cell whose color should change (because marked)
        @param newColor  the new color for the cell
     */
    private void changeCellColor(BingoValueCell cell, Color newColor)
    {
        BingoValueCell newCell = new BingoValueCell(cell.text(), newColor);
        Location loc = cell.location();
        remove(cell);
        add(newCell, loc);
    }

    /** 
       Returns the cell containing the given value, or <code>null</code>
       if this bingo card does not contain the given value.
       (Precondition: all cells have been filled.)
     */
    private BingoValueCell findCellContaining(int value)
    {
        for (int row=1; row < numRows(); row++)
            for (int col=0; col < numCols(); col++)
            {
                BingoValueCell cell = getCellAt(row, col);
                if ( cell.textEqualsValue(value) )
                    return cell;
        }
        return null;
    }

    /** 
       Returns the cell at the given (row, col) location, or
       <code>null</code> if there is no Bingo value cell there.
     */
    public BingoValueCell getCellAt(int row, int col)
    {
        return (BingoValueCell) objectAt(new Location(row, col));
    }

    /** 
        Indicates this card won by setting the column headings to the
        highlight color used to mark numbers.  Assumes that the highlight
        color is different from the initial column heading color.
        
        This method contains exactly the same code as the code in initialize() which adds
        BINGO to the top of the card, except for the color of the text cell.
     */
    public void indicateCardWon()
    {
        for(int i=0; i<BINGO.length(); i++)
        {
            String letter = BINGO.substring(i, i+1);
            TextCell theCell = new TextCell(letter, BingoGUI.getMarkedColor());
            Location location = new Location(0, i);
            remove(location);
            this.add(theCell, location);
        }
    }

}
