package model;

import java.util.Arrays;

public class ListaPrenotazioni {
    private Prenotazione[] prenotazioni;

    public ListaPrenotazioni() {
        prenotazioni = new Prenotazione[0];
    }

    public Prenotazione get(int i) {
        return prenotazioni[i];
    }

    /*
    public int indexOf(String nome) {
        for (int j = 0; j < prenotazioni.length; j++) {
            if (prenotazioni[j].getNome().equals(nome)) {
                return j;
            }
        }

        return -1;
    }
     */

    public int length() {
        return prenotazioni.length;
    }

    public void add(Prenotazione i) {
        Prenotazione[] arrayHold = new Prenotazione[prenotazioni.length + 1];

        for (int j = 0; j < prenotazioni.length; j++) {
            arrayHold[j] = prenotazioni[j];
        }

        arrayHold[prenotazioni.length] = i;

        prenotazioni = arrayHold;

    }

    public void remove(int i) {
        if (i >= 0 && i < prenotazioni.length) {
            Prenotazione[] arrayHold = new Prenotazione[prenotazioni.length - 1];

            for (int j = 0; j < i; j++) {
                arrayHold[j] = prenotazioni[j];
            }

            for (int j = i + 1; j < prenotazioni.length; j++) {
                arrayHold[j - 1] = prenotazioni[j];
            }

            prenotazioni = arrayHold;
        }

    }

    public void remove(Prenotazione i) {
        for (int j = 0; j < prenotazioni.length; j++) {
            if (prenotazioni[j] == i) {
                this.remove(j);
                return;
            }
        }
    }

    public Prenotazione[] toArray() {
        return prenotazioni;
    }

    @Override
    public String toString() {
        return "ListaPrenotazioni{" +
                "prenotazioni=" + Arrays.toString(prenotazioni) +
                '}';
    }
}
