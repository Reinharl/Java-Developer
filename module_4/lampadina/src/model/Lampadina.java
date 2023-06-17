package model;

public class Lampadina {

    private static final int NUMBER_CLICK = 3;
    private Stato state;
    private int click;

    public Lampadina() {
        state = Stato.SPENTA;
        click = 0;
    }

    public Stato stato() {
        return state;
    }

    public void click() {
        if (click++ < NUMBER_CLICK) {
            state = state == Stato.ACCESA ? Stato.SPENTA : Stato.ACCESA;
        } else {
            state = Stato.ROTTA;
        }
    }


}
