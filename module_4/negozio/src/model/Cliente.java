package model;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Cliente {
    private String nome;
    private int eta;
    private int puntiRegalo;
    private Carello carello;

    public Cliente(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
        puntiRegalo = 0;
        carello = new Carello();
    }

    public String getNome() {
        return nome;
    }

    public int getEta() {
        return eta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public Carello getCarello() {
        return carello;
    }

    public void setCarello(Carello carello) {
        this.carello = carello;
    }

    public int getPuntiRegalo() {
        return puntiRegalo;
    }

    public void setPuntiRegalo(int puntiRegalo) {
        this.puntiRegalo = puntiRegalo;
    }

    public void aggiungiAlCarello(Prodotto prodotto, int quantita) {
        carello.aggiungiAlCarello(prodotto, quantita);

        double importo = calcolaImporto(prodotto, quantita);
        carello.addImporto(importo);
    }

    public void rimuoviDalCarello(Prodotto prodotto, int quantita) {
        carello.rimuoviDalCarello(prodotto, quantita);

        double importo = calcolaImporto(prodotto, quantita);
        carello.addImporto(-importo);
    }

    public double calcolaImporto(Prodotto prodotto, int quantita) {
        double importo = prodotto.getPrezzo() * quantita;

        LocalDate oggi = LocalDate.now();
        DayOfWeek giornoSettimana = oggi.getDayOfWeek();

        if (prodotto.getTipoProdotto() == TipoProdotto.ALIMENTARE && eta > 60 && (giornoSettimana == DayOfWeek.MONDAY || giornoSettimana == DayOfWeek.WEDNESDAY)) {
            importo -= 0.20 * importo;
        }

        return importo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "name='" + nome + '\'' +
                ", age=" + eta +
                ", giftPoints=" + puntiRegalo +
                '}';
    }
}
