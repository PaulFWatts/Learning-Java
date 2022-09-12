import java.util.Scanner;

/**
 * Reverses the digits of number.
 */
public class ReverseDigitsComplete {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int number, lastDigit;
        int reverse = 0;
        
        System.out.print("Enter a positive integer: ");
        number = sc.nextInt();
        //Even if they entered a single-digit number, must still do loop at least once
        do {
            lastDigit = number % 10;
            reverse = (reverse * 10) + lastDigit; //* 10 shifts reverse to the left, then can add new last digit
            number = number / 10; //shifts original number to the right, 'chopping off' last digit
        } while (number > 0);
        System.out.println ("That number reversed is " + reverse);
    }

}
