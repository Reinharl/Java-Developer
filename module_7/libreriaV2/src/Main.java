import model.Author;
import model.Library;
import model.Book;

public class Main {
    public static void main(String[] args) {
        Author a1 = new Author("Mario", "Rossi");
        Author a2 = new Author("Luigi", "Verdi");
        Author a3 = new Author("Alessia", "Neri");

        Book l1 = new Book(a1, "I dolori del giovane Programmatore", "I dolori del giovane Programmatore");
        Book l2 = new Book(a1, "Errori da non ripetere", "Errori da non ripetere");
        Book l3 = new Book(a2, "Uno, nessuno e diecimila bug", "Uno, nessuno e diecimila bug");
        Book l4 = new Book(a3, "Come programmare in Java da zero", "Come programmare in Java da zero");
        Book l5 = new Book(a3, "Mille splendidi errori", "Mille splendidi errori");
        Book l6 = new Book(a3, "Non si esce vivi dalle biblioteche", "Non si esce vivi dalle biblioteche");
        Book l7 = new Book(a3, "I dolori del vecchio Programmatore", "I dolori del vecchio Programmatore");

        Library lib = new Library();
        lib.addBook(l1);
        lib.addBook(l2);
        lib.addBook(l3);
        lib.addBook(l4);
        lib.addBook(l5);
        lib.addBook(l6);
        lib.addBook(l7);

        lib.printAuthorAscending(a3);

    }
}
