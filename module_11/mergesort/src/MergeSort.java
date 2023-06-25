import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {9, 7, 3, -2, 1, 5, 7, 2, 0};

        System.out.println(Arrays.toString(mergeSort(array)));
    }

    public static int[] mergeSort(int[] array) {
        if (array.length < 2) {
            return array;
        }

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }

        for (int i = 0; i < array.length - mid; i++) {
            right[i] = array[mid + i];
        }

        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right, array);
    }

    public static int[] merge(int[] left, int[] right, int[] array) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }

        return array;
    }
}
