
// Board class for implementing Tic-Tac-Toe. It holds a 2-D array of the Piece class and allows us to manipulate the board and check board status
public class Board {
    
    // 2-D char array that will store the data for the Tic-Tac-Toe board
    private Piece[][] board; 

    // Default constructor that initializes board as a 3x3 2-D array
    public Board() {
        this.board = new Piece[3][3];
    }

    // Constructor that allows for 2-D array of any size
    public Board(int boardSize) {
        this.board = new Piece[boardSize][boardSize];
    }

    // Overrides default toString method from Object class
    public String toString() {
        String s = "+-".repeat(board.length) + "+" + '\n';
        for (int i = 0; i < board.length; i++) {
            s += "|";
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == null || board[i][j].getChecker() == '\u0000') {
                    s += " ";
                }
                else { 
                    s += board[i][j];
                }
                s += '|';
            }
            s += '\n' + "+-".repeat(board.length) + "+" + '\n';
        }
        return s;
    }

    // Valids parameters and procedes to add the desired checker to the Board
    public boolean addChecker(Piece checker, int row, int col) {
        if (checker.getChecker() != 'X' && checker.getChecker() != 'O') {
            System.out.println("Invalid checker type");
            return false;
        }
        if (row >= board.length || col >= board[0].length) { 
            System.out.println("Index is out of range");
            return false; 
        }
        if (board[row][col] == null) { 
            board[row][col] = checker;
            return true;
        }
        if (board[row][col].getChecker() != '\u0000') { 
            System.out.println("Space is already taken");
            return false; 
        }
        
        board[row][col] = checker;
        return true;
    }

    // Valids parameters and procedes to remove the desired index's checker from the Board
    public boolean removeChecker(int row, int col) {
        if (row >= board.length || col >= board[0].length) {
            System.out.println("Index is out of range");
            return false;
        }
        board[row][col].setChecker('\u0000');
        return true;
    }

    // Returns true if specified char has a win in the game
    public boolean isWin(Piece checker) {
        if (checker.getChecker() != 'X' && checker.getChecker() != 'O') {
            System.out.println("Invalid checker type");
            return false;
        }
        // loops through possible row/col indices. checks for horizontal/vertical win each pass for efficiency
        for (int i = 0; i < board.length; i++) {
            // checks for horizontal win
            if ((board[i][0] != null && board[i][0].equals(checker)) && (board[i][1] != null && board[i][1].equals(checker)) && (board[i][2] != null && board[i][2].equals(checker))) {
                return true;
            }
            // checks for vertical win
            if ((board[0][i] != null && board[0][i].equals(checker)) && (board[1][i] != null && board[1][i].equals(checker)) && (board[2][i] != null && board[2][i].equals(checker))) {
                return true;
            }
        }
        // checks for upper-left to lower-right diagonal win
        if ((board[0][0] != null && board[0][0].equals(checker)) && (board[1][1] != null && board[1][1].equals(checker)) && (board[2][2] != null && board[2][2].equals(checker))) {
            return true;
        }
        // checks for upper-right to lower-left diagonal win
        if ((board[0][2] != null && board[0][2].equals(checker)) && (board[1][1] != null && board[1][1].equals(checker)) && (board[2][0] != null && board[2][0].equals(checker))) {
            return true;
        }
        // returns false if no win is found
        return false;
    }

    // Iterates through Board and checks if the board is full; meaning a tie has occurred
    public boolean isFull() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == null || board[i][j].getChecker() == '\u0000') {
                    return false;
                }
            }
        }
        return true;
    }

    // Replaces current board's 2-D array with new default one
    public void reset() {
        board = new Piece[board.length][board.length];
    }
}