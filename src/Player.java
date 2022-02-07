package src;

public class Player {

    private char checker;
    private int numWins;

    public Player(char checker) {
        assert (checker == 'X' || checker == 'O'): "Invalid Checker Type";
        this.checker = checker;
        this.numWins = 0;
    }

    public String toString() {
        return "Player " + checker;
    }

    public char getChecker() {
        return checker;

    }
    
    public int getNumWins() {
        return this.numWins;
    }

    public static void main(String[] args) {
        Player test = new Player('X');
        System.out.println(test);
        System.out.println(test.getChecker());
        System.out.println(test.getNumWins());
    }
}
