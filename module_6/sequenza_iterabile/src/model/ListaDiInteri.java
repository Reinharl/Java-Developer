package model;

public class ListaDiInteri extends IterabileAbstract<Integer> implements Sequenza<Integer> {
    private int[] array;

    public ListaDiInteri() {
        array = new int[0];
    }

    public ListaDiInteri(int[] array) {
        this.array = array;
    }

    @Override
    public int get(int i) {
        return array[i];
    }

    @Override
    public boolean contains(Integer i) {
        for (int value : array) {
            if (value == i) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public void add(Integer i) {
        int[] arrayHold = new int[array.length + 1];

        for (int j = 0; j < array.length; j++) {
            arrayHold[j] = array[j];
        }

        arrayHold[array.length] = i;

        array = arrayHold;
    }

    @Override
    public void remove(int i) {
        if (i >= 0 && i < array.length) {
            int[] arrayHold = new int[array.length - 1];

            for (int j = 0; j < i; j++) {
                arrayHold[j] = array[j];
            }

            for (int j = i + 1; j < array.length; j++) {
                arrayHold[j - 1] = array[j];
            }

            array = arrayHold;
        }

    }

    @Override
    public void clear() {
        array = new int[0];
    }

    @Override
    public Integer next() {
        if (index < array.length) {
            return array[index++];
        } else {
            return -1;
        }
    }

    @Override
    public boolean hasNext() {
        return index < array.length;
    }
}
