## Esercizio 3: Inverti Stringa 🛴

Data una stringa, stampare la stessa stringa invertendone il contenuto a partire dal primo spazio,
ad esempio data la stringa «come stai» stampare a video «stai come». Potete dare per assunto
che la stringa conterrà sempre un solo spazio.

**Suggerimento**: utilizzate i metodi della classe String

Inserite il codice della vostra soluzione all’interno del metodo reverseString del
seguente codice:

```java
import java.util.Scanner;

public class InvertiStringa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string:");
        String a = sc.nextLine();
        reverseString(a);
    }

    private static void reverseString(String s) {
        // Inserisci qui il tuo codice
    }
}
