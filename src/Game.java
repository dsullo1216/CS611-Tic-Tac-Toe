import java.util.Scanner;

// Game class for implementing Tic-Tac-Toe. Holds an instance of Board class and includes methods to faciliate the game of Tic-Tac-Toe.
public abstract class Game {
    
    // Holds an instance of our Board class for the game
    Board board;
    
    // TODO Put this in Main
    public char chooseGame(Scanner sc) {
        System.out.println("Welcome to Board Games!");
        System.out.println("1. Tic-Tac-Toe");
        System.out.println("2. Order and Chaos");
        System.out.print("Please choose which game you would like to play (1/2): ");
        char choice = sc.next().charAt(0);
        while (choice != '1' && choice != '2') {
            System.out.print("Incorrect character entered. Please enter eitehr '1' or '2': ");
            choice = sc.next().charAt(0);
        }
        if (choice == '1') {
            this.board = new TicTacToeBoard();
        }
        else {
            this.board = new OrderChaosBoard();
        }
        return choice;
    }

    // Handles the beginning of a Tic-Tac-Toe game by printing the proper messages and allows user to determine whether 'X' or 'O' goes first
    public abstract Player[] launchGame(Scanner sc);

    // Handles adding a checker to the board and validating indices inputs
    public abstract void addChecker(Player player, Scanner sc);

    // Handles adding checker to the board and procedes to check for win for specified player or a tie
    public abstract boolean processMove(Player player, Scanner sc);

    public abstract void playGame(Scanner sc);

}