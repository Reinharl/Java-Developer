import java.util.Arrays;
import java.util.Scanner;

public class Tabelline {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Inserisci n: ");
        int n = sc.nextInt();

        System.out.print("Inserisci m: ");
        int m = sc.nextInt();

        System.out.println(Arrays.toString(multiplicationTables(n, m)));
    }

    /**
     * Given two numbers n and m, it returns the first m digits of the table of n.
     *
     * @param n table of
     * @param m first digits
     * @return first m digits of the table of n
     */
    public static int[] multiplicationTables(int n, int m) {
        int[] result = new int[m];

        for (int i = 0; i < result.length; i++) {
            result[i] = n * i;
        }

        return result;
    }
}
