import java.awt.Color;
import java.util.ArrayList;
import kit101.turtle.Turtle;

/**
 * ShapeTest, a driver program to test the various kinds of Shape.
 * Used in task 9.2CR to test drive various 'library' classes that extend from
 * Shape and Polygon.
 *
 * @author KIT101 Teaching Team, Paul Watts
 * @version September 2020
 */
public class ShapeTest {
    private static final int LEFT_X = 125, RIGHT_X = 375, BOTTOM_Y = 125, TOP_Y = 375; //target locations
    private static final int CENTRE_X = 250, CENTRE_Y = 250; //and an additional target location

    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();
        Turtle device = new Turtle();

        drawTargets(device);

        /**  Instantiate Shape objects using constants like LEFT_X, TOP_Y
        * to select a target location
        */
        shapes.add(new Polygon(8, 50, LEFT_X, BOTTOM_Y, Color.BLUE, device));
        shapes.add(new Polygon(10, 40, RIGHT_X, TOP_Y, Color.RED, device));
        shapes.add(new Rectangle(120, 100, LEFT_X, TOP_Y, Color.CYAN, device));
        shapes.add(new Circle(80, CENTRE_X, CENTRE_Y, Color.GREEN, device));
        shapes.add(new Triangle (140, RIGHT_X, BOTTOM_Y, Color.MAGENTA, device));
        //Draw all shapes
        for (Shape s : shapes) {
            System.out.println("Displaying " + s);
            s.draw();
        }
    }
    
    /** Paints some target marks in the drawing area. */
    public static void drawTargets(Turtle device) {
        drawTarget(device, LEFT_X, BOTTOM_Y);
        drawTarget(device, LEFT_X, TOP_Y);
        drawTarget(device, RIGHT_X, TOP_Y);
        drawTarget(device, RIGHT_X, BOTTOM_Y);
        drawTarget(device, CENTRE_X, CENTRE_Y);
    }
    
    /** Draws a small + centred at (x, y). */
    public static void drawTarget(Turtle device, int x, int y) {
        device.penUp();
        device.moveTo(x - 5, y);
        device.penDown();
        device.moveTo(x + 5, y);
        device.penUp();
        device.moveTo(x, y - 5);
        device.penDown();
        device.moveTo(x, y + 5);
        device.penUp();
    }
}
