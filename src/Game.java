import java.util.Scanner;

// Abstract game class for implementing Board-games based on checkers. Holds an instance of Board class and includes methods to faciliate games.
public abstract class Game {
    
    // Holds an instance of our Board class for the game
    Board board;
    
    // Handles the beginning of a game by printing the proper messages and allows user to determine game settings
    public abstract Player[] launchGame(Scanner sc);

    // Handles the end of a game by printing the proper messages and allows user to determine if they want to keep playing
    public abstract boolean continueGame(Player player1, Player player2, Scanner sc);

    // Handles adding a checker to the board and validating indices inputs
    public abstract void addChecker(Player player, Scanner sc);

    // Handles adding checker to the board and procedes to check for win for specified player or a tie
    public abstract boolean processMove(Player player, Scanner sc);

    // Handles starting the game as well as the continuation of the game
    public abstract void playGame(Scanner sc);

}