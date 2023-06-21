package model;

public class Bevanda {
    private final String nome;
    private final double prezzo;

    public Bevanda(String nome, double prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

}
