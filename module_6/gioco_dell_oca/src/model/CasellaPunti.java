package model;

public class CasellaPunti extends Casella {
    private int punti;

    public CasellaPunti(int punti) {
        super();
        this.punti = punti;
    }

    public int getPunti() {
        return punti;
    }

    @Override
    public String toString() {
        return "punti = " + punti;
    }
}
