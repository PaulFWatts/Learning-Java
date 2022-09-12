import java.awt.Color;
import kit101.turtle.Turtle;

/**
 * A rectangle with a width and a height.
 * 
 * @author KIT101 Teaching Team, Paul Watts
 */
public class Rectangle extends Shape {
  protected double width; // width of rectangle
  protected double height; // height of rectangle

  /**
   * Creates a new Rectangle with the given width and height, centred at (x, y),
   * and the given Turtle graphics device.
   */
  public Rectangle(double width, double height, int x, int y, Color color, Turtle device) {
    super(x, y, color, device);
    this.width = width;
    this.height = height;
  }

  /** Draws the Rectangle. */
  public void draw() {

    startDrawing();
    for (int i = 0; i <= 2; i++) {
      device.move(width);
      device.turn(90);
      device.move(height);
      device.turn(90);
    }
    endDrawing();
  }

  /** Moves to the first (bottom-left) vertex, relative to the centre. */
  protected void moveToStart() {
    device.moveTo(centre.x - width / 2, centre.y - height / 2);
  }

  /** Returns the rectangle's width. */
  public double getWidth() {
    return width;
  }

  /** Returns the rectangle's height. */
  public double getHeight() {
    return height;
  }

  /** Returns a String representation of the rectangle. */
  public String toString() {
    return "Rectangle(width = " + width + ", height = " + height + ", centre = " + centre + ")";
  }
}
