import java.util.Scanner;

public class GameCenter {

    private TicTacToeGame ticTacToeGame;
    private OrderChaosGame orderChaosGame;
    
    public GameCenter() {
        this.ticTacToeGame = new TicTacToeGame();
        this.orderChaosGame = new OrderChaosGame();
    }

    public char launchGameCenter(Scanner sc) {
        System.out.println("Welcome to the Board Game Hub! Where you can play Tic-Tac-Toe and Order and Chaos!");
        System.out.println("Which game would you like to play?");
        System.out.println("1. Tic-Tac-Toe");
        System.out.println("2. Order and Chaos");
        System.out.print("Please enter either '1' or '2' to begin the game: ");
        char choice = sc.next().charAt(0);
        while (choice != '1' && choice != '2') {
            System.out.print("Incorrect character entered. Please enter either '1' or '2': ");
            choice = sc.next().charAt(0);
        }
        if (choice == '1') {
            ticTacToeGame.playGame(sc);
        }
        else {
            orderChaosGame.playGame(sc);
        }
        return choice;
    }

    public boolean continueGameCenter(Scanner sc, char choice) {
        System.out.print("Would you like to play another game? (Y/N): ");
            char playAgain = sc.next().charAt(0);
            while (playAgain != 'Y' && playAgain != 'N') {
                System.out.print("Please enter either Y or N to choose to play again: ");
                playAgain = sc.next().charAt(0);
            }
            if (playAgain == 'Y') {
                System.out.print("Would you like to keep playing the same game? (Y/N): ");
                playAgain = sc.next().charAt(0);
                while (playAgain != 'Y' && playAgain != 'N') {
                    System.out.print("Please enter either Y or N to choose to play again: ");
                    playAgain = sc.next().charAt(0);
                }
                if (playAgain == 'Y') {
                    if (choice == '1') {
                        ticTacToeGame.board.reset();
                        ticTacToeGame.playGame(sc);
                    }
                    else {
                        orderChaosGame.board.reset();
                        orderChaosGame.playGame(sc);
                    }
                }
                else {
                    if (choice == '0') {
                        ticTacToeGame.board.reset();
                        ticTacToeGame.playGame(sc);
                    }
                    else {
                        orderChaosGame.board.reset();
                        orderChaosGame.playGame(sc);
                    }
                }
                return true;    
            }
            else{

                return false;
            }
    }

    public void playGameCenter(Scanner sc) {
        char choice = launchGameCenter(sc);
        boolean continueGameCenter;
        while (true) {
            continueGameCenter = continueGameCenter(sc, choice);
            if (!(continueGameCenter)) {
                break;
            }
        }
    }
}