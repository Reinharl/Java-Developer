package model;

import java.util.Objects;

public class Author {
    private static int idTot = 0;
    private int idAuthor;
    private String name;
    private String surname;

    public Author(String name, String surname) {
        idAuthor = idTot++;
        this.name = name;
        this.surname = surname;
    }

    public static int getIdTot() {
        return idTot;
    }

    public static void setIdTot(int idTot) {
        Author.idTot = idTot;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return idAuthor == author.idAuthor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAuthor);
    }
}
