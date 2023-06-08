## Esercizio 6: Conta Occorrenze in Stringa 🛴

Scrivere un metodo che, dato un char a e una stringa b, stampa il numero di occorrenze di a in b.

**Suggerimento**: usate i cicli for

Inserire il codice della vostra soluzione all'interno del metodo countOccurrences del seguente codice:

```java
import java.util.Scanner;

public class ContaOccorrenze {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter character a:");
        String a = sc.nextLine();
        System.out.print("Enter string b:");
        String b = sc.nextLine();
        countOccurrences(a.charAt(0), b);
    }

    static void countOccurrences(char a, String b) {
        // Inserisci qui il tuo codice
    }
}
```
