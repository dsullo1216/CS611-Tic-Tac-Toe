import java.util.Scanner;

public class OrderChaosGame extends Game {
    
    public OrderChaosGame() {
        this.board = new OrderChaosBoard();
    }

    // Handles the beginning of an Order and Chaos game by printing the proper messages
    public Player[] launchGame(Scanner sc) {
        System.out.println("Welcome to Order and Chaos");
        System.out.println(board);
        Player[] players = new Player[2];
        players[0] = new OrderChaosPlayer('1');
        players[1] = new OrderChaosPlayer('2');
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
            if (playAgain == 'Y') {
                board.reset();
                System.out.println(board);
                return true;
            }
            else{
                System.out.println("Game Over. Final Score: " + player1 + " - " + player1.getNumWins() + ", " + player2 + " - " + player2.getNumWins());
                return false;
            }
    }

    @Override
    public void addChecker(Player player, Scanner sc) {

        System.out.print(player + ", Would you like to place an 'X' or an 'O'? : ");
        char checker = sc.next().charAt(0);
        while (checker != 'X' && checker != 'O') {
            System.out.print("Invalid checker. Please try again: ");
            checker = sc.next().charAt(0);
        }
        System.out.print(player + ", Enter your move in the format 'row,col' : ");
        String playerMove = sc.next();
        if (playerMove.length() < 3) {
            playerMove = "x,x";
        }
        int playerRow = Character.getNumericValue(playerMove.charAt(0));
        int playerCol = Character.getNumericValue(playerMove.charAt(2));
        while (board.addChecker(new Piece(checker), playerRow, playerCol) == false) {
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

    public boolean processMoveOrder(Player player, Scanner sc) {

        if (board.isWin(new Piece ('X')) || board.isWin(new Piece ('O'))) {
            player.changeNumWins(player.getNumWins() + 1);
            System.out.println(player + " has won the game!");
            return true;
        }
        return false;
    }

    public boolean processMoveChaos(Player player, Scanner sc) {
        if (board.isFull()) {
            player.changeNumWins(player.getNumWins() + 1);
            System.out.println(player + " has won the game!");
            return true;
        }
        return false;
    }


    @Override
    public boolean processMove(Player player, Scanner sc) {
        addChecker(player, sc);
        if (board.isWin(new Piece ('X')) || board.isWin(new Piece ('O'))) {
            System.out.println("Player 1 has won the game!");
            return true;
        }
        else if (board.isFull()) {
            System.out.println("Player 2 has won the game!");
            return true;
        }
        return false;
    }

    @Override
    public void playGame(Scanner sc) {
        Player[] players = launchGame(sc);
        Player player1 = players[0];
        Player player2 = players[1];
        while (true) {
            while (true) {
                if (processMove(player1, sc)) {
                    break;
                }
                if (processMove(player2, sc)) {
                    break;
                }
            }
            if (!board.isFull()) {
                player1.changeNumWins(player1.getNumWins() + 1);
            }
            else {
                player2.changeNumWins(player2.getNumWins() + 1);
            }
            if (!continueGame(player1, player2, sc)) {
                break;
            }
        }
    }
}
