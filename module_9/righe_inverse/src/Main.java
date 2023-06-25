import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        righeInverse();
    }

    public static void righeInverse() {
        Path pathRighe = Paths.get("module_9", "righe_inverse", "src", "righe.txt");
        ArrayList<String> righe = new ArrayList<>();

        try {
            Scanner reader = new Scanner(new BufferedReader(new FileReader(pathRighe.toString())));

            while (reader.hasNext()) {
                String riga = reader.nextLine();
                righe.add(riga);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Path pathRigheInverse = Paths.get("module_9", "righe_inverse", "src", "righeInverse.txt");
        try {
            File righeInverse = new File(pathRigheInverse.toString());

            righeInverse.createNewFile();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileWriter writer = new FileWriter(pathRigheInverse.toFile());

            for (int i = 0; i < righe.size(); i++) {
                writer.write(righe.get(righe.size() - 1 - i));
                writer.write("\n");
            }
            writer.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
