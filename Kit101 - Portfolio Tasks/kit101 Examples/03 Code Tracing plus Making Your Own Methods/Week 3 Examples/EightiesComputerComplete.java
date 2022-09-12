import java.util.Scanner;

/**
 * A Star Wars first name generator.
 * 
 * @author James Montgomery, Liansheng Tan, class
 */
public class EightiesComputerComplete {

    /**
     * Generates a 'Star Wars' style name based on a person's
     * given and family names.
     */
    public static String starWarsName(String given, String family) {
        String formatted;
        formatted = given.substring(0, 3);
        formatted += family.substring(0, 2);
        return formatted;
    }
    
    /**
     * Prints the given message all in capitals, with a leading and
     * trailing ellipsis.
     */
    public static void printAllCaps(String text) {
        System.out.println("..." + text.toUpperCase() + "...");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String givenName, familyName; //user's names
        String newName; //generated name
        
        printAllCaps("Welcome to 1980s computer");
        
        printAllCaps("It prints every message in all caps");
        printAllCaps("with leading and trailing ellipses");
 
        System.out.println();
        printAllCaps("Enter your first given name");
        givenName = sc.next();
        printAllCaps("Enter your family name");
        familyName = sc.next();
        
        printAllCaps("Formatting");
        printAllCaps("");
        printAllCaps("");
        newName = starWarsName(givenName, familyName);
        
        printAllCaps("Your Star Wars first name is " + newName);
        
        printAllCaps("Program ends");
    }
    
}
