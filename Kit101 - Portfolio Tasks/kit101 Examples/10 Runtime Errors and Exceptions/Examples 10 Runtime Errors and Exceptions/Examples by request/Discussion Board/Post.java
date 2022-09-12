/**
 * A basic discussion board message, with only the author's name and message.
 * Does not support fancy formatting and does not timestamp messages.
 */
public class Post {
    private String author; //the post's author; read-only
    private String message; //their post; read-only
    
    /** Creates a new Post containing the message by author. */
    public Post(String author, String message) {
        this.author = author;
        this.message = message;
    }
    
    /**
     * Returns true if either the author or the message contain the given text,
     * false otherwise. This message is outside the template we suggest, because
     * it's adding additional functionality to the object.
     */
    public boolean contains(String query) {
        query = query.toLowerCase();
        return author.toLowerCase().contains(query) || message.toLowerCase().contains(query);
    }
    
    /** Returns the post's author. */
    public String getAuthor() {
        return author;
    }

    /** Returns the posted message. */
    public String getMessage() {
        return message;
    }
    
    /** Returns a formatted version of the post. */
    public String toString() {
        //The String.format() method allows us to (in this case) right
        //align the author assuming a screen width of 80 characters
        return message + '\n' + String.format("%80s", "Author: " + author);
    }
    
}
    