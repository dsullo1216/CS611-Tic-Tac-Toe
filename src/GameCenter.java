import java.util.Scanner;
// TODO: Add ConnectFour to playable games
// Class to facilitate running both Tic-Tac-Toe and Order and Chaos
public class GameCenter {

    private TicTacToeGame ticTacToeGame;
    private OrderChaosGame orderChaosGame;
    private ConnectFourGame connectFourGame;
    
    // Constructor that simply initializes the instances of each game
    public GameCenter() {
        this.ticTacToeGame = new TicTacToeGame();
        this.orderChaosGame = new OrderChaosGame();
        this.connectFourGame = new ConnectFourGame();
    }

    // Handles the users initial choice and launches the first game
    public void launchGameCenter(Scanner sc) {
        System.out.println("Welcome to the Board Game Hub! Where you can play Tic-Tac-Toe and Order and Chaos!");
        System.out.println("Which game would you like to play?");
        System.out.println("1. Tic-Tac-Toe");
        System.out.println("2. Order and Chaos");
        System.out.println("3. Connect Four");
        System.out.print("Please choose to begin the game: ");
        char choice = sc.next().charAt(0);
        while (choice != '1' && choice != '2' && choice != '3') {
            System.out.print("Incorrect character entered. Please enter one of the numbers above: ");
            choice = sc.next().charAt(0);
        }
        switch (choice) {
            case '1': ticTacToeGame.playGame(sc);
                      break;
            case '2': orderChaosGame.playGame(sc);
                      break;
            case '3': connectFourGame.playGame(sc);
                      break;
            default: break;
        }
    }

    // Handles subsequent games and switching between games
    public boolean continueGameCenter(Scanner sc) {
        System.out.print("Would you like to play another game? (Y/N): ");
            char playAgain = sc.next().charAt(0);
            while (playAgain != 'Y' && playAgain != 'N') {
                System.out.print("Please enter either Y or N to choose to play again: ");
                playAgain = sc.next().charAt(0);
            }
            if (playAgain == 'Y') {
                System.out.println("Which game would you like to play?");
                System.out.println("1. Tic-Tac-Toe");
                System.out.println("2. Order and Chaos");
                System.out.println("3. Connect Four");
                System.out.print("Please choose to begin the game: ");
                playAgain = sc.next().charAt(0);
                while (playAgain != '1' && playAgain != '2' && playAgain != '3') {
                    System.out.print("Incorrect character entered. Please enter one of the numbers above: ");
                    playAgain = sc.next().charAt(0);
                }
                switch (playAgain) {
                    case '1': ticTacToeGame.playGame(sc);
                              break;
                    case '2': orderChaosGame.playGame(sc);
                              break;
                    case '3': connectFourGame.playGame(sc);
                              break;
                    default: break;
                }
                return true;    
            }
            return false;
    }

    // Calls on other methods of GameCenter class to fully operate the Board games
    public void playGameCenter(Scanner sc) {
        launchGameCenter(sc);
        boolean continueGameCenter;
        while (true) {
            continueGameCenter = continueGameCenter(sc);
            if (!(continueGameCenter)) {
                break;
            }
        }
    }
}