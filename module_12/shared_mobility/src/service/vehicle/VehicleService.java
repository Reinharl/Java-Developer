package service.vehicle;

import dto.VehicleDto;
import exception.GenericException;
import model.vehicle.Vehicle;

import java.util.List;
import java.util.UUID;

public interface VehicleService {

    void save(VehicleDto vehicleDto) throws GenericException;

    List<Vehicle> findByVehicleType(UUID vehicleTypeId);
}
