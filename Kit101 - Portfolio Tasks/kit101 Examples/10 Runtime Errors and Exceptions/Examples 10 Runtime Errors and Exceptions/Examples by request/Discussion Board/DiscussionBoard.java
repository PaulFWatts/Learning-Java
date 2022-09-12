import java.util.Scanner;

/**
 * A very simple discussion board (basic data only and not online).
 * Designed to demonstrate object-oriented design (the Post is a new class
 * representing a user's message), use of arrays of objects (the sequence
 * of Posts), and also functional decomposition.
 * 
 * @author James Montgomery
 */
public class DiscussionBoard {

    /** Prompts the user for a line of text. */
    public static String readLine(String promptFor, Scanner in) {
        System.out.print(promptFor + ": ");
        return in.nextLine();
    }
    
    /**
     * Gets details for a new post from the user and adds to the collection,
     * if space. Combines some functionality that is separate in task 7.1PP.
     */
    public static int addPost(Post[] posts, int numPosts, Scanner in) {
        String author, message; //new post details
        if (numPosts < posts.length) {
            posts[numPosts] = new Post(readLine("Author", in), readLine("Message", in));
            numPosts++;
        } else {
            System.out.println("500: Collection is full"); //<-- 500 is the HTTP Server Error code :-)
        }
        return numPosts;
    }
    
    /** Displays all posts, numbered. */
    public static void display(Post[] posts, int numPosts, String heading) {
        System.out.println("\n" + heading + "\n");
        for (int i = 0; i < numPosts; i++) {
            System.out.println((i + 1) + ". " + posts[i]);
        }
        System.out.println();
    }
    
    /** Finds and displays all posts whose message contains query. */
    public static void findAll(String query, Post[] posts, int numPosts) {
        Post[] matches = new Post[numPosts]; //temporary container for matches
        int count = 0; //number of matches
        
        for (int i = 0; i < numPosts; i++) {
            if (posts[i].contains(query)) {
                matches[count] = posts[i];
                count++;
            }
        }
        
        if (count == 0) {
            System.out.print("No matches found.");
        } else {
            display(matches, count, "Matching posts:");
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int MAX_POSTS = 100;
        Post[] posts = new Post[MAX_POSTS]; //collection of posts
        int numPosts = 0; //number of posts
        int option; //user's menu selection
        
        do {
            System.out.print("1. New post\n2. Display posts\n3. Search\n4. Quit\nEnter choice: ");
            option = in.nextInt();
            in.nextLine(); //rest of program uses nextLine(), so read past empty string after the number
            switch (option) {
                case 1: numPosts = addPost(posts, numPosts, in); break;
                case 2: display(posts, numPosts, "Discussion Board"); break;
                case 3: findAll(readLine("Search for", in), posts, numPosts); break;
            }
        } while (option != 4);
    }
}