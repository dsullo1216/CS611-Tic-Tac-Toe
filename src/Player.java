
// Player class for implementing Tic-Tac-Toe and Order and Chaos. It holds the number of wins the player has. Includes getters/setters
public abstract class Player {

    // int storing the number of wins the Player has
    public int numWins;

    // Constructor that takes either 'X' or 'O' as parameter and initializes numWins
    public Player() {
        this.numWins = 0;
    }

    // Overrides default toString method from Object class
    public abstract String toString();
    
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