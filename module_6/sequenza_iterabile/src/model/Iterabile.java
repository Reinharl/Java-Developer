package model;

public interface Iterabile<E> {

    E next();
    boolean hasNext();
    void reset();
}
