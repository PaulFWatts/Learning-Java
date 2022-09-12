import java.util.Random;
import java.util.Scanner;

/**
 * An improved guessing game where (1) a user may play zero or more times,
 * (2) each time a new random secret number is selected and (3) the user is
 * given a hint if they are wrong.
 */
public class NumberGuessPlusCompleted {
    
    public static void main(String[] args) {
        final int MAX = 50;
        Random generator = new Random();
        Scanner sc = new Scanner(System.in);
        
        int hidden; 
        int guess; 
        String answer;
        
        System.out.print("Do you want to play the game,(y)es or (n)o: ");
        answer = sc.next();
        while (answer.equalsIgnoreCase("y")) {
            hidden = generator.nextInt(MAX) + 1;
            do {
                System.out.print("Enter your next guess: ");
                guess = sc.nextInt();

                if (guess < hidden) {
                    System.out.println("too low");
                } else if (guess > hidden) {
                    System.out.println("too high");
                }
            } while (guess != hidden);

            System.out.println("Well done");
            System.out.print("Do you want to play the game,(y)es or (n)o: ");
            answer = sc.next();
        }
     }

}
