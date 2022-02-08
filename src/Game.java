package src;
import java.util.Scanner;

public class Game {
    
    private Board board;
    
    public Game() {
        this.board = new Board();
    }

    public void playGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println(board);
        System.out.print("Please enter which player should move first 'X' or 'O': ");
        char player1Checker = sc.next().charAt(0);
        while (player1Checker != 'X' && player1Checker != 'O') {
         System.out.print("Incorrect character entered. Please enter either 'X' or 'O': ");
         player1Checker = sc.next().charAt(0);
        }
        Player player1 = new Player(player1Checker);
        Player player2;
        if (player1Checker == 'X') {
            player2 = new Player('O');
        }
        else {
            player2 = new Player('X');
        }
        while (true) {

            System.out.print(player1 + ", Enter your move in the format 'row,col' : ");
            String player1Move = sc.next();
            int player1Row = Character.getNumericValue(player1Move.charAt(0));
            int player1Col = Character.getNumericValue(player1Move.charAt(2));
            while (board.addChecker(player1.getChecker(), player1Row, player1Col) == false) {
                System.out.print("Invalid move. Please try again: ");
                player1Move = sc.next();
                player1Row = Character.getNumericValue(player1Move.charAt(0));
                player1Col = Character.getNumericValue(player1Move.charAt(2));
            }
            System.out.println(board);
            if (this.board.isWin(player1.getChecker())) {
                player1.changeNumWins(player1.getNumWins() + 1);
                System.out.println(player1 + " has won the game!");
                break;
            }

            System.out.print(player2 + ", Enter your move in the format 'row,col' : ");
            String player2Move = sc.next();
            int player2Row = Character.getNumericValue(player2Move.charAt(0));
            int player2Col = Character.getNumericValue(player2Move.charAt(2));
            while (board.addChecker(player2.getChecker(), player2Row, player2Col) == false) {
                System.out.print("Invalid move. Please try again: ");
                player2Move = sc.next();
                player2Row = Character.getNumericValue(player2Move.charAt(0));
                player2Col = Character.getNumericValue(player2Move.charAt(2));
            }
            System.out.println(board);
            if (this.board.isWin(player2.getChecker())) {
                player1.changeNumWins(player2.getNumWins() + 1);
                System.out.println(player2 + " has won the game!");
                break;
            }
        }


        sc.close();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
    }
}
