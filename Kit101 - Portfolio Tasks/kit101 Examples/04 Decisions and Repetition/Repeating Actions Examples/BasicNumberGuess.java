import java.util.Random;
import java.util.Scanner;

/**
 * Basic guessing game that doesn't give the user any hint upon each
 * incorrect guess.
 */
public class BasicNumberGuess {

    public static void main(String[] args) {
        final int MAX = 10; //number to guess will be between 1 and MAX
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int hidden; //the secret to guess
        int guess; //the user's current guess

        //initialisation
        hidden = rand.nextInt(MAX) + 1; //a random number between 1 and MAX inclusive
        do {
            System.out.print("Enter the correct number (between 1 and " + MAX + "): ");
            guess = sc.nextInt(); //the body & update
        } while (guess != hidden); //the test
        System.out.println("Well done");
    }

}
