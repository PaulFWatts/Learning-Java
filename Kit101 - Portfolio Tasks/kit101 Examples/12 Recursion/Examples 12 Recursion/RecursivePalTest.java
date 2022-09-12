import java.util.Scanner;

/**
 * Demonstrates recursive testing if a String is a palindrome.
 */
public class RecursivePalTest {

    public static void main(String[] args) {
        Scanner sc;
        RecursiveDemos demo;
        String word;
        boolean isPalindrome;

        sc = new Scanner(System.in);
        demo = new RecursiveDemos();

        System.out.println("Enter a word");
        word = sc.next();
        isPalindrome = demo.palindrome(word);
        System.out.print("The word " + word + " is");
        if (!isPalindrome) {
            System.out.print(" not");
        }
        System.out.println(" a palindrome.");
    }
}
