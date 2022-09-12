import java.util.Scanner;

/**
 * Snakes and Ladders game, to be completed as part of a guided exercise.
 * @author
 * @version
 */
public class SALGame {
    private Scanner sc;      //scanner object for keyboard input
    private int playerNum;   //to record the current player
    private int p1position;  //player 1 counter
    private int p2position;  //player 2 counter
    private Die roller;      //the virtual Die
    private Board gameBoard; //the virtual Board
    private boolean tracing; //controls debugging output

    /**
     * Creates a new Snakes & Ladders game by creating a new game board and
     * die. The game is ready to be played at the end of this.
     */
    public SALGame() {
        sc = new Scanner(System.in);
        roller = new Die();
        gameBoard = new Board();
        tracing = true; //switch on messages
    }

    /**
     * Controls the "outer loop" of the game; calls playGame() to play each
     * individual game.
     */
    public void startPlaying() {
        trace("start Playing - will control outer loop");
        trace("calls playGame for a single game");
        playGame();
    }

    /**
     * Plays one game; calls makeAMove() for each move and swapPlayer when
     * necessary.
     */
    public void playGame() {
        trace("playGame started");
        trace("controls a single game");
        trace("calls makeAMove");
        trace("return is " + makeAMove(2));
        trace("calls swapPlayer");
        swapPlayer();
    }

    /**
     * Changes the value of the counter for the given player. Uses roll method of
     * the Die to find distance to move and moveOn method of the Board to find
     * new position for the player.
     * @param player - the current player
     * @return true if the game is now over, false otherwise
     */
    public boolean makeAMove(int player) {
        boolean finished; // needed for return
        finished = true;
        trace("makeAMove - parameter is " + player);
        trace("try rolling Die " + roller.roll());
        trace("try moving " + gameBoard.moveOn(0,6));
        return finished;
    }

    /**
     * Swaps the current player by changing the value of the instance variable
     * playerNum.
     */
    public void swapPlayer() {
        trace("swap player called");
    }

    /**
     * Displays a tracing (i.e., debug) message to standard output if the
     * instance variable trace is true.
     * @param message the debugging message to output
     */
    public void trace(String message) {
        if (tracing) {
            System.out.println(message);
        }
    }

    /**
     * Sets whether or not tracing messages will be displayed (by modifying the
     * tracing instance variable).
     * @param on if true tracing messags will be displayed
     */
    public void setTracing(boolean on) {
        tracing = on;
    }

}
