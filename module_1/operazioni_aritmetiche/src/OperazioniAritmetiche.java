import java.util.Scanner;

public class OperazioniAritmetiche {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a:");
        int a = sc.nextInt();
        System.out.print("Enter b:");
        int b = sc.nextInt();
        computeValues(a, b);
    }

    /**
     * Calculate the sum, difference, product and division of two numbers.
     * @param a is the first term
     * @param b is the last term
     */
    private static void computeValues(int a, int b) {
        System.out.println("Sum: " + (a + b));
        System.out.println("Difference: " + (a - b));
        System.out.println("Product: " + (a * b));
        System.out.println("Division: " + ((double) a / b));
    }
}
