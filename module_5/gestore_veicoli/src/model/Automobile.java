package model;

public class Automobile extends Veicolo {
    private int numeroPorte;

    public Automobile(String targa, int numeroPosti, int numeroPorte) {
        super(targa, numeroPosti);
        this.numeroPorte = numeroPorte;
    }

    @Override
    public String toString() {
        return super.toString() + ":" + numeroPorte;
    }
}
