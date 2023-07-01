import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        righeInverse();
    }

    public static void righeInverse() {
        Path pathRighe = Paths.get("module_9", "righe_inverse", "src", "righe.txt");
        List<String> list = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathRighe.toString()));

            String line = reader.readLine();
            while (line != null) {
                list.add(line);
                line = reader.readLine();
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
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathRigheInverse.toString()));

            for (int i = 0; i < list.size(); i++) {
                writer.write(list.get(list.size() - 1 - i) + '\n');
            }
            writer.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
