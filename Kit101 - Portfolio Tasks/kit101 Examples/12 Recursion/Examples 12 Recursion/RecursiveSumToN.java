import java.util.Scanner;

/**
 * Demonstrates recursive sum of the first n positive integers.
 */
public class RecursiveSumToN {

    public static void main(String[] args) {
        Scanner sc;
        RecursiveDemos demo;
        int endPoint;
        int sumOf;

        sc = new Scanner(System.in);
        demo = new RecursiveDemos();

        System.out.print("Enter an positive integer: ");
        endPoint = sc.nextInt();
        System.out.println("Adding from 1 to " + endPoint);
        sumOf = demo.sum(endPoint);
        System.out.println("Total is: " + sumOf);
    }
}
