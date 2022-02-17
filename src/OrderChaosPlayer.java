// Extension of Player class to represent an Order and Chaos player. Overrides abstract class' toString and holds an instance of a char to specify players
public class OrderChaosPlayer extends Player {

    private char playerNum;

    public OrderChaosPlayer(char playerNum) {
        assert (playerNum == '1' || playerNum == '2'): "Invalid Player Number";
        this.playerNum = playerNum;
        this.numWins = 0;
    }
    @Override
    public String toString() {
        return "Player " + playerNum;
    }

    public char getPlayerNum() {
        return this.playerNum;
    }
}
