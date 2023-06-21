import model.ListaOrdinataDiInteri;

public class Main {
    public static void main(String[] args) {
        ListaOrdinataDiInteri l = new ListaOrdinataDiInteri();
        l.add(10);
        l.add(4);
        l.add(7);
        l.add(11);
        l.add(0);
        System.out.println(l.get(2) == 7);
        System.out.println(l.add(-2, 0));
        System.out.println(!l.add(2,3));
        System.out.println(!l.addLast(8));



    }
}
