package model;

import exception.MeaningAlreadyExistingException;
import exception.WordNotPresentException;

import java.util.*;

public class Dizionario {
    private Map<Character, Map<String, List<String>>> dictionary;

    public Dizionario() {
        dictionary = new TreeMap<>(Comparator.naturalOrder());
    }

    private void inserisciParola(Character lettera, String parola, List<String> significati) {
        Map<String, List<String>> wordMap = dictionary.get(lettera);

        if (wordMap.containsKey(parola)) {
            throw new WordNotPresentException("Parola già inserita.");
        } else {
            wordMap.put(parola, significati);
        }
    }

    public void inserisciParola(String parola, List<String> significati) {
        Character lettera = parola.charAt(0);

        if (!dictionary.containsKey(lettera)) {
            Map<String, List<String>> map = new TreeMap<>(Comparator.naturalOrder());
            map.put(parola, significati);
            dictionary.put(lettera, map);
        } else {
            inserisciParola(lettera, parola, significati);
        }
    }

    private void aggiungiSignificato(Character lettera, String parola, String significato) {
        Map<String, List<String>> wordMap = dictionary.get(lettera);

        if (wordMap.containsKey(parola)) {
            List<String> list = new ArrayList<>(wordMap.get(parola));
            if (list.contains(significato)) {
                throw new MeaningAlreadyExistingException("Significato già presente.");
            } else {
                list.add(significato);
                wordMap.put(parola, list);
            }
        } else {
            throw new WordNotPresentException("Parola non inserita.");
        }
    }

    public void aggiungiSignificato(String parola, String significato) {
        Character lettera = parola.charAt(0);

        if (!dictionary.containsKey(lettera)) {
            throw new WordNotPresentException("Parola non inserita");
        }
        aggiungiSignificato(lettera, parola, significato);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char lettera : dictionary.keySet()) {
            sb.append(lettera).append(": [");
            Map<String, List<String>> parole = dictionary.get(lettera);
            for (String parola : parole.keySet()) {
                sb.append(parola).append(": (");
                List<String> significati = parole.get(parola);
                for (int i = 0; i < significati.size(); i++) {
                    sb.append(significati.get(i));
                    if (i < significati.size() - 1) {
                        sb.append(";");
                    }
                }
                sb.append("), ");
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append("]\n");
        }
        return sb.toString();
    }
}
