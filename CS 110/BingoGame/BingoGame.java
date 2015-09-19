import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

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
    public static final int MAX_VALUE = 76;

    // Instance variables: Encapsulated data for each BingoGame object
    private Random    randNumGenerator;
    private BingoCard card;
    private BingoGUI  display;

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

    }

    /** Includes or removes the Complete Row Marked winning strategy when
     *  user clicks the appropriate button.
     */
    public void onCompleteRowWinsButtonClick()
    {
        // Create a warning dialog box (JOptionPane).
        JOptionPane.showMessageDialog(null,
                                "The method for specifying a row winning " +
                                "strategy has not been implemented yet.",
                                "Under Development",
                                JOptionPane.WARNING_MESSAGE);

        // Should call toggle with a new object of your row winning strategy class.
    }

    /** Adds or removes the given strategy from the list of registered
     *  strategies, depending on whether it is already there.
     */
//     private void toggle(WinningStrategy strategy)
//     {
//         if ( ! registeredStrategies.remove(strategy) )
//             registeredStrategies.add(strategy);
//     }

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
        for ( int i = 0; i < 5; i++ )   // this loop is stub behavior
        {
            card.playNumber(randNumGenerator.nextInt(MAX_VALUE));
            countOfNumbersCalled++;
            System.out.print(".");
            display.showGrid();
        }

        // Indicate that the game is over.
        card.indicateCardWon();
        display.showGrid();
        System.out.println("\nPlayed 5 numbers.");
    }

    /** Reports which winning strategies will be used.  (If no winning
     *  strategies were chosen, uses a pre-determined set of basic ones.)
     */
    private void reportStrategies()
    {
        // Let the user know which strategies are being used.
        System.out.println("\nPlaying Bingo with following strategies:");
        System.out.println("\tnone");   // stub behavior
    }

    /** Returns <code>true</code> if the game is over (a Bingo card has won
     *  according to a registered strategy).
     */
    private boolean gameOver()
    {
        // Check whether the card has won according to any of the registered
        // strategies.

        // You will implement this method
        return false;           // stub behavior
    }
}
