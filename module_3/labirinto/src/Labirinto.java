import java.util.Scanner;
import java.util.Random;


public class Labirinto {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Labyrinth dimension
        int dim = 4;

        char[][] labyrinth = initLabyrinth(dim);
        viewLabyrinth(labyrinth);

        int[] P = positionP(labyrinth);
        int[] E = positionE(labyrinth);

        String move;

        do {
            move = input.nextLine();

            switch (move) {
                case "w" -> moveUp(labyrinth, P);
                case "s" -> moveDown(labyrinth, P);
                case "d" -> moveRight(labyrinth, P);
                case "a" -> moveLeft(labyrinth, P);
                default -> System.exit(0);
            }
            viewLabyrinth(labyrinth);
            P = positionP(labyrinth);

        } while (labyrinth[P[0]][P[1]] != labyrinth[E[0]][E[1]]);
        System.out.println("HAI VINTO!!!");

    }

    /**
     * Initialize a random maze of the given size.
     *
     * @param dim dimension of maze
     * @return array representation of the maze
     */
    public static char[][] initLabyrinth(int dim) {
        // Exercise labyrinth
        // char[][] labyrinth = {{'-', '-', 'W', 'W', '-'}, {'-', 'W', '-', 'W', '-'}, {'P', 'W', '-', 'W', 'W'}, {'-', '-', 'W', '-', 'E'}, {'W', '-', '-', '-', 'W'}};
        char[][] labyrinth = new char[dim][dim];

        Random r = new Random();

        String carrateri = "-W";

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                labyrinth[i][j] = carrateri.charAt(r.nextInt(carrateri.length()));
            }
        }

        labyrinth[r.nextInt(labyrinth[0].length)][0] = 'P';
        labyrinth[r.nextInt(labyrinth[0].length)][dim - 1] = 'E';
        int[] P = positionP(labyrinth);
        int[] E = positionE(labyrinth);

        if (!isSolvable(labyrinth))
            return initLabyrinth(dim);
        else {
            labyrinth[P[0]][P[1]] = 'P';
            labyrinth[E[0]][E[1]] = 'E';
            return labyrinth;
        }
    }

    /**
     * View the maze on console.
     *
     * @param labyrinth maze to view
     */
    public static void viewLabyrinth(char[][] labyrinth) {
        for (int i = 0; i < labyrinth[0].length; i++) {
            for (int j = 0; j < labyrinth[0].length; j++) {
                System.out.print(labyrinth[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Player position within the maze.
     *
     * @param labyrinth maze to process
     * @return player position
     */
    public static int[] positionP(char[][] labyrinth) {
        int[] positionP = new int[2];

        for (int i = 0; i < labyrinth[0].length; i++) {
            for (int j = 0; j < labyrinth[0].length; j++) {
                if (labyrinth[i][j] == 'P') {
                    positionP[0] = i;
                    positionP[1] = j;
                }
            }
        }
        return positionP;
    }

    /**
     * Location of the exit inside the labyrinth.
     *
     * @param labyrinth maze to process
     * @return exit position
     */
    public static int[] positionE(char[][] labyrinth) {
        int[] positionE = new int[2];

        for (int i = 0; i < labyrinth[0].length; i++) {
            for (int j = 0; j < labyrinth[0].length; j++) {
                if (labyrinth[i][j] == 'E') {
                    positionE[0] = i;
                    positionE[1] = j;
                }
            }
        }
        return positionE;
    }

    /**
     * Moves the player up
     *
     * @param labyrinth maze to process
     * @param positionP position of player
     */
    public static void moveUp(char[][] labyrinth, int[] positionP) {
        if (positionP[0] - 1 < 0)
            return;
        if (labyrinth[positionP[0] - 1][positionP[1]] == '-' || labyrinth[positionP[0] - 1][positionP[1]] == 'E') {
            labyrinth[positionP[0] - 1][positionP[1]] = 'P';
            labyrinth[positionP[0]][positionP[1]] = '-';
        }
    }

    /**
     * Moves the player down
     *
     * @param labyrinth maze to process
     * @param positionP position of player
     */
    public static void moveDown(char[][] labyrinth, int[] positionP) {
        if (positionP[0] + 1 >= labyrinth[0].length)
            return;
        if (labyrinth[positionP[0] + 1][positionP[1]] == '-' || labyrinth[positionP[0] + 1][positionP[1]] == 'E') {
            labyrinth[positionP[0] + 1][positionP[1]] = 'P';
            labyrinth[positionP[0]][positionP[1]] = '-';
        }
    }

    /**
     * Moves the player right
     *
     * @param labyrinth maze to process
     * @param positionP position of player
     */
    public static void moveRight(char[][] labyrinth, int[] positionP) {
        if (positionP[1] + 1 >= labyrinth[0].length)
            return;
        if (labyrinth[positionP[0]][positionP[1] + 1] == '-' || labyrinth[positionP[0]][positionP[1] + 1] == 'E') {
            labyrinth[positionP[0]][positionP[1] + 1] = 'P';
            labyrinth[positionP[0]][positionP[1]] = '-';
        }
    }

    /**
     * Moves the player left
     *
     * @param labyrinth maze to process
     * @param positionP position of player
     */
    public static void moveLeft(char[][] labyrinth, int[] positionP) {
        if (positionP[1] - 1 < 0)
            return;
        if (labyrinth[positionP[0]][positionP[1] - 1] == '-' || labyrinth[positionP[0]][positionP[1] - 1] == 'E') {
            labyrinth[positionP[0]][positionP[1] - 1] = 'P';
            labyrinth[positionP[0]][positionP[1]] = '-';
        }
    }

    /**
     * The program through the brute force method indicates whether the maze is solvable or not.
     *
     * @param labyrinth maze to process
     * @return whether it is fixable or not
     */
    public static boolean isSolvable(char[][] labyrinth) {
        int count = 0;
        int[] P = positionP(labyrinth);
        int[] E = positionE(labyrinth);

        Random r = new Random();

        while (labyrinth[P[0]][P[1]] != labyrinth[E[0]][E[1]] && count < 100 * labyrinth[0].length) {
            count++;
            int numero = r.nextInt(4);
            switch (numero) {
                case 0 -> moveUp(labyrinth, P);
                case 1 -> moveDown(labyrinth, P);
                case 2 -> moveRight(labyrinth, P);
                case 3 -> moveLeft(labyrinth, P);
            }
            P = positionP(labyrinth);
        }

        return count < 100 * labyrinth[0].length;
    }
}
