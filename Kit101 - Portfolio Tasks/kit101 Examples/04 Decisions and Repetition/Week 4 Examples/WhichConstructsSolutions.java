import java.util.Scanner;

/**
 * Possible solutions to Which construct? activity.
 */
public class WhichConstructsSolutions {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String TARGET = "James";
        String name;
        
        //Ask the user for their name
        System.out.print("Enter your first given name: ");
        name = sc.next();
        //and then...

        //Uncomment the relevant section of code (tip: select the lines then Ctrl + Shift + /)
        //1.  Greet them personally
//        System.out.println("Hello " + name);
        
        //2. Greet them personally 5 times
//        for (int i = 0; i < 5; i++) {
//            System.out.println("Hello " + name);
//        }
        
        //3. If it's 'James' then print 'lame', otherwise print 'Good name'
//        if (name.equals(TARGET)) {
//            System.out.println("lame");
//        } else {
//            System.out.println("Good name");
//        }
            
        //4. If it's 'James' then print 'lame' and ask them for their name again,
        //   otherwise print 'Good name'
//        while (name.equals(TARGET)) {
//            System.out.println("lame");
//            System.out.print("Enter your first given name: ");
//            name = sc.next();
//        }
//        System.out.println("Good name");

        //5. Display their name in capitals and spaced out.
        //   For example, 'James' is printed as J A M E S
//        name = name.toUpperCase();
//        for (int i = 0; i < name.length(); i++) {
//            System.out.print(name.charAt(i) + " ");
//        }
//        System.out.println(); //just to be tidy
    }
    
}
