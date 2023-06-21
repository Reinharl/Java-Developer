import model.AutoCarro;
import model.Automobile;

public class Main {
    public static void main(String[] args) {
        Automobile automobile = new Automobile("cf123rm", 4, 4);
        AutoCarro autoCarro = new AutoCarro("ca133sm", 4, 2);

        System.out.println(automobile);
        System.out.println(autoCarro);
    }
}
