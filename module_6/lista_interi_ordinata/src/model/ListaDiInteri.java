package model;

import java.util.Arrays;

public class ListaDiInteri {
    private int[] array;

    public ListaDiInteri() {
        array = new int[0];
    }

    public int get(int i) {
        return array[i];
    }

    public int indexOf(int i) {
        for (int j = 0; j < array.length; j++) {
            if (array[j] == i) {
                return j;
            }
        }

        return -1;
    }

    public int length() {
        return array.length;
    }

    public boolean contains(int i) {
        for (int value : array) {
            if (value == i) {
                return true;
            }
        }

        return false;
    }

    public void add(int i) {
        int[] arrayHold = new int[array.length + 1];

        for (int j = 0; j < array.length; j++) {
            arrayHold[j] = array[j];
        }

        arrayHold[array.length] = i;

        array = arrayHold;

    }

    public void add(int i, int pos) {
        if (pos >= 0 && pos < array.length) {
            int[] arrayHold = new int[array.length + 1];

            for (int j = 0; j < pos; j++) {
                arrayHold[j] = array[j];
            }

            arrayHold[pos] = i;

            for (int j = pos + 1; j < array.length + 1; j++) {
                arrayHold[j] = array[j - 1];
            }

            array = arrayHold;
        }
    }

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

    public void removeFirst(int i) {
        for (int j = 0; j < array.length; j++) {
            if (array[j] == i) {
                this.remove(j);
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "ListaDiInteri{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
