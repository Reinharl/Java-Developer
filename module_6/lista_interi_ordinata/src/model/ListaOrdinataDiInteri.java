package model;

public class ListaOrdinataDiInteri {
    private ListaDiInteri listaDiInteri;

    public ListaOrdinataDiInteri() {
        listaDiInteri = new ListaDiInteri();
    }

    public int get(int i) {
        return listaDiInteri.get(i);
    }

    public void add(int k) {
        for (int i = 0; i < listaDiInteri.length(); i++) {
            if (listaDiInteri.get(i) > k) {
                listaDiInteri.add(k, i);
                return;
            }
        }

        listaDiInteri.add(k);
    }

    public boolean add(int k, int j) {
        if (j == 0 && listaDiInteri.get(j) >= k) {
            listaDiInteri.add(k, j);
            return true;
        } else if (j == listaDiInteri.length() - 1 && listaDiInteri.get(j) <= k) {
            listaDiInteri.add(k);
            return true;
        } else if (listaDiInteri.get(j - 1) <= k && listaDiInteri.get(j) >= k) {
            listaDiInteri.add(k, j);
            return true;
        }

        return false;
    }

    public boolean addLast(int k) {
        if (listaDiInteri.get(listaDiInteri.length() - 1) <= k) {
            listaDiInteri.add(k);
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "ListaOrdinataDiInteri{" +
                "listaDiInteri=" + listaDiInteri +
                '}';
    }
}
