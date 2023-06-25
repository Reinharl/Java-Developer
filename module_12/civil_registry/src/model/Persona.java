package model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Persona {

    private String nome;
    private String cognome;
    private int eta;
    private String codiceFiscale;
    private String indirizzo;
    private List<Persona> figli;

    public Persona(String nome, String cognome, int eta, String codiceFiscale, String indirizzo) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.codiceFiscale = codiceFiscale;
        this.indirizzo = indirizzo;
        this.figli = new ArrayList<>();
    }

    public void addFiglio(Persona persona) {
        figli.add(persona);
    }

}
