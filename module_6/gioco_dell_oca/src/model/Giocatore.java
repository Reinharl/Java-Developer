package model;

import java.util.Objects;

public class Giocatore {
    private static int idTot = 1;
    private int idGiocatore;
    private int posizione;
    private int punteggio;

    public Giocatore() {
        idGiocatore = idTot++;
        posizione = 0;
        punteggio = 0;
    }

    public int getIdGiocatore() {
        return idGiocatore;
    }

    public void setIdGiocatore(int idGiocatore) {
        this.idGiocatore = idGiocatore;
    }

    public int getPosizione() {
        return posizione;
    }

    public void setPosizione(int posizione) {
        this.posizione = posizione;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public int tiraDadi() {
        return (int) (Math.random()*11 + 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Giocatore giocatore = (Giocatore) o;
        return idGiocatore == giocatore.idGiocatore;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGiocatore);
    }
}
