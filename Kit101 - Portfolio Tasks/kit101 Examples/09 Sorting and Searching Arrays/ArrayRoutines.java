/**
 * ArrayRoutines: A collection of class methods to deal with arrays,
 * duplicating some of the methods in java.util.Arrays (all the better to see
 * that the code in that class isn't magic!).
 * <p>
 * All methods in this class are static, similar to the way utility methods in
 * java.util.Arrays are declared, so you don't need to create an object of this
 * class to use them.
 * 
 * @author Robyn Gibson, Julian Dermoudy, James Montgomery
 * @version April 2017
 * @see java.util.Arrays
 */
public class ArrayRoutines {
    
    private static boolean tracing; //controls whether trace-level debugging output will be shown
    
    // Searching and sorting functions
    
    /**
     * Performs a linear search for the location of a value in the array; returns
     * -1 if it is not present. See, e.g.,
     * <a href="https://en.wikipedia.org/wiki/Linear_search">the Wikipedia article</a>.
     * @param data  the array to search
     * @param target  the target to search for
     * @return the position of target in data, or -1 if not found
     */
    public static int linearSearch(int[] data, int target) {
        boolean found = false;
        int index = -1;
        int counter = 0;
        
        while (counter < data.length && !found) {
            if (data[counter] == target) {
                trace("found at " + counter);
                found = true;
                index = counter;
            } else {
                counter++;
                trace("moving on to " + counter);
            }
        }
        return index;
    }
    
    /**
     * Performs a binary search to find the position of the value t; returns -1 if
     * it is not in the array. See, e.g.,
     * <a href="https://en.wikipedia.org/wiki/Binary_search">the Wikipedia article</a>.
     * @param data  the array to search
     * @param target  the target value to find
     * @return the position of target in data, or -1 if not found
     */
    public static int binarySearch(int[] data, int target) {
        boolean found = false;
        int low = 0;
        int high = data.length - 1;
        int middle;
        int index = -1;
        
        while (low <= high && !found) {
            middle = (low + high)/2;
            trace("searching from " + low + " to " + high);
            trace("middle is " + middle);
            if (data[middle] == target) {
                trace("found at " + middle);
                found = true;
                index = middle;
            } else {
                trace("search moving on");
                if (target < data[middle]) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            }
        }
        
        return index;
    }
    
    /**
     * Sorts the array into ascending order using insertion sort. See, e.g.,
     * <a href="https://en.wikipedia.org/wiki/Insertion_sort">the Wikipedia
     * article</a>.
     * @param data  the array to sort
     */
    public static void insertionSort(int[] data) {
        int key; //value to "insert"
        int position; //where to "insert"
        
        for (int index = 1; index < data.length; index++) {
            key = data[index];
            trace("find position for " + key);
            position = index;
            // shift larger values to the right
            while (position > 0 && data[position-1] > key) {
                trace("move element along");
                data[position] = data[position-1];
                position--;
            }
            trace("placing at " + position);
            data[position] = key;
        }
    }
    
    /**
     * Sorts the array into lexicographic (alphabetical) order using insertion
     * sort. See, e.g., <a href="https://en.wikipedia.org/wiki/Insertion_sort">
     * the Wikipedia article</a>.
     * @param data  the array to sort
     */
    public static void insertionSort(String[] data) {
        String key; //value to "insert"
        int position; //where to "insert"
        
        for (int index = 1; index < data.length; index++) {
            key = data[index];
            position = index;
            // shift larger values to the right
            while (position > 0 && data[position-1].compareTo(key) > 0) {
                data[position] = data[position-1];
                position--;
            }
            data[position] = key;
        }
    }
    
    /**
     * Sorts the array into ascending order using selection sort. See, e.g.,
     * <a href="https://en.wikipedia.org/wiki/Selection_sort">the Wikipedia
     * article</a>.
     * @param data  the array to sort
     */
    public static void selectionSort(int[] data) {
        int min, temp;
        
        for (int index = 0; index < data.length-1; index++) {
            min = index;
            for (int scan = index + 1; scan < data.length; scan++) {
                if (data[scan] < data[min]) {
                    min = scan;
                }
            }
            //swap the values
            temp = data[min];
            data[min] = data[index];
            data[index] = temp;
        }
    }
    
    
    // General utitility functions for displaying and using arrays
    
    /**
     * Displays the values stored in an array of ints
     * @param a  the array
     */
    public static void display(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("element " + i + ": " + a[i]); //<-- the formatting is up to you
        }
    }
    
    /**
     * Displays the values stored in an array of Strings
     * @param a  the array
     */
    public static void display(String[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("element " + i + ": " + a[i]); //<-- the formatting is up to you
        }
    }
        
    /**
     * Fills an array with the given value.
     * @param a  the array to fill
     * @param value  the value to set each element to
     */
    public static void fill(int[] a, int value) {
        for (int i = 0; i < a.length; i++) {
            a[i] = value;
        }
    }
    
    /**
     * Returns the sum of all elements in an array of integers.
     * @param a  the array
     * @return the sum of the array's elements
     */
    public static int sum(int[] a) {
        int total = 0;
        for (int i = 0; i < a.length; i++) {
            total = total + a[i];
        }
        return total;
    }

    /**
     * Insert value in next "empty" slot in array, given the current number of
     * entries in the array; returns the new number of filled positions.
     * Does not add anything if the array is full.
     * @param a  the array
     * @param count  the current number of "filled" spots in the array
     * @param value  the value to be added to the array
     * @return the new number of items in the array
     */
    public static int add(int[] a, int count, int value) {
        if (count == a.length) {
            a[count] = value;
            count = count + 1;
        }
        return count;
    }
    
    /**
     * Sets the value in the array at position index to the given replacement
     * value. Demonstrates that changes to array argument elements persist
     * after the method is finished. (Serves no other practical purpose.)
     * @param a  the array to modify
     * @param index  the position to modify
     * @param replacement  the value to copy into a[index]
     */
    public static void change(int[] a, int index, int replacement) {
        trace("change(): start");
        trace("change(): index param is: " + index);
        trace("change(): array element at this position is: " + a[index]);
        a[index] = replacement;
        trace("change(): array change done" );
        trace("change(): array element at position " + index + " now: " + a[index]);
        index = 100;
        trace("change(): index param changed to: " + index);
        trace("change(): over");
    }
    
    
    /**
     * Prints a tracing message (prefixed by 'ArrayRoutines: ') if tracing is
     * enabled.
     * @param message  the tracing message
     */
    public static void trace(String message) {
        if(tracing) {
            System.out.println("ArrayRoutines: " + message);
        }
    }
    
    /** Enables or disables tracing. */
    public static void setTracing(boolean on) {
        tracing = on;
    }
    
}
