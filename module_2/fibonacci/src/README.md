## Esercizio 6: Fibonacci 🛵

Scrivere un metodo che stampa l'ennesimo elemento della sequenza di Fibonacci, nella quale ogni numero è definito dalla somma dei due precedenti, eccetto i primi due che sono per definizione 0 e 1. 

Esempio: 0,1,1,2,3,5,8,13,21,34,... E così via. Assumete di iniziare da 0, dunque fibonacci(0) = 0, fibonacci (1) = 1, ... e così via.

Inserite il codice dalla vostra soluzione all'interno del seguente codice:

```java
 
import java.util.Scanner;
 
public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter index:");
        int index =sc.nextInt();
        fibonacci(index);
    }
 
    static void fibonacci(int index) {
        //inserite il vostro codice qui
    }
}
```

Test: fibonacci(45) deve stampare 113490317