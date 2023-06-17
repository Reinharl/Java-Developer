package model;

public class Contatore {
    private int counter = 0;

    public Contatore() {
    }

    public Contatore(int counter) {
        this.counter = counter;
    }

    public void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    public void restore() {
        counter = 0;
    }

    public void restore(int restore) {
        counter = restore;
    }

}
