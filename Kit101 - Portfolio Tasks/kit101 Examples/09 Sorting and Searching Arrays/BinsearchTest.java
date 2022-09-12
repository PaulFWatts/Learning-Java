
import java.util.Scanner;

/** Simple demonstration of binary search. */
public class BinsearchTest {

    public static void main(String[] args) {
        int[] numbers = { 5, 9, 13, 23, 65, 78, 93 };
        int myGuess, position;
        Scanner sc = new Scanner(System.in);

        ArrayRoutines.setTracing(true);
        System.out.println("Try to guess one of my numbers");
        myGuess = sc.nextInt();
        position = ArrayRoutines.binarySearch(numbers, myGuess);
        if (position != -1) {
            System.out.println("Congratulations, you found one!");
        } else {
            System.out.println("Bad luck");
        }
    }
}
