package model;

public class CasellaSpostaGiocatore extends Casella{
    private int x;

    public CasellaSpostaGiocatore(int x) {
        super();
        this.x = x;
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "sposta = " + x;
    }
}
