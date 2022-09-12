/**
 * Test drives the Die class. Unchanged from Part 1, since the interface to
 * the Die class hasn't changed.
 */
public class DieTester {

    public static void main(String[] args) {
        Die d1, d2, d3;
        int current;

        System.out.println("Testing Die class");
        d1 = new Die();
        d2 = new Die(8);
        d3 = new Die(2);
        System.out.println("Testing d1 (should have default number of sides, 6)" );
        System.out.println("Sides: " + d1.getFaces());
        System.out.println("Starting face value of d1 (should always be 1): " + d1.getFaceValue());
        System.out.println("Rolling d1 10 times");
        for (int count = 1; count <= 10; count++) {
            current = d1.roll();
            System.out.println("Current face value: " + current);
        }

        System.out.println("Testing d2 (created with 8 sides)");
        System.out.println("Sides: " + d2.getFaces());

        System.out.println("Starting face value (should always be 1): " + d2.getFaceValue());
        System.out.println("Rolling d2 10 times");
        for (int count = 1; count <= 10; count++) {
            current = d2.roll();
            System.out.println("Current face value: " + current);
        }

        System.out.println("Testing d3 (created with requested 2 sides; should now be default)" );
        System.out.println("Sides: " + d3.getFaces());

        System.out.println("Starting face value (should always be 1): " + d3.getFaceValue());
        System.out.println("Rolling d3 10 times");
        for (int count = 1; count <= 10; count++) {
            current = d3.roll();
            System.out.println("Current face value: " + current);
        }
    }
}
