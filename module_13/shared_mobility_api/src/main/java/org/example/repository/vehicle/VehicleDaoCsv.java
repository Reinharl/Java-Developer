package org.example.repository.vehicle;

import org.example.model.vehicle.Vehicle;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class VehicleDaoCsv implements DaoVehicle {

    private static volatile VehicleDaoCsv instance;
    private final Path VEHICLE_REPOSITORY_PATH = Path.of("module_13", "shared_mobility_api", "src", "main", "java", "org", "example", "csv", "vehicle");
    private Map<UUID, Vehicle> vehicleMap;

    private VehicleDaoCsv() throws IOException {
        vehicleMap = new HashMap<>();

        if (!Files.exists(VEHICLE_REPOSITORY_PATH))
            Files.createFile(VEHICLE_REPOSITORY_PATH);
        else
            this.vehicleMap.putAll(Files.lines(VEHICLE_REPOSITORY_PATH)
                    .map(Vehicle::parseCsv)
                    .collect(Collectors.toMap(
                            Vehicle::getId,
                            Function.identity()
                    )));
    }

    // singleton pattern
    public static VehicleDaoCsv getInstance() throws IOException {
        VehicleDaoCsv result = instance;

        if (result != null) {
            return result;
        }
        synchronized (VehicleDaoCsv.class) {
            if (instance == null)
                instance = new VehicleDaoCsv();
            return instance;
        }
    }

    public boolean updateCsv() {
        try (BufferedWriter bw = Files.newBufferedWriter(VEHICLE_REPOSITORY_PATH)) {
            for (Vehicle c : vehicleMap.values()) {
                bw.write(c.getCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean save(Vehicle vehicle) {
        vehicleMap.put(vehicle.getId(), vehicle);
        return vehicleMap.get(vehicle.getId()).equals(vehicle) && updateCsv();
    }

    @Override
    public boolean update(Vehicle vehicle) {
        vehicleMap.replace(vehicle.getId(), vehicle);
        return vehicleMap.get(vehicle.getId()).equals(vehicle) && updateCsv();
    }

    @Override
    public boolean deleteById(UUID id) {
        return vehicleMap.remove(id) != null && updateCsv();
    }

    @Override
    public Optional<Vehicle> findById(UUID id) {
        return Optional.ofNullable(vehicleMap.get(id));
    }

    @Override
    public Optional<Vehicle> findByPlate(String plate) {
        return vehicleMap.values().stream()
                .filter(car -> car.getPlate().equals(plate))
                .findFirst();
    }

    @Override
    public List<Vehicle> findByVehicleType(UUID vehicleTypoId) {
        return vehicleMap.values().stream()
                .filter(vehicle -> vehicle.getVehicleTypo().equals(vehicleTypoId))
                .toList();
    }

    @Override
    public Collection<Vehicle> findAll() {
        return vehicleMap.values();
    }
}
