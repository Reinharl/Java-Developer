import model.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Libro[] books = new Libro[]{
                new Libro(123, "Luciana Litizzetto", "I dolori del giovane Programmatore"),
                new Libro(4, "Super Mario", "Errori da non ripetere"),
                new Libro(98, "Luigi Pirandino", "Uno, nessuno e diecimila bug"),
                new Libro(33, "Roberto Roberti", "Come programmare in Java da zero"),
                new Libro(76, "Piero Java", "Mille splendidi errori"),
                new Libro(2, "Lavinia Pitoni", "Non si esce vivi dalle biblioteche"),
                new Libro(235, "Luciana Litizzetto Jr.", "I dolori del vecchio Programmatore")
        };

        Biblioteca library = new Biblioteca(books);
        System.out.println(library.esisteLibro(76));

        Libro[] booksInLibrary = library.getLibriOrdinati();
        System.out.println(booksInLibrary[0].getIndex() == 2);
        System.out.println(booksInLibrary[1].getIndex() == 4);
        System.out.println(booksInLibrary[2].getIndex() == 33);
        System.out.println(booksInLibrary[3].getIndex() == 76);
        System.out.println(booksInLibrary[4].getIndex() == 98);
        System.out.println(booksInLibrary[5].getIndex() == 123);
        System.out.println(booksInLibrary[6].getIndex() == 235);
    }

    public static class Main {

        public static void main(String[] args) {
            Giocatore g1 = new Giocatore("01", "Mario", "Rossi");
            Giocatore g2 = new Giocatore("02", "Luigi", "Bianchi");
            Giocatore g3 = new Giocatore("03", "Alessio", "Neri");
            Giocatore g4 = new Giocatore("04", "Alberto", "Verdi");
            Giocatore g5 = new Giocatore("05", "Valeria", "Gialli");
            Giocatore g6 = new Giocatore("06", "Sabrina", "Rossi");
            Giocatore g7 = new Giocatore("07", "Alessandra", "Bianchi");
            Giocatore g8 = new Giocatore("08", "Rossana", "Neri");
            Giocatore g9 = new Giocatore("09", "Rosa", "Verdi");
            Giocatore g10 = new Giocatore("10", "Roberta", "Gialli");

            Squadra s1 = new Squadra("01", "Milano", new Giocatore[]{g1,g2});
            Squadra s2 = new Squadra("02", "Roma", new Giocatore[]{g3,g4});
            Squadra s3 = new Squadra("03", "Bari", new Giocatore[]{g5,g6});
            Squadra s4 = new Squadra("04", "Catania", new Giocatore[]{g7,g8});
            Squadra s5 = new Squadra("05", "Palermo", new Giocatore[]{g9,g10});

            Classifica c1 = new Classifica(new Squadra[]{s1,s2,s3,s4,s5});

            c1.esistoPartita(s1, 3, s2, 0);
            c1.esistoPartita(s2, 3, s3, 3);
            c1.esistoPartita(s3, 3, s4, 2);
            c1.esistoPartita(s4, 1, s5, 0);
            c1.esistoPartita(s5, 1, s1, 2);

            System.out.println(Arrays.toString(c1.getClassifica()));
            System.out.println(c1.getMigliorAttacco());
            System.out.println(c1.getPeggiorDifesa());
        }




    }
}
