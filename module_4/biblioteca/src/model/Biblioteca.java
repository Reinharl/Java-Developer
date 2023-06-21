package model;

import java.util.Arrays;

public class Biblioteca {
    private Libro[] libri;

    public Biblioteca() {

    }

    public Biblioteca(Libro[] libri) {
        this.libri = libri;
    }

    public boolean esisteLibro(int index) {

        for (Libro libro : libri) {
            if (libro.getIndex() == index) {
                return true;
            }
        }

        return false;
    }

    public Libro[] getLibriOrdinati() {
        Libro[] libriOrdinati = libri;

        Arrays.sort(libriOrdinati);

        // Arrays.sort(libriOrdinati, Comparator.comparing(Libro::getIndex));

        /*
        for (int i = 1; i < libriOrdinati.length; i++) {
            Libro key = libriOrdinati[i];
            int j = i - 1;
            while (j >= 0 && libriOrdinati[j].getIndex() > key.getIndex()) {
                libriOrdinati[j + 1] = libriOrdinati[j];
                j--;
            }
            libriOrdinati[j + 1] = key;
        }
         */

        return libriOrdinati;

    }
}
