package org.example.repository.driving_license_typology;

import org.example.model.user.DrivingLicenseTypology;
import org.example.repository.driving_license.DrivingLicenseDaoCsv;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DrivingLicenseTypologyDaoCsv implements DaoDrivingLicenseTypology {
    private static volatile DrivingLicenseTypologyDaoCsv instance;
    private final Path DRIVING_LICENSE_TYPOLOGY_REPOSITORY_PATH = Path.of("module_13", "shared_mobility_api", "src", "main", "java", "org", "example", "csv", "driving_license_typology");
    private Map<UUID, DrivingLicenseTypology> drivingLicenseTypologyMap;

    private DrivingLicenseTypologyDaoCsv() throws IOException {
        drivingLicenseTypologyMap = new HashMap<>();

        if (!Files.exists(DRIVING_LICENSE_TYPOLOGY_REPOSITORY_PATH))
            Files.createFile(DRIVING_LICENSE_TYPOLOGY_REPOSITORY_PATH);
        else drivingLicenseTypologyMap.putAll(Files.lines(DRIVING_LICENSE_TYPOLOGY_REPOSITORY_PATH)
                .map(DrivingLicenseTypology::parseCsv)
                .collect(Collectors.toMap(
                        DrivingLicenseTypology::getId,
                        Function.identity()
                )));
    }

    // singleton pattern
    public static DrivingLicenseTypologyDaoCsv getInstance() throws IOException {
        DrivingLicenseTypologyDaoCsv result = instance;

        if (result != null) {
            return result;
        }
        synchronized (DrivingLicenseDaoCsv.class) {
            if (instance == null)
                instance = new DrivingLicenseTypologyDaoCsv();

            return instance;
        }
    }

    public boolean updateCsv() {
        try (BufferedWriter bw = Files.newBufferedWriter(DRIVING_LICENSE_TYPOLOGY_REPOSITORY_PATH)) {
            for (DrivingLicenseTypology dl : drivingLicenseTypologyMap.values()) {
                bw.write(dl.getCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean save(DrivingLicenseTypology drivingLicenseTypology) {
        drivingLicenseTypologyMap.put(drivingLicenseTypology.getId(), drivingLicenseTypology);
        return drivingLicenseTypologyMap.get(drivingLicenseTypology.getId()).equals(drivingLicenseTypology) && updateCsv();
    }

    @Override
    public boolean update(DrivingLicenseTypology drivingLicenseTypology) {
        drivingLicenseTypologyMap.replace(drivingLicenseTypology.getId(), drivingLicenseTypology);
        return drivingLicenseTypologyMap.get(drivingLicenseTypology.getId()).equals(drivingLicenseTypology) && updateCsv();
    }

    @Override
    public boolean deleteById(UUID id) {
        return drivingLicenseTypologyMap.remove(id) != null && updateCsv();
    }

    @Override
    public Optional<DrivingLicenseTypology> findById(UUID id) {
        return Optional.ofNullable(drivingLicenseTypologyMap.get(id));
    }

    @Override
    public Collection<DrivingLicenseTypology> findAll() {
        return drivingLicenseTypologyMap.values();
    }

    @Override
    public List<DrivingLicenseTypology> findAllByDrivingLicenseId(UUID id) {
        return drivingLicenseTypologyMap.values().stream()
                .filter(drivingLicenseTypology -> drivingLicenseTypology.getDrivingLicenseId().equals(id))
                .toList();
    }
}
