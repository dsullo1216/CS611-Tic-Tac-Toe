import java.util.Scanner;

// Extension of Game class to represent a Connect Four game. Implements abstract methods needed to play Connect Four
public class ConnectFourGame extends Game {

    public ConnectFourGame() {
        this.board = new ConnectFourBoard();
    }

    // Handles the beginning of a Connect Four game by printing the proper messages and allows user to determine whether 'X' or 'O' goes first
    @Override
    public Player[] launchGame(Scanner sc) {
        System.out.println("Welcome to Connect Four!");
        System.out.println(board);
        System.out.print("Please enter which player should move first 'X' or 'O': ");
        char player1Checker = sc.next().charAt(0);
        while (player1Checker != 'X' && player1Checker != 'O') {
            System.out.print("Incorrect character entered. Please enter either 'X' or 'O': ");
            player1Checker = sc.next().charAt(0);
           }
        Player[] players = new Player[2];
        Player player1 = new ConnectFourPlayer(new Piece(player1Checker));
        Player player2;
        if (player1Checker == 'X') {
            player2 = new ConnectFourPlayer(new Piece('O'));
        }
        else {
            player2 = new ConnectFourPlayer(new Piece('X'));
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

    // Handles adding checker to the board and validating index input
    @Override
    public void addChecker(Player player, Scanner sc) {
        System.out.print(player + ", Enter which column you would like to add a piece: ");
        String playerMove = sc.next();
        if (playerMove.length() != 1) {
            playerMove = "x";
        }
        int playerCol = Character.getNumericValue(playerMove.charAt(0));
        while (board.addChecker(((ConnectFourPlayer) player).getChecker(), playerCol) == false) {
            System.out.print("Invalid move. Please try again: ");
            playerMove = sc.next();
            if (playerMove.length() != 1) {
                continue;
            }
            playerCol = Character.getNumericValue(playerMove.charAt(0));
        }
        System.out.println(board);
    }

    @Override
    public boolean processMove(Player player, Scanner sc) {
        addChecker(player, sc);
        if (board.isWin(((ConnectFourPlayer) player).getChecker())) {
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

    // Calls other methods of ConnectFourGame class and facilitates the game
    @Override
    public void playGame(Scanner sc) {
        Player[] players = launchGame(sc);
        Player player1 = players[0];
        Player player2 = players[1];
        boolean continueGame;
        while (true) {
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
