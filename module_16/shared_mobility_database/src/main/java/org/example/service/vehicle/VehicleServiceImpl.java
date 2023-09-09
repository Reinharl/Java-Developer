package org.example.service.vehicle;

import org.example.dto.VehicleDto;
import org.example.exception.GenericException;
import org.example.model.user.LicenseTypo;
import org.example.model.vehicle.GeoCoordinates;
import org.example.model.vehicle.Vehicle;
import org.example.model.vehicle.VehicleTypo;
import org.example.repository.license_typo.DaoLicenseTypo;
import org.example.repository.license_typo.LicenseTypoDaoSQL;
import org.example.repository.vehicle.DaoVehicle;
import org.example.repository.vehicle.VehicleDaoSQL;
import org.example.repository.vehicle_typo.DaoVehicleTypo;
import org.example.repository.vehicle_typo.VehicleTypoDaoSQL;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public class VehicleServiceImpl implements VehicleService {

    private final Logger logger = Logger.getLogger("VEHICLE-SERVICE");
    private final DaoVehicle vehicleRepository;
    private final DaoVehicleTypo vehicleTypoRepository;
    private final DaoLicenseTypo licenseTypoRepository;

    public VehicleServiceImpl() {
        vehicleRepository = new VehicleDaoSQL();
        licenseTypoRepository = new LicenseTypoDaoSQL();
        vehicleTypoRepository = new VehicleTypoDaoSQL();
    }

    @Override
    public void save(VehicleDto vehicleDto) throws GenericException, SQLException {
        if (vehicleRepository.findByPlate(vehicleDto.getPlate()).isPresent()) {
            throw new GenericException("Plate not valid");
        }

        LicenseTypo licenseTypo = licenseTypoRepository.findByName(vehicleDto.getLicenseTypology())
                .orElseThrow(() -> new GenericException("License typology not found"));

        VehicleTypo vehicleTypo = vehicleTypoRepository.findByName(vehicleDto.getVehicleTypo())
                .orElseThrow(() -> new GenericException("Vehicle typology not found"));

        Vehicle vehicle = Vehicle.builder()
                .id(UUID.randomUUID())
                .position(new GeoCoordinates(vehicleDto.getLatitude(), vehicleDto.getLongitude()))
                .isAvailable(vehicleDto.isAvailable())
                .priceForMinute(vehicleDto.getPriceForMinute())
                .plate(vehicleDto.getPlate())
                .fuelPercentage(vehicleDto.getFuelPercentage())
                .licenseTypo(licenseTypo.getId())
                .needHelmet(vehicleDto.isNeedHelmet())
                .vehicleTypo(vehicleTypo.getId())
                .build();

        vehicleRepository.save(vehicle);
        logger.info("Saved " + vehicleDto.getVehicleTypo().toLowerCase() + ": " + vehicle);
    }

    @Override
    public List<Vehicle> findByVehicleType(UUID vehicleTypeId) throws SQLException {
        return vehicleRepository.findByVehicleType(vehicleTypeId);
    }

}
