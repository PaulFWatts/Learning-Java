import kit101.turtle.Turtle;

/**
 * Demonstrates importing a class from a package, declaration of a reference
 * variable, instantiation of a Turtle object and calling methods on that
 * object.
 *
 * @author James Montgomery
 */
public class TurtleBasics {

  public static void main(String[] args) {
    Turtle device; // declares a reference variable, but it doesn't refer to an object yet

    device = new Turtle(); // instantiates a Turtle object and assigns its reference to device

    device.move(100);
    device.turn(90);
    device.move(100);
    device.turn(90);
    device.move(100);
    device.turn(90);
    device.move(100);
  }

}
