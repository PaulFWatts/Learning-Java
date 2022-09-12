import java.util.Scanner;

/**
 * Sum zero or more integers entered by the user until -1 entered.
 */
public class AddIntegers {

    public static void main(String[] args) {
        final int SENTINEL = -1;
        //Tip: Our prompt is 'parameterised' by the chosen sentinel value _and_
        //     will be used more than once, so let's make it a constant String
        final String PROMPT = "Enter an integer (or " + SENTINEL + " to finish and display total)";

        Scanner sc = new Scanner(System.in);
        int currentEntry;
        int total = 0;

        System.out.println(PROMPT);
        currentEntry = sc.nextInt();
        System.out.println("Information only: About to enter the loop");
        while (currentEntry != SENTINEL) {
            System.out.println("Information only: About to add " + currentEntry + " to the total " + total);
            total = total + currentEntry;
            System.out.println("Total now " + total);
            System.out.println(PROMPT);
            currentEntry = sc.nextInt();
        }
        System.out.println("Total is: " + total);
    }
}
