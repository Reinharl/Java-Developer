import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("module_9", "mappa_di_righe", "src", "righe.txt");

        List<String> file = readFile(path.toString());
        Map<String, List<String>> map = createMap(file);

        System.out.println(map);

    }

    public static List<String> readFile(String path) {
        ArrayList<String> file = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));

            String line = reader.readLine();
            while (line != null) {
                file.add(line);
                line = reader.readLine();
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

    public static Map<String, List<String>> createMap(List<String> file) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : file) {
            String[] splitKeyValue = s.split(":");

            String key = splitKeyValue[0];

            String[] splitValueValue = splitKeyValue[1].split(",");
            List<String> value = List.of(splitValueValue);

            map.put(key, value);
        }

        return map;

    }
}
