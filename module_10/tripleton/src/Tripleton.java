public class Tripleton {

    private static Tripleton[] instance = new Tripleton[3];
    private static int index = 0;

    private Tripleton() {

    }

    public static Tripleton getInstance() {
        if (instance[index] == null) {
            instance[index] = new Tripleton();
        }

        int temp = index;
        index = ++index % 3;

        return instance[temp];
    }

}
