package src;

public class Piece {
    
    private char checker;

    public Piece(char checker) {
        assert (checker == 'X' || checker == 'O'): "Invalid Checker Type";
        this.checker = checker;
    }

    public String toString() {
        return this.checker + "";
    }

    public boolean equals(Piece other) {
        if (this.checker ==  other.checker) {
            return true;
        }
        return false;
    }

    public char getChecker() {
        return this.checker;
    }

    public char setChecker(char newChecker) {
        assert (newChecker == 'X' || newChecker == 'O' || newChecker == '\u0000'): "Invalid Checker Type";
        this.checker = newChecker;
        return this.checker;
    }


}