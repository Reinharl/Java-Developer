package model;

public class Veicolo {
    private String targa;
    private int numeroPosti;

    public Veicolo(String targa, int numeroPosti) {
        this.targa = targa;
        this.numeroPosti = numeroPosti;
    }

    @Override
    public String toString() {
        return targa;
    }
}
