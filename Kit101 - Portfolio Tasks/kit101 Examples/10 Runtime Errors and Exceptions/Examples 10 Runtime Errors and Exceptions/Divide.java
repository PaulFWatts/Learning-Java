import java.util.Scanner;

/** Demonstrates what happens when an unchecked exception is caused. */
public class Divide {

    public static void main(String[] args) {
        final char YES = 'y';
        Scanner sc = new Scanner(System.in);
        int number, divisor, answer;
        char goOn = YES;

        while (goOn == YES) {
            System.out.println("Enter number to divide");
            number = sc.nextInt();
            System.out.println("Enter number to divide by");
            divisor = sc.nextInt();
            answer = number / divisor;
            System.out.println("answer: " + answer);
            System.out.println("Do another? (y/n)");
            goOn = sc.next().charAt(0);
        }
    }

}
