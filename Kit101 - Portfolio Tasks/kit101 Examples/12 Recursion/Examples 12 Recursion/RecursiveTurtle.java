import kit101.turtle.Turtle;

/**
 * A modified Turtle that can create a Sierpinski fractal pattern (a recursive
 * pattern of triangles within triangles.
 *
 */
public class RecursiveTurtle extends Turtle {

    /**
     * Draws a triangle from the present location and starting in the current
     * direction. Is not recursive.
     * @param side  the side length
     */
    public void triangle(double side) {
        for (int i = 1; i <= 3; i++) {
            move(side);
            turn(120);
        }
    }

    /**
     * Draws a "super" triangle (actually a Sierpinski triangle fractal pattern)
     * made up of order levels. Is recursive because it calls itself several
     * times to draw the next level of (smaller) triangles.
     * @param order  the order of the pattern (how many levels to draw)
     * @param the side length of the current outer triangle
     */
    public void superTriangle(int order, double size) {
        if (order == 1) {
            triangle(size);
        } else {
            superTriangle(order-1, size/2);
            move(size/2);
            superTriangle(order-1, size/2);
            turn(120); move(size/2); turn(-120);
            superTriangle(order-1, size/2);
            turn(-120); move(size/2); turn(120);
        }
    }
}
