import kit101.turtle.Turtle; 

/**
 * Demonstrates drawing a square with a Turtle by repeatedly (four times)
 * drawing a line and turning 90 degrees.
 */
public class TurtleSquare { 

    public static void main(String[] args) { 
        Turtle mrStrong = new Turtle();
        int size = 100; //square's size; could be a constant

        //      init          test     update
        for (int sides = 0; sides < 4; sides++) {
            mrStrong.move(size);
            mrStrong.turn(90);
        }
    }

} 
