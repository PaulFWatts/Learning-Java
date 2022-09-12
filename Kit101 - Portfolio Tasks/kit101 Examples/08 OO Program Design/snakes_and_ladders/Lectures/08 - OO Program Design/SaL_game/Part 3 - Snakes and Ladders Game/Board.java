import java.util.Arrays;

/**
 * A Snakes and Ladders board
 * @author Robyn Gibson, James Montgomery
 * @version 1.01
 */
public class Board {
    private final int MAX = 50; //number of squares on the board

    //Note that the integer 'next position' and String message for each square could be represented by a new class
    private int[] gameBoard; //the game board and the connections between squares
    private String[] messageBoard; //mirrors the game board and has messages associated with snakes and ladders
    private int[] ladderStarts = { 4, 15, 22, 30, 38 }; //|- ladder connections
    private int[] ladderEnds =   {14, 36, 42, 35, 42 }; //|
    private String[] ladderMessages = {
        ":-) You have worked on this unit every day this week",
        ":-) All your tutorial work and your record book is up to date",
        ":-) You have your assignment completed two days before it is due",
        ":-) You have read over the notes before this week's lectures",
        ":-) You have revised the topics from last week's lectures"
    };
    private int[] snakeStarts = {47, 34, 25, 18, 12 }; //|- snake connections
    private int[] snakeEnds =   {20, 24, 17,  8, 5  }; //|
    private String[] snakeMessages = {
        ":-( You have copied your assignment from another student",
        ":-( You have written 100 lines of code without compiling",
        ":-( You have not done any work on this unit for 10 days",
        ":-( You are just starting work on your assignment - it is due in 2 days",
        ":-( You spent the last lecture reading the newspaper"
    };

    private boolean tracing; //controls debugging output


    /** Creates a new Snakes and Ladders game board. */
    public Board() {
        gameBoard = new int[MAX + 1];
        messageBoard = new String[MAX + 1];
        Arrays.fill(gameBoard, 0); //0 is an ordinary square, no ladder or snake
        //Note: messageBoard contents already initialised to null by default
        //Add ladders
        for (int i = 0; i < ladderStarts.length; i++) {
            gameBoard[ladderStarts[i]] = ladderEnds[i];
            messageBoard[ladderStarts[i]] = ladderMessages[i];
        }
        //Add snakes
        for (int i = 0; i < snakeStarts.length; i++) {
            gameBoard[snakeStarts[i]] = snakeEnds[i];
            messageBoard[snakeStarts[i]] = snakeMessages[i];
        }
        //Add winner message
        messageBoard[MAX]  = "Congratulations, you have reached the end";
    }

    /** Displays the board details for debugging purposes. Not suitable for game output. */
    public void checkBoards() {
        if (tracing) {
            for (int i = 0; i <= MAX; i++) {
                System.out.println("Cell: " + i + " next is " + gameBoard[i] );
                System.out.println("Message: " + messageBoard[i]);
            }
        }
    }

    /** Moves dist squares from start, following any ladder or snake at the final cell. */
    public int moveOn(int start, int dist) {
        int next; //next location on the board

        next = start;
        if (start + dist <= MAX) {
            next = next + dist;
            if (gameBoard[next] != 0) {
                System.out.println(messageBoard[next]);
                next = gameBoard[next];
            }
        } else {
            System.out.println("You must roll the exact number to finish");
        }
        return next;
    }

    /** Returns the numerical position of the last square on the board. */
    public int getLastSquare() {
        return MAX;
    }

    /** Display the given debugging message if tracing is on. */
    public void trace(String message) {
        if (tracing) {
            System.out.println(message);
        }
    }

    /** Controls whether debugging output will be displayed. */
    public void setTracing(boolean on) {
        tracing = on;
    }

}
