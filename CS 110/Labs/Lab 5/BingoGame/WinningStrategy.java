
/**
  Project Name: Bingo Card Lab<br>
  This class is an interface containing code for winning strategies. All strategies have three methods: a 
  description which tells the user how the strategy is played, a method to determine if the user has won, and 
  a statement to tell the user they have won if they win.
  <br> <br>
  Created: <br>
    May 5, 2015,  Marc Kuniansky
    <br> <br>
  Modifications: <br>
    May 5 2015, Marc Kuniansky, Created the interface and added the description(), isWinner, and winningStatement()
                methods.
    <br> <br>
  
  @author Marc Kuniansky
  @version May 5 2014, Version 1
 **/
public interface WinningStrategy
{ //Begin Interface
    public String description();
    public boolean isWinner(BingoCard bingoCard);
    public String winningStatement();
} //End interface
