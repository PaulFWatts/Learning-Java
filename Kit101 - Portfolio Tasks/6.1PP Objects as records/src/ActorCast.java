import java.util.Scanner;

/**
 * Actor Cast (6.1PP Objects as records)
 *
 * This program allows recording of details for Actors being considered for
 * casting and creates an Actor DataType with the entered details.
 *
 * @author Paul Watts
 * @version 1.0 (August 2020)
 *
 */

public class ActorCast {

  /**
   * This method reads the required data from the user and Instantiates a new
   * Actor DataType
   * @return actor A new Actor DataType
   */
  
  public static Actor readActor() {
    Scanner sc = new Scanner(System.in); // A new instance of Scanner to read user input
    String name = null; // First and last name of the Actor
    int membershipId = 0; // Screen Guild Membership number
    int revenue = 0; // Expected revenue film contribution in AUD$M

    // Get the required details from the user
    System.out.print("Please enter first and last name of the Actor: ");
    name = sc.nextLine();
    System.out.print("Please enter the Screen Guild membership ID: ");
    membershipId = sc.nextInt();

    while (revenue <= 0) {
      System.out.print("Please enter the estimated film revenue contribution in Millions: ");
      revenue = sc.nextInt();
      if (revenue <= 0) {
        System.out.println("Error! Revenue must be greater than 0");
      }
    }
    // Instantiate a new Actor DataType with the entered details
    Actor actor = new Actor(name, membershipId, revenue);
    sc.close();
    return actor;
  }

  public static void main(String[] args) {

    Actor actor = null; // local variable for Actor DataType

    System.out.println("Enter Actor Data");

    // Call readActor method to obtain Actor details from user and return an Actor
    // DataType
    actor = readActor();
    System.out.println("You entered:");
    System.out.println(actor);

  }
}
