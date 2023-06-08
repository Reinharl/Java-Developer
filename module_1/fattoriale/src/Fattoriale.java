public class Fattoriale {
    public static void main(String[] args) {
        System.out.println(factorial(0) == (1));
        System.out.println(factorial(2) == (2));
        System.out.println(factorial(5) == (120));
        System.out.println(factorial(10) == (3628800));
        System.out.println(factorial(20) == 2432902008176640000L);
    }

    /**
     * Calculate the factorial of the number n.
     *
     * @param n the number to elaborate
     * @return the factorial of n
     */
    private static long factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
