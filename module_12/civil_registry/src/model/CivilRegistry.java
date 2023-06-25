package model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class CivilRegistry {
    private List<Persona> civilRegistry;

    public CivilRegistry() {
        civilRegistry = new ArrayList<>();
    }

    public void inserisciPersona(Persona persona) {
        civilRegistry.add(persona);
    }

    public void rimuoviPersona(String codiceFiscale) {
        civilRegistry = civilRegistry.stream()
                .filter(x -> !x.getCodiceFiscale().equals(codiceFiscale))
                .toList();
    }

    public List<Persona> cercaPerNome(String nome) {
        return civilRegistry.stream()
                .filter(x -> x.getNome().equals(nome))
                .toList();
    }

    public List<Persona> piuAnziane() {
        return civilRegistry.stream()
                .sorted(Comparator.comparing(Persona::getEta).reversed())
                .limit(3)
                .toList();
    }

    public List<String> indirizziPerNome(String nome) {
        return civilRegistry.stream()
                .filter(x -> x.getNome().equals(nome))
                .map(Persona::getIndirizzo)
                .toList();
    }

    public List<Persona> getChildren(String name) {
        return civilRegistry.stream()
                .filter(x -> x.getNome().equals(name))
                .flatMap(x -> x.getFigli().stream())
                .toList();
    }

}
