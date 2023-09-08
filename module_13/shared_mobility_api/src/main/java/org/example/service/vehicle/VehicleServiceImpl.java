package org.example.service.vehicle;

import org.example.dto.VehicleDto;
import org.example.exception.GenericException;
import org.example.model.vehicle.GeoCoordinates;
import org.example.model.vehicle.Vehicle;
import org.example.repository.license_typo.DaoLicenseTypo;
import org.example.repository.license_typo.LicenseTypoDaoCsv;
import org.example.repository.vehicle.DaoVehicle;
import org.example.repository.vehicle.VehicleDaoCsv;
import org.example.repository.vehicle_typo.DaoVehicleTypo;
import org.example.repository.vehicle_typo.VehicleTypoDaoCsv;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public class VehicleServiceImpl implements VehicleService {

    private final Logger logger = Logger.getLogger("VEHICLE-SERVICE");
    private final DaoVehicle vehicleRepository;
    private final DaoVehicleTypo vehicleTypoRepository;
    private final DaoLicenseTypo licenseTypoRepository;

    public VehicleServiceImpl() throws IOException {
        vehicleRepository = VehicleDaoCsv.getInstance();
        licenseTypoRepository = LicenseTypoDaoCsv.getInstance();
        vehicleTypoRepository = VehicleTypoDaoCsv.getInstance();
    }

    @Override
    public void save(VehicleDto vehicleDto) throws GenericException {
        if (vehicleRepository.findByPlate(vehicleDto.getPlate()).isPresent()) {
            throw new GenericException("Plate not valid");
        }

        UUID licenseTypo = licenseTypoRepository.findIdByName(vehicleDto.getLicenseTypology())
                .orElseThrow(() -> new GenericException("License typology not found"));

        UUID vehicleTypo = vehicleTypoRepository.findIdByName(vehicleDto.getVehicleTypo())
                .orElseThrow(() -> new GenericException("Vehicle typology not found"));

        Vehicle vehicle = Vehicle.builder()
                .id(UUID.randomUUID())
                .position(new GeoCoordinates(vehicleDto.getLatitude(), vehicleDto.getLongitude()))
                .isAvailable(vehicleDto.isAvailable())
                .priceForMinute(vehicleDto.getPriceForMinute())
                .plate(vehicleDto.getPlate())
                .fuelPercentage(vehicleDto.getFuelPercentage())
                .licenseTypo(licenseTypo)
                .needHelmet(vehicleDto.isNeedHelmet())
                .vehicleTypo(vehicleTypo)
                .build();

        vehicleRepository.save(vehicle);
        logger.info("Saved " + vehicleDto.getVehicleTypo().toLowerCase() + ": " + vehicle);
    }

    @Override
    public List<Vehicle> findByVehicleType(UUID vehicleTypeId) {
        return vehicleRepository.findByVehicleType(vehicleTypeId);
    }

}
