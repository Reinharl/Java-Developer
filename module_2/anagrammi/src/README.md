## Esercizio 7: Anagrammi 🛵

Due stringhe a e b sono dette anagrammi se contengono gli stessi caratteri con le stesse frequenze. Ad esempio, gli anagrammi di CAT sono CAT, ACT, TAC, TCA, ATC, e CTA.
Date due stringhe a e b in input, stampare "anagrammi" se sono anagrammi (case-intensitive), "non anagrammi" altrimenti.

Inserite il codice della vostra soluzione all'interno del metodo anagrams del seguente codice:
```java
import java.util.Scanner;
 
public class Anagrammi {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter string a:");
        String a = sc.nextLine();
        System.out.print("Enter string b:");
        String b =sc.nextLine();
        anagrams(a, b);
    }
 
    static void anagrams(String a, String b) {
        //inserite qui il vostro codice
    }
}
```