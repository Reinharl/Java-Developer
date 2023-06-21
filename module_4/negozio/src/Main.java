import model.*;

public class Main {

    public static void main(String[] args) {
        Prodotto p1 = new Prodotto("Mela", 1.99, TipoProdotto.ALIMENTARE);
        Prodotto p2 = new Prodotto("Pasta", 0.99, TipoProdotto.ALIMENTARE);
        Prodotto p3 = new Prodotto("Biscotti", 2.49, TipoProdotto.ALIMENTARE);
        Prodotto p4 = new Prodotto("Detersivo", 3.79, TipoProdotto.NON_ALIMENTARE);
        Prodotto p5 = new Prodotto("Pane", 2.99, TipoProdotto.ALIMENTARE);
        Prodotto p6 = new Prodotto("Shampoo", 4.99, TipoProdotto.NON_ALIMENTARE);
        Prodotto p7 = new Prodotto("Yogurt", 1.49, TipoProdotto.ALIMENTARE);
        Prodotto p8 = new Prodotto("Sapone", 1.29, TipoProdotto.NON_ALIMENTARE);
        Prodotto p9 = new Prodotto("Spazzolino da denti", 2.79, TipoProdotto.NON_ALIMENTARE);

        Negozio n = new Negozio();
        System.out.println(n.aggiungiProdotto(p1, 1));
        System.out.println(n.aggiungiProdotto(p2, 2));
        System.out.println(n.aggiungiProdotto(p3, 3));
        System.out.println(n.aggiungiProdotto(p4, 5));
        System.out.println(n.aggiungiProdotto(p5, 8));
        System.out.println(n.aggiungiProdotto(p6, 13));
        System.out.println(n.aggiungiProdotto(p7, 21));
        System.out.println(n.aggiungiProdotto(p8, 34));
        System.out.println(n.aggiungiProdotto(p9, 55));




    }
}
