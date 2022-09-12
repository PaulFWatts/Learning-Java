import java.util.Scanner;

/**
 * Snakes and Ladders game, completed.
 * @author Robyn Gibson
 * @author Julian Dermoudy
 * @author James Montgomery
 * @version 3.3 (April 2018)
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
    }

    /**
     * Controls the "outer loop" of the game; calls playGame() to play each
     * individual game.
     */
    public void startPlaying() {
        final char YES = 'y'; //valid yes response
        char answer; //user's response

        System.out.print("Do you want to play Snakes and Ladders? (y/n) ");
        answer = sc.next().toLowerCase().charAt(0); //<-- this code for reading 1 character could be its own method
        while (answer == YES) {
            playGame();
            System.out.print("Do you want to play again? (y/n) ");
            answer = sc.next().toLowerCase().charAt(0);
        }
    }

    /**
     * Plays one game; calls makeAMove() for each move and swapPlayer when
     * necessary.
     */
    public void playGame() {
        boolean over; //is the game over yet?

        trace("game started");
        over = false;
        p1position = 0;
        p2position = 0;
        playerNum = 1;
        while (!over) {
            System.out.println();
            over = makeAMove(playerNum);
            if (!over) {
                swapPlayer();
                //Could insert a pause here, either time-based or the user pressing Enter
            }
        }
        System.out.println("Winner of this game is Player " + playerNum);
    }

    /**
     * Changes the value of the counter for the given player. Uses roll method of
     * the Die to find distance to move and moveOn method of the Board to find
     * new position for the player.
     * @param player - the current player
     * @return true if the game is now over, false otherwise
     */
    public boolean makeAMove(int player) {
        int dieRolled; //value rolled by player
        int playerPos; //copy of current player's position
        boolean finished = false; //must be or this would not have been called

        System.out.println();
        System.out.println("Current Player: " + player);
        dieRolled = roller.roll();

        //Note: This method's implementation could be improved if players were actual objects since
        // could simply "point" to the current player, saving some repetition of decision making code.

        //Get current player's position
        switch (player) {
            case 1: playerPos = p1position; break;
            default: playerPos = p2position; //currently only 2 players
        }

        //Make the move
        System.out.println("Starting at position: " + playerPos);
        System.out.println("Die roll is: " + dieRolled);
        playerPos = gameBoard.moveOn(playerPos, dieRolled);
        System.out.println("Now at position: " + playerPos);

        //Update current player's position
        switch (player) {
            case 1: p1position = playerPos; break;
            default: p2position = playerPos;
        }

        if (playerPos == gameBoard.getLastSquare()) {
            finished = true;
        }
        //Alternatively, in one line (in fact, this would be preferred):
        //return playerPos == gameBoard.getLastPosition();

        return finished;
    }

    /**
     * Swaps the current player by changing the value of the instance variable
     * playerNum.
     */
    public void swapPlayer() {
        if (playerNum == 1) {
            playerNum = 2;
        } else {
            playerNum = 1;
        }
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
