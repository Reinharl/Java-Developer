import java.util.Arrays;

public class PalindromaRicorsiva {

    public static void main(String[] args) {
        String s = "itopinonavevanonipoti";
        System.out.println(isPalindroma(s));
    }

    public static boolean isPalindroma(String s) {

        if (s.length() <= 1) {
            return true;
        } else {
            char sIniziale = s.charAt(0);
            char sFinale = s.charAt(s.length() - 1);
            if (sIniziale == sFinale) {
                return isPalindroma(s.substring(1, s.length() - 1));
            } else {
                return false;
            }

        }
    }


}
