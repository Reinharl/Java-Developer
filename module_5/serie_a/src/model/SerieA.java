package model;

import java.util.Arrays;

public class SerieA {

    private Squadra[] squadre;

    public SerieA(Squadra[] squadre) {
        this.squadre = squadre;
    }

    private void vittoria(Squadra squadraV) {
        for (Squadra squadra : squadre) {
            if (squadra.getId().equals(squadraV.getId())) {
                squadra.setPunteggio(squadra.getPunteggio() + 3);
            }
        }
    }

    private void pareggio(Squadra squadraV, Squadra squadraP) {
        for (Squadra squadra : squadre) {
            if (squadra.getId().equals(squadraV.getId()) || squadra.getId().equals(squadraP.getId())) {
                squadra.setPunteggio(squadra.getPunteggio() + 1);
            }
        }
    }

    private void assegnaGol(Squadra squadra, int golFatti, int golSubiti) {
        for (Squadra squadra1 : squadre) {
            if (squadra1.getId().equals(squadra.getId())) {
                squadra1.setGolFatti(squadra1.getGolFatti() + golFatti);
                squadra1.setGolSubiti(squadra1.getGolSubiti() + golSubiti);
            }
        }
    }

    public void esistoPartita(Squadra squadraCasa, int golCasa, Squadra squadraOspite, int golOspite) {
        if (golCasa > golOspite) {
            vittoria(squadraCasa);
        } else if (golCasa < golOspite) {
            vittoria(squadraOspite);
        } else {
            pareggio(squadraCasa, squadraOspite);
        }

        assegnaGol(squadraCasa, golCasa, golOspite);
        assegnaGol(squadraOspite, golOspite, golCasa);
    }

    public Squadra[] getClassifica() {
        Squadra[] classifica = squadre;

        Arrays.sort(classifica);
        return classifica;
    }

    public Squadra getMigliorAttacco() {
        int max = 0;
        for (int i = 1; i < squadre.length; i++) {
            if (squadre[i].getGolFatti() > squadre[max].getGolFatti()) {
                max = i;
            }
        }

        return squadre[max];
    }

    public Squadra getPeggiorDifesa() {
        int max = 0;
        for (int i = 1; i < squadre.length; i++) {
            if (squadre[i].getGolSubiti() > squadre[max].getGolSubiti()) {
                max = i;
            }
        }

        return squadre[max];
    }
}
