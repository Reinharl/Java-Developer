package model;

import java.util.Arrays;

public class ListaDiRiparazioni {
    private Riparazione[] array;

    public ListaDiRiparazioni() {
        array = new Riparazione[0];
    }

    public Riparazione get(int i) {
        return array[i];
    }

    public int indexOf(String address) {
        for (int j = 0; j < array.length; j++) {
            if (array[j].getAddress().equals(address)) {
                return j;
            }
        }

        return -1;
    }

    public int length() {
        return array.length;
    }

    public boolean contains(String address) {
        for (Riparazione value : array) {
            if (value.getAddress().equals(address)) {
                return true;
            }
        }

        return false;
    }

    public void add(Riparazione i) {
        Riparazione[] arrayHold = new Riparazione[array.length + 1];

        for (int j = 0; j < array.length; j++) {
            arrayHold[j] = array[j];
        }

        arrayHold[array.length] = i;

        array = arrayHold;

    }

    @Override
    public String toString() {
        return "ListaDiRiparazioni{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
