package model;

import java.util.*;

public class Library {
    private List<Book> book;

    public Library() {
        book = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (book != null) {
            this.book.add(book);
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

    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();

        for (Book b : book) {
            if(b.getTitle().equals(title)) {
                result.add(b);
            }
        }

        return result;
    }

    public List<Book> searchByAuthor(Author author) {
        return searchByAuthorId(author.getIdAuthor());
    }

    public List<Book> searchByAuthorId(int idAuthor) {
        List<Book> result = new ArrayList<>();

        for (Book b : book) {
            if(b.getAuthor().getIdAuthor() == idAuthor) {
                result.add(b);
            }
        }

        return result;
    }

    public void printAuthorAscending(Author author) {
        printAuthorAscending(author.getIdAuthor());
    }

    public void printAuthorAscending(int idAuthor) {
        List<Book> libri = searchByAuthorId(idAuthor);

        Collections.sort(libri);

        for (Book libro : libri) {
            System.out.print(libro.getTitle() + " : " + libro.getSynopsis() + "\n");
        }
    }
}
