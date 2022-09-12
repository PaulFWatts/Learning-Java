
/**
 * Demonstrations of recursive solutions to problems.
 */
public class RecursiveDemos {

    private boolean debugging = true;

    /**
     * Calculates the sum of the first n positive integers. Implementation is
     * recursive. Requires that num is positive but does not check if it is not.
     * @param num  a positive integer
     * @return the sum from 0 to num
     */
    public int sum(int num) {
        trace("in sum, argument is: " + num);
        int total;
        if (num == 1) {
            trace("  in sum, base case");
            total = 1;
        } else {
            trace("  in sum, recursive case");
            total = num + sum(num - 1);
        }
        trace("in sum, argument is: " + num + ". About to return " + total);
        return total;
    }

    /**
     * Purely for demonstration purposes, this method recursively calculates the
     * sum of the values in the array from the given starting point to the end.
     * @param a  the array to sum over
     * @param pos  the starting point
     * @return the sum of the elements in a from pos to the end
     */
    public int sumFrom(int[] a, int pos) {
        trace("in sumFrom: a.length == " + a.length + ", pos == " + pos + (pos < a.length ? ", a[pos] == " + a[pos] : ""));
        int total;
        if (pos >= a.length) { //guaranteed to terminate, even if first value of pos beyond end of array
            trace("  in sumFrom, base case (no elements to sum)");
            total = 0; //the sum of *no elements*
        } else {
            trace("  in sumFrom, recursive case");
            total = a[pos] + sumFrom(a, pos + 1);
        }
        trace("in sumFrom: a.length == " + a.length + " and pos == " + pos + ". About to return " + total);
        return total;
    }

    /**
     * Returns true if s is a palindrome, false otherwise. Uses a recursive
     * technique to perform the test.
     * @param s  a String to test if is a palindrome
     * @return true if s is a palindrom, false if it is not
     */
    public boolean palindrome(String s) {
        boolean isPal = false;
        int length;
        char first, last;

        length = s.length();
        trace("in palindrome: length == " + length);
        if  (s.length() <= 1) { //base case
            isPal = true;
        } else {
            first = s.charAt(0);
            last = s.charAt(length - 1);
            trace("in palindrome: first let is " + first + " and last let is " + last );
            if (first == last) {
                trace("in palindrome call for: " + 1  + " to " + (length - 1) + " which is '" + s.substring(1,length - 1) + "'");
                isPal = palindrome( s.substring(1, length - 1) );
            }
        }
        return isPal;
    }

    /* The following demonstration of binary search illustrates a common pattern:
     * a public method that takes only as many arguments as the caller has (in this
     * case an array (assumed sorted) and the value to search for), and a private
     * recusive method that takes additional arguments needed to define the sub-task
     * to be performed.
     */

    /**
     * Performs binary search on the given array.
     * @param a  the array to search (must be sorted already)
     * @param x  the value to search for
     * @return the index of x in a, or -1 if it is not present
     */
    public int binarySearch(int[] a, int x) {
        //This begins the recursive process by searching the entire array
        return binarySearch(a, x, 0, a.length - 1);
    }

      /**
       * The private, recursive binary search method needs to know the bounds of
       * its search.
       */
    private int binarySearch(int[] a, int x, int low, int high) {
        trace("Entering binarySearch(x == " + x + ", low == " + low + ", high = " + high + ")");
        int pos; //result of *this* call to binarySearch
        if (low > high) { //base case 1: not found
            trace("binarySearch base case 1: " + x + " not found");
            pos = -1;
        } else {
            int mid = (low + high)/2;
            if (a[mid] == x) { //base case 2: found
                trace("binarySearch base case 2: " + x + " found at position " + mid);
                pos = mid;
            } else if (a[mid] < x) { //recursive case 1: search top half
                trace("binarySearch recursive case 1: searching for " + x + " in top half");
                pos = binarySearch(a, x, mid+1, high);
            } else { //recursive case 2: search bottom half
                trace("binarySearch recursive case 2: searching for " + x + " in bottom half");
                pos = binarySearch(a, x, low, mid-1);
            }
        }
        trace("Leaving binarySearch(x == " + x + ", low == " + low + ", high = " + high + "): pos == " + pos);
        return pos;
    }


    public void setTracing(boolean on) {
        debugging = on;
    }

    public void trace(String message) {
        if (debugging) {
            System.out.println(message);
        }
    }
}
