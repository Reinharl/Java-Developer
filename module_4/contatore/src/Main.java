import model.Contatore;

public class Main {
    public static void main(String[] args) {
        Contatore counterEmpty = new Contatore();
        System.out.println(counterEmpty.getCounter());

        Contatore counterParam = new Contatore(5);
        System.out.println(counterParam.getCounter());
        counterParam.increment();
        System.out.println(counterParam.getCounter());
        counterParam.restore();
        System.out.println(counterParam.getCounter());
        counterParam.restore(2);
        System.out.println(counterParam.getCounter());
    }

}
