## Esercizio 8: Minimo e Massimo 🛵

Dato un array di interi (inseriti dall'utente, separati da virgola e senza spazi), effettuare la conversione dei valori in interi e stampare in ordine minimo e massimo (separati da virgola).

Gli interi inseriti possono anche assumere valori negativi. Per il parsing da String a int, potete usare il metodo parseInt() della classe Integer (e l'autoboxing).

Implementare i metodi parseNumbers e computeMinAndMax del seguente codice:

```java
public class MinimoMassimo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter numbers (comma-separated):");
        String a = sc.nextLine();
        int[] values = parseNumbers(a);
        computeMinAndMax(values);
    }
 
    static int[] parseNumbers(String s) {
        //inserite qui il vostro codice
    }
 
    static void computeMinAndMax(int[] values) {
        //inserite qui il vostro codice
    }
}
```
