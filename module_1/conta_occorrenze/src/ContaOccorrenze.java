import java.util.Scanner;

public class ContaOccorrenze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter character a:");
        String a = sc.nextLine();
        System.out.print("Enter string b:");
        String b = sc.nextLine();
        countOccurrences(a.charAt(0), b);
    }

    /**
     * Given a char a and a string b, print the number of occurrences of a in b (Case sensitive).
     *
     * @param a occurrences to count
     * @param b where to count
     */
    static void countOccurrences(char a, String b) {
        int count = 0;

        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == a) {
                count++;
            }
        }

        System.out.println(count);
    }
}
