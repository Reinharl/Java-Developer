package model;

import java.util.Arrays;

public class Squadra implements Comparable<Squadra> {
    private String id;
    private String nome;
    private Giocatore[] giocatori;
    private int punteggio;
    private int golFatti;
    private int golSubiti;

    public String getId() {
        return id;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public int getGolFatti() {
        return golFatti;
    }

    public void setGolFatti(int golFatti) {
        this.golFatti = golFatti;
    }

    public int getGolSubiti() {
        return golSubiti;
    }

    public void setGolSubiti(int golSubiti) {
        this.golSubiti = golSubiti;
    }

    public Squadra(String id, String nome, Giocatore[] giocatori) {
        this.id = id;
        this.nome = nome;
        this.giocatori = giocatori;
    }

    @Override
    public int compareTo(Squadra o) {
        int comparePunteggio = Integer.compare(o.punteggio, this.punteggio);

        if (comparePunteggio == 0) {
            return Integer.compare(o.golFatti, this.golFatti);
        } else {
            return comparePunteggio;
        }
    }

    @Override
    public String toString() {
        return nome;
    }
}
