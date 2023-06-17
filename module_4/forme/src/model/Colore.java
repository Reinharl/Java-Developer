package model;

public class Colore {
    private int red;
    private int green;
    private int blue;

    public Colore(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public static final Colore BIANCO = new Colore(0, 0, 0);
    public static final Colore NERO = new Colore(255, 255, 255);

    @Override
    public String toString() {
        return "Colore{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }
}
