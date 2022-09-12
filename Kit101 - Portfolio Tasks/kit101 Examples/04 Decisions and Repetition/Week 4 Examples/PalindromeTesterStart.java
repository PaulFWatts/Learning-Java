import java.util.Scanner;

/**
 * A palindrome tester.
 */
public class PalindromeTesterStart {
        
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

        //TASK: Write a pre-tested loop to TEST if letters match (and left and right have not crossed over)
        //      and in the BODY to UPDATE left and right positions and the letters they refer to.





        //TASK: Determine if we have reached the middle; print a message to say if word is palindrome or not


    }
}
