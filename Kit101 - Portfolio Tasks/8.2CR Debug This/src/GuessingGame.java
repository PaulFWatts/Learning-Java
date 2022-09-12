import java.util.Random;
import java.util.Scanner;

/**
 * A number guessing game with varying degrees of difficulty.
 * @author Anonymous, [add your name in corrected version]
 */
public class GuessingGame {

    public enum Outcome { CORRECT, TOO_HIGH, TOO_LOW, RAGE_QUIT };

    private final int[] DIFFICULTIES = { 25, 100, 1000 };
    private Random generator = new Random();
    private Scanner in = new Scanner(System.in);

    public int selectSecret(int max) {
        int secret = generator.nextInt(max) + 1;
        return secret;
    }

    public int selectDifficulty() {
        int option;

        do {
            System.out.print("New Game\n1. Easy\n2. Medium\n3. Hard\nSelect difficulty: ");
            option = in.nextInt();
        } while (option < 1 || option > 3);

        return DIFFICULTIES[option-1];
    }

    public void oneGame() {
        final int STOP_WHEN;
        Outcome result = null;
        int attempts = 1;
        int max, secret, guess;

        max = selectDifficulty();
        STOP_WHEN = -max;
        secret = selectSecret(max);

        System.out.print("Enter guess between 1 and " + max + ", or " + STOP_WHEN + " to give up: ");
        guess = in.nextInt();
        while (guess != secret && guess != STOP_WHEN) {
            if (guess < secret) {
                result = Outcome.TOO_LOW;
            } else if (guess > secret) {
                result = Outcome.TOO_HIGH;
            }
            showFeedback(result, attempts, secret, max);
            System.out.print("Enter guess between 1 and " + max + ", or " + STOP_WHEN + " to give up: ");
            guess = in.nextInt();
            attempts++;
        }

        if (guess == secret) {
            result = Outcome.CORRECT;
        } else {
            result = Outcome.RAGE_QUIT;
        }
        showFeedback(result, attempts, secret, max);
    }

    public void showFeedback(Outcome outcome, int attempts, int secret, int max) {
        switch (outcome) {
            case TOO_LOW:
                System.out.println("Too low!");
                System.out.println("Attempts so far: " + attempts);
                break;
            case TOO_HIGH:
                System.out.println("Too high!");
                System.out.println("Attempts so far: " + attempts);
                break;
            case RAGE_QUIT:
                System.out.println("Bad luck. You gave up after " + attempts + " attempts");
                System.out.println("The secret number was " + secret);
                break;
            case CORRECT:
                System.out.println("Congratulations ");
                System.out.println("Number of attempts: " + attempts);
                System.out.println("Efficiency: " + efficiency(attempts, max) + "%");
        }
    }

    public double efficiency(int attempts, int range) {
        double e;

        e = (double) (range - attempts + 1) / range;
        e = Math.round(e * 10000) / 100.0;

        return e;
    }

    public char nextChar() {
        return in.next().toLowerCase().charAt(0);
    }

    public void play() {
        char keepGoing;

        System.out.println("Number Guess Deluxe");
        System.out.println();
        System.out.print("Enter y to play (any other key to stop): ");
        keepGoing = nextChar();
        while (keepGoing == 'y') {
            oneGame();
            System.out.print("Enter y to play again (any other key to stop): ");
            keepGoing = nextChar();
        }
    }

    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
        game.play();
    }
}