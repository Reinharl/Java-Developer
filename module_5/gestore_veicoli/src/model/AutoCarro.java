package model;

public class AutoCarro extends Veicolo {
    private int capacita;

    public AutoCarro(String targa, int numeroPosti, int capacita) {
        super(targa, numeroPosti);
        this.capacita = capacita;
    }

    @Override
    public String toString() {
        return super.toString() + ":" + capacita;
    }
}
