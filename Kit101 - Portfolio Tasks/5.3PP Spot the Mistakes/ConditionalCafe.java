import java.util.Scanner;

/** Test harness */
public class ConditionalCafe {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    final int CAPACITY = 26; // warn if number of patrons is above this
    int patrons; // the current number of patrons

    System.out.print("Enter current number of patrons: ");
    patrons = sc.nextInt();

    if (patrons > CAPACITY) {
      System.out.println("Safe number of customers has been exceeded! Ask someone to leave.");
      System.out.println("Make sure they've paid their bill first!");
    }
  }
}