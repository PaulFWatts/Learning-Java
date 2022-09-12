import java.util.Arrays;

/**
 * Additional array (hence loop & method) tracing examples.
 * Try tracing the examples first, then run the code to see if you're right.
 */
public class TraceableArrayCode {
    
    /** Trace this method. Once done, what would you say it _does_? */
    public static void mysteryMethod1(int[] data, int startVal) {
        for (int i = 0; i < data.length; i++) {
            data[i] = startVal + i;
        }
    }

    /**
     * Trace this method. Once done, what would you say it _does_?
     * (Hint: this one is quite contrived [odd, useless], so write a full sentence.)
     */
    public static void mysteryMethod2(int[] data) {
        int i = 0;
        while (i < data.length) {
            if (data[i] % 2 != 0) {
                data[i] += 1;
            }
            i++;
        }
    }

    
    public static void main(String[] args) {
        int[] initialValues = { 2, 7, 6, 3, 1 };
        int[] testValues;
        
        testValues = Arrays.copyOf(initialValues, initialValues.length);
        
        System.out.println("Before mysteryMethod1, array is " + Arrays.toString(testValues));
        mysteryMethod1(testValues, 3);
        System.out.println("After mysteryMethod1, array is  " + Arrays.toString(testValues));
        
        //reset test values before using mysteryMethod2
        testValues = Arrays.copyOf(initialValues, initialValues.length);
        System.out.println("Before mysteryMethod2, array is " + Arrays.toString(testValues));
        mysteryMethod2(testValues);
        System.out.println("After mysteryMethod2, array is  " + Arrays.toString(testValues));

    }
}