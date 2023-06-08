import java.util.Scanner;

public class PariDispari {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number:");
        int number = sc.nextInt();
        checkEvenOdd(number);
    }

    /**
     * Check if the number is even (true) or odd (false).
     *
     * @param number number to check
     */
    private static void checkEvenOdd(int number) {
        if (number % 2 == 0) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
