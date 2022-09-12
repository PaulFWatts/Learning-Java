import java.util.Scanner;

/** Test harness */
public class Reversed {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String text;

    System.out.print("Enter some text: ");
    text = sc.nextLine();

    System.out.print("Your message reversed: ");
    for (int i = text.length() - 1; i >= 0; i--) {
      System.out.print(text.charAt(i));
    }
    System.out.println();
  }

}