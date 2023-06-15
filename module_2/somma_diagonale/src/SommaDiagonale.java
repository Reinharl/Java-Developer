import java.util.Scanner;

public class SommaDiagonale {
    public static void main(String[] args) {
        int[][] matrix = initMatrix();
        System.out.println(principalDiagonalSum(matrix));
        System.out.println(diagonalSum(matrix, false));

    }

    /**
     * Initialize matrix
     *
     * @return matrix
     */
    public static int[][] initMatrix() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Inserisci la dimensione della matrice: ");
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print("Inserisci l'elemnto [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix[i][j] = sc.nextInt();
            }
        }

        return matrix;
    }

    /**
     * Principal diagonal sum of a matrix.
     *
     * @param matrix matrix to process
     * @return principal diagonal sum
     */
    public static int principalDiagonalSum(int[][] matrix) {
        return principalDiagonalSum(matrix, 0);
    }

    /**
     * Diagonal sum of a matrix, index = 0 for principal
     * index = matrix[0].length-1 for secondary
     *
     * @param matrix matrix to process
     * @param index  principal or secondary
     * @return
     */
    private static int principalDiagonalSum(int[][] matrix, int index) {
        int sum = 0;

        for (int i = 0; i < matrix[0].length; i++) {
            sum += matrix[Math.abs(index - i)][i];
        }

        return sum;
    }

    /**
     * Diagonal sum of matrix, if flag is true then is the principal sum
     * else is the secondary.
     *
     * @param matrix matrix to process
     * @param flag   principal or secondary
     * @return diagonal sum
     */
    public static int diagonalSum(int[][] matrix, boolean flag) {
        if (flag) {
            return principalDiagonalSum(matrix, 0);
        } else {
            return principalDiagonalSum(matrix, matrix[0].length - 1);
        }
    }
}
