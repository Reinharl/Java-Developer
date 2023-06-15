import java.util.Scanner;

public class ContaVocaliConsonanti {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Inserisci una frase: ");
        String s = sc.nextLine();
        countVocalsConsonant(s);
    }

    /**
     * Given a String, press the number of vocals and consonants.
     * @param s string to process
     */
    public static void countVocalsConsonant(String s) {
        String sLowerCase = s.toLowerCase();

        String vocals = "aeiouáàéèíìóòúù";
        String consonants = "bcdfghjklmnpqrstuvxyz";

        int countVocals = 0;
        int countConsonants = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < consonants.length(); j++) {
                if (j < vocals.length() && sLowerCase.charAt(i) == vocals.charAt(j)) {
                    countVocals++;
                    break;
                } else if (sLowerCase.charAt(i) == consonants.charAt(j)) {
                    countConsonants++;
                    break;
                }
            }
        }

        System.out.println("Vocals: " + countVocals);
        System.out.println("Consonants: " + countConsonants);

    }
}
