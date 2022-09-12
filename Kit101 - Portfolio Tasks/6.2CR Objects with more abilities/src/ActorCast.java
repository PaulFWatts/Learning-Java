import java.util.Scanner;

/**
 * Actor Cast (6.2CR Objects with more abilities)
 *
 * This program allows recording of details for Actors being considered for
 * casting and creates an Actor DataType with the entered details. 2020-08-21
 * Added method to read an Actor.Skill from the user and pass to Actor
 * 2020-08-21 Added call to obtain the Agent's commission and output it
 *
 * @author Paul Watts
 * @version 1.1 (August 2020)
 *
 */

public class ActorCast {

  /**
   * This method reads the required data from the user and Instantiates a new
   * Actor DataType /* /* @return actor A new Actor DataType
   */
  public static Actor readActor() {
    Scanner sc = new Scanner(System.in); // A new instance of Scanner to read user input
    Actor.Skill skill; // Skill level of the actor
    String name = null; // First and last name of the Actor
    int membershipId = 0; // Screen Guild Membership number
    int revenue = 0; // Expected revenue film contribution in AUD$M
    int choice = 0; // menu choice for actor skill level
    double commission = 0.0; // Agent's commission based on 1% of Actors revenue

    // Get the name and membership ID from the user
    System.out.print("Please enter first and last name of the Actor: ");
    name = sc.nextLine();
    System.out.print("Please enter the Screen Guild membership ID: ");
    membershipId = sc.nextInt();

    // Get the revenue from the user ensuring that it's a valid number
    while (revenue <= 0) {
      System.out.print("Please enter the estimated film revenue contribution in Millions: ");
      revenue = sc.nextInt();
      if (revenue <= 0) {
        System.out.println("Error! Revenue must be greater than 0");
      }
    }

    // Get the actor's skill level ensuring they make a valid choice
    System.out.println("Please enter the skill level for the actor: ");
    while (choice <= 0) {
      System.out.println("1 " + Actor.Skill.WOODEN);
      System.out.println("2 " + Actor.Skill.HAM);
      System.out.println("3 " + Actor.Skill.OSCAR_WORTHY);
      System.out.print("Choice ( 1 - 3): ");
      choice = sc.nextInt();
      if (choice <= 0) {
        System.out.println("Error! Choice must be between 1 and 3 inclusive");
      }
    }
    switch (choice) {
    case 1:
      skill = Actor.Skill.WOODEN;
      break;
    case 2:
      skill = Actor.Skill.HAM;
      break;
    case 3:
      skill = Actor.Skill.OSCAR_WORTHY;
      break;
    default:
      skill = Actor.Skill.WOODEN;
    }

    // Instantiate a new Actor DataType with the entered details (commission will be
    // calculated)
    Actor actor = new Actor(name, membershipId, revenue, skill, commission);
    sc.close();
    return actor;
  }

  public static void main(String[] args) {
    Actor actor = null; // local variable for Actor DataType
    double commission = 0.0;
    System.out.println("Enter Actor Data");

    // Call readActor method to obtain Actor details from user and return an Actor
    // DataType
    actor = readActor();

    // Output the results
    System.out.println("You entered:");
    System.out.println(actor); // Print Actor details using toString method
    // Note it would be tidier to add commission to the toString method but
    // following assignment instructions
    commission = Actor.getCommission(); // Call getCommission method on Actor to obtain Agent's commission
    System.out.println("Commission:$" + String.format("%.2f", commission)); // format to 2 decimal place

  }
}
