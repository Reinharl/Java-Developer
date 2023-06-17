package model;

import java.awt.*;

public class Quadrato {
    private final double side;
    private Colore color;

    public Quadrato(double side) {
        this.side = side;
        color = Colore.NERO;
    }

    public Quadrato(double side, Colore color) {
        this.side = side;
        this.color = color;
    }

    public double perimeter() {
        return 4 * side;
    }

    public void print() {
        System.out.println(this);
    }

    public void setColor(Colore color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Quadrato{" +
                "side=" + side +
                ", color=" + color +
                '}';
    }
}
