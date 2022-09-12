import java.util.Scanner;

/**
 * Example of using switch in a simple menu-driven program.
 * The menu options are short (1 character long) Strings.
 * 
 * @author James Montgomery
 */
public class SwitchOnStringExample {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice; //user's selection
        double cost; //item's price

        //Present menu and get user's selection
        System.out.println("Fruit Price Check");
        System.out.println("Choices:");
        System.out.println("(a)pple");
        System.out.println("(b)anana");
        System.out.println("(c)herry");
        System.out.print("Enter your selection (a-c): ");
        //Read next 1 character long 'word' from user
        choice = sc.next(); //this is _not_ a char, but a String

        //Tip: These menu options would be better declared as constants
        switch (choice) {
            case "a": cost = 1.2;
                      break;
            case "b": cost = 2.45;
                      break;
            case "c": cost = 5.99;
                      break;
            default: System.err.println("Unknown option!");
                     cost = 0;
        }
        System.out.println("Price is $" + cost);
    }
}
