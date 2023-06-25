import java.util.Arrays;

public class RicercaBinaria {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println(binarySearch(array, 7));
    }


    public static boolean binarySearch(int[] array, int key) {
        int mid = array.length / 2;

        if (array[mid] == key) {
            return true;
        } else if (array.length == 1) {
            return false;
        } else if (key < array[mid]) {
            return binarySearch(Arrays.copyOfRange(array, 0, mid), key);
        } else {
            return binarySearch(Arrays.copyOfRange(array, mid, array.length), key);
        }
    }
}
