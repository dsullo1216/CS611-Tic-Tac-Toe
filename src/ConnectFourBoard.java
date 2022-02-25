// Extension of Board class to represent a Connect Four board. Overrides abstract methods for checking for wins
public class ConnectFourBoard extends Board{

    // Calls the Board constructor to initialize a 6x7 2-D list
    public ConnectFourBoard() {
        super(6, 7);
        winCondition = 4;
    }

    // Validates parameters and procedes to add the desired checker to the Board
    @Override
    public boolean addChecker(Piece checker, int col) {
        if (checker.getChecker() != 'X' && checker.getChecker() != 'O') {
            System.out.println("Invalid checker type");
            return false;
        }
        if (col >= board[0].length || col < 0) { 
            System.out.println("Index is out of range");
            return false; 
        }
        if (isColFull(col)) {
            System.out.println("Column is already full");
            return false;
        }
        int bottomRow = 0;
        while (bottomRow < board.length && board[bottomRow][col] == null) {
            bottomRow++;
        }
        board[bottomRow-1][col] = checker;
        return true;
    }

    public boolean isColFull(int col) {
        if (col >= board[0].length || col < 0) { 
            System.out.println("Index is out of range");
            return false; 
        }
        return !(board[0][col] == null);
    }

    // Returns true if specified char has a win horizontally
    @Override
    public boolean isHorizontalWin(Piece checker) {
        if (checker.getChecker() != 'X' && checker.getChecker() != 'O') {
            System.out.println("Invalid checker type");
            return false;
        }
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != null && board[i][j].equals(checker)) {
                    count++;
                    if (count >= winCondition) {
                        return true;
                    }
                }
                else {
                    count = 0;
                }
            }
            count = 0;
        }
        return false;
    }

    // Returns true if specified char has a win vertically
    @Override
    public boolean isVerticalWin(Piece checker) {
        int count = 0;
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != null && board[j][i].equals(checker)) {
                    count++;
                    if (count == winCondition) {
                        return true;
                    }
                }
                else {
                    count = 0;
                }
            }
            count = 0;
        }
        return false;
    }

    // Returns true if specifed char has a win diagonally from top-left to bottom-right
    @Override
    public boolean isDiagonalDownWin(Piece checker) {
        for (int i = 0; i < board.length - 3; i++) {
            for (int j = 0; j < board[0].length - 3; j++) {
                if ((board[i][j] != null && board[i][j].equals(checker)) && 
                (board[i+1][j+1] != null && board[i+1][j+1].equals(checker)) && 
                (board[i+2][j+2] != null && board[i+2][j+2].equals(checker)) && 
                (board[i+3][j+3] != null && board[i+3][j+3].equals(checker))) {
                    return true;
                }
            }
        }
        return false;
    }

    // Returns true if specified char has a win diagonally from bottom-left to top-right
    @Override
    public boolean isDiagonalUpWin(Piece checker) {
        for (int i = 3; i < board.length; i++) {
            for (int j = 0; j < board[0].length - 3; j++) {
                if ((board[i][j] != null && board[i][j].equals(checker)) && 
                (board[i-1][j+1] != null && board[i-1][j+1].equals(checker)) && 
                (board[i-2][j+2] != null && board[i-2][j+2].equals(checker)) && 
                (board[i-3][j+3] != null && board[i-3][j+3].equals(checker))) {
                    return true;
                }
            }
        }
        return false;
    }

    // Returns true if specified char has a win in the game
    @Override
    public boolean isWin(Piece checker) {
        if (checker.getChecker() != 'X' && checker.getChecker() != 'O') {
            System.out.println("Invalid checker type");
            return false;
        }
        return (isHorizontalWin(checker) || isVerticalWin(checker) || isDiagonalDownWin(checker) || isDiagonalUpWin(checker));
    }

}