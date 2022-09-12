import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 9.1PP A DNA sequencer to perform various operations with a dna String
 * representing DNA bases.
 *
 * @author Paul Watts
 * @date September, 2020
 *
 *       Note: Program could be refactored to call a method to display all
 *       output however have traded this off against readability and
 *       maintainability.
 */

class Sequencer {

  // Menu control logic
  public static void menu(String dna, Scanner sc) {
    int choice = 0; // menu choice

    while (choice != 6) {
      choice = getMenuChoice(sc); // Get menu choice from the user
      switch (choice) {
      case 1:
        displaySequence(dna);
        break;
      case 2:
        displayErrorRate(dna);
        break;
      case 3:
        transcribeEntireSequence(dna);
        break;
      case 4:
        transcribePartSequence(dna, sc);
        break;
      case 5:
        dna = switchComplement(dna);
        break;
      case 6:
        break;
      default:
        break;
      }
    }
  }

  // Obtain menu choice from the user with appropriate error handling
  public static int getMenuChoice(Scanner sc) {
    int choice = 0;
    boolean valid = false; // Evaluate a valid choice by user

    while (valid == false) {
      System.out.println("1. Display the sequence");
      System.out.println("2. Display the error rate");
      System.out.println("3. Transcribe the entire sequence");
      System.out.println("4. Transcribe a sequence section");
      System.out.println("5. Switch to the sequence's complement");
      System.out.println("6. Quit");
      System.out.println();
      System.out.print("Enter an option: ");

      /** Error check for an integer entry and valid range */
      try {
        choice = sc.nextInt(); // Read choice from user
        valid = true; // assume valid if error not thrown
      } catch (InputMismatchException ex) {
        sc.nextLine(); // clean up the scanner input buffer
        valid = false;
      }

      if (choice < 1 || choice > 6 || valid == false) {
        System.err.println("Error! Choice must be a number between 1 and 6");
        System.out.println();
        valid = false; // reset valid to false
      }
    }
    return choice;
  }

  // Obtain a DNA sequence without whitespaces and return it formatted
  public static String obtainSequence(Scanner sc) {
    String dna = null; // Stores the DNA sequence
    boolean contains = true; // tests for spaces (whitespace) in dna

    while (contains == true) {
      System.out.println("Please enter your DNA Sequence: ");
      dna = sc.nextLine();
      contains = dna.contains(" "); // test for white spaces in DNA sequence
      if (contains == true) {
        System.out.println("Spaces are not valid in a DNA sequence");
        System.out.println();
      }
    }
    dna = formatSequence(dna); // Parse and format the sequence
    return dna;
  }

  /**
   * format dna by making the string all upper case and replacing all non-DNA
   * characters with lower case n. Valid DNA characters are A,T,G,C
   */
  private static String formatSequence(String dna) {
    System.out.println();
    dna = dna.toUpperCase();
    dna = dna.replaceAll("[^ATGC]", "n"); // replace non valid DNA chars
    System.out.println("* Formatted the DNA sequence *");
    System.out.println();
    return dna;
  }

  /** display the sequence */
  private static void displaySequence(String dna) {
    System.out.println();
    System.out.println("Sequence: " + dna);
    System.out.println();
  }

  /**
   * calculate and display the proportion of invalid characters in the dna
   * sequence
   */
  private static void displayErrorRate(String dna) {
    int counter = 0; // counter for occurrences of invalid characters
    float percentage; // percentage of invalid characters

    /** count occurrences of invalid characters, represented by 'n' */
    for (int i = 0; i < dna.length(); i++) {
      if (dna.charAt(i) == 'n') {
        counter++;
      }
    }
    percentage = (float) ((counter * 100) / dna.length()); // express the result as a %
    System.out.println();
    System.out.println("Sequence error rate: " + percentage + "%");
    System.out.println();
  }

  /** Transcribe and display the mRNA equivalent of the entire dna sequence */
  private static void transcribeEntireSequence(String dna) {
    String mrna; // mRNA equivalent of dna

    System.out.println();
    mrna = dna.replace("T", "U");
    System.out.println("DNA sequence:    " + dna);
    System.out.println("mRNA equivalent: " + mrna);
    System.out.println();
  }

  /** Allow user to enter a portion of the sequence to transcribe */
  private static void transcribePartSequence(String dna, Scanner sc) {
    int start = 1; // starting position for transcription
    int end = 0; // ending position for transcription
    int length = dna.length(); // length of dna string
    String partial; // user selected portion of dna string
    String mrna; // mRNA equivalent of user selected portion of dna
    boolean error = true; // control logic for while loop

    System.out.println();

    while (error == true) {
      System.out.println("Enter starting position: ");
      start = sc.nextInt();
      System.out.println("Enter ending position: ");
      end = sc.nextInt();
      error = false; // clear error condition in preparation for test
      if (start < 1 || end > length) {
        System.out.println("Number must be greater than 0 and less than " + (length + 1));
        error = true; // set error condition
      }
    }
    partial = dna.substring((start - 1), end);
    mrna = partial.replace("T", "U");
    System.out.println();
    System.out.println("DNA partial sequence: " + partial);
    System.out.println("mRNA equivalent:      " + mrna);
    System.out.println();
  }

  /** switch the sequence to it's compliment according to replacement rules */
  private static String switchComplement(String dna) {

    dna = dna.replace("A", "t").replace("A", "t").replace("T", "a").replace("G", "c").replace("C", "g").toUpperCase()
        .replace("N", "n");

    System.out.println();
    System.out.println("Sequence complement: " + dna);
    System.out.println();
    return dna;
  }

  public static void main(String[] args) {
    String dna = null; // String to represent DNA sequence
    Scanner sc = new Scanner(System.in); // instantiate a new Scanner object
    sc.useDelimiter(System.lineSeparator()); // resolves /n problem with the Scanner

    System.out.println();
    System.out.println("Welcome to the DNA Sequencer");
    System.out.println();
    dna = obtainSequence(sc); // Obtain the required DNA sequence from the user
    menu(dna, sc); // Execute menu choices until user quits
  }
}
