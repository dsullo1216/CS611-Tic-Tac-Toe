
// Player class for implementing Tic-Tac-Toe. It holds the respective Piece as well as the number of wins the player has. Includes getters/setters
public class Player {

    // char storing either 'X' or 'O' as the Player's checker
    private Piece checker;
    // int storing the number of wins the Player has
    private int numWins;

    // Constructor that takes either 'X' or 'O' as parameter and initializes numWins
    public Player(Piece checker) {
        assert (checker.getChecker() == 'X' || checker.getChecker() == 'O'): "Invalid Checker Type";
        this.checker = checker;
        this.numWins = 0;
    }

    // Overrides default toString method from Object class
    public String toString() {
        return "Player " + checker;
    }

    // getter that returns the value for checker
    public Piece getChecker() {
        return this.checker;

    }
    
    // getter that returns the value for numWins
    public int getNumWins() {
        return this.numWins;
    }

    // setter that allows us to change the value for numWins
    public int changeNumWins(int newNumWins) {
        this.numWins = newNumWins;
        return this.numWins;
    }
}