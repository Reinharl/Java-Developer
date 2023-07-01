import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("9", "A", "Z", "1", "B", "Y", "4", "a", "c");
        List<Double> number = List.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0);

        // Ordinare una lista di stringhe senza modificarla
        List<String> sortedList = list.stream()
                .sorted()
                .toList();

        // Convertire un maiusolo le stringhe in una lista
        list = list.stream()
                .map(String::toUpperCase)
                .toList();

        // Metodo che aggiunge l'IVA ad ogni prezzo e li stampi

        number.stream()
                .map(p -> p * 1.22)
                .forEach(System.out::println);

        // Stampa i numeri dispari da 1 a 10
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        integers.stream()
                .filter(n -> n % 2 != 0)
                .forEach(System.out::println);

        /*
         Metodo per ottenere una stringa che rappresenta la concatenzaione
         contenute in una lista, rese maiuscole e separate da virgola
         */
        String s = list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));

        /*
        Metodo per ottenere, a partire da una lista di numeri, una mappa
        dove ogni numero dispari è associata la sua rappresentazione in stringa
         */

        Map<Integer, String> map = integers.stream()
                .filter(x -> x % 2 != 0)
                .collect(Collectors.toMap(Function.identity(), String::valueOf));

        /*
        Metodo per ottenere, a partire da una lista di stringhe una mappa
        con chiava la stringa e valore il numero di occorenze nella lista
         */
        Map<String, Long> map2 = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        /*
        Metodo per ottenere, a partire da una lista di stringhe, restituisca
        una occorrenze delle stringhe che iniziano con tale lettera.
         */

        Map<String, Long> map3 = list.stream()
                .collect(Collectors.groupingBy(x -> x.charAt(0) + "", Collectors.counting()));

        // Restituire la somma di una lista di interi
        Integer sum = integers.stream()
                .mapToInt(x -> x)
                .sum();


    }
}
