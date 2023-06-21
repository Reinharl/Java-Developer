package model;

public class ListaBevande {
    private Bevanda[] bevande;

    public ListaBevande() {
        bevande = new Bevanda[0];
    }

    public Bevanda get(int i) {
        return bevande[i];
    }

    public int indexOf(String nome) {
        for (int j = 0; j < bevande.length; j++) {
            if (bevande[j].getNome().equals(nome)) {
                return j;
            }
        }

        return -1;
    }

    public int length() {
        return bevande.length;
    }

    public void add(Bevanda i) {
        Bevanda[] arrayHold = new Bevanda[bevande.length + 1];

        for (int j = 0; j < bevande.length; j++) {
            arrayHold[j] = bevande[j];
        }

        arrayHold[bevande.length] = i;

        bevande = arrayHold;

    }

    public void remove(int i) {
        if (i >= 0 && i < bevande.length) {
            Bevanda[] arrayHold = new Bevanda[bevande.length - 1];

            for (int j = 0; j < i; j++) {
                arrayHold[j] = bevande[j];
            }

            for (int j = i + 1; j < bevande.length; j++) {
                arrayHold[j - 1] = bevande[j];
            }

            bevande = arrayHold;
        }

    }

    public void remove(Bevanda i) {
        for (int j = 0; j < bevande.length; j++) {
            if (bevande[j] == i) {
                this.remove(j);
                return;
            }
        }
    }

}
