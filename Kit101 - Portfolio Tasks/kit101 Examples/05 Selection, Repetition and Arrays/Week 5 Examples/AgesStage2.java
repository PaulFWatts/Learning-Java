import java.util.Scanner;

/**
 * Demonstration of using arrays to store and work with
 * a collection of items.
 * 
 * Stage 2: Using a larger array to accommodate varying numbers of
 * age values, in order to calculate their average even more flexibly.
 * This stage starts to look a lot more complex, as it requires
 * additional variables to keep track of the current program state.
 * Perhaps if it were broken up into methods for key tasks that could
 * be improved.
 * 
 * @author James Montgomery
 */
public class AgesStage2 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int NO_MORE = -1; //special value user enters to indicate no more values
        final int CAPACITY = 10; //arbitrary maximum number of values to store
        
        int entry; //user's current age entry
        int[] ages = new int[CAPACITY]; //people's ages
        int count = 0; //number of entries in ages
        int sum = 0; //sum of all ages
        double average; //calculated result

        //Read ages from user
        System.out.println("Record up to " + CAPACITY + " ages");
        do {
            System.out.print("Enter age " + (count + 1) + " (" + NO_MORE + " to stop): ");
            entry = sc.nextInt();
            if (entry != NO_MORE) { //<-- A slight complication of using a sentinel value
                ages[count] = entry;
                count++;
            }
        } while (entry != NO_MORE && count < ages.length);
        
        //Calculate sum and then average
        for (int i = 0; i < count; i++) {
            sum += ages[i];
        }
        average = (double) sum / count;

        System.out.println("Average of " + count + " ages: " + average);        
    }
    
}
