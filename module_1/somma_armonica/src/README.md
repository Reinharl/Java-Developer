## Esercizio 10: Somma Armonica 🛵

Scrivere un programma che, dato un intero n in input, calcoli la somma di una serie armonica
fino a n, ossia:

$$
Harmonic(n) = 1 + \frac{1}{2} + \frac{1}{3} + \cdots + \frac{1}{n}
$$

Implementate il metodo harmonicSum del seguente codice:

```java
public class SommaArmonica {
    public static void main(String[] args) {
        System.out.println(harmonicSum(0) == (0));
        System.out.println(harmonicSum(1) == (1));
        System.out.println(harmonicSum(2) == (3. / 2));
        System.out.println(harmonicSum(20) == (55835135. / 15519504));
    }

    private static double harmonicSum(int n) {
        // Inserisci qua il tuo codice
    }
}
```
