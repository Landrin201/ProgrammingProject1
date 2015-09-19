
/**
 *  Bingo Game:<br>
 *
 *  A WinWithMarkedRow object checks for a complete row of marked cells
 *  as a winning Bingo strategy.
 *
 *  @author Kelly Schultz and Alyce Brady
 *  @version Apr 20, 2009
 */
public class WinWithMarkedRow implements WinningStrategy
{
    /** Constructs an object of this class. */
    public WinWithMarkedRow()
    {
        // Optional constructor; can be left out.
    }

    /** Returns the description of this particular strategy.
     */
    public String description()
    {
        return "Win if all values in a row have been marked.";
    }

    /** Returns <code>true</code> if the given bingo card is a winner according
     *  to the strategy of looking for a completely marked row.
     */
    public boolean isWinner(BingoCard card)
    {
        for ( int row = 1; row < card.numRows(); row++ )
            if ( isWinningRow(card, row) )
                return true;
        return false;
    }

    /** Returns <code>true</code> if the given row of the given bingo card
     *  is a winning (completely marked) row.
     */
    private boolean isWinningRow(BingoCard card, int row)
    {
        for ( int col=0; col < card.numCols(); col++ )
            if (!card.getCellAt(row, col).isMarked() )
                return false;
        return true;
    }

    /* Redefined from Object class. */
    public boolean equals(Object obj)
    {
        if ( obj instanceof WinWithMarkedRow )
            return true;
        return false;
    }
}
