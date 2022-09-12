/**
 * Tests implementation of insertion sort in ArrayRoutines
 */
public class InsertSortTest {

    public static void main(String[] args) {
        int[] testValues = {3, 9, 6, 1, 2};

        ArrayRoutines.setTracing(true);
        System.out.println("We have an array of " + testValues.length + " integers");
        System.out.println("Here are the values before sorting");
        ArrayRoutines.display(testValues);
        ArrayRoutines.insertionSort(testValues);
        System.out.println("Here are the values after sorting");
        ArrayRoutines.display(testValues);
    }
}


