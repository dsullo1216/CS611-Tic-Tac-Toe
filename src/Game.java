package src;
import java.util.Scanner;

public class Game {
    
    private Board board;
    
    public Game() {
        this.board = new Board();
    }

    public boolean processMove(Player player, int row, int col) {
        board.addChecker(player.getChecker(), row, col);
        return board.isWin(player.getChecker());
    }

    public void playGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe!");
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
            
            
            break;
        }


        sc.close();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
    }
}
