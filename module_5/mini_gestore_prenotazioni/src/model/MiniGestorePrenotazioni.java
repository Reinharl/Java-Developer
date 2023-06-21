package model;

public class MiniGestorePrenotazioni {
    private int m;
    private int n;
    private ListaPrenotazioni prenotazioniInterne;
    private ListaPrenotazioni prenotazioniEsterne;

    public MiniGestorePrenotazioni(int m, int n) {
        this.m = m;
        this.n = n;
        prenotazioniInterne = new ListaPrenotazioni();
        prenotazioniEsterne = new ListaPrenotazioni();
    }

    private boolean prenotaInterno(Prenotazione p) {
        prenotazioniInterne.add(p);
        return true;
    }

    private boolean prenotaEsterno(Prenotazione p) {
        prenotazioniEsterne.add(p);
        return true;
    }

    private boolean prenotaSingola(Prenotazione prenotazione) {
        PrenotazioneSingola p = (PrenotazioneSingola) prenotazione;
        boolean isPreferenzaInterno = p.getPreferenza() == Preferenza.INTERNO;

        if ((isPreferenzaInterno && prenotazioniInterne.length() < m) || (!isPreferenzaInterno && prenotazioniEsterne.length() >= n)) {
            return prenotaInterno(p);
        } else if ((isPreferenzaInterno && prenotazioniInterne.length() >= m) || (!isPreferenzaInterno && prenotazioniEsterne.length() < n)) {
            return prenotaEsterno(p);
        }

        return false;
    }

    public boolean prenotaGruppo(Prenotazione prenotazione) {
        PrenotazioneGruppo p = (PrenotazioneGruppo) prenotazione;

        if (prenotazioniInterne.length() + p.getnPosti() <= m) {
            return prenotaInterno(p);
        } else if (prenotazioniEsterne.length() + p.getnPosti() <= n) {
            return prenotaEsterno(p);
        }
        return false;
    }


    public boolean prenota(Prenotazione prenotazione) {
        if (prenotazione instanceof PrenotazioneSingola) {
            return prenotaSingola(prenotazione);
        } else {
            return prenotaGruppo(prenotazione);
        }
    }

    public Prenotazione[] prenotazioniAttualiInterno() {
        return prenotazioniInterne.toArray();
    }

    public Prenotazione[] prenotazioniAttualiEsterno() {
        return prenotazioniEsterne.toArray();
    }

    @Override
    public String toString() {
        return "MiniGestorePrenotazioni{" +
                "m=" + m +
                ", n=" + n +
                ", prenotazioniInterne=" + prenotazioniInterne +
                ", prenotazioniEsterne=" + prenotazioniEsterne +
                '}';
    }
}
