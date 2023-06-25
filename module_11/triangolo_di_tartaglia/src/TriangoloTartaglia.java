import java.util.Arrays;

public class TriangoloTartaglia {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(triangoloTartaglia(10)));
    }

    public static int[] triangoloTartaglia(int n) {
        int[] result = new int[n];

        for (int i = 0; i < result.length; i++) {
            result[i] = calcolaElemento(n, i);
        }

        return result;
    }

    public static int calcolaElemento(int n, int k) {
        if (n == 0) {
            return 1;
        } else if (k == 0 || k == n-1) {
            return 1;
        } else {
            return calcolaElemento(n - 1, k - 1) + calcolaElemento(n - 1, k);
        }
    }
}
