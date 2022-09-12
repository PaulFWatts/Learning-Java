import java.util.Scanner;

/**
 * Illustrates user input and a maths function.
 *
 * @author James Montgomery, Liansheng Tan and class
 */
public class AgeDifferenceComplete {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //to read keyboard input
        int age1; //person 1's age
        int age2; //person 2's age
        int diff; //absolute difference between ages
        
        System.out.print("Enter age of person 1: ");
        age1 = sc.nextInt();
        System.out.print("Enter age of person 2: ");
        age2 = sc.nextInt();
        diff = Math.abs(age1 - age2);
        System.out.println("The absolute difference in ages is " + diff);
    }

}
