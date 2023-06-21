package model;

public interface Sequenza<E> {
    int get(int i);
    boolean contains(E e);
    int size();
    void add(E e);
    void remove(int i);
    void clear();


}
