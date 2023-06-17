import model.Cerchio;
import model.Quadrato;

public class Main {
    public static void main(String[] args) {
        Quadrato quadrato = new Quadrato(4);

        System.out.println(quadrato.perimeter());
        quadrato.print();

        Cerchio cerchio = new Cerchio(1);
        System.out.println(cerchio.circumference());
        System.out.println(cerchio.area());
    }
}
