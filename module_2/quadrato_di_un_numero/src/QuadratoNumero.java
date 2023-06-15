public class QuadratoNumero {
    public static void main(String[] args) {
        System.out.println(square(3));
        System.out.println(square(6));
    }

    /**
     * Given a number, calculate the square of that number using the odd sum.
     * @param number number to process
     * @return the square of the number
     */
    public static int square(int number) {
        int result = 0;

        for (int i = 0; i < Math.abs(number); i++) {
            result += 2*i+1;
        }

        return result;
    }
}
