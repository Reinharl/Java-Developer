package model;

public class Negozio {
    private static final int DIMENSIONE_MAX = 100;
    private ListaProdotti listaProdotti;

    public Negozio() {
        listaProdotti = new ListaProdotti();
    }

    public boolean aggiungiProdotto(Prodotto prodotto, int quantita) {
        if (listaProdotti.getDimensione() + quantita <= DIMENSIONE_MAX) {
            listaProdotti.aggiungiProdotto(prodotto, quantita);
            return true;
        } else {
            return false;
        }
    }

    public boolean rimuoviProdotto(Prodotto prodotto, int quantita) {
        if (listaProdotti.contains(prodotto)) {
            if (listaProdotti.getQuantita(prodotto) - quantita > 0) {
                listaProdotti.rimuoviProdotto(prodotto, quantita);
            } else {
                listaProdotti.rimuoviProdotto(prodotto);
            }
            return true;
        }

        return false;
    }

    public int getQuantita(Prodotto prodotto) {
        return listaProdotti.getQuantita(prodotto);
    }
}
