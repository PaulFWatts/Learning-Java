import java.util.Scanner;

/**
 * Demonstrates nested ifs
 *
 * @author James Montgomery
 * @author Robyn Gibson
 * @version 1.1 March 2014
 */
public class SmallestOf3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2, num3;
        int smallest;

        System.out.println("Enter 3 integers:");
        num1 = sc.nextInt();
        num2 = sc.nextInt();
        num3 = sc.nextInt();

        if ( num1 < num2 ) {
            if (  num1 < num3  ) {
                smallest = num1;
            } else { //must be num3
                smallest = num3;
            }
        } else { //must be num2 or num3
            if ( num2 < num3 ) {
                smallest  = num2;
            } else { //must be num3
                smallest = num3;
            }
        }

        System.out.println("The smallest of these three numbers is: " + smallest);
    }
}
