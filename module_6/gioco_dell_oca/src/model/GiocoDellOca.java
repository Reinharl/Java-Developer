package model;

public class GiocoDellOca {
    private int n;
    private Giocatore[] giocatori;
    private Tabellone tabellone;

    public GiocoDellOca(int n, Giocatore[] giocatori) {
        this.n = n;
        this.giocatori = giocatori;
        tabellone = new Tabellone(n, giocatori);
    }

    public void giocaUnTurno() {
        for (Giocatore giocatore : giocatori) {
            gioca(giocatore);

            if (giocatore.getPosizione() == this.n - 1) {
                System.out.println("Il giocatore " + giocatore.getIdGiocatore() + " ha vinto!");
                return;
            }
        }
    }

    public void gioca(Giocatore giocatore) {
        int n = giocatore.tiraDadi();
        tabellone.posizionaGiocatore(giocatore, n);

        System.out.println("Il giocatore " + giocatore.getIdGiocatore() + " ha tirato e gli è uscito: " + n);
        System.out.println("Si trova in posizione: " + giocatore.getPosizione());
        System.out.println("ed ha : " + giocatore.getPunteggio() + " punti");
    }

    public void visualizzaTabellone() {
        tabellone.visualizzaTabellone();
    }
}
