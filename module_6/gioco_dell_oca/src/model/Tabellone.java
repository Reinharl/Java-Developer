package model;

import java.util.Arrays;

public class Tabellone {
    private final int n;
    private Giocatore[] giocatori;
    private Casella[] caselle;

    public Tabellone(int n, Giocatore[] giocatori) {
        this.n = n;
        this.giocatori = giocatori;
        caselle = new Casella[n];
        generaTabellone(n);
    }

    public void generaTabellone(int n) {
        caselle[0] = new CasellaVuota();
        caselle[n - 1] = new CasellaVuota();

        for (int i = 1; i < n - 1; i++) {
            int rand = (int) (Math.random() * 3);

            switch (rand) {
                case 0 -> {
                    CasellaVuota casella = new CasellaVuota();
                    caselle[i] = casella;
                }
                case 1 -> {
                    do {
                        rand = (int) (Math.random() * 7 - 3);
                    } while (rand == 0);
                    CasellaSpostaGiocatore casella = new CasellaSpostaGiocatore(rand);
                    caselle[i] = casella;
                }
                case 2 -> {
                    do {
                        rand = (int) (Math.random() * 7 - 3);
                    } while (rand == 0);
                    CasellaPunti casella = new CasellaPunti(rand);
                    caselle[i] = casella;
                }
            }
        }
    }

    public void visualizzaTabellone() {
        System.out.println(Arrays.toString(caselle));
    }

    public void posiziona(Giocatore g, int n) {
        int posizione = g.getPosizione();

        if (posizione + n >= this.n) {
            n = 2 * (this.n - 1 - posizione) - n;
            posiziona(g, n);
        } else {
            g.setPosizione(posizione + n);
        }
    }

    public void posizionaGiocatore(Giocatore g, int n) {
        posiziona(g, n);

        while (caselle[g.getPosizione()] instanceof CasellaSpostaGiocatore) {
            CasellaSpostaGiocatore casella = (CasellaSpostaGiocatore) caselle[g.getPosizione()];
            posiziona(g, casella.getX());
        }

        if (caselle[g.getPosizione()] instanceof CasellaPunti) {
            CasellaPunti casella = (CasellaPunti) caselle[g.getPosizione()];
            g.setPunteggio(g.getPunteggio() + casella.getPunti());
        }
    }

}
