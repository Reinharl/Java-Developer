package model;

import java.util.Objects;

public class Prenotazione {
    private final String codice;
    private int nPosti;

    public Prenotazione(String codice, int nPosti) {
        this.codice = codice;
        this.nPosti = nPosti;
    }

    public String getCodice() {
        return codice;
    }

    public int getnPosti() {
        return nPosti;
    }

    public void setnPosti(int nPosti) {
        this.nPosti = nPosti;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "codice='" + codice + '\'' +
                ", nPosti=" + nPosti +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prenotazione that = (Prenotazione) o;
        return Objects.equals(codice, that.codice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codice);
    }
}
