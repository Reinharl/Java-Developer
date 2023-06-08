import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string:");
        String a = sc.nextLine();
        stringReverse(a);
    }

    /**
     * Given a string s, print its reverse.
     *
     * @param s string to reverse
     */
    static void stringReverse(String s) {
        String[] split = s.split("");

        for (int i = 0; i < s.length(); i++) {
            System.out.print(split[s.length() - 1 - i]);
        }
    }
}
