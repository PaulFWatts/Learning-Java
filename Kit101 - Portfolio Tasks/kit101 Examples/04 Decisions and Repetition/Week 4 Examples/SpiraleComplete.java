import kit101.turtle.Turtle;

/**
 * Draws a spirale pattern by repeatedly drawing squares starting at 10 degrees
 * to each other.
 */
public class SpiraleComplete {

    public static void main(String[] args) {
        Turtle drawer = new Turtle();

        //There will be 36 squares, each 10 degrees different from the last
        for (int outer = 0; outer < 36; outer++) {
            for(int inner = 0; inner < 4; inner++) {
                drawer.move(100);
                drawer.turn(90);
            }
            drawer.turn(10);
        }
    }
}
