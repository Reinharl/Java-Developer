package model;

public class DistributoreDiBevande {
    private int n;
    private ListaBevande listaBevande;
    private double saldo;

    public DistributoreDiBevande(int n) {
        this.n = n;
        listaBevande = new ListaBevande();
        saldo = 0;
    }

    public void caricaProdotto(Bevanda p) {
        if (listaBevande.length() < n) {
            listaBevande.add(p);
        }
    }

    public void inserisciImporto(double importo) {
        saldo += importo;
    }

    public Bevanda scegliProdotto(String nome) {
        int indexOfBevanda = listaBevande.indexOf(nome);

        if (indexOfBevanda != -1) {
            Bevanda p = listaBevande.get(indexOfBevanda);

            if (saldo >= p.getPrezzo()) {
                saldo -= p.getPrezzo();
                listaBevande.remove(p);
                return p;
            }
        }

        return null;
    }

    public double saldoAttuale() {
        return saldo;
    }

    public double getResto() {
        double temp = saldo;
        saldo = 0;
        return temp;
    }
}
