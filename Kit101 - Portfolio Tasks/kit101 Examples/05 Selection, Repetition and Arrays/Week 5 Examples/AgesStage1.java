import java.util.Scanner;

/**
 * Demonstration of using arrays to store and work with
 * a collection of items.
 * 
 * Stage 1: Using an array and loops to make the code for reading four
 * age values and calculating their average more flexible and shorter.
 * 
 * @author James Montgomery
 */
public class AgesStage1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int SIZE = 4;
        int[] ages = new int[SIZE]; //people's ages
        int sum = 0; //sum of all ages
        double average; //calculated result

        //Read ages from user
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age " + (i + 1) + " of " + ages.length + ": ");
            ages[i] = sc.nextInt();
        }

        //Calculate sum and then average
        for (int i = 0; i < ages.length; i++) {
            sum += ages[i];
        }
        average = (double) sum / ages.length;

        System.out.println("Average age: " + average);        
    }
    
}
