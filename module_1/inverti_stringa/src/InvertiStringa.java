import java.util.Scanner;

public class InvertiStringa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string:");
        String a = sc.nextLine();
        reverseString(a);
    }

    /**
     * Reverses a String consisting of two words separated by a space.
     *
     * @param s is the String to reverse
     */
    private static void reverseString(String s) {
        String[] split = s.split(" ");
        System.out.println(split[1] + " " + split[0]);
    }
}
