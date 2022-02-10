package src;

// Wrapper class that invokes our Game class to run Tic-Tac-Toe.
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
    }
}