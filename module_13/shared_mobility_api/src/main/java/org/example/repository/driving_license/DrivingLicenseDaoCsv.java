package org.example.repository.driving_license;

import org.example.model.user.DrivingLicense;
import org.example.repository.user.UserDaoCsv;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DrivingLicenseDaoCsv implements DaoDrivingLicense {
    private static volatile DrivingLicenseDaoCsv instance;
    private final Path DRIVING_LICENSE_REPOSITORY_PATH = Path.of("module_13", "shared_mobility_api", "src", "main", "java", "org", "example", "csv", "driving_license");
    private Map<UUID, DrivingLicense> drivingLicenseMap;

    private DrivingLicenseDaoCsv() throws IOException {
        drivingLicenseMap = new HashMap<>();

        if (!Files.exists(DRIVING_LICENSE_REPOSITORY_PATH))
            Files.createFile(DRIVING_LICENSE_REPOSITORY_PATH);
        else drivingLicenseMap.putAll(Files.lines(DRIVING_LICENSE_REPOSITORY_PATH)
                .map(DrivingLicense::parseCsv)
                .collect(Collectors.toMap(
                        DrivingLicense::getId,
                        Function.identity()
                )));
    }

    // singleton pattern
    public static DrivingLicenseDaoCsv getInstance() throws IOException {
        DrivingLicenseDaoCsv result = instance;

        if (result != null) {
            return result;
        }
        synchronized (UserDaoCsv.class) {
            if (instance == null)
                instance = new DrivingLicenseDaoCsv();

            return instance;
        }
    }

    public boolean updateCsv() {
        try (BufferedWriter bw = Files.newBufferedWriter(DRIVING_LICENSE_REPOSITORY_PATH)) {
            for (DrivingLicense dl : drivingLicenseMap.values()) {
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
    public boolean save(DrivingLicense drivingLicense) {
        drivingLicenseMap.put(drivingLicense.getId(), drivingLicense);
        return drivingLicenseMap.get(drivingLicense.getId()).equals(drivingLicense) && updateCsv();
    }

    @Override
    public boolean update(DrivingLicense drivingLicense) {
        drivingLicenseMap.replace(drivingLicense.getId(), drivingLicense);
        return drivingLicenseMap.get(drivingLicense.getId()).equals(drivingLicense) && updateCsv();
    }

    @Override
    public boolean deleteById(UUID id) {
        return drivingLicenseMap.remove(id) != null && updateCsv();
    }

    @Override
    public Optional<DrivingLicense> findById(UUID id) {
        return Optional.ofNullable(drivingLicenseMap.get(id));
    }

    @Override
    public Optional<DrivingLicense> findByLicenseNumber(String licenseNumber) {
        return drivingLicenseMap.values().stream()
                .filter(drivingLicense -> drivingLicense.getLicenseNumber().equals(licenseNumber))
                .findFirst();
    }

    @Override
    public Optional<DrivingLicense> findByUserId(UUID userId) {
        return drivingLicenseMap.values().stream()
                .filter(drivingLicense -> drivingLicense.getUserId().equals(userId))
                .findFirst();
    }

    @Override
    public Collection<DrivingLicense> findAll() {
        return drivingLicenseMap.values();
    }

}
