import java.util.Scanner;

/**
 * ActorCast (Copied from 7.1PP Arrays of objects and refactored)
 *
 * This class is called by ActorMain and creates an array of Actor Objects of
 * Actors being considered for casting. It creates the array with the details
 * entered by the user and displays the full actor details or just the most
 * valuable actor or the average actor revenue.
 *
 * @author Paul Watts
 * @version 1.1 (October 2020)
 *
 *
 */

public class ActorCast {
  private Scanner sc;
  private int numActors; // number of actors in the actors array
  private final int CAPACITY = 50; // the maximum number of elements in the Actor array
  private Actor[] actors;

  public ActorCast() {
    sc = new Scanner(System.in); // new instance of scanner to read user input
    actors = new Actor[CAPACITY]; // Array to store Actor objects
    numActors = 0; // number of actors in the actors array
  }

  /**
   * Create an array of actors based on details entered by the user
   * 
   * @param sc     A Scanner object
   * @param actors Array of Actor Objects
   */
  public void bulkAdd(Scanner sc, Actor[] actors) {
    String again = "y"; // Used to control "Enter another actor" logic

    while (numActors < actors.length && again.equals("y")) {
      Actor actor = readActor(sc); // Read actor details from the user and instantiate new actor
      actors[numActors] = actor; // Add actor to the array
      numActors++;

      if (numActors == actors.length) {
        System.out.println();
        System.err.print("Maximum number of Actors entered. Press <y> to continue");
        sc.nextLine();
        System.out.println();
        break;
      } else {
        System.out.println();
        System.out.print("Enter another Actor (y,n)? ");
        again = sc.nextLine();
      }
    }
  }

  /*
   * Obtain actor details from the the user
   * 
   * @param sc A Scanner object
   * 
   * @return actor an Actor DataType
   */
  public Actor readActor(Scanner sc) {
    Actor actor = null; // Local variable for Actor DataType
    Actor.Skill skill; // Skill level of the actor
    int revenue; // Expected revenue film contribution in AUD$M
    String name; // First and last name of the Actor
    int membershipId; // Screen Guild Membership number
    double commission = 0.0; // Agent's commission based on 1% of Actors revenue

    // Get the name and membership ID from the user
    System.out.println();
    System.out.print("Please enter first and last name of the Actor: ");
    name = sc.nextLine();
    System.out.print("Please enter the Screen Guild membership ID: ");
    membershipId = sc.nextInt();
    sc.nextLine(); // Clear the input buffer
    // Get the revenue from the user ensuring that it's a valid number
    revenue = 0; // reset the revenue
    while (revenue <= 0) {
      System.out.print("Please enter the estimated film revenue contribution in Millions: ");
      revenue = sc.nextInt();
      if (revenue <= 0) {
        System.out.println("Error! Revenue must be greater than 0");
      }
    }
    skill = readSkill(sc); // Get the actor's skill level
    actor = new Actor(name, membershipId, revenue, skill, commission); // Instantiate new Actor
    return actor;
  }

