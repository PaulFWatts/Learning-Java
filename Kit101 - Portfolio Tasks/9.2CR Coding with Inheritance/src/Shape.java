import java.awt.Color;
import java.awt.Point;
import kit101.turtle.Turtle;

/**
 * An abstract shape with a centre at some (x, y). Must be extended to define an
 * actual shape.
 * 
 * You must not modify this file. You do not need to submit this file.
 * 
 * @author KIT101 Teaching Team
 */
public abstract class Shape {
  protected Point centre; // centre of the shape
  protected Color color; // shape's colour
  protected Turtle device; // the Turtle graphics device for drawing the shape
  private TurtleState savedState; // saved details about the Turtle

  /**
   * Creates a new Shape centred around (x, y) with the given colour and Turtle
   * graphics device.
   */
  public Shape(int x, int y, Color color, Turtle device) {
    centre = new Point(x, y);
    this.color = color;
    this.device = device;
  }

  /**
   * Draws the shape. Subclasses must provide an implementation and should call
   * startDrawing at the start and endDrawing at the end so that the Turtle is
   * restored to how it was before the shape was drawn.
   */
  public abstract void draw();

  /**
   * Moves to the first (bottom-left) vertex, relative to the centre. Assumes the
   * pen is up. The base implementation just moves to the centre and must be
   * overridden.
   */
  protected void moveToStart() {
    device.moveTo(centre.x, centre.y);
  }

  /**
   * Saves the drawing device's state (position, direction, colour, pen) and moves
   * to the first vertex.
   */
  protected void startDrawing() {
    savedState = new TurtleState(device);
    device.penUp();
    moveToStart();
    device.penDown();
    device.setColor(color);
  }

  /** Restores the drawing device's state (position, direction, colour, pen). */
  protected void endDrawing() {
    savedState.restore(device);
  }

  /** Returns the centre of the shape. */
  public Point getCentre() {
    return new Point(centre); // must return a copy
  }

  /**
   * Sets the centre of the shape. Is not a truly 'valid' setter as it accepts two
   * parameters rather than a Point object, so doesn't match the getter.
   */
  public void setCentre(int x, int y) {
    centre.setLocation(x, y);
  }

  /** Returns the Shape's colour. */
  public Color getColor() {
    return color;
  }

  /** Sets the Shape's colour. */
  public void setColor(Color color) {
    this.color = color;
  }

  /** Returns a String representation of this shape. */
  public String toString() {
    return "Shape(centre=" + centre + ")";
  }

  /**
   * An advanced language feature: a nested class. You do not need to understand
   * how this works, although it's reasonably straightfoward. This class type is
   * only visible inside this source file. We're using it as a way of packaging up
   * the Turtle's state without defining the four instance variables below as
   * instance variables of Shape.
   */
  private static class TurtleState {
    Point.Double pos;
    double direction;
    Color colour;
    boolean penDown;

    public TurtleState(Turtle t) {
      pos = new Point.Double(t.getX(), t.getY());
      direction = t.getDirection();
      colour = t.getColor();
      penDown = t.isDown();
    }

    public void restore(Turtle t) {
      t.penUp();
      t.moveTo(pos.x, pos.y);
      t.turnTo(direction);
      t.setColor(colour);
      t.setPenDown(penDown);
    }
  }

}