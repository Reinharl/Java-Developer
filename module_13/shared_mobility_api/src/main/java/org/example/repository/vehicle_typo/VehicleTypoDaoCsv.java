package org.example.repository.vehicle_typo;

import org.example.model.vehicle.VehicleTypo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class VehicleTypoDaoCsv implements DaoVehicleTypo {
    private static volatile VehicleTypoDaoCsv instance;
    private final Path VEHICLE_TYPO_REPOSITORY_PATH = Path.of("module_13", "shared_mobility_api", "src", "main", "java", "org", "example", "csv", "vehicle_typo");
    private Map<UUID, String> vehicleTypoMap;

    public VehicleTypoDaoCsv() throws IOException {
        vehicleTypoMap = new HashMap<>();
        initMap();

        if (!Files.exists(VEHICLE_TYPO_REPOSITORY_PATH)) {
            Files.createFile(VEHICLE_TYPO_REPOSITORY_PATH);
            initFile();
        } else {
            try (BufferedReader br = Files.newBufferedReader(VEHICLE_TYPO_REPOSITORY_PATH)) {
                while (br.ready()) {
                    String[] values = br.readLine().split(",");

                    vehicleTypoMap.put(UUID.fromString(values[0]), values[1]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static VehicleTypoDaoCsv getInstance() throws IOException {
        VehicleTypoDaoCsv result = instance;

        if (result != null) {
            return result;
        }
        synchronized (VehicleTypoDaoCsv.class) {
            if (instance == null)
                instance = new VehicleTypoDaoCsv();
            return instance;
        }
    }

    private void initMap() {
        for (VehicleTypo typo : VehicleTypo.values()) {
            vehicleTypoMap.put(UUID.randomUUID(), typo.name());
        }
    }

    private void initFile() throws IOException {
        BufferedWriter bw = Files.newBufferedWriter(VEHICLE_TYPO_REPOSITORY_PATH);
        for (Map.Entry<UUID, String> entry : vehicleTypoMap.entrySet()) {
            bw.write(entry.getKey() + "," + entry.getValue());
            bw.newLine();
        }
        bw.close();
    }

    @Override
    public Optional<UUID> findIdByName(String name) {
        for (Map.Entry<UUID, String> typologyMap : vehicleTypoMap.entrySet()) {
            if (typologyMap.getValue().equals(name))
                return Optional.of(typologyMap.getKey());
        }
        return Optional.empty();
    }

}
