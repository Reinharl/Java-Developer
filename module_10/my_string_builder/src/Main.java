import model.MyString;

public class Main {
    public static void main(String[] args) {
        MyString.Builder msb = new MyString.Builder();

        msb.append("Facilissimo")
                .append(" concatenare")
                .append(" stringhe!");

        String myFinalString = msb.build();

        System.out.println(myFinalString.equals("Facilissimo concatenare stringhe!"));
        System.out.println(myFinalString);
    }
}
