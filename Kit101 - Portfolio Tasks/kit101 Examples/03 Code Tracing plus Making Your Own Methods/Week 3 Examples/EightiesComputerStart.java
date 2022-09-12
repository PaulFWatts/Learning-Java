import java.util.Scanner;

/**
 * A Star Wars first name generator.
 * 
 * @author James Montgomery, Liansheng Tan, class
 */
public class EightiesComputerStart {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String givenName, familyName; //user's names
        String newName; //generated name
        
        System.out.println("...WELCOME TO 1980S COMPUTER...");
        
        System.out.println("...IT PRINTS EVERY MESSAGE IN ALL CAPS...");
        System.out.println("...WITH LEADING AND TRAILING ELLIPSES...");
 
        System.out.println();
        System.out.println("...ENTER YOUR FIRST GIVEN NAME...");
        givenName = sc.next();
        System.out.println("...ENTER YOUR FAMILY NAME...");
        familyName = sc.next();
        
        System.out.println("...FORMATTING...");
        System.out.println("......");
        System.out.println("......");
        newName = givenName.substring(0, 3);
        newName += familyName.substring(0, 2);
        newName = newName.toUpperCase();
        
        System.out.println("...YOUR STAR WARS FIRST NAME IS " + newName + "...");
        
        System.out.println("...PROGRAM ENDS...");
    }
    
}
