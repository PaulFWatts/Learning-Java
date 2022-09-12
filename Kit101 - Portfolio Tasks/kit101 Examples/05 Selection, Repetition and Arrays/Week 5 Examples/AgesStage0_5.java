import java.util.Scanner;

/**
 * Demonstration of using arrays to store and work with
 * a collection of items.
 * 
 * Stage 0.5: A slightly less naive solution for taking four age values
 * and calculating their average. If you were to use an array for this
 * problem then you would never do so this way (which is still just as
 * inflexible as Stage 0).
 * 
 * @author James Montgomery
 */
public class AgesStage0_5 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int SIZE = 4;
        int[] ages = new int[SIZE]; //people's ages
        int sum; //sum of all ages
        double average; //calculated result

        //Read ages from user
        System.out.print("Enter age 1 of 4: ");
        ages[0] = sc.nextInt();
        System.out.print("Enter age 2 of 4: ");
        ages[1] = sc.nextInt();
        System.out.print("Enter age 3 of 4: ");
        ages[2] = sc.nextInt();
        System.out.print("Enter age 4 of 4: ");
        ages[3] = sc.nextInt();
        
        //Calculate sum and then average
        sum = ages[0] + ages[1] + ages[2] + ages[3];
        average = (double) sum / 4;

        System.out.println("Average age: " + average);        
    }
    
}
