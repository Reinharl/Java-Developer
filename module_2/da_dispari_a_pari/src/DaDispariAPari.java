import java.util.Arrays;
import java.util.Scanner;

public class DaDispariAPari {

    public static void main(String[] args) {
        int[] numbers = initArray();
        System.out.println(Arrays.toString(oddToEven(numbers)));

    }

    /**
     * Given an array converts odd numbers to even numbers
     *
     * @param array array to process
     * @return conversion result
     */
    public static int[] oddToEven(int[] array) {
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                result[i] = 2 * array[i];
            } else {
                result[i] = array[i];
            }
        }

        return result;
    }

    /**
     * Initialize an array.
     *
     * @return array
     */
    public static int[] initArray() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Inserisci la dimensione dell'array: ");
        int n = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            System.out.print("Inserisci il " + (i + 1) + "' numero: ");
            array[i] = sc.nextInt();
        }

        return array;
    }
}
