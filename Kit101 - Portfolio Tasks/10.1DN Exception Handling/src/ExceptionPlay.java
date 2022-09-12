import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.Reader;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.net.URL;
import java.net.MalformedURLException;

/**
 * Exception Play (10.1 Exception Handling)
 * 
 * A collection of code samples that will involve exception handling.
 * 
 * @author James Montgomery, Paul Watts
 */
public class ExceptionPlay {
  /** Program menu options */
  enum MenuOption {
    DIVIDE, ARRAY, FILE, URL, QUIT
  };

  /** Runs the integer division example. */
  public static void divide(Scanner in) {
    int number, divisor = 0, answer = 0;
    char goOn = 'y';

    System.out.println("\nDivision Example");
    while (goOn == 'y') {
      System.out.print("Enter number to divide: ");
      number = in.nextInt();
      System.out.print("Enter number to divide by: ");
      divisor = in.nextInt();
      try {
        answer = number / divisor;
        System.out.println("Answer: " + answer);
      } catch (ArithmeticException ex) {
        System.err.print("Unable to perform the division: " + ex.getMessage());
        System.out.println();
      }
      System.out.println("\nDo another? (y/n)");
      goOn = in.next().toLowerCase().charAt(0);
    }
  }

  /** Runs the array access example. */
  public static void arrayAccess(Scanner in) {
    int[] data = { 2, 4, 6, 0, 1 };
    int index; // user's selected position to view
    char goOn = 'y';

    System.out.println("\nArray Access Example");
    while (goOn == 'y') {
      System.out.print("Enter an index to view: ");
      index = in.nextInt();
      try {
        System.out.println("Value at position " + index + " is " + data[index]);
      } catch (ArrayIndexOutOfBoundsException ex) {
        System.err.print("Unable to view the index: " + ex.getMessage());
        System.out.println();
      }

      System.out.println("\nInspect another? (y/n)");
      goOn = in.next().toLowerCase().charAt(0);
    }
  }

  /**
   * Reads and displays lines of text from the given data source, which could be
   * standard input, a file, or even a network connection. Closes the Reader
   * object (indirectly) at the end.
   */
  public static void readAndDisplay(Reader reader) throws IOException {
    BufferedReader in; // a Reader that can read whole lines at a time
    String line; // a line of text from the data source

    in = new BufferedReader(reader);
    line = in.readLine();
    while (line != null) {
      System.out.println(line);
      line = in.readLine();
    }
    in.close();
  }

  /** Runs the file reading example. */
  public static void readFile(Scanner in) {
    String fileName;

    try {
      System.out.print("Enter a file name in current directory: ");
      fileName = in.nextLine();
      System.out.println("Contents of " + fileName + ":");
      readAndDisplay(new FileReader(fileName));
    } catch (IOException ex) {
      System.out.println();
      System.err.print("Unable to access the file: " + ex.getMessage());
      System.out.println();
    }
  }

  /** Runs the web page reading example. */
  public static void readWebPage(Scanner in) {
    String urlString; // the user's input
    URL url; // an actual URL object

    System.out.print("Enter a web page URL: ");
    urlString = in.next();
    try {
      url = new URL(urlString);
      System.out.println("Contents of " + url + ":");
      readAndDisplay(new InputStreamReader(url.openStream()));
    } catch (MalformedURLException ex) {
      System.out.println();
      System.err.print("URL error due to " + ex.getMessage());
      System.out.println();
    } catch (IOException ex) {
      System.out.println();
      System.err.print("URL error due to  " + ex.getMessage());
      System.out.println();
    }
  }

  public static void main(String[] args) {
    final int LAST_OPTION = 5;
    Scanner sc = new Scanner(System.in);
    int choice; // user's numerical choice
    MenuOption option = null; // user's actual selection

    do {
      System.out.print("Exception Examples\n1. Integer division\n2. Array access\n"
          + "3. File reading\n4. Read a web page\n5. Quit\nSelection: ");
      choice = sc.nextInt();
      sc.nextLine(); // read past newline after user's menu choice
      option = (choice > 0 && choice <= LAST_OPTION) ? MenuOption.values()[choice - 1] : null; // <-- clever but not
                                                                                               // very readable use of
                                                                                               // an enum
      switch (option) {
      case DIVIDE:
        divide(sc);
        break;
      case ARRAY:
        arrayAccess(sc);
        break;
      case FILE:
        readFile(sc);
        break;
      case URL:
        readWebPage(sc);
      }
    } while (option != MenuOption.QUIT);
  }
}
