import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter index: ");
        int index = sc.nextInt();
        fibonacci(index);
    }

    /**
     * Press the nth element of the Fibonacci sequence.
     *
     * @param index nth element
     */
    public static void fibonacci(int index) {
        if (index == 0) {
            System.out.println("0");
        } else if (index == 1) {
            System.out.println("1");
        } else {
            int n = 0, m = 1, temp;

            for (int i = 0; i < index; i++) {
                temp = m;
                m = n + m;
                n = temp;
            }

            System.out.println(n);
        }
    }
}