  /**
   * Get the actor's skill level ensuring they make a valid choice
   * 
   * @param sc scanner object
   * @return skill Actor's skill level
   */
  public Actor.Skill readSkill(Scanner sc) {
    int choice; // records the user's menu choice
    Actor.Skill skill; // Skill level of the actor

    System.out.println("Please enter the skill level for the actor: ");
    choice = 0; // Reset choice
    while (choice <= 0) {
      System.out.println("1 " + Actor.Skill.WOODEN);
      System.out.println("2 " + Actor.Skill.HAM);
      System.out.println("3 " + Actor.Skill.OSCAR_WORTHY);
      System.out.print("Choice ( 1 - 3): ");
      choice = sc.nextInt();
      sc.nextLine(); // Clear the input buffer
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
    return skill;
  }

  /*
   * Add an actor to the actors array based on details entered by the user
   * 
   * @param actors Array of Actor Objects
   * 
   * @param sc A scanner object
   */
  private void addOneActor(Scanner sc, Actor[] actors) {
    Actor actor = readActor(sc); // read actor details from the user and instantiate new Actor
    actors[numActors] = actor; // Add actor to the array
    numActors++;
  }

  /** This method displays all actors, one per line. */
  private void displayActor() {
    System.out.println(); // Leave a blank line
    for (int i = 0; i < numActors; i++) {
      System.out.println(actors[i].toString());
    }
    System.out.println(); // Leave a blank line
  }

  /**
   * This method calculates and returns the actor with the highest revenue
   * potential
   * 
   * @param actors Array of Actor Objects
   * @param skill  The skill level of actors to consider
   * @return highest The actor of a particular skill level with the highest
   *         revenue potential, or null if no such actor is in the collection
   */
  public Actor mostValuableActor(Actor[] actors, Actor.Skill skill) {
    Actor highest = null; // Most valuable actor

    System.out.println(); // Leave a blank line
    for (int i = 0; i < numActors; i++) {
      if (actors[i].getSkill() == skill) {
        if (highest == null || actors[i].getRevenue() > highest.getRevenue()) {
          highest = actors[i];
        }
      }
    }
    return highest;
  }

  /**
   * This method calculates and returns the actor with the highest revenue
   * potential
   * 
   * @param actors Array of Actor Objects
   * @param skill
   * @return averageRevenue Calculated average revenue
   */
  public int averageActorRevenue(Actor[] actors, Actor.Skill skill) {
    int revenue = 0; // Expected revenue film contribution in AUD$M
    int matching = 0; // number of actors matching the particular skill level
    int averageRevenue = -1; // default value if no matching actors for required skill level

    System.out.println(); // Leave a blank line

    for (int i = 0; i < numActors; i++) {
      if (actors[i].getSkill() == skill) {
        revenue = revenue + actors[i].getRevenue(); // Sum revenue from all actors with matching skill
        matching++;
      }
    }
    if (matching > 0) { // Just in case there is nothing in the array to prevent divide by zero error
      averageRevenue = revenue / matching; // calculate the average revenue
    }
    return averageRevenue;
  }

  // This main method contains the controlling logic for the program using a menu
  // structure.
  public void showMenu() {
    Actor.Skill skill; // Skill level of the actor
    int choice; // records the user's menu choice
    Actor highest; // Most valuable actor
    int averageRevenue; // Average actor revenue

    System.out.println();
    System.out.println("Actor Cast"); // display name of program
    System.out.println();
    System.out.println("* Bulk load of Actors *");
    bulkAdd(sc, actors); // build array of actors from user input
    System.out.println();

    // Display Menu and obtain menu choice from user
    do {

      System.out.println("1. Add another Actor");
      System.out.println("2. Display Actors");
      System.out.println("3. Display most valuable Actor for a particular skill level");
      System.out.println("4. Display average Actor Revenue for a particular skill level");
      System.out.println("5. Quit");
      System.out.println();
      System.out.print("Enter an option: ");
      choice = sc.nextInt(); // Read choice from user

      // Error check the user's response
      if (choice < 1 || choice > 5) {
        System.out.println("Error! Choice must be between 1 and 5");
        System.out.println();
      }

      // Execute the required actions based on the user's choice
      switch (choice) {
      case 1: {
        sc.nextLine(); // Clear the input buffer
        if (numActors >= CAPACITY) {
          System.out.println();
          System.err.print("Maximum number of Actors entered. Press return to continue");
          sc.nextLine();
          System.out.println();
        } else {
          addOneActor(sc, actors); // Add actors returning number of actors in array
        }
        break;
      }
      case 2: {
        displayActor(); // Display each actor on a separate line
        break;
      }
      case 3: {
        skill = readSkill(sc); // Get the actor's skill level
        highest = mostValuableActor(actors, skill); // Calculate and Return the most valuable actor
        if (highest == null) {
          System.out.println("No actor found with a skill level of " + skill);
        } else {
          System.out.println("The most valuable actor is " + highest.toString());
        }
        System.out.println();
        break;
      }
      case 4: {
        skill = readSkill(sc); // Get the actor's skill level
        averageRevenue = averageActorRevenue(actors, skill);// Calculate and Return the average revenue
        if (averageRevenue == -1) {
          System.out.println("No actor found with a skill level of " + skill);
        } else {
          System.out.println("The average actor revenue for " + skill + " actors is $" + averageRevenue + "M");
        }
        System.out.println();
        break;
      }
      }

    } while (choice != 5); // Exit loop when user chooses menu choice 4

    // End program
    System.out.println();
    System.out.println("Thanks for running Actor Cast");
  }
}