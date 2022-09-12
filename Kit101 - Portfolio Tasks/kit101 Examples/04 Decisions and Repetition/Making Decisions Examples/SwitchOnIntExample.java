import java.util.Scanner;

/**
 * Example of using switch in a simple menu-driven program.
 * The menu has numbered items
 * 
 * @author James Montgomery
 */
public class SwitchOnIntExample {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice; //user's selection
        double cost; //item's price

        //Present menu and get user's selection
        System.out.println("Fruit Price Check");
        System.out.println("Choices:");
        System.out.println("1. Apple");
        System.out.println("2. Banana");
        System.out.println("3. Cherry");
        System.out.print("Enter your selection (1-3): ");
        choice = sc.nextInt();

        //Tip: These menu options would be better declared as constants
        switch (choice) {
            case 1: cost = 1.2;
                    break;
            case 2: cost = 2.45;
                    break;
            case 3: cost = 5.99;
                    break;
            default: System.err.println("Unknown option!");
                     cost = 0;
        }
        System.out.println("Price is $" + cost);
    }
}
