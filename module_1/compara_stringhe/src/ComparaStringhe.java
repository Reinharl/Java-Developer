public class ComparaStringhe {
    public static void main(String[] args) {
        String a = "ciao come va ?";
        String b = "cIao come vA ?";
        String c = "ciao come va ";
        System.out.println("2".equals("" + compareStrings(a, b, c)));
        a = "ciao come va ?";
        b = "cIaoo come vA ?";
        c = "ciao come va a";
        System.out.println("1".equals("" + compareStrings(a, b, c)));
        a = "ciao come va ?";
        b = "cIao come va ?";
        c = "ciao come vA ?";
        System.out.println("3".equals("" + compareStrings(a, b, c)));
    }

    /**
     * Given three strings a, b and c as input, print the integer corresponding to the number of equal Strings
     * each other (case insensitive).
     *
     * @param a is the first String
     * @param b is the second String
     * @param c is the third String
     * @return the number of equal String
     */
    private static int compareStrings(String a, String b, String c) {
        String A = a.toUpperCase();
        String B = b.toUpperCase();
        String C = c.toUpperCase();

        if (A.equals(B) && B.equals(C)) {
            return 3;
        } else if (A.equals(B) || B.equals(C) || C.equals(A)) {
            return 2;
        } else
            return 1;
    }
}
