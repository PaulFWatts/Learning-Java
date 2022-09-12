
/**
 * Driver program for the RecursiveTurtle. Draws the Sierpinski pattern with
 * different orders in different parts of the window.
 *
 * Note that for moderate orders the current implementation of Turtle will
 * cause an exception due to the list of lines being read at the same time new
 * lines are being added by drawing commands. This will be fixed in the future.
 */
public class FractalTriangle {

    public static void main(String[] args) {
        RecursiveTurtle st;
        st = new RecursiveTurtle();
        st.penUp();
        st.moveTo(25,275);
        st.penDown();
        st.superTriangle(1,200);
        st.penUp();
        st.moveTo(275,275);
        st.penDown();
        st.superTriangle(2,200);
        st.penUp();
        st.moveTo(25,25);
        st.penDown();
        st.superTriangle(3,200);
        st.penUp();
        st.moveTo(275,25);
        st.penDown();
        st.superTriangle(4,200);
    }

}
