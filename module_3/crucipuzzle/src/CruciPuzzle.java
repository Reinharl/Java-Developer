import java.util.Scanner;

public class CruciPuzzle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char[][] cruciPuzzle = initCruci();
        String word;

        viewCruci(cruciPuzzle);

        System.out.print("\nInserisci una parola (E) per uscire: ");
        word = input.nextLine();

        while (!word.equals("E")) {
            System.out.println("\nOrizzontale: " + searchHorizontally(cruciPuzzle, word.toUpperCase()));
            System.out.println("Verticale: " + searchVertically(cruciPuzzle, word.toUpperCase()));
            System.out.println("Orizzontale (senso inverso): " + searchHorizontally(cruciPuzzle, stringReverse(word.toUpperCase())));
            System.out.println("Verticale (senso inverso): " + searchVertically(cruciPuzzle, stringReverse(word.toUpperCase())));

            System.out.print("\nInserisci una parola (E) per uscire: ");
            word = input.nextLine();
        }

    }

    /**
     * Initialize a given Crucipuzzle.
     *
     * @return matrix representation of the Crucipuzzle
     */
    public static char[][] initCruci() {

        char[][] cruciPuzzle = {
                {'H', 'D', 'G', 'U', 'P', 'Y', 'S', 'P', 'A', 'O'},
                {'T', 'S', 'A', 'K', 'O', 'Y', 'O', 'L', 'P', 'S'},
                {'R', 'C', 'M', 'C', 'N', 'R', 'I', 'A', 'A', 'B'},
                {'I', 'O', 'B', 'A', 'I', 'S', 'C', 'T', 'L', 'A'},
                {'G', 'R', 'E', 'L', 'F', 'A', 'C', 'E', 'O', 'L'},
                {'L', 'F', 'R', 'A', 'L', 'L', 'U', 'S', 'I', 'E'},
                {'I', 'A', 'E', 'M', 'E', 'M', 'L', 'S', 'L', 'N'},
                {'A', 'N', 'T', 'A', 'D', 'O', 'C', 'A', 'G', 'A'},
                {'J', 'O', 'T', 'R', 'B', 'N', 'D', 'G', 'O', 'D'},
                {'L', 'Y', 'O', 'O', 'U', 'E', 'S', 'M', 'S', 'M'}
        };

        return cruciPuzzle;
    }

    /**
     * View the Crucipuzzle on console.
     *
     * @param cruciPuzzle Crucipuzzle to view
     */
    public static void viewCruci(char[][] cruciPuzzle) {
        for (int i = 0; i < cruciPuzzle[0].length; i++) {
            for (int j = 0; j < cruciPuzzle[0].length; j++) {
                System.out.print(" " + cruciPuzzle[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Search the word horizontally
     *
     * @param cruciPuzzle Crucipuzzle to process
     * @param word        word to search
     * @return
     */
    public static boolean searchHorizontally(char[][] cruciPuzzle, String word) {
        int count = 0;

        for (int i = 0; i < cruciPuzzle[0].length; i++) {
            for (int j = 0; j < cruciPuzzle[0].length; j++) {
                if (cruciPuzzle[i][j] == word.charAt(0) && word.length() + j - cruciPuzzle[0].length <= 0) {
                    for (int k = 1; k < word.length(); k++) {
                        if (cruciPuzzle[i][j + k] == word.charAt(k)) {
                            count++;
                        } else
                            break;
                    }

                    if (count == word.length() - 1)
                        return true;
                    else
                        count = 0;
                }
            }
        }

        return false;
    }

    /**
     * Search the word vertically
     *
     * @param cruciPuzzle Crucipuzzle to process
     * @param word        word to search
     * @return
     */
    public static boolean searchVertically(char[][] cruciPuzzle, String word) {
        int count = 0;

        for (int j = 0; j < cruciPuzzle[0].length; j++) {
            for (int i = 0; i < cruciPuzzle[0].length; i++) {
                if (cruciPuzzle[i][j] == word.charAt(0) && word.length() + i - cruciPuzzle[0].length <= 0) {
                    for (int k = 1; k < word.length(); k++) {
                        if (cruciPuzzle[i + k][j] == word.charAt(k)) {
                            count++;
                        } else
                            break;
                    }

                    if (count == word.length() - 1)
                        return true;
                    else
                        count = 0;
                }
            }
        }

        return false;
    }

    /**
     * Reverse the string.
     *
     * @param s string to reverse
     * @return reverted string
     */
    private static String stringReverse(String s) {
        StringBuilder result = new StringBuilder(s);

        return result.reverse().toString();
    }
}
