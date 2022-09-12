import java.awt.Color;
import kit101.turtle.Turtle;

/**
 * A circle (implemented as a many-sided polygon).
 * 
 * @author KIT101 Teaching Team, Paul Watts
 */
public class Circle extends Polygon {
  public static final int FINENESS = 100;
  protected double radius; // circle's radius

  /**
   * Creates a new Circle with the given radius and centre, using the given Turtle
   * graphics device.
   */
  public Circle(double radius, int x, int y, Color color, Turtle device) {
    super(FINENESS, Math.sin(Math.PI / FINENESS) * radius * 2, x, y, color, device);
    this.radius = radius;
  }

  /** Returns the circle's radius. */
  public double getRadius() {
    return radius;
  }

  /** Returns a String representation of the circle. */
  public String toString() {
    return "Circle(radius = " + radius + ", centre=" + centre + ")";
  }
}