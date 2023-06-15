public class Tombola {
    public static void main(String[] args) {
        int[][] card = new int[][]{{9, 27, 55, 70, 83}, {11, 39, 57, 73, 85}, {5, 18, 34, 41, 62}};
        int[] drawnNumber = new int[]{9, 27, 55, 70, 83, 11, 39, 57, 73, 85, 5, 18, 34, 41, 62};

        tombola(card, drawnNumber);
    }

    /**
     * Taken as input a folder of the bingo in the form of a 3x5 matrix and an array of numbers extracted, the function will check how many doubles, ternis, quaterns and cinquins are present in the card and possibly if he made a bingo.
     *
     * @param card        card to process
     * @param drawnNumber drawn number to process
     */
    public static void tombola(int[][] card, int[] drawnNumber) {
        int ambi = 0, terni = 0, quaterne = 0, cinquine = 0;
        int count = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                for (int value : drawnNumber) {
                    if (card[i][j] == value) {
                        count++;
                    }
                }
            }

            switch (count) {
                case 5 -> cinquine++;
                case 4 -> quaterne++;
                case 3 -> terni++;
                case 2 -> ambi++;
            }

            count = 0;
        }

        if (cinquine == 3) {
            System.out.println("TOMBOLA!");
        } else {
            System.out.println("Il giocatore ha totalizzato ambi: " + ambi + ", terni: " + terni + ", quaterne: " + quaterne + ", cinquine: " + cinquine);
        }
    }
}
