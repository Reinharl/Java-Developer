package service.vehicle;

import dto.VehicleDto;
import exception.GenericException;
import model.vehicle.GeoCoordinates;
import model.vehicle.Vehicle;
import repository.license_typo.DaoLicenseTypo;
import repository.license_typo.LicenseTypoDaoCsv;
import repository.vehicle.DaoVehicle;
import repository.vehicle.VehicleDaoCsv;
import repository.vehicle_typo.DaoVehicleTypo;
import repository.vehicle_typo.VehicleTypoDaoCsv;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class VehicleServiceImpl implements VehicleService {

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
        System.out.println("Saved " + vehicleDto.getVehicleTypo().toLowerCase() + ": " + vehicle);
    }

    @Override
    public List<Vehicle> findByVehicleType(UUID vehicleTypeId) {
        return vehicleRepository.findByVehicleType(vehicleTypeId);
    }

}
