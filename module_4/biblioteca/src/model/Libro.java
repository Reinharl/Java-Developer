package model;

public class Libro implements Comparable<Libro> {
    private int index;
    private String author;
    private String title;

    public Libro(int id, String author, String title) {
        this.index = id;
        this.author = author;
        this.title = title;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + index +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public int compareTo(Libro libro) {
        return Integer.compare(this.getIndex(), libro.getIndex());
    }

}
