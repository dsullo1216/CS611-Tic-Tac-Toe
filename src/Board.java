package src;

public class Board {
    
    // 2-D char array that will store the data for the Tic-Tac-Toe board
    private char[][] board; 

    // Default constructor that initializes board as a 3x3 2-D array
    public Board() {
        this.board = new char[3][3];
    }

    // Constructor that allows for 2-D array of any size
    public Board(int boardSize) {
        this.board = new char[boardSize][boardSize];
    }

    // Overrides default toString method from Object class
    public String toString() {
        String s = "+-".repeat(this.board.length) + "+" + '\n';
        for (int i = 0; i < this.board.length; i++) {
            s += "|";
            for (int j = 0; j < this.board[0].length; j++) {
                if (this.board[i][j] == '\u0000') {
                    s += " ";
                }
                s += this.board[i][j];
                s += '|';
            }
            s += '\n' + "+-".repeat(this.board.length) + "+" + '\n';
        }
        return s;
    }

    // Valids parameters and procedes to add the desired checker to the Board
    public boolean addChecker(char checker, int row, int col) {
        if (checker != 'X' && checker != 'O') {
            System.out.println("Invalid checker type");
            return false;
        }
        if (row >= this.board.length || col >= this.board[0].length) { 
            System.out.println("Index is out of range");
            return false; 
        }
        if (this.board[row][col] != '\u0000') { 
            System.out.println("Space is already taken");
            return false; 
        }
        
        this.board[row][col] = checker;
        return true;
    }

    // Valids parameters and procedes to remove the desired index's checker from the Board
    public boolean removeChecker(int row, int col) {
        if (row >= this.board.length || col >= this.board[0].length) {
            System.out.println("Index is out of range");
            return false;
        }
        this.board[row][col] = '\u0000';
        return true;
    }

    // Returns true if specified char has a win in the game
    public boolean isWin(char checker) {
        if (checker != 'X' && checker != 'O') {
            System.out.println("Invalid checker type");
            return false;
        }
        // loops through possible row/col indices. checks for horizontal/vertical win each pass for efficiency
        for (int i = 0; i < this.board.length; i++) {
            // checks for horizontal win
            if (this.board[i][0] == checker && this.board[i][1] == checker && this.board[i][2] ==  checker) {
                return true;
            }
            // checks for vertical win
            if (this.board[0][i] == checker && this.board[1][i] == checker && this.board[2][i] ==  checker) {
                return true;
            }
        }
        // checks for upper-left to lower-right diagonal win
        if (this.board[0][0] == checker && this.board[1][1] == checker && this.board[2][2] ==  checker) {
            return true;
        }
        // checks for upper-right to lower-left diagonal win
        if (this.board[0][2] == checker && this.board[1][1] == checker && this.board[2][0] ==  checker) {
            return true;
        }
        // returns false if no win is found
        return false;
    }

    // Replaces current board's 2-D array with new default one
    public void reset() {
        this.board = new char[this.board.length][this.board.length];
    }
}