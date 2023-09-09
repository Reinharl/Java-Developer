package org.example.repository.vehicle;

import org.example.model.vehicle.Vehicle;
import org.example.repository.Dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DaoVehicle extends Dao<Vehicle> {

    Optional<Vehicle> findByPlate(String plate) throws SQLException;

    List<Vehicle> findByVehicleType(UUID vehicleTypoId) throws SQLException;
}
