package org.example.service.vehicle;

import org.example.dto.VehicleDto;
import org.example.exception.GenericException;
import org.example.model.vehicle.Vehicle;

import java.util.List;
import java.util.UUID;

public interface VehicleService {

    void save(VehicleDto vehicleDto) throws GenericException;

    List<Vehicle> findByVehicleType(UUID vehicleTypeId);
}
