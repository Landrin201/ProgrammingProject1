
/**
 *  Bingo Game:<br>
 *
 *  A WinWithMarkedCol object checks for a complete column of marked cells
 *  as a winning Bingo strategy.
 *
 *  @author Kelly Schultz and Alyce Brady
 *  @version Apr 20, 2009
 */
public class WinWithMarkedCol implements WinningStrategy
{
    /** Returns the description of this particular strategy.
     */
    public String description()
    {
        return "Win if all values in a column have been marked.";
    }

    /** Returns <code>true</code> if the given bingo card is a winner according
     *  to the strategy of looking for a completely marked row.
     */
    public boolean isWinner(BingoCard card)
    {
        for ( int col = 0; col < card.numCols(); col++ )
            if ( isWinningCol(card, col) )
                return true;
        return false;
    }

    /** Returns <code>true</code> if the given column of the given bingo card
     *  is a winning (completely marked) column.
     */
    private boolean isWinningCol(BingoCard card, int col)
    {
        for ( int row=1; row < card.numRows(); row++ )
            if ( ! card.getCellAt(row, col).isMarked() )
                return false;
        return true;
    }

    /* Redefined from Object class. */
    public boolean equals(Object obj)
    {
        if ( obj instanceof WinWithMarkedCol )
            return true;
        return false;
    }
}
