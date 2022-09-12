import java.util.Scanner;
import java.lang.Math;

/**
 * 3.4PP Compound Interest Calculator
 * 
 * @author Paul Watts
 * @version 1.1 (August 2020)
 * 
 */
public class InvestmentCalc {

  /**
   * Calculates the amount of interest an investment will receive over time.
   * 
   * @param principle the principal amount in dollars
   * @param years     number of years to calculate interest
   * @param rate      interest rate percent
   * @return interest the calculated compound interest
   */

  public static double compoundInterest(int principle, int years, double rate) {
    double interest; // variable to return the calculated compound interest
    double calc; // used to simplify compound interest calculation

    // Calculate the compound interest
    rate = rate / 100; // Convert the passed interest rate to a percentage
    calc = Math.pow(1 + rate, years); // Calculate interest% + 1 raised to the power of the number of years
    interest = (principle * calc) - principle; // formula for calculating compound interest
    return interest;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int principle; // principle amount in dollars
    double rate = 0.0; // interest rate percentage
    double interest; // calculated compound interest

    System.out.println("Investment Calculator");
    System.out.println();

    // Calculate interest based on principle of $1000,3 years,at 3.5% and display
    interest = compoundInterest(1000, 3, 3.5);
    System.out.println("Bank A: $" + interest);

    // Calculate interest based on principle of $1000,3 years,at 4.5% and display
    interest = compoundInterest(1000, 3, 4.5);
    System.out.println("Bank B: $" + interest);
    System.out.println();

    // Calculate interest over 5 years with principle and rate entered by the user
    // and display
    System.out.print("Input principle ($): ");
    principle = sc.nextInt();
    System.out.print("Input interest rate (percent): ");
    rate = sc.nextInt();
    System.out.println("CALCULATING...");
    interest = compoundInterest(principle, 5, rate);
    System.out.println("5 year investment: $" + interest);
    sc.close();
  }
}