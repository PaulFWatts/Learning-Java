import java.util.Scanner;

/** Test harness */
public class SomeSequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, j, k;
        int min, middle, max;

        System.out.print("Enter three integers, separated by spaces: ");
        i = sc.nextInt();
        j = sc.nextInt();
        k = sc.nextInt();

        min = Math.min(i, Math.min(j, k));
        max = Math.max(i, Math.max(j, k));
        middle = i + j + k - min - max;
        System.out.println("The middle value is " + middle);
    }

}