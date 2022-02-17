import java.util.Scanner;

// Wrapper class that invokes our Game class to run Tic-Tac-Toe.
public class Main {
    public static void main(String[] args) {
        GameCenter gameCenter = new GameCenter();
        Scanner sc = new Scanner(System.in);
        gameCenter.playGameCenter(sc);
        sc.close();
    } 
    
}