import java.util.Arrays;

public class SommaRicorsiva {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(sommaRicorsiva(array));
    }

    public static int sommaRicorsiva(int[] array) {
        if (array.length == 1) {
            return array[0];
        } else {
            return array[array.length - 1] + sommaRicorsiva(Arrays.copyOf(array, array.length - 1));
        }
    }
}
