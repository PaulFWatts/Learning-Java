import kit101.turtle.Turtle;

/**
 * Draws a spirale pattern by repeatedly drawing squares starting at different
 * angles to each other.
 */
public class SpiraleStart {

    public static void main(String[] args) {
        Turtle drawer = new Turtle();

        //TASK: Add a loop around this one to slightly rotate each square that is drawn
        for(int inner = 0; inner < 4; inner++) {
            drawer.move(100);
            drawer.turn(90);
        }
    }
}
