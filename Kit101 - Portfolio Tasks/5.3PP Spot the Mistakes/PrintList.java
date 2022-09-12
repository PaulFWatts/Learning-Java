import java.util.Scanner;

/** Test harness */
public class PrintList {

  public static void main(String[] args) {
    String[] document = { "You", "call", "this", "a", "book?" };

    System.out.println("There are " + document.length + " entries.");

    for (int i = 0; i < document.length; i++) {
      System.out.println(document[i] + " has " + document[i].length() + " letters.");
    }
  }
}