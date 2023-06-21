package model;

import java.util.Arrays;

public class ListaDiTecnici {
    private Tecnico[] array;

    public ListaDiTecnici() {
        array = new Tecnico[0];
    }

    public Tecnico get(int i) {
        return array[i];
    }

    public int indexOf(String name) {
        for (int j = 0; j < array.length; j++) {
            if (array[j].getName().equals(name)) {
                return j;
            }
        }

        return -1;
    }


    public boolean contains(String name) {
        for (Tecnico value : array) {
            if (value.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    public void add(Tecnico i) {
        Tecnico[] arrayHold = new Tecnico[array.length + 1];

        for (int j = 0; j < array.length; j++) {
            arrayHold[j] = array[j];
        }

        arrayHold[array.length] = i;

        array = arrayHold;

    }

    @Override
    public String toString() {
        return "ListaDiTecnici{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
