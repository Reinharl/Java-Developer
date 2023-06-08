## Esercizio 8: Numero Primo 🛵

Scrivere un metodo che, dato in input un intero a, ritorni true se il numero è primo, false
altrimenti.

**Suggerimento**: un numero si dice «primo» se è divisibile solo per sé stesso e per 1

Inserite il codice della vostra soluzione all’interno del metodo isPrime del seguente codice:

```java
public class NumeroPrimo {
    public static void main(String[] args) {
        int number = 0;
        System.out.println(!isPrime(number));
        number = 1;
        System.out.println(!isPrime(number));
        number = 2;
        System.out.println(isPrime(number));
        number = 17;
        System.out.println(isPrime(number));
        number = 631;
        System.out.println(isPrime(number));
        number = 634;
        System.out.println(!isPrime(number));
        number = 999;
        System.out.println(!isPrime(number));
        number = 997;
        System.out.println(isPrime(number));
    }

    private static boolean isPrime(int number) {
        // Inserisci qua il tuo codice
    }
}
```
