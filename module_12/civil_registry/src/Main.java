import model.CivilRegistry;
import model.Persona;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CivilRegistry registry = new CivilRegistry();

        // Inserisci persone nel sistema
        Persona persona1 = new Persona("Mario", "Rossi", 30, "ABC123", "Via Roma 1");
        Persona persona2 = new Persona("Luca", "Bianchi", 40, "DEF456", "Via Verdi 2");
        Persona persona3 = new Persona("Mario", "Verdi", 35, "GHI789", "Via Italia 3");

        registry.inserisciPersona(persona1);
        registry.inserisciPersona(persona2);
        registry.inserisciPersona(persona3);

        // Rimuovi persona dal codice fiscale
        registry.rimuoviPersona("DEF456");

        // Cerca persone per nome
        List<Persona> personePerNome = registry.cercaPerNome("Mario");
        System.out.println("Persone con nome 'Mario': " + personePerNome);

        // Ottieni le 3 persone più anziane
        List<Persona> personePiuAnziane = registry.piuAnziane();
        System.out.println("Le 3 persone più anziane: " + personePiuAnziane);

        // Ottieni indirizzi per nome
        List<String> indirizziPerNome = registry.indirizziPerNome("Mario");
        System.out.println("Indirizzi delle persone di nome 'Mario': " + indirizziPerNome);

        // Aggiungi figli a una persona
        Persona figlio1 = new Persona("Giuseppe", "Rossi", 5, "XYZ789", "Via Roma 1");
        Persona figlio2 = new Persona("Anna", "Rossi", 10, "LMN456", "Via Roma 1");

        persona1.addFiglio(figlio1);
        persona1.addFiglio(figlio2);

        // Ottieni figli per nome del genitore
        List<Persona> figliPerNome = registry.getChildren("Mario");
        System.out.println("Figli delle persone di nome 'Mario': " + figliPerNome);
    }
}

