import java.util.Scanner;

/**
 * A palindrome tester.
 */
public class PalindromeTesterComplete {
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word;
        int leftPos, rightPos;
        char leftLet, rightLet;
    
        System.out.print("Enter a word: ");    
        word = sc.next(); 

        //Initialisation: set initial positions of left and right; find first and last letters
        leftPos = 0;
        rightPos = word.length() - 1;
        leftLet = word.charAt(leftPos);
        rightLet = word.charAt(rightPos);

        //Test before loop (first time compares first and last letters in word)
        while( (leftLet == rightLet) && (leftPos < rightPos) ) {
            //body and update
            leftPos = leftPos + 1; 
            rightPos = rightPos - 1; 
            leftLet = word.charAt(leftPos); 
            rightLet = word.charAt(rightPos); 
        }

        //if we reached half way then must be a palindrome
        if (leftPos >= rightPos) {
            System.out.println("IS a palindrome");
        } else {
            System.out.println("NOT a palindrome");
        }
    }

}
