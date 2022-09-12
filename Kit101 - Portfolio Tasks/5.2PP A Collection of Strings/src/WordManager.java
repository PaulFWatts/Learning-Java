import java.util.Scanner;

/**
 * Word Manager (5.2PP Collection of Strings)
 *
 * This program allows a user to maintain a small collection of words and
 * display them comma delimited, as well as display the average word length.
 * Several common operations, for example deletion, are not supported at this
 * time.
 *
 * @author Paul Watts
 * @version 1.1 (August 2020)
 *
 */

public class WordManager {

  /**
   * Adds the word to the next empty space in the array and returns the total
   * number of words added.
   * 
   * @param words the array of words to be added to
   * @param count the current count of the number of words in the words array
   * @param word  the new word to be added
   * @return count the new total for the number of words in the the words array
   *
   */
  public static int add(String[] words, int count, String word) {
    if (count < words.length) {
      words[count] = word; // Add the passed word to the array.
      System.out.println("Added " + word); // Give the user feedback that the word has been added
      count++; // increment the counter for number of words added
    } else {
      System.out.println("Sorry! The collection is full");
    }
    System.out.println(); // Display a blank line for formatting reasons
    return count; // return total number of words added
  }

  /**
   * Displays the words in the words array as a comma separated list.
   * 
   * @param words the array of words
   * @param count the current count of the number of words in the the words array
   *
   */
  public static void printList(String[] words, int count) {
    System.out.println(); // start with a blank line
    for (int i = 0; i < count; i++) {
      System.out.print(words[i]); // print current elements of words array comma delimited
      if (i < (count - 1)) {
        System.out.print(", ");// Don't print comma delimiter after last word in array
      }
    }
    System.out.println(); // end with 2 blank lines
    System.out.println();
    return;
  }

  /**
   * Calculates the average length of the words in the words array.
   *
   * @param words the array of words
   * @param count the current count of the number of words in the words array
   * @return average the average length of the words in the array
   *
   */
  public static double averageLength(String[] words, int count) {
    double average = 0.0; // average length of words in the array
    double length = 0.0; // size of a particular word in the array
    double sum = 0.0; // total size of the words in the array

    for (int i = 0; i < count; i++) {
      length = words[i].length(); // get the size of the word
      sum = sum + length; // total the lengths
    }
    // Prevent a divide by 0 error if they never add a word. In this case average
    // will be 0.0
    if (count > 0)
      average = sum / count; // Calculate the average size of the words in the array
    return average;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); // new instance of scanner to read user input
    final int CAPACITY = 20; // the maximum number of elements in the words array
    int count = 0; // the number of elements in the words array
    int choice; // records the user's menu choice
    double average = 0.0; // average length of words in the array
    String aWord = null; // records a new word entered by a user
    String[] words = new String[CAPACITY]; // array used to store a collection of words entered by a user

    System.out.println("Word Manager"); // display name of program
    System.out.println();

    // Display Menu and obtain menu choice from user
    do {
      System.out.println("1. Add a word");
      System.out.println("2. Display words");
      System.out.println("3. Display average word length");
      System.out.println("4. Quit");
      System.out.println();
      System.out.print("Enter an option: ");
      choice = sc.nextInt(); // Read choice from user

      // First, error check the user's response
      if (choice < 1 || choice > 4) {
        System.out.println("Error! Choice must be between 1 and 4");
        System.out.println();
      }

      // Execute the required actions based on the user's choice
      switch (choice) {
      case 1: {
        System.out.print("Please enter the word to add to the collection: ");
        aWord = sc.next();
        count = add(words, count, aWord);
        break;
      }
      case 2: {
        printList(words, count);
        break;
      }
      case 3: {
        average = averageLength(words, count);
        System.out.println();
        System.out.println("Average word size in the collection is: " + average);
        System.out.println();
        break;
      }
      }

    } while (choice != 4); // Exit loop when user chooses menu choice 4

    // End program
    System.out.println();
    System.out.println("Thanks for running Word Manager");
    sc.close();
  }

}
