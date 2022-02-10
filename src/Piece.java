
// Piece class for implementing Tic-Tac-Toe. Holds a char of either 'X' or 'O' to be placed on the Board. Includes getters/setters
public class Piece {

    // Just holds our checker character for Tic-Tac-Toe
    private char checker;

    // Constructor that validates that the checker is either X or O
    public Piece(char checker) {
        assert (checker == 'X' || checker == 'O'): "Invalid Checker Type";
        this.checker = checker;
    }

    // Overrides default toString method from Object class
    public String toString() {
        return this.checker + "";
    }

    // Overrides default equals method from Object class
    public boolean equals(Piece other) {
        if (this.checker ==  other.checker) {
            return true;
        }
        return false;
    }

    // getter than returns the char for the Piece
    public char getChecker() {
        return this.checker;
    }

    // setter than lets us update the value for the checker char
    public char setChecker(char newChecker) {
        assert (newChecker == 'X' || newChecker == 'O' || newChecker == '\u0000'): "Invalid Checker Type";
        this.checker = newChecker;
        return this.checker;
    }


}