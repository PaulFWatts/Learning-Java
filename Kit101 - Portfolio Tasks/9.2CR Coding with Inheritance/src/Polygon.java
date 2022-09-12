import java.awt.Color;
import kit101.turtle.Turtle;

/**
 * A regular n-sided Polygon with sides of a particular length.
 * 
 * You must not modify this file. You do not need to submit this file.
 * 
 * @author KIT101 Teaching Team
 */
public class Polygon extends Shape {
  public static final int MIN_SIDES = 3; // minimum possible number of sides
  protected int sides; // number of sides (read only)
  protected double sideLength; // length of the sides (read only)

  /**
   * Creates a new n-sided Polygon with the given length sides, centred at (x, y),
   * and the given Turtle graphics device.
   */
  public Polygon(int sides, double sideLength, int x, int y, Color color, Turtle device) {
    super(x, y, color, device);
    this.sides = sides < MIN_SIDES ? MIN_SIDES : sides;
    this.sideLength = sideLength <= 0 ? 1 : sideLength;
  }

  /** Draws the Polygon. */
  public void draw() {
    double angle = 360.0 / sides; // internal angle at each vertex
    double angleToStart = -90 - angle / 2; // angle towards bottom-left start

    startDrawing();
    for (int i = 0; i < sides; i++) {
      device.move(sideLength);
      device.turn(angle);
    }
    endDrawing();
  }

  /** Moves to the first (bottom-left) vertex, relative to the centre. */
  protected void moveToStart() {
    double turnBy = -90 - (360.0 / sides) / 2; // angle toward first vertex (bottom-left)

    device.moveTo(centre.x, centre.y);
    device.turn(turnBy);
    device.move((sideLength / 2) / Math.sin(Math.PI / sides)); // length of the hypotenuse
    device.turn(-turnBy);
  }

  /** Returns the polygon's number of sides. */
  public int getSides() {
    return sides;
  }

  /** Returns the polygon's side length. */
  public double getSideLength() {
    return sideLength;
  }

  /** Returns a String representation of this polygon. */
  public String toString() {
    return "Polygon(sides=" + sides + ", side_length=" + sideLength + ", centre=" + centre + ")";
  }

}