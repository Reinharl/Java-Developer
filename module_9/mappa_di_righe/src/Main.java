import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("module_9", "mappa_di_righe", "src", "righe.txt");
        ArrayList<String> file = readFile(path.toString());

        Map<String, List<String>> map = createMap(file);

        System.out.println(map);

    }

    public static ArrayList<String> readFile(String path) {
        ArrayList<String> file = new ArrayList<>();

        try {
            Scanner reader = new Scanner(new BufferedReader(new FileReader(path)));

            while (reader.hasNext()) {
                file.add(reader.nextLine());
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

    public static Map<String, List<String>> createMap(ArrayList<String> file) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : file) {
            String[] splitKeyValue = s.split(":");

            String key = splitKeyValue[0];

            String[] splitValueValue = splitKeyValue[1].split(",");
            List<String> value = new ArrayList<>(Arrays.asList(splitValueValue));

            map.put(key, value);
        }

        return map;

    }
}
