import java.util.Scanner;

/**
 * ISSApplicant 4.4CR Fix this
 * 
 * This program checks the applicant against a range of basic eligibility
 * criteria to assess their suitability for training for the International Space
 * Station (ISS)
 * 
 * @author Paul Watts
 * @version 1.1 (August 2020)
 */
public class ISSApplicant {

  /**
   * This method checks the applicant's responses against the desired eligibility
   * criteria and returns true if they pass and false if they fail
   * 
   * @param experience applicant's years of experience
   * @param size       applicant's height in cm
   * @param weight     applicant's weight in kg
   * @return success Returns true if applicant has passed eligibility tests
   * 
   */
  public static boolean isEligible(int experience, int size, double weight) {
    final int YEARS = 3;
    final int MIN = 158;
    final int MAX = 190;
    final double MASS = 100.0;
    boolean success = false;

    if (experience >= YEARS && weight < MASS) {
      if (size >= MIN && size <= MAX) {
        success = true;
      }
    }
    return success;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); // New instance of the Scanner object
    String again; // Used to control logic flow for processing another applicant
    int experience; // applicant's number of years experience
    int height; // applicant's height
    double weight; // applicant's weight to nearest 1/2 kg

    System.out.println("ISS ASTRONAUT APPLICATION - INITIAL ELIGIBILITY CHECK");

    do {
      System.out.print("How many years' relevant experience do you have post undergraduate studies? ");
      experience = sc.nextInt();
      System.out.print("Height (whole cm): ");
      height = sc.nextInt();
      System.out.print("Weight (to nearest half kg): ");
      weight = sc.nextDouble();
      if (isEligible(experience, height, weight)) {
        System.out.println("Welcome! Please proceed to next round of the application process");
      } else {
        System.out.println("Sorry, but you do not meet the minimum eligibility requirements");
      }
      System.out.print("\nProcess another applicant (y/n)? ");
      again = sc.next();
    } while (again.equals("y"));
    sc.close();
  }

}
