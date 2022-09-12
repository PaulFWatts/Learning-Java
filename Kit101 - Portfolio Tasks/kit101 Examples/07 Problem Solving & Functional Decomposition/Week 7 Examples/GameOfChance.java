import java.util.Scanner;

/** 
 * A simple die roll game to illustrate functional decomposition.
 * Method header comments removed to save space for in-class
 * demonstration.
 * 
 * @author James Montgomery
 * @version 6 April 2017
 */
public class GameOfChance {
    
    public static boolean continuePlay(Scanner in, String prompt) {
        System.out.print(prompt + " (y/n) ");
        return in.next().toLowerCase().equals("y");
    }
    
    public static void playGames(Scanner in) {
        int games = 0; //number of games played
        int score = 0; //player's current score
        do {
            games++;
            score += playOneGame(in);
            System.out.println("Cumulative score: " + score);
            if (score < 0) {
                System.out.println("You know gambling never pays, in the long run?");
            }
        } while (continuePlay(in, "Play again?"));
        System.out.println("Final score: " + score +
                           "\tAverage score: " + ((double)score/games));
    }
    
    public static int playOneGame(Scanner in) {
        final int CAP = 20; //if player exceeds this then they get negative points
        Die die = new Die(); //the game die
        int total = 0; //player's total
        
        do {
            total += die.roll();
            System.out.println("You rolled a " + die.getFaceValue() + " taking you to " + total);
        } while (total <= CAP && continuePlay(in, "Roll again?"));
        
        if (total <= CAP) {
            total = total / 4; //1 point per each whole 4 units in total
            System.out.println("You earned " + total + " points!");
        } else {
            total = CAP - total; //or lose one point for every unit over
            System.out.println("You went bust and lost " + total + " points!");
        }
        return total;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcome to Roll of the Dice*");
        System.out.println("\n(instructions would go here)\n\n*only one die included");
        if (continuePlay(sc, "Roll the die?")) {
            playGames(sc);
        }
        System.out.println("Thanks for playing!");
    }
    
}
