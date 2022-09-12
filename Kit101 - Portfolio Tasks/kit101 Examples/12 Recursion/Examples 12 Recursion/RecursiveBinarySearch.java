import java.util.Arrays;

/**
 * Demonstrates recursive sum over an array, just to prove it can be done.
 * This driver program integrates a main() method with an organiser object, to
 * keep things compact.
 */
public class RecursiveBinarySearch {
    //the recursive function implementations
    private RecursiveDemos demo = new RecursiveDemos();
    //assume (i.e., make) sorted
    private int[] someValues = { 1, 3, 6, 10, 22, 25, 28, 35, 37, 42, 50 };

    public void runAllDemos() {
        System.out.println("Recursive Binary Search Demonstration");
        System.out.println("Will be searching this array: " + Arrays.toString(someValues));

        runOneDemo(42);
        runOneDemo(3);
        runOneDemo(1);
        runOneDemo(2);
    }

    public void runOneDemo(int target) {
        int pos;
        System.out.println("Searching for value " + target);

        pos = demo.binarySearch(someValues, target);
        if (pos >= 0) {
            System.out.println("Value found at position " + pos);
        } else {
            System.out.println("Value not found");
        }
        System.out.println(); //blank line between demonstrations
    }


    public static void main(String[] args) {
        RecursiveBinarySearch demonstrator = new RecursiveBinarySearch();
        demonstrator.runAllDemos();
    }

}
