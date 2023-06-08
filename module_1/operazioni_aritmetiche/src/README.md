## Esercizio 1: Operatori aritmetici 🛴

Scrivere un programma Java che permetta all’utente di inserire due numeri interi e,
successivamente, stampi a video il risultato di addizione, sottrazione, moltiplicazione e divisione
tra i due numeri.

Inserite il codice della vostra soluzione all’interno del metodo computeValues del seguente codice:

```java
import java.util.Scanner;

public class OperazioniAritmetiche {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a:");
        int a = sc.nextInt();
        System.out.print("Enter b:");
        int b = sc.nextInt();
        computeValues(a, b);
    }

    private static void computeValues(int a, int b) {
        // Inserisci qui il tuo codice
    }
}