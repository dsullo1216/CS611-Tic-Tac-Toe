import java.util.Scanner;

// Extension of Game class to represent a Tic-Tac-Toe game. Implements abstract methods needed to play Tic-Tac-Toe
public class TicTacToeGame extends Game {

    public TicTacToeGame() {
        this.board = new TicTacToeBoard();
    }

    // Handles the beginning of a Tic-Tac-Toe game by printing the proper messages and allows user to determine whether 'X' or 'O' goes first
    @Override
    public Player[] launchGame(Scanner sc) {
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println(board);
        System.out.print("Please enter which player should move first 'X' or 'O': ");
        char player1Checker = sc.next().charAt(0);
        while (player1Checker != 'X' && player1Checker != 'O') {
         System.out.print("Incorrect character entered. Please enter either 'X' or 'O': ");
         player1Checker = sc.next().charAt(0);
        }
        Player[] players = new Player[2];
        Player player1 = new TicTacToePlayer(new Piece(player1Checker));
        Player player2;
        if (player1Checker == 'X') {
            player2 = new TicTacToePlayer(new Piece('O'));
        }
        else {
            player2 = new TicTacToePlayer(new Piece('X'));
        }
        players[0] = player1;
        players[1] = player2;
        return players;
    }

    // Handles the end of the game by printing proper messages and allows user to decide whether to play another game
    public boolean continueGame(Player player1, Player player2, Scanner sc) {
        System.out.print("Would you like to play again? (Y/N): ");
            char playAgain = sc.next().charAt(0);
            while (playAgain != 'Y' && playAgain != 'N') {
                System.out.print("Please enter either Y or N to choose to play again: ");
                playAgain = sc.next().charAt(0);
            }
            board.reset();
            if (playAgain == 'Y') {
                System.out.println(board);
                return true;
            }
            else{
                System.out.println("Game Over. Final Score: " + player1 + " - " + player1.getNumWins() + ", " + player2 + " - " + player2.getNumWins());
                return false;
            }
    }

    // Handles adding a checker to the board and validating indices inputs
    @Override
    public void addChecker(Player player, Scanner sc) {
        System.out.print(player + ", Enter your move in the format 'row,col' : ");
        String playerMove = sc.next();
        if (playerMove.length() < 3) {
            playerMove = "x,x";
        }
        int playerRow = Character.getNumericValue(playerMove.charAt(0));
        int playerCol = Character.getNumericValue(playerMove.charAt(2));
        while (board.addChecker(((TicTacToePlayer) player).getChecker(), playerRow, playerCol) == false) {
            System.out.print("Invalid move. Please try again: ");
            playerMove = sc.next();
            if (playerMove.length() < 3) {
                continue;
            }
            playerRow = Character.getNumericValue(playerMove.charAt(0));
            playerCol = Character.getNumericValue(playerMove.charAt(2));
        }
        System.out.println(board);
    }

    // Handles adding checker to the board and procedes to check for win for specified player or a tie
    @Override
    public boolean processMove(Player player, Scanner sc) {
        addChecker(player, sc);
        if (board.isWin(((TicTacToePlayer) player).getChecker())) {
            player.changeNumWins(player.getNumWins() + 1);
            System.out.println(player + " has won the game!");
            return true;
        }
        else if (board.isFull()) {
            System.out.println("It's a tie!");
            return true;
        }
        return false;
    }

    // Calls other methods of TicTacToeGame class and facilitates the game
    public void playGame(Scanner sc) {
        Player[] players = launchGame(sc);
        Player player1 = players[0];
        Player player2 = players[1];
        boolean continueGame;
        while(true) {
            while (true) {
                if (processMove(player1, sc)) {
                    break;
                }
                if (processMove(player2, sc)) {
                    break;
                }
            }
            continueGame = continueGame(player1, player2, sc);
            if (!(continueGame)) {
                break;
            }
        }
    }
}
