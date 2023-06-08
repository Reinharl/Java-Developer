## Esercizio 9: Fattoriale 🛵

Scrivere un programma che, dato un intero n in input, ne calcoli il fattoriale, ossia:

$$
n! = \begin{cases} 1 && \text{se $n = 0$} \\ n \cdot (n-1) \cdot \ldots \cdot 2 \cdot 1 && \text{se $n\neq0$}\end{cases}
$$

Implementate il metodo factorial del seguente codice

```java
public class Fattoriale {
    public static void main(String[] args) {
        System.out.println(factorial(0) == (1));
        System.out.println(factorial(2) == (2));
        System.out.println(factorial(5) == (120));
        System.out.println(factorial(10) == (3628800));
        System.out.println(factorial(20) == 2432902008176640000L);
    }

    private static long factorial(int n) {
        // Inserisci qua il codice
    }
}
```
