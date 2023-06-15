import java.util.Scanner;

public class Anagrammi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string a: ");
        String a = sc.nextLine();
        System.out.print("Enter string b: ");
        String b = sc.nextLine();
        anagrams(a, b);
    }

    /**
     * Given two strings print whether they are anagrams or not.
     *
     * @param a first string
     * @param b second string
     */
    public static void anagrams(String a, String b) {
        if (a.length() != b.length()) {
            System.out.println("non anagrammi");
        } else {
            a = a.toLowerCase();
            b = b.toLowerCase();
            boolean find = false;

            for (int i = 0; i < a.length(); i++) {
                for (int j = 0; j < b.length(); j++) {
                    if (a.charAt(i) == b.charAt(j)) {
                        find = true;
                        b = b.substring(0, j) + null + b.substring(j + 1);
                        break;
                    }
                }

                if (!find) {
                    System.out.println("non anagrammi");
                    return;
                } else {
                    find = false;
                }
            }

            System.out.println("anagrammi");
        }
    }
}
