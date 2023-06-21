package model;

public abstract class IterabileAbstract<E> implements Iterabile<E> {
    protected int index;

    @Override
    public void reset() {
        this.index = 0;
    }
}
