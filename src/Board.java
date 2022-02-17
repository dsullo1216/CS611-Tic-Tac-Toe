
// Abstract board class for implementing Board-based games. It holds a 2-D array of the Piece class and allows us to manipulate the board and check board status
public abstract class Board {
    
    // 2-D char array that will store the data for the board
    Piece[][] board; 

    // Default constructor that initializes board as a 3x3 2-D array
    public Board() {
        this.board = new Piece[3][3];
    }

    // Constructor that allows for 2-D array of any size square
    public Board(int boardSize) {
        this.board = new Piece[boardSize][boardSize];
    }

    // Constructor that allows for 2-D array of any size rectangle
    public Board(int boardLength, int boardWidth) {
        this.board = new Piece[boardLength][boardWidth];
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
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0) { 
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

    // Returns true if specified char has a win horizontally
    abstract public boolean isHorizontalWin(Piece checker);

    // Returns true if specified char has a win vertically
    abstract public boolean isVerticalWin(Piece checker);

    // Returns true if specifed char has a win diagonally from top-left to bottom-right
    abstract public boolean isDiagonalDownWin(Piece checker);

    // Returns true if specified char has a win diagonally from bottom-left to top-right
    abstract public boolean isDiagonalUpWin(Piece checker);

    // Returns true if specified char has a win in the game
    abstract public boolean isWin(Piece checker);

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
        board = new Piece[board.length][board[0].length];
    }
}