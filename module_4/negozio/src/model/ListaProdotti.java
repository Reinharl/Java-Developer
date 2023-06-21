package model;

import java.util.HashMap;
import java.util.Map;

public class ListaProdotti {
    private Map<Prodotto, Integer> listaProdotti;
    private int dimensione;

    public ListaProdotti() {
        listaProdotti = new HashMap<>();
        dimensione = 0;
    }

    public int getDimensione() {
        return dimensione;
    }

    public boolean contains(Prodotto prodotto) {
        return listaProdotti.containsKey(prodotto);
    }

    public void aggiungiProdotto(Prodotto prodotto, int quantita) {
        listaProdotti.put(prodotto, quantita);
        dimensione += quantita;
    }

    public void rimuoviProdotto(Prodotto prodotto) {
        dimensione -= listaProdotti.get(prodotto);
        listaProdotti.remove(prodotto);
    }

    public void rimuoviProdotto(Prodotto prodotto, int quantita) {
        dimensione -= quantita;
        listaProdotti.put(prodotto, listaProdotti.get(prodotto) - quantita);
    }

    public int getQuantita(Prodotto prodotto) {
        return listaProdotti.getOrDefault(prodotto, -1);
    }

    @Override
    public String toString() {
        return "ListaProdotti{" +
                "listaProdotti=" + listaProdotti +
                ", dimensione=" + dimensione +
                '}';
    }
}
