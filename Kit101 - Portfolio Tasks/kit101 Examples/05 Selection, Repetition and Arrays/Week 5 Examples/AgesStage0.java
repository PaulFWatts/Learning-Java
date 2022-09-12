import java.util.Scanner;

/**
 * Demonstration of using arrays to store and work with
 * a collection of items.
 * 
 * Stage 0: A naive solution for taking four age values and
 * calculating their average.
 * 
 * @author James Montgomery
 */
public class AgesStage0 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age1, age2, age3, age4; //four people's ages
        int sum; //sum of all ages
        double average; //calculated result

        //Read ages from user
        System.out.print("Enter age 1 of 4: ");
        age1 = sc.nextInt();
        System.out.print("Enter age 2 of 4: ");
        age2 = sc.nextInt();
        System.out.print("Enter age 3 of 4: ");
        age3 = sc.nextInt();
        System.out.print("Enter age 4 of 4: ");
        age4 = sc.nextInt();
        
        //Calculate sum and then average
        sum = age1 + age2 + age3 + age4;
        average = (double) sum / 4;

        System.out.println("Average age: " + average);        
    }
    
}
