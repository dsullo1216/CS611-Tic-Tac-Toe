# CS611-<ASSIGNMENT Order-And-Chaos/>
## Name
---------------------------------------------------------------------------
David Sullo
dsullo@bu.edu
U44891473
## Files
---------------------------------------------------------------------------
<.java file /> - <1 line comment about the file />
<Board.java> Abstract board class for implementing Board-based games. It holds a 2-D array of the Piece class and allows us to manipulate the board and check board status
<Game.java> Abstract game class for implementing Board-games based on checkers. Holds an instance of Board class and includes methods to faciliate games.
<Player.java> Abstract player class for implementing Tic-Tac-Toe and Order and Chaos. It holds the number of wins the player has. Includes getters/setters
<Piece.java> Piece class for implementing Tic-Tac-Toe. Holds a char of either 'X' or 'O' to be placed on the Board. Includes getters/setters
<TicTacToeBoard.java> Extension of Board class to represent a Tic-Tac-Toe board. Overrides abstract methods for checking for wins
<TicTacToeGame.java> Extension of Game class to represent a Tic-Tac-Toe game. Implements abstract methods needed to play Tic-Tac-Toe
<TicTacToePlayer.java> Extension of Player class to represent a Tic-Tac-Toe player. Overrides abstract class' toString and holds an instance of the Piece class
<OrderChaosBoard.java> Extension of Board class to represent an Order and Chaos board. Overrides abstract methods for checking for wins
<OrderChaosGame.java> Extension of Game class to represent an Order and Chaos game. Implements abstract methods needed to play Order and Chaos
<OrderChaosPlayer.java> Extension of Player class to represent an Order and Chaos player. Overrides abstract class' toString and holds an instance of a char to specify players
<GameCenter.java> Class to facilitate running both Tic-Tac-Toe and Order and Chaos
<Main.java> Wrapper class that invokes our GameCenter class to run GameCenter.
## Notes
---------------------------------------------------------------------------
## How to run
---------------------------------------------------------------------------
1. Navigate to the main Project Directory after downloading the files
2. Run command line from within the src folder
3. Run the following instructions on command line:
javac *.java
java Main