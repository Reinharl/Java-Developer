package model;

public class Cerchio {
    private final double radius;
    private Colore color;

    public Cerchio(double radius) {
        this.radius = radius;
        color = Colore.NERO;
    }

    public Cerchio(double radius, Colore color) {
        this.radius = radius;
        this.color = color;
    }

    public double circumference() {
        return 2 * Math.PI * radius;
    }

    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
}
