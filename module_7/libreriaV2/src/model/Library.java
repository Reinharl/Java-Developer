package model;

import java.util.*;

public class Library {
    private HashMap<Integer, Book> book;

    public Library() {
        book = new HashMap<>();
    }

    public void addBook(Book book) {
        if (book != null) {
            this.book.put(book.getIdBook(), book);
        }
    }

    public void removeBook(Book libro) {
        removeBook(libro.getIdBook());
    }

    public void removeBook(int idBook) {
        book.remove(idBook);
    }

    public Book searchById(int idBook) {
        return book.get(idBook);
    }

    public ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> result = new ArrayList<>();

        for (Integer entry : book.keySet()) {
            Book libro = book.get(entry);

            if (libro.getTitle().equals(title)) {
                result.add(libro);
            }
        }

        return result;
    }

    public ArrayList<Book> searchByAuthor(Author author) {
        return searchByAuthor(author.getIdAuthor());
    }

    public ArrayList<Book> searchByAuthor(int idAuthor) {
        ArrayList<Book> result = new ArrayList<>();

        for (Integer entry : book.keySet()) {
            Book libro = book.get(entry);

            if (libro.getAuthor().getIdAuthor() == idAuthor) {
                result.add(libro);
            }
        }

        return result;
    }

    public void printAuthorAscending(Author author) {
        printAuthorAscending(author.getIdAuthor());
    }

    public void printAuthorAscending(int idAuthor) {
        ArrayList<Book> libri = searchByAuthor(idAuthor);

        Collections.sort(libri);

        for (Book libro : libri) {
            System.out.print(libro.getTitle() + " : " + libro.getSynopsis() + "\n");
        }
    }
}
