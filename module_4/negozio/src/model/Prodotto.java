package model;

import java.util.Objects;

public class Prodotto {
    private final String nome;
    private final double prezzo;
    private final TipoProdotto tipoProdotto;

    public Prodotto(String nome, double prezzo, TipoProdotto tipoProdotto) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.tipoProdotto = tipoProdotto;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public TipoProdotto getTipoProdotto() {
        return tipoProdotto;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "nome='" + nome + '\'' +
                ", prezzo=" + prezzo +
                ", tipoProdotto=" + tipoProdotto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prodotto prodotto = (Prodotto) o;
        return prezzo == prodotto.prezzo && Objects.equals(nome, prodotto.nome) && tipoProdotto == prodotto.tipoProdotto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, prezzo, tipoProdotto);
    }
}
