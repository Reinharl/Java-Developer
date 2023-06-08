## Esercizio 4: Rimpiazza gli Intrusi 🛴

Date tre stringhe a, b e c in input, stampare c dopo aver rimpiazzato, all’interno di c, ogni
occorrenza compresa tra due spazi di a con b. Ad esempio, date in input le stringhe «a», «b», «a
abc d», stampare a video «a bbc d». Potete dare per assunto che la stringa c conterrà sempre e
solo due spazi.

**Suggerimento**: utilizzate i metodi della classe String

```java
import java.util.Scanner;

public class RimpiazzaIntrusi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string:");
        String a = sc.nextLine();
        System.out.print("Enter string:");
        String b = sc.nextLine();
        System.out.print("Enter string:");
        String c ø= sc.nextLine();
        replaceIntruder(a, b, c);
    }

    private static void replaceIntruder(String a, String b , String c) {
        // Inserisci qui il tuo codice
    }

}
```
