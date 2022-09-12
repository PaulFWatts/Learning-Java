import java.util.Scanner;

/**
 * Typing Tutor (4.2PP Repetition, repetition, repetition)
 * 
 * This program tests a user's typing by allowing them to type a word as quickly
 * and accurately as they can and then reporting the results
 * 
 * @author Paul Watts
 * @version 1.0 (August 2020)
 */

public class TypingTutor {

  /**
   * Displays the heading in ALL CAPS, underlined by tildes (~), followed by a
   * blank line.
   */
  public static void printHeading(String heading) {
    System.out.println(heading.toUpperCase());
    for (int i = 0; i < heading.length(); i++) {
      System.out.print("~");
    }
    System.out.println();
    return;
  }

  /**
   * Tests the user's typing ability by having them type the given word correctly
   * at least required times before finishing. Returns the total number of
   * attempts. If the given word is never typed correctly, the required number of
   * times, this method won't end.
   */
  public static int runTutorial(Scanner in, String word, int required) {
    int attempts = 0; // Number of attempts to type the given word
    int correct = 0; // Number of times the given word was typed correctly

    do {
      System.out.print("Type '" + word + "': ");
      if (in.nextLine().equals(word)) {
        System.out.println("Correct!");
        correct++;
        attempts++;
      } else {
        System.out.println("Try again");
        attempts++;
      }
    } while (correct < required);

    return attempts;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    final String WORD = "cats"; // the word to type
    final int TIMES = 10; // required number of correct repetitions
    long startTime, endTime; // start and end time of typing test
    double seconds; // elapsed time in seconds
    int attempts; // the number of attempts to type the correct word

    printHeading("Typing Tutor");
    System.out.println("You need to type a word " + TIMES + " times correctly, as quickly as you can");
    System.out.println("Your word in today's test is '" + WORD + "' (do not enter the quotes)");
    System.out.println();

    // The test
    System.out.println("Press enter to start the test");
    sc.nextLine();
    startTime = System.currentTimeMillis();
    attempts = runTutorial(sc, WORD, TIMES);
    endTime = System.currentTimeMillis();

    // Test report
    seconds = (double) (endTime - startTime) / 1000;
    System.out.println("You took " + seconds + " seconds and " + attempts + " attempts to correctly type '" + WORD
        + "' " + TIMES + " times");
    System.out.println();
    printHeading("Come back for more practice soon");
    sc.close();
  }

}
