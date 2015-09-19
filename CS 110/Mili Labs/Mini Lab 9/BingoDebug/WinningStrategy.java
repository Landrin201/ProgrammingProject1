
/**
 *  Bingo Game:<br>
 *
 *  A WinningStrategy class implements a way to check for a particular winning
 *  strategy for winning at Bingo (such as a complete row of marked cells, a
 *  complete column of marked cells, a complete diagonal of marked cells, etc.).
 *
 *  @author Kelly Schultz and Alyce Brady
 *  @version Apr 20, 2009
 */

public interface WinningStrategy
{
    /** Returns the description of a particular strategy.
     */
    public String description();

    /** Returns <code>true</code> if the given bingo card is a winner according
     *  to a particular strategy.
     */
    public boolean isWinner(BingoCard card);
}
