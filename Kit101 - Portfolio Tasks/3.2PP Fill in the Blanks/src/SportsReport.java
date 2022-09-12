import java.util.Scanner;

/**
 * 3.2PP Sports News Generator
 * 
 * @author Paul Watts
 */
public class SportsReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String winner; //winning team's name, may be multiple words
        String loser; // losing team's name
        int round; //current competition round
        int winnerPoints; // points scored by winner
        int loserPoints; // points scored by loser
        int difference; // point difference

/**
 * This code will require refactoring once further Java knowledge is obtained in this course. For example
 * it is possible to enter a lower number or the same number for the winning team as the losing team resulting in a draw 
 * or a negative number value being displayed for the difference.
 */
        System.out.println("Sports News Weekly");
        System.out.println();
        System.out.print("Enter the winning team's name: ");
        winner = sc.nextLine();
        System.out.print("Enter the losing team's name: ");
        loser = sc.nextLine();
        System.out.print("What round of the competition? ");
        round = sc.nextInt();
        System.out.print("Points scored by the winning team? ");
        winnerPoints = sc.nextInt();
        System.out.print("Points scored by the losing team? ");
        loserPoints = sc.nextInt();
        difference = winnerPoints - loserPoints; // Calulate the point difference
        System.out.println();
        System.out.println(winner + " beat " + loser + " by " + difference + " points at the weekend in a thrilling game.");
        System.out.println("The final score line was " + winnerPoints + " points" + " to " + loserPoints + ".");
        System.out.println("After just " + round + " rounds " + winner + " look like favourites to win the competition.");
    }
}
