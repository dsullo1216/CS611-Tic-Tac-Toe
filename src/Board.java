package src;

public class Board {
    
    private char[][] board; // 2-D char array that will store the data for the Tic-Tac-Toe board

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

    public static void main(String[] args) {
        Board test = new Board();
        System.out.println(test);
    }
}