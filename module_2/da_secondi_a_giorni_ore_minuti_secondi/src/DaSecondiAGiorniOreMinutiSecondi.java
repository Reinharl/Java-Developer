import java.util.Scanner;

public class DaSecondiAGiorniOreMinutiSecondi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Inserisci un numero di secondi: ");
        int n = sc.nextInt();

        System.out.println(fromSecondsToDaysHoursMinutesSeconds(n));
    }

    /**
     * Given a number it converts to a string of days hours minutes and seconds.
     * @param number number to convert
     * @return days hours minutes and seconds
     */
    public static String fromSecondsToDaysHoursMinutesSeconds(int number) {
        int days, hours, minutes, seconds;

        days = number/86400;
        number -= days*86400;

        hours = number/3600;
        number -= hours*3600;

        minutes = number/60;
        number -= minutes*60;

        seconds = number;

        return "Giorni: " + days + ", Ore: " + hours + ", Minutes: " + minutes + ", Seconds: " + seconds;
    }
}