import kit101.turtle.Turtle;
import java.awt.*;

public class Triangle extends Polygon {

  /**
   * Creates a new Triangle (i.e. A 3 sided Polygon) with the given length sides,
   * centred at (x, y) and the given Turtle graphics device.
   * 
   * @param sideLength length of the sides
   * @param x          center point x
   * @param y          center point y
   * @param color      pen colour
   * @param device     a Turtle device
   */
  public Triangle(double sideLength, int x, int y, Color color, Turtle device) {
    super(3, sideLength, x, y, color, device);
  }
}
