import model.SerieA;
import model.Squadra;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Squadra roma = new Squadra("1", "as roma", null);
        Squadra lazio = new Squadra("2", "ss lazio", null);
        Squadra juve = new Squadra("3", "fc juventus", null);
        Squadra inter = new Squadra("4", "fc inter", null);

        Squadra[] squadre = new Squadra[]{roma, lazio, juve, inter};
        SerieA serieA = new SerieA(squadre);
        serieA.esistoPartita(inter, 0, lazio, 1);
        serieA.esistoPartita(inter, 1, lazio, 1);
        serieA.esistoPartita(roma, 3, lazio, 1);
        serieA.esistoPartita(roma, 3, lazio, 0);
        serieA.esistoPartita(juve, 2, lazio, 1);
        serieA.esistoPartita(juve, 3, lazio, 0);
        Squadra[] chart = serieA.getClassifica();
        System.out.println(Arrays.toString(chart));
        System.out.println(serieA.getMigliorAttacco() == roma);
        System.out.println(serieA.getPeggiorDifesa() == lazio);
    }
}
