/**
 * Illustrates object, and particularly {@code String} comparisons.
 */
public class StringComparisons {

    public static void main(String[] args) {
        //TASK 1: Pick two words to replace the values of first and third
        String first = "pick a word";
        String second = new String(first); //creates a copy of the text in first
        String third = "pick a different word";
        String fourth = third;

        System.out.println("first is\t\"" + first + "\"");
        System.out.println("second is\t\"" + second + "\"");
        System.out.println("third is\t\"" + third + "\"");
        System.out.println("fourth is\t\"" + fourth + "\"");
        System.out.println(); //this variant of println() prints an empty line

        //TASK 2: What will be the result of each of these comparisons?
        // (The println()s are merely so we can run the program to see)

        System.out.println("first == second is " + (first == second));

        System.out.println("first.equals(second) is " + first.equals(second));

        System.out.println("first.compareTo(second) is " + first.compareTo(second));

        System.out.println("first.compareTo(third) is " + first.compareTo(third));

        System.out.println("third.compareTo(first) is " + third.compareTo(first));

        System.out.println("third.compareTo(fourth) is " + third.compareTo(fourth));

        System.out.println("third == fourth is " + (third == fourth));
    }

}
