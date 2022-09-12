import java.util.Scanner;

/**
 * 4.3CR User Input Functions
 * 
 * @author Paul Watts
 * @version 1.1 (August 2020)
 */
public class UserInput {

  /**
   * This method prompts the user to enter an integer within a given range and
   * continues prompting them until they enter a valid response within that range
   * 
   * @param in     Scanner object
   * @param prompt Prompt to display to the user
   * @param min    Minimum number in the required range
   * @param max    Maximum number in the required range
   * @return value Entered value
   */
  public static int promptForInt(Scanner in, String prompt, int min, int max) {
    int value = 0; // Entered value by user

    do {
      System.out.print(prompt + " between " + min + " and " + max + ": ");
      value = in.nextInt();
      if ((value < min) || (value > max)) {
        System.out.println();
        System.out.println("Error! Number must be an integer between " + min + " and " + max);
        System.out.println();
      }
    } while ((value < min) || (value > max));

    return value;
  }

  /**
   * This method prompts the user to enter a double within a given range and
   * continues prompting them until they enter a valid response within that range
   * 
   * @param in     Scanner object
   * @param prompt Prompt to display to the user
   * @param min    Minimum number in the required range
   * @param max    Maximum number in the required range
   * @return value Entered value
   */

  public static double promptForDouble(Scanner in, String prompt, double min, double max) {
    double value = 0.0; // Entered value by user

    do {
      System.out.print(prompt + " between " + min + " and " + max + ": ");
      value = in.nextDouble();
      if ((value < min) || (value > max)) {
        System.out.println();
        System.out.println("Error! Number must be a percent value between " + min + " and " + max);
        System.out.println();
      }
    } while ((value < min) || (value > max));

    return value;
  }

  /**
   * This method is used to control continuing the program or ending it
   * 
   * @param in     Scanner object
   * @param prompt Prompt to display to the user
   * @return value Returned value; true to continue or false to end
   */
  public static boolean promptForYesNo(Scanner in, String prompt) {
    String input; // Used to capture user's input
    boolean test = false; // Used to control logic flow
    boolean value = false; // Returned value

    do {
      System.out.print(prompt + " (yes/no): ");
      input = in.next();
      if (input.toLowerCase().equals("y") || input.toLowerCase().equals("yes") || input.toLowerCase().equals("true")) {
        value = true;
        test = true;
      }
      if (input.toLowerCase().equals("n") || input.toLowerCase().equals("no") || input.toLowerCase().equals("false")) {
        value = false;
        test = true;
      }
      if ((!test)) {
        System.out.println();
        System.out.println("Error! Answer must be `yes`,`y`,`true` or `no`,`n`,`false`");
        System.out.println();
      }
    } while (!test);

    return value;

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // All values are initialised so code will compile and run
    int guess = -1; // user's guess (between 1 and 10)
    double percent = -1; // a percentage (as a value between 0 and 1)
    boolean again = false; // do they want to go again?

    System.out.println("Testing prompt for int... the number should be saved in guess.");
    System.out.println(" - Enter '20' -- should loop with error");
    System.out.println(" - Enter '-2' -- should loop with error");
    System.out.println(" - Enter '2' and it should work");
    guess = promptForInt(sc, "Enter a number", 1, 10);
    System.out.println("Guess: " + guess);
    System.out.println();

    System.out.println("Testing prompt for double... the number should be saved in percent.");
    System.out.println(" - Enter '20' -- should loop with error");
    System.out.println(" - Enter '-1' -- should loop with error");
    System.out.println(" - Enter '0.5' and it should work");
    percent = promptForDouble(sc, "Enter percent value", 0.0, 1.0);
    System.out.println("Percent: " + percent);
    System.out.println();

    System.out.println("Testing prompt for yes/no... the result is saved in again.");
    System.out.println(" - Extend these boolean tests by adding more messages to verify your solution!");
    System.out.println(" - Enter 'yes' and it should succeed");
    again = promptForYesNo(sc, "Play again?");
    System.out.println("Again: " + again);
    System.out.println();
    System.out.println(" - Verify that it can also read in false...");
    again = promptForYesNo(sc, "Play again?");
    System.out.println("Again: " + again);
    System.out.println();

    System.out.println("Tests complete...");
    sc.close();
  }
}
