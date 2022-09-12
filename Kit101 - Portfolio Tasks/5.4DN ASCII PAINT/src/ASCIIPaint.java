import java.util.Scanner;

/**
 * 5.4DN ASCII Paint Command-driven paint program for text-based images.
 * 
 * @author Paul Watts
 * @version 1.1 (August 2020)
 *
 */
public class ASCIIPaint {

  /**
   * Converts the multi-line String into a 2D array of characters. Each line in
   * the String must be the same length.
   */
  public static char[][] stringToImage(String str) {
    char[][] result;
    String[] rows;

    rows = str.split("\n");
    result = new char[rows.length][];
    for (int r = 0; r < rows.length; r++) {
      result[r] = rows[r].toCharArray();
    }
    return result;
  }

  /** Reads the next character the user enters. */
  public static char nextChar(Scanner in) {
    return in.next().charAt(0);
  }

  /**
   * Displays the given character-based image with a leading and trailing blank
   * line.
   */
  public static void displayImage(char[][] image) {
    System.out.println(); // Leading blank line
    for (int row = 0; row < image.length; row++) {
      for (int col = 0; col < image[row].length; col++) {
        System.out.print(image[row][col]);
      }
      System.out.println(); // Finished printing the row,add a new line before printing next row
    }
    System.out.println(); // Trailing blank line
  }

  /** Returns true if (row, col) is inside the image, false otherwise. */
  public static boolean inBounds(int row, int col, char[][] image) {
    if (row >= 0 && (row) < image.length) {
      if (col >= 0 && col < image[(row)].length) {
        return true;
      }
    }
    return false;
  }

  /**
   * Displays the 9 cells in the image centred at (row, col). Displays a space for
   * any cell that is outside the image's bounds.
   */
  public static void zoom(char[][] image, int row, int col) {
    int x = 0; // row loop counter
    int y = 0; // column loop counter
    int r = row - 1; // row position counter

    while (x < 3) { // Display 3 rows only
      while (y < 3) { // Display 3 columns only
        if (inBounds(r, (col - 1), image)) {
          System.out.print(image[r][(col - 1)]); // output the element at the valid array position
        } else {
          System.out.print(" "); // it's out of bounds, print a space
        }
        if (inBounds(r, col, image)) {
          System.out.print(image[r][(col)]); // output the element at the valid array position
        } else {
          System.out.print(" "); // it's out of bounds, print a space
        }
        if (inBounds(r, (col + 1), image)) {
          System.out.println(image[r][(col + 1)]); // output the element at the valid array position
        } else {
          System.out.println(" "); // it's out of bounds, print a space
        }
        r++; // Increment the row position counter
        y++; // Increment the column loop counter
      }
      x++; // Increment the row loop counter
    }
  }

  /**
   * Starts a flood fill operation by selecting the replacement colour at the
   * given row and column.
   */
  public static void floodFill(char[][] image, int row, int col, char fill) {
    // must be within the bounds of the image and not already equal to fill
    if (inBounds(row, col, image) && image[row][col] != fill) {
      floodFill(image, row, col, image[row][col], fill);
    }
  }

  /**
   * Performs flood fill, replacing replace with fill, starting from (row, col).
   */
  public static void floodFill(char[][] image, int row, int col, char replace, char fill) {
    if (inBounds(row, col, image) && (image[row][col] == replace)) {
      image[row][col] = fill;
    } else
      return;

    // Recursive call to fill all adjacent positions within bounds
    floodFill(image, (row - 1), col, replace, fill);
    floodFill(image, (row + 1), col, replace, fill);
    floodFill(image, row, (col - 1), replace, fill);
    floodFill(image, row, (col + 1), replace, fill);
    return;
  }

  public static void main(String[] args) {
    // Commands
    final char CMD_PRINT = 'p', CMD_ZOOM = 'z', CMD_FILL = 'f', CMD_HELP = '?', CMD_LOAD = 'l', CMD_SAVE = 's',
        CMD_QUIT = 'q';
    Scanner sc = new Scanner(System.in);
    char[][] image; // the character-based 'image'
    char command; // user's entered command
    int row = 0; // |
    int col = 0; // |- command parameters
    char brush; // |
    char fill; // fill character

    // The initial image source
    String strImage = "######  ######  ########\n" + "########  #######  #####\n" + "#####  ##### #### ######\n"
        + "#####   ######## #######\n" + "##### #######   ########\n" + "######  ###  ###########\n"
        + "### ############   #####\n" + "##### #########   ######\n" + "#### ####  #### ###  ###";

    image = stringToImage(strImage);
    System.out.println("ASCII Paint");
    System.out.println("===========");
    System.out.println();
    System.out.println("Enter commands (? for help). There are no further prompts after this point.");

    do {
      command = nextChar(sc); // read the next single-character command

      switch (command) {
      case CMD_PRINT:
        displayImage(image);
        break;
      case CMD_ZOOM:
        // Trap any input exception errors (e.g a char or String)
        try {
          row = sc.nextInt();
          col = sc.nextInt();
        } catch (Exception e) {
          System.err.println("row and col must be a number");
          System.out.println();
          sc.nextLine(); // Flush the input buffer so it won't trigger the menu again
          break;
        }
        // We have a number,make sure it is valid as an array counter (can be out of
        // bounds)
        if (row < 0 || col < 0) {
          System.err.println("row and col must be a number >= 0");
          System.out.println();
          sc.nextLine(); // Flush the input buffer so it won't trigger the menu again
          break;
        }
        zoom(image, row, col); // Call zoom method to "zoom" in on the image
        break;
      case CMD_FILL:
        // Trap any input exception errors
        try {
          row = sc.nextInt();
          col = sc.nextInt();
          fill = sc.next().charAt(0);
        } catch (Exception e) {
          System.err.println("Invalid, please try again");
          System.out.println();
          sc.nextLine(); // Flush the input buffer so it won't trigger the menu again
          break;
        }
        // We have a number,make sure it is valid as an array counter (can be out of
        // bounds)
        if (row < 0 || col < 0) {
          System.err.println("row and col must be a number >= 0, please try again");
          System.out.println();
          sc.nextLine(); // Flush the input buffer so it won't trigger the menu again
          break;
        }
        floodFill(image, row, col, fill);
        break;
      case CMD_LOAD:
        // TODO

      case CMD_SAVE:
        // TODO
        System.err.println("Feature not implemented");
        break;
      case CMD_QUIT:
        break;
      case CMD_HELP:
      default:
        System.out.println("\nCommands:");
        System.out.println(CMD_PRINT + "             \tDisplay the image");
        System.out.println(CMD_ZOOM + " row col     \tShow cells surrounding (row, col)");
        System.out.println(CMD_FILL + " row col fill\tFill from (row, col) with fill (a single character)");
        System.out.println(CMD_HELP + "             \tShow this list of commands");
        System.out.println(CMD_LOAD + " filename    \tLoad the text image from filename");
        System.out.println(CMD_SAVE + " filename    \tSave the current image to filename");
        System.out.println(CMD_QUIT + "             \tLeave the program");
        System.out.println("\nCommands may be chained together, separated by whitespace");
        System.out.println();
      }
    } while (command != CMD_QUIT);
    sc.close();
  }

}
