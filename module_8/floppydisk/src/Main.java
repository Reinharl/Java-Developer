import model.FloppyDisk;

import exceptions.IllegalHeadException;
import exceptions.WriteLockException;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FloppyDisk floppyDisk = new FloppyDisk();

        try {
            floppyDisk.write(new byte[]{0x01, 0x02, 0x02});
            floppyDisk.placeHead(0);
            byte[] data = floppyDisk.read(2);
            System.out.println("Dati letti: " + Arrays.toString(data));

            floppyDisk.activeWriteLock();
            floppyDisk.write(new byte[]{0x04, 0x05, 0x06});

            floppyDisk.disableWriteLock();
            floppyDisk.format();

        } catch (IllegalHeadException e) {
            System.out.println("Errore di posizionamento della testina: " + e.getMessage());
        } catch (WriteLockException e) {
            System.out.println("Errore di scrittura: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
