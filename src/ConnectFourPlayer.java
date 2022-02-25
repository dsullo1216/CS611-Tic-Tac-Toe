// Extension of Player class to represent a Connect Four player. Overrides abstract class' toString and holds an instance of the Piece class
public class ConnectFourPlayer extends Player {

    //char storing either 'X' or 'O' as the Player's checker
    private Piece checker;

    // Constructor that takes either 'X' or 'O' as parameter and initializes numWins
    public ConnectFourPlayer(Piece checker){
        assert (checker.getChecker() == 'X' || checker.getChecker() == 'O'): "Invalid Checker Type";
        this.checker = checker;
        this.numWins = 0;
    }

    // Overrides default toString method from Object class
    @Override
    public String toString() {
        return "Player " + checker;
    }

    // getter than returns the value for checker
    public Piece getChecker() {
        return this.checker;
    }
    
}