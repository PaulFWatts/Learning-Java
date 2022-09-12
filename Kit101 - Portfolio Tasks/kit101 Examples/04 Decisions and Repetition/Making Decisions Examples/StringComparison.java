import java.util.Scanner;

/**
 * Illustrates object, and particularly {@code String} comparisons.
 */
public class StringComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first; //first word from user
        String second; //second word from user

        //Prompt for and read user's words
        System.out.println("String Comparison Example");
        System.out.print("Enter first word to compare: ");
        first = sc.next();
        System.out.print("Enter second word to compare: ");
        second = sc.next();

        System.out.println();
        System.out.println("Confirming stored values:");
        System.out.println("first is  \"" + first + "\""); // the \" means the character ", not the start/end of a String
        System.out.println("second is \"" + second + "\"");
        //Display outcome of various object reference and String comparisons
        System.out.println();
        System.out.println("Comparison outcomes:");
        System.out.println("first == second is " + (first == second));
        System.out.println("first.equals(second) is " + first.equals(second));
        System.out.println("first.compareTo(second) is " + first.compareTo(second));
        System.out.println("second.compareTo(first) is " + second.compareTo(first));
    }

}
