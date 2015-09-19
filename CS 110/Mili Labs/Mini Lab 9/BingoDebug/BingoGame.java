import java.util.ArrayList;
import java.util.Random;

/**
 *  Bingo Game:<br>
 *
 *  A BingoGame object controls the play of a game of bingo.
 *
 *  @author Kelly Schultz and Alyce Brady
 *  @version April 21, 2009
 */
public class BingoGame
{
    // Public constant value (not tied to a particular instance).
    /** The numbers on the Bingo cards will range from 1 to MAX_VALUE. */
    public static final int MAX_VALUE = 75;

    // Instance variables: Encapsulated data for each BingoGame object
    private Random    randNumGenerator;
    private BingoCard card;
    private BingoGUI  display;
    private WinningStrategy strategy;  // temporary; should be gone or commented out
    private ArrayList<WinningStrategy> registeredStrategies;

    /**
     * Constructs an object that controls games of Bingo.
     */
    public BingoGame()
    {
        // Create a random number generator to use for calling numbers.
        this.randNumGenerator = new Random();

        // Create and initialize the card for the bingo game.
        this.card = new BingoCard(MAX_VALUE);

        // Create graphical user interface capable of displaying
        // the bingo game.  This will also display the initial card.
        this.display = new BingoGUI(card, this,
                                    "Kelly Schultz and Alyce Brady",  // authors
                                    "",  // outside assistance
                                    "April 2009",  // date
                                    ""); // help file, e.g. "file:Bingo.html"

        // Create the list of strategies to use to determine a win.
        this.registeredStrategies = new ArrayList<WinningStrategy>();
    }

    /** Includes or removes the Complete Row Marked winning strategy when
     *  user clicks the appropriate button.
     */
    public void onCompleteRowWinsButtonClick()
    {
        toggle(new WinWithMarkedRow());
    }

    /** Includes or removes the Complete Column Marked winning strategy when
     *  user clicks the appropriate button.
     */
    public void onCompleteColumnWinsButtonClick()
    {
        toggle(new WinWithMarkedCol());
    }

    /** Adds or removes the given strategy from the list of registered
     *  strategies, depending on whether it is already there.
     */
    private void toggle(WinningStrategy strategy)
    {
        if ( ! registeredStrategies.remove(strategy) )
            registeredStrategies.add(strategy);
    }

    /** Plays a game of Bingo when user clicks the Play button.
     *  (Precondition: <code>setDisplay</code> must be called first.)
     */
    public void onPlayButtonClick()
    {
        // Initialize the Bingo card.
        card.initialize();
        int countOfNumbersCalled = 0;

        // Let the user know which strategies are being used.
        reportStrategies();
        
        // Play the game.
        while ( ! gameOver() )
        {
            card.playNumber(randNumGenerator.nextInt(MAX_VALUE));
            countOfNumbersCalled++;
            System.out.print(".");
            display.showGrid();
        }

        // Indicate that the game is over.
        card.indicateCardWon();
        display.showGrid();
        System.out.println("\nTook " + countOfNumbersCalled +
                           " called numbers to win.");
    }

    /** Reports which winning strategies will be used.  (If no winning
     *  strategies were chosen, uses a pre-determined set of basic ones.)
     */
    private void reportStrategies()
    {
        // If user didn't choose any win strategies, use the basic ones.
        if ( registeredStrategies.isEmpty() )
        {
            registeredStrategies.add(new WinWithMarkedRow());
            registeredStrategies.add(new WinWithMarkedCol());
        }

        // Let the user know which strategies are being used.
        System.out.println("\nPlaying Bingo with following strategies:");
        for ( WinningStrategy strategy: registeredStrategies )
            System.out.println("\t" + strategy.description());
    }

    /** Returns <code>true</code> if the game is over (a Bingo card has won
     *  according to a registered strategy).
     */
    private boolean gameOver()
    {
        // Check whether the card has won according to any of the registered
        // strategies.
        for ( WinningStrategy strategy: registeredStrategies )
            if ( strategy.isWinner(card) )
                return true;
        return false;
    }

    // Stub created during lab -- might still be in class or might not.
    private boolean stubMethod()
    {
        System.out.println(strategy.description());
        return strategy.isWinner(card);
    }
}
