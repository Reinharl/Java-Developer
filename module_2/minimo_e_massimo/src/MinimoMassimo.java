import java.util.Scanner;

public class MinimoMassimo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter numbers (comma-separated): ");
        String a = sc.nextLine();
        int[] values = parseNumbers(a);
        computeMinAndMax(values);
    }

    /**
     * Converts comma separated values to integers
     *
     * @param s the comma
     * @return values
     */
    static int[] parseNumbers(String s) {
        String[] split = s.split(",");
        int[] result = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.parseInt(split[i]);
        }

        return result;
    }

    /**
     * Print the values in ascending order
     *
     * @param values values to process
     */
    public static void computeMinAndMax(int[] values) {
        int temp;

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length - i - 1; j++) {
                if (values[j] > values[j + 1]) {
                    temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < values.length - 1; i++) {
            System.out.print(values[i] + ", ");
        }
        System.out.println(values[values.length - 1]);

    }

}
