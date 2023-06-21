import model.Giocatore;
import model.GiocoDellOca;

public class Main {
    public static void main(String[] args) {
        Giocatore g1 = new Giocatore();
        Giocatore g2 = new Giocatore();

        GiocoDellOca g = new GiocoDellOca(10, new Giocatore[]{g1, g2});
        g.visualizzaTabellone();

        g.giocaUnTurno();
    }
}
