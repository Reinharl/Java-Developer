package model;

public class Carello {
    private ListaProdotti listaProdotti;
    private double importo;

    public Carello() {
        listaProdotti = new ListaProdotti();
        importo = 0;
    }

    public void aggiungiAlCarello(Prodotto prodotto, int quantita) {
        listaProdotti.aggiungiProdotto(prodotto, quantita);
    }

    public void rimuoviDalCarello(Prodotto prodotto) {
        listaProdotti.rimuoviProdotto(prodotto);
    }

    public void rimuoviDalCarello(Prodotto prodotto, int quantita) {
        listaProdotti.rimuoviProdotto(prodotto, quantita);
    }

    public double getImporto() {
        return importo;
    }

    public void addImporto(double importo) {
        this.importo += importo;
    }
}
