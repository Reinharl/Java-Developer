import model.Interruttore;
import model.Lampadina;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Lampadina lamp = new Lampadina();
        Interruttore switchLamp1 = new Interruttore(lamp);
        Interruttore switchLamp2 = new Interruttore(lamp);

        boolean flag = true;
        do {
            Scanner sc = new Scanner(System.in);

            System.out.println("1: click interruttore 1");
            System.out.println("2: click interruttore 2");
            System.out.println("3: per uscire");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> {
                    switchLamp1.click();
                    System.out.println(lamp.stato());
                }
                case 2 -> {
                    switchLamp2.click();
                    System.out.println(lamp.stato());
                }
                case 3 -> flag = false;
            }
        } while (flag);
    }
}
