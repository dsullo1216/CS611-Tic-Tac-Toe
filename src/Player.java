package src;

public class Player {

    // char storing either 'X' or 'O' as the Player's checker
    private char checker;
    // int storing the number of wins the Player has
    private int numWins;

    // Constructor that takes either 'X' or 'O' as parameter and initializes numWins
    public Player(char checker) {
        assert (checker == 'X' || checker == 'O'): "Invalid Checker Type";
        this.checker = checker;
        this.numWins = 0;
    }

    // Overrides default toString method from Object class
    public String toString() {
        return "Player " + checker;
    }

    // getter that returns the value for checker
    public char getChecker() {
        return checker;

    }
    
    // getter that returns the value for numWins
    public int getNumWins() {
        return this.numWins;
    }

    public int changeNumWins(int newNumWins) {
        this.numWins = newNumWins;
        return this.numWins;
    }

    public static void main(String[] args) {
        Player test = new Player('X');
        System.out.println(test);
        System.out.println(test.getChecker());
        System.out.println(test.getNumWins());
    }
}
