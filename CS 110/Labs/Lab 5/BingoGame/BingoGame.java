import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

/**
    Bingo Game:<br>
  
    A BingoGame object controls the play of a game of bingo. It constructs all nescessary
    elements nescessary of the game. 
    <br> <br>
    Modifications <br>
        May 1 2015, Marc Kuniansky, Changed the for loop in the PlayOnButtonClick method 
                                    to a while loop. Fully implemented the GameOver strategy
                                    and the toggle strategies, adding protection to the
                                    PlayOnButtonClick method to prevent the game from
                                    running without any strategies implemented. 
                                    Made an array list of WinningStrategy, allowing many
                                    winning strategies to be made and used.
        May 7 2015, Marc Kuniansky, Modified to include the newly added strategies
                                    DiagonalWin, CornerWin, HardColumnWin, 
                                    HardRowWin, Perimeter, and Blackout.
  
    @author Marc Kuniansky, with assistance from Alyce Brady
    @version May 7, 2015
 */
public class BingoGame
{ //Begin class
    // Public constant value (not tied to a particular instance).
    /** The numbers on the Bingo cards will range from 1 to MAX_VALUE. */
    public static final int MAX_VALUE = 76;

    // Instance variables: Encapsulated data for each BingoGame object
    private Random    randNumGenerator;
    private BingoCard card;
    private BingoGUI  display;
    public WinningStrategy winningStrategy;
    ArrayList<WinningStrategy> strategyList;

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
        strategyList = new ArrayList<WinningStrategy>();
    }

    /** 
       Includes or removes the RowWinner winning strategy when
       user clicks the appropriate button.
     */
    public void onCompleteRowWinsButtonClick()
    { //Begin onCompleteRowsWinsButtonClick
        toggle(new RowWinner());
    } //End onCompleteRowsWinsButtonClick
    
    /** 
       Includes or removes the ColumnWinner winning strategy when
       user clicks the appropriate button.
     */
    public void onCompleteColumnWinsButtonClick()
    { //Begin onCompleteColumnWinsButtonClick
        toggle(new ColumnWinner());
    } //End onCompleteColumnWinsButtonClick
    
    /**
       Includes or removes the DiagonalWinner winning strategy when
       user clicks the appropriate button.
     */
    public void onCompleteDiagonalWinsButtonClick()
    { //Begin onCompleteDiagonalWinsButtonClick
        toggle(new DiagonalWinner());
    } //End onCompleteDiagonalWinsButtonClick
    
    /**
       Includes or removes the CornerWinner winning strategy when
       user clicks the appropriate button.
     */
    public void onCornersWinsButtonClick()
    { //Begin onCompleteCornersWinsButtonClick
        toggle(new CornerWinner());
    } //End onCompleteCornersWinsButtonClick
    
    /**
       Includes or removes the CornerWinner winning strategy when
       user clicks the appropriate button.
     */
    public void onBlackoutWinsButtonClick()
    { //Begin onBlackoutWinsButtonClick
        toggle(new Blackout());
    } //End onBlackoutWinsButtonClick
    
     /**
       Includes or removes the HardColumnWinner winning strategy when
       user clicks the appropriate button.
     */
    public void onHardCompleteColumnWinsButtonClick()
    { //Begin onHardCompleteColumnWinsButtonClick
        toggle(new HardColumnWinner());
    } //End onHardCompleteColumnWinsButtonClick
    
    /**
       Includes or removes the HardColumnWinner winning strategy when
       user clicks the appropriate button.
     */
    public void onHardCompleteRowWinsButtonClick()
    { //Begin onHardCompleteRowWinsButtonClick
        toggle(new HardRowWinner());
    } //End onHardCompleteRowWinsButtonClick
    
    /**
       Includes or removes the Perimeter winning strategy when
       user clicks the appropriate button.
     */
    public void onPerimeterWinsButtonClick()
    { //Begin onHardCompleteRowWinsButtonClick
        toggle(new Perimeter());
    } //End onHardCompleteRowWinsButtonClick

    /** Adds or removes the given strategy from the list of registered
     *  strategies, depending on whether it is already there.
     */
    private void toggle(WinningStrategy strategy)
    { //Begin toggle
        if (!strategyList.remove(strategy))
            strategyList.add(strategy);
    } //End toggle

    /** 
       Plays a game of Bingo with the selected winnign strategies
       when user clicks the Play button. If no winning
       strategies were chosen, uses a pre-determined set of basic ones.
       
       The game will continue to play until a winning condition is met.
        (Precondition: <code>setDisplay</code> must be called first.)
     */
    public void onPlayButtonClick()
    { //Begin onPlayButtonClick
       // Initialize the Bingo card.
        card.initialize();
        int countOfNumbersCalled = 0; //Count how many numbers have been called
        
        //If no strategies have yet been selected by the user, add the two default strategies.
        if(strategyList.isEmpty())
        { //End if
            strategyList.add(new RowWinner());
            strategyList.add(new ColumnWinner());
        } //End if
        
        // Let the user know which strategies are being used.
        reportStrategies(strategyList);
        display.showGrid();
        //Play the game. Stop playing the game if gameOver==true.
        while(this.gameOver(strategyList, card)==false)
        { //Begin while
            card.playNumber(randNumGenerator.nextInt(MAX_VALUE));
            countOfNumbersCalled++;
            System.out.print(".");
            display.showGrid();
        } //End while

        // Indicate that the game is over.
        card.indicateCardWon();
        display.showGrid();
        //Tell the user how many numbers were picked before a winner was chosen.
        System.out.println("\nTook " +countOfNumbersCalled + " called numbers to win. \n");
    } //End onPlayButtonClick

    /** 
       Reports which winning strategies will be used.
     */
    private void reportStrategies(ArrayList<WinningStrategy> strategyList)
    { //Begin reportStrategies
        System.out.println("Playing Bingo with the following strategies:");
        for(WinningStrategy strategy: strategyList)
        { //Begin for loop
            System.out.println("      " +strategy.description()+"\n");
        } //End for loop
    } //End reportStrategies

    /** 
        Returns <code>true</code> if the game is over (a Bingo card has won
        according to a registered strategy). Also prints a statement telling
        the player how they won.
     */
    private boolean gameOver(ArrayList<WinningStrategy> strategyList, BingoCard theCard)
    { //Begin gameOver
        for(WinningStrategy strategy: strategyList)
        { //Begin for loop
            if(strategy.isWinner(theCard)==true)
            { //Begin if statement
                //If one of the methods wins, print a message.
                System.out.println("\nWe have a winner! " + strategy.winningStatement());
                return true; //Return true if one of the methods won
            } //End if statement
        } //End for loop
        return false; //Return false if noone has won yet.
    } //End gameOver
} //End class
