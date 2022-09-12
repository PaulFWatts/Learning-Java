import java.util.Random;
import java.util.Scanner;

/**
 * An improved guessing game where (1) a user may play zero or more times,
 * (2) each time a new random secret number is selected and (3) the user is
 * given a hint if they are wrong.
 */
public class NumberGuessPlusStart {

    public static void main(String[] args) {
        final int MAX = 50;
        Random generator = new Random();
        Scanner sc = new Scanner(System.in);

        int hidden;
        int guess;
        String answer;

        //Note: Code has been indented to match completed solution

        //TASK: Prompt the user: do they want to play?

        //TASK: Add an outer loop to check if user wants to play/keep playing

            hidden = generator.nextInt(MAX) + 1;
            do {
                System.out.print("Enter your next guess: ");
                guess = sc.nextInt();

                //TASK: Provide feedback if guess too low or too high




            } while (guess != hidden);

            System.out.println("Well done");
            //TASK: Prompt the user: do they want to keep playing?


     }

}
