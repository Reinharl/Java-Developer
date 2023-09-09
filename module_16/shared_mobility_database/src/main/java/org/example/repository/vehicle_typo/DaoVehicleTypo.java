package org.example.repository.vehicle_typo;

import org.example.model.vehicle.VehicleTypo;

import java.sql.SQLException;
import java.util.Optional;

public interface DaoVehicleTypo {

    Optional<VehicleTypo> findByName(String name) throws SQLException;
}
