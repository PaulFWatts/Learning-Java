import java.util.Arrays;

/**
 * Demonstrates recursive sum over an array, just to prove it can be done.
 */
public class RecursiveSumAnArray {

    public static void main(String[] args) {
        RecursiveDemos demo;
        int[] someValues = { 3, 5, 1, 2, 4, 9 };
        int sumOf;

        demo = new RecursiveDemos();

        System.out.println("About to recursively sum the values " + Arrays.toString(someValues));
        sumOf = demo.sumFrom(someValues, 0);
        System.out.println("Total is: " + sumOf);
    }
}
