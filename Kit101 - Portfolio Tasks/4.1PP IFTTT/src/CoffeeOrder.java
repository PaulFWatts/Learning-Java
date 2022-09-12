import java.util.Scanner;

/**
 * Coffee Order Generator (4.1PP IFTTT)
 * 
 * This program reads a user's coffee order and outputs the order details based
 * on their preferences.
 * 
 * @author Paul Watts
 * @version 1.0 (August 2020)
 */
public class CoffeeOrder {

  public static void main(final String[] args) {
    final Scanner sc = new Scanner(System.in);
    String coffee; // user's description of kind of coffee
    int shots; // number of coffee shots, 1, 2, possibly higher
    boolean useSoy; // use soy milk instead of regular milk?

    // Get coffee details from user
    System.out.print("What kind of coffee would you like (e.g., latte, cappuccino)? ");
    coffee = sc.nextLine(); // in case they say 'flat white'
    System.out.print("How many shots (1, 2, ...)? ");
    shots = sc.nextInt();
    System.out.print("With soy milk (true or false)? ");
    useSoy = sc.nextBoolean();

    // Display order details
    System.out.print("Order details: ");

    // Display message based on the number of shots entered
    if (shots == 1) {
      System.out.print(" Single Shot ");

    } else if (shots == 2) {
      System.out.print(" Double Shot ");

    } else {
      System.out.print(" Dark and bitter ");
    }

    // Display message based on their soy milk selection
    if (useSoy == true) {
      System.out.print("soy ");
    }

    // Display the type of coffee they entered
    System.out.println(coffee);

    sc.close();

  }
}
