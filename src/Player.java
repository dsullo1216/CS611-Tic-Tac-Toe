package src;

public class Player {

    private char checker;
    private int numWins;

    public Player(char checker) {
        assert (checker == 'X' || checker == 'O'): "Invalid Checker Type";
        this.checker = checker;
        this.numWins = 0;
    }
}
