import java.util.Scanner;

public class RimpiazzaIntrusi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string:");
        String a = sc.nextLine();
        System.out.print("Enter string:");
        String b = sc.nextLine();
        System.out.print("Enter string:");
        String c = sc.nextLine();
        replaceIntruder(a, b, c);
    }

    /**
     * Given three strings a, b and c, print c after replacing, inside c, each
     * occurrence between two spaces of a with b.
     *
     * @param a is the old String
     * @param b is the new String
     * @param c is the String to elaborate
     */
    private static void replaceIntruder(String a, String b, String c) {
        String[] split = c.split(" ");
        System.out.println(split[0] + " " + split[1].replace(a, b) + " " + split[2]);
    }

}