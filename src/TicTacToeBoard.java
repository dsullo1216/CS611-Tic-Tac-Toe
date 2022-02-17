public class TicTacToeBoard extends Board {
    
    public TicTacToeBoard() {
        super(3);
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
                    }
                    else {
                        count = 0;
                        break;
                    }
                }
                if (count == board.length) {
                    return true;
                }
                else {
                    count = 0;
                }
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
                    }
                    else {
                        count = 0;
                        break;
                    }
                }
                if (count == board.length) {
                    return true;
                }
                else {
                    count = 0;
                }
            }
            return false;
        }
    
        // Returns true if specifed char has a win diagonally from top-left to bottom-right
        @Override
        public boolean isDiagonalDownWin(Piece checker) {
            int count = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][i] != null && board[i][i].equals(checker)) {
                    count++;
                }
                else {
                    count = 0;
                    break;
                }
                if (count == board.length) {
                    return true;
                }
            }
            return false;
        }
    
        // Returns true if specified char has a win diagonally from bottom-left to top-right
        @Override
        public boolean isDiagonalUpWin(Piece checker) {
            int count = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][i] != null && board[i][i].equals(checker)) {
                    count++;
                }
                else {
                    count = 0;
                    break;
                }
                if (count == board.length) {
                    return true;
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
