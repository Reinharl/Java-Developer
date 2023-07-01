import model.Dizionario;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dizionario d = new Dizionario();
        d.inserisciParola("caldo", List.of("alta temperatura", "pieno di passione"));

        try {
            d.inserisciParola("caldo", List.of("senza riflettere"));
        } catch (Exception e) {
            System.out.println(true);
        }

        d.inserisciParola("calcio", List.of("impugnatura della pistola"));
        d.aggiungiSignificato("calcio", "sport");
        d.aggiungiSignificato("calcio", "elemento chimico");

        try {
            d.aggiungiSignificato("calcio", "sport");
        } catch (Exception e) {
            System.out.println(true);
        }

        System.out.println(d);
    }
}
