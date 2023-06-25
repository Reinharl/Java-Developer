public class Main {
    public static void main(String[] args) {
        Tripleton a = Tripleton.getInstance();
        Tripleton b = Tripleton.getInstance();
        Tripleton c = Tripleton.getInstance();
        Tripleton d = Tripleton.getInstance();
        Tripleton e = Tripleton.getInstance();
        Tripleton f = Tripleton.getInstance();
        System.out.println(a == d);
        System.out.println(b == e);
        System.out.println(c == f);
    }
}
