import java.awt.Color;
import kit101.turtle.Turtle;

/**
 * 3.3PP Stamp Method: Implements a reusable 'stamp' that can draw the author's
 * initials at any location on the Turtle Graphics window.
 * 
 * @author Paul Watts
 * @version 1.1 (August 2020)
 * 
 */
public class Stamps {

  /**
   * Draws the author's initials using the given Turtle.
   *
   * Declare a method that receives the coordinates for drawing the initials at
   * (x,y), where x is relative to the bottom left corner of the drawing and y is
   * relative to the starting point. Also receives the desired pen colour.
   * 
   * @param stamper an instance of the Turtle Graphics object
   * @param x       x position for drawing
   * @param y       y position for drawing
   * @param ink     pen colour for drawing
   */

  public static void drawStamp(Turtle stamper, double x, double y, Color ink) {
    // Declare variables for saving the state of the Turtle
    Color oldInk; // Turtle pen colour
    double oldDirection; // Turtle angle
    double oldX; // Turtle x position
    double oldY; // Turtle y position

    // Assign Turtle state to the variables
    oldInk = stamper.getColor();
    oldDirection = stamper.getDirection();
    oldX = stamper.getX();
    oldY = stamper.getY();

    // paint initials; remembering to use stamper.penUp() to move without drawing a
    // line...

    stamper.penUp();
    stamper.setColor(ink); // Set the ink colour to the passed colour
    stamper.moveTo(x + 50, y + 10); // Set initial relative starting point,50 pixels from left and 10 up
    stamper.penDown();
    // Draw the letter P
    stamper.turn(90);
    stamper.move(100);
    stamper.turn(-90);
    stamper.move(40);
    stamper.turn(-90);
    stamper.move(30);
    stamper.turn(-90);
    stamper.move(40);
    // Reposition the turtle for next letter
    stamper.penUp();
    stamper.turn(90);
    stamper.move(70);
    stamper.turn(90);
    stamper.move(90);
    // Draw the letter W
    stamper.penDown();
    stamper.turn(110);
    stamper.move(105);
    stamper.penUp(); // Reposition to start of line
    stamper.turn(180);
    stamper.move(105);
    stamper.penDown(); // Continue drawing
    stamper.turn(120);
    stamper.move(40);
    stamper.turn(-100);
    stamper.move(40);
    stamper.turn(120);
    stamper.move(105);

    // Restore the Turtle to it's saved state
    stamper.penUp();
    stamper.moveTo(oldX, oldY);
    stamper.setColor(oldInk);
    stamper.turn(oldDirection);

  }

  public static void main(String[] args) {
    Turtle t = new Turtle(); // the graphics device

    // Call the drawStamp method 3 times at diffent locations and using different
    // pen colours
    drawStamp(t, 0, 1, Color.BLUE);
    drawStamp(t, 100, 130, Color.GREEN);
    drawStamp(t, 350, 230, Color.RED);

  }
}
