// Extension of Board class to represent an Order and Chaos board. Overrides abstract methods for checking for wins
public class OrderChaosBoard extends Board {

    // Calls the Board constructor to initialize a 6x6 2-D list 
    public OrderChaosBoard() {
        super(6);
        winCondition = 5;
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
                    break;
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
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[j][i] != null && board[j][i].equals(checker)) {
                    count++;
                    if (count >= winCondition) {
                        return true;
                    }
                }
                else {
                    count = 0;
                    break;
                }
            }
            count = 0;
        }
        return false;
    }

    // Returns true if specifed char has a win diagonally from top-left to bottom-right
    @Override
    public boolean isDiagonalDownWin(Piece checker) {
        for (int i = 0; i < board.length - 4; i++) {
            for (int j = 0; j < board[0].length - 4; j++) {
                if ((board[i][j] != null && board[i][j].equals(checker)) && 
                (board[i+1][j+1] != null && board[i+1][j+1].equals(checker)) && 
                (board[i+2][j+2] != null && board[i+2][j+2].equals(checker)) && 
                (board[i+3][j+3] != null && board[i+3][j+3].equals(checker)) && 
                (board[i+4][j+4] != null && board[i+4][j+4].equals(checker))) {
                    return true;
                }
            }
        }
        return false;
    }

    // Returns true if specified char has a win diagonally from bottom-left to top-right
    @Override
    public boolean isDiagonalUpWin(Piece checker) {
        for (int i = 4; i < board.length; i++) {
            for (int j = 0; j < board[0].length - 4; j++) {
                if ((board[i][j] != null && board[i][j].equals(checker)) && 
                (board[i-1][j+1] != null && board[i-1][j+1].equals(checker)) && 
                (board[i-2][j+2] != null && board[i-2][j+2].equals(checker)) && 
                (board[i-3][j+3] != null && board[i-3][j+3].equals(checker)) && 
                (board[i-4][j+4] != null && board[i-4][j+4].equals(checker))) {
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