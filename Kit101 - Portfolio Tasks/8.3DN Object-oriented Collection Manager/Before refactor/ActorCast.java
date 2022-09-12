package com.paulfwatts;
import java.util.Scanner;

/**
 * Actor Cast (Copied from 7.1PP Arrays of objects)
 *
 * This program creates an array of Actor Objects of Actors being considered for
 * casting. It creates the array with the details entered by the user and
 * displays the full actor details or just the most valuable actor or the average actor revenue.
 *
 * @author Paul Watts
 * @version 1.0 (October 2020)
 *
 *
 */

public class ActorCast {

    /* Create an array of actors based on details entered by the user
    /* @param sc         A Scanner object
     * @param actors     Array of Actor Objects
     * @return numActors Number of actors in the actors array
     */

   public static int bulkAdd (Scanner sc, Actor[] actors, int numActors) {
        String again = "y"; // Used to control "Enter another actor" logic

        while (numActors < actors.length && again.equals("y")) {
            numActors = readActor(sc, actors, numActors); // read actor details from the user and instantiate new actor

            if (numActors == actors.length) {
                System.out.println();
                System.err.print("Maximum number of Actors entered. Press return to continue");
                sc.nextLine();
                System.out.println();
                break;
            } else {
                System.out.println();
                System.out.print("Enter another Actor (y,n)? ");
                again = sc.nextLine();
            }
        }
        return numActors;
    }

    /* Obtain actor details from the the user
    * @param sc         A Scanner object
    * @param actors     Array of actor objects
    * @return numActors Number of actors in the actors array
    */
    public static int readActor(Scanner sc, Actor[] actors, int numActors) {
        Actor.Skill skill = null; // Skill level of the actor
        String name = null; // First and last name of the Actor
        int membershipId = 0; // Screen Guild Membership number
        int revenue = 0; // // Expected revenue film contribution in AUD$M
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

        // Instantiate a new Actor DataType with the entered details`
        actors[numActors] = new Actor(name, membershipId, revenue, skill, commission);
        numActors++;
        return numActors;

   }

    /** Get the actor's skill level ensuring they make a valid choice
     * @param sc        scanner object
     * @return skill    Actor's skill level
     * */
    public static Actor.Skill readSkill(Scanner sc) {
        int choice = 0; // user choice
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

    /* Add an actor to the actors array based on details entered by the user
    * @param actors    Array of Actor Objects
    * @param sc        A scanner object
    * @return numActors Number of actors in the actors array
    */
    private static int addOneActor(Scanner sc, Actor[] actors, int numActors) {
        numActors = readActor(sc, actors, numActors); // read actor details from the user and instantiate new Actor
        return numActors;
    }

    /**This method displays all actors, one per line.
     * @param actors    Array of Actor Objects
     * @param numActors Number of actors in the actors array
     */
    public static void displayActor(Actor[] actors, int numActors) {
        System.out.println(); // Leave a blank line
        for (int i = 0; i < numActors ; i++) {
            System.out.println(actors[i].toString());
        }
        System.out.println(); // Leave a blank line
    }

    /**This method calculates and returns the actor with the highest revenue potential
     * @param actors    Array of Actor Objects
     * @param numActors Number of actors in the actors array
     * @param skill     The skill level of actors to consider
     * @return highest  The actor of a particular skill level with the highest revenue potential,
     *                  or null if no such actor is in the collection
     */
    public static Actor mostValuableActor(Actor[] actors, int numActors, Actor.Skill skill) {
        Actor highest = null;
        System.out.println(); // Leave a blank line
        for (int i = 0; i < numActors ; i++) {
            if (actors[i].getSkill() == skill){
                if (highest == null || actors[i].getRevenue() > highest.getRevenue()) {
                    highest = actors[i];
                }
            }
        }
        return highest;
    }
    /**This method calculates and returns the actor with the highest revenue potential
     * @param actors           Array of Actor Objects
     * @param numActors        Number of actors in the actors array
     * @param skill
     * @return averageRevenue  Calculated average revenue
     */
    public static int averageActorRevenue(Actor[] actors, int numActors, Actor.Skill skill) {
        int revenue = 0;
        int averageRevenue = -1; // default value if no matching actors for required skill level
        int matching = 0; // number of actors matching the passed skill level

        System.out.println(); // Leave a blank line

        for (int i = 0; i < numActors ; i++) {
            if (actors[i].getSkill() == skill) {
                revenue = revenue + actors[i].getRevenue(); // Sum revenue from all actors with matching skill
                matching++;
            }
        }
        if(matching > 0 ) { // Just in case there is nothing in the array to prevent divide by zero error
            averageRevenue = revenue / matching; // calculate the average revenue
        }
        return averageRevenue;
    }

    // This main method contains the controlling logic for the program using a menu structure.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // new instance of scanner to read user input
        final int CAPACITY = 50; // the maximum number of elements in the Actor array
        int numActors = 0; // number of actors in the actors array
        Actor[] actors = new Actor[CAPACITY]; // Array to store Actor objects
        int choice; // records the user's menu choice
        Actor highest; // Most valuable actor
        int averageRevenue; // Average actor revenue
        Actor.Skill skill = null; // Skill level of the actor


        System.out.println();
        System.out.println("Actor Cast"); // display name of program
        System.out.println();
        System.out.println("* Bulk load of Actors *"); // give the user some contect
        numActors = bulkAdd(sc, actors, numActors); // build array of actors from user input
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
                        numActors = addOneActor(sc, actors, numActors); // Add actors returning number of actors in array
                    }
                    break;
                }
                case 2: {
                    displayActor(actors, numActors); // Display each actor on a separate line
                    break;
                }
                case 3: {
                    skill = readSkill(sc); // Get the actor's skill level
                    highest = mostValuableActor(actors, numActors, skill); // Calculate and Return the most valuable actor
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
                    averageRevenue = averageActorRevenue(actors, numActors, skill);// Calculate and Return the average revenue
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