import java.util.Random;

/**
 * An initial attempt to define a game die with a selectable number of faces.
 *
 * @author James Montgomery
 * @version 6 April 2017
 */
public class Die {
    //Instance data

    private int numFaces; //number of sides
    private int faceValue; //current side facing 'up'
    private Random generator; //to select next up side

    //Constructors

    /** Creates a new Die with the default number of faces (6). */
    public Die() {
        this(6); //<-- calls the Die(int) constructor (and reduces duplication)
    }

    /**
     * Creates a new Die with the given number of faces and an initial value of 1.
     * @param faces the number of faces on the die
     */
    public Die(int faces) {
        if (faces >= 4) {
            numFaces = faces;
        } else {
            numFaces = 6;
        }
        faceValue = 1;
        generator = new Random();
    }

    //Getters and modifiers

    /** Returns the Die's current face value. */
    public int getFaceValue() {
        return faceValue;
    }

    /** Simulates rolling the die; returns the new face. */
    public int roll() {
        faceValue = generator.nextInt(numFaces) + 1;
        return faceValue;
    }

    /** Returns the number of faces on the Die. */
    public int getFaces() {
        return numFaces;
    }

}
