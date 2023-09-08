package repository.license_typo;

import model.user.LicenseTypo;

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
    private final Path LICENSE_TYPO_REPOSITORY_PATH = Path.of("module_12", "shared_mobility", "src", "csv", "license_typo");
    private Map<UUID, String> licenseTypoMap;

    public LicenseTypoDaoCsv() throws IOException {
        licenseTypoMap = new HashMap<>();
        initMap();

        Files.deleteIfExists(LICENSE_TYPO_REPOSITORY_PATH);
        Files.createFile(LICENSE_TYPO_REPOSITORY_PATH);
        initFile();
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
