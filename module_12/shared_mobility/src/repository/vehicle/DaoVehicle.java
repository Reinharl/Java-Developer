package repository.vehicle;

import model.vehicle.Vehicle;
import repository.Dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DaoVehicle extends Dao<Vehicle> {

    Optional<Vehicle> findByPlate(String plate);

    List<Vehicle> findByVehicleType(UUID vehicleTypoId);
}
