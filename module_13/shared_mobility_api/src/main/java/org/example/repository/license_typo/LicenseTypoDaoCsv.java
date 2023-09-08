package org.example.repository.license_typo;

import org.example.model.user.LicenseTypo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class LicenseTypoDaoCsv implements DaoLicenseTypo {
    private static volatile LicenseTypoDaoCsv instance;
    private final Path LICENSE_TYPO_REPOSITORY_PATH = Path.of("module_13", "shared_mobility_api", "src", "main", "java", "org", "example", "csv", "license_typo");
    private Map<UUID, String> licenseTypoMap;

    public LicenseTypoDaoCsv() throws IOException {
        licenseTypoMap = new HashMap<>();
        initMap();

        if (!Files.exists(LICENSE_TYPO_REPOSITORY_PATH)) {
            Files.createFile(LICENSE_TYPO_REPOSITORY_PATH);
            initFile();
        } else {
            try (BufferedReader br = Files.newBufferedReader(LICENSE_TYPO_REPOSITORY_PATH)) {
                while (br.ready()) {
                    String[] values = br.readLine().split(",");

                    licenseTypoMap.put(UUID.fromString(values[0]), values[1]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static LicenseTypoDaoCsv getInstance() throws IOException {
        LicenseTypoDaoCsv result = instance;

        if (result != null) {
            return result;
        }
        synchronized (LicenseTypoDaoCsv.class) {
            if (instance == null)
                instance = new LicenseTypoDaoCsv();
            return instance;
        }
    }

    private void initMap() {
        for (LicenseTypo typo : LicenseTypo.values()) {
            licenseTypoMap.put(UUID.randomUUID(), typo.name());
        }
    }

    private void initFile() throws IOException {
        BufferedWriter bw = Files.newBufferedWriter(LICENSE_TYPO_REPOSITORY_PATH);
        for (Map.Entry<UUID, String> entry : licenseTypoMap.entrySet()) {
            bw.write(entry.getKey() + "," + entry.getValue());
            bw.newLine();
        }
        bw.close();
    }

    @Override
    public Optional<UUID> findIdByName(String name) {
        for (Map.Entry<UUID, String> typologyMap : licenseTypoMap.entrySet()) {
            if (typologyMap.getValue().equals(name))
                return Optional.of(typologyMap.getKey());
        }
        return Optional.empty();
    }

}
