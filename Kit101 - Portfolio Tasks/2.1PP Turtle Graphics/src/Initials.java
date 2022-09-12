import java.awt.Color;
import turtle.Turtle;

/**
 * 2.1PP Turtle Graphics task to draw the author's initials.
 * Some of the code below has been _over_ commented to help you understand
 * what is happening.
 *
 * @author Paul Watts
 */
public class Initials {

    public static void main(String[] args) {
        Turtle painter; //the turtle graphics object

        painter = new Turtle(); //create the turtle

        //paint initials; remembering to use painter.penUp() to move without drawing a line...
        painter.setColor(Color.BLUE); //set the pen color for the first initial
        //Draw the letter P
        painter.turn(90);
        painter.move(100);
        painter.turn(-90);
        painter.move(40);
        painter.turn(-90);
        painter.move(30);
        painter.turn(-90);
        painter.move(40);
        //Reposition the turtle for next letter
        painter.penUp();
        painter.turn(90);
        painter.move(70);
        painter.turn(90);
        painter.move(90);
        //Draw the letter W
        painter.penDown();
        painter.turn(110);
        painter.move(105);
        painter.penUp(); //Reposition to start of line
        painter.turn(180);
        painter.move(105);
        painter.penDown(); //Continue drawing
        painter.turn(120);
        painter.move(40);
        painter.turn(-100);
        painter.move(40);
        painter.turn(120);
        painter.move(105);
    }

}
    