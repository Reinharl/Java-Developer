package model;

import java.util.Objects;

public class Book implements Comparable<Book> {

    private static int idTot = 0;
    private int idBook;
    private Author author;
    private String synopsis;
    private String title;

    public Book(Author author, String synopsis, String title) {
        idBook = idTot++;
        this.author = author;
        this.synopsis = synopsis;
        this.title = title;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public int compareTo(Book libro) {
        return CharSequence.compare(this.getTitle(), libro.getTitle());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book libro = (Book) o;
        return idBook == libro.idBook;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBook);
    }
}
