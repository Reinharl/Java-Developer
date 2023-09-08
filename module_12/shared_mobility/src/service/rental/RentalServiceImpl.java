package service.rental;

import exception.GenericException;

import model.rental.Rental;
import model.user.DrivingLicense;
import model.user.DrivingLicenseTypology;
import model.user.User;
import model.vehicle.Vehicle;
import repository.driving_license.DaoDrivingLicense;
import repository.driving_license.DrivingLicenseDaoCsv;
import repository.driving_license_typology.DaoDrivingLicenseTypology;
import repository.driving_license_typology.DrivingLicenseTypologyDaoCsv;
import repository.rental.DaoRental;
import repository.rental.RentalDaoCsv;
import repository.user.DaoUser;
import repository.user.UserDaoCsv;
import repository.vehicle.DaoVehicle;
import repository.vehicle.VehicleDaoCsv;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class RentalServiceImpl implements RentalService {

    private final DaoRental rentalRepository;
    private final DaoUser userRepository;
    private final DaoDrivingLicense drivingLicenseRepository;
    private final DaoDrivingLicenseTypology drivingLicenseTypologyRepository;
    private final DaoVehicle vehicleRepository;

    public RentalServiceImpl() throws IOException {
        rentalRepository = RentalDaoCsv.getInstance();
        userRepository = UserDaoCsv.getInstance();
        vehicleRepository = VehicleDaoCsv.getInstance();
        drivingLicenseRepository = DrivingLicenseDaoCsv.getInstance();
        drivingLicenseTypologyRepository = DrivingLicenseTypologyDaoCsv.getInstance();
    }


    @Override
    public void start(UUID userId, UUID vehicleId) throws GenericException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new GenericException("User not found"));

        DrivingLicense drivingLicense = drivingLicenseRepository.findByUserId(userId)
                .orElseThrow(() -> new GenericException("Driving License not found"));

        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new GenericException("Vehicle not found"));

        if (!vehicle.isAvailable())
            throw new GenericException("Vehicle already rent");

        if (!isDrivingLicenseValid(drivingLicense, vehicle))
            throw new GenericException("Driving license not valid for this vehicle");

        if (vehicle.getNeedHelmet() && !user.isHasHelmet())
            throw new GenericException("This vehicle needs helmet");

        vehicle.setAvailable(false);
        vehicleRepository.update(vehicle);

        Rental rental = Rental.builder()
                .id(UUID.randomUUID())
                .userId(userId)
                .vehicleId(vehicleId)
                .startTime(LocalDateTime.now())
                .duration(Duration.ZERO)
                .build();

        rentalRepository.save(rental);

        System.out.println("Rental started");
    }

    @Override
    public void end(UUID rentalId) throws GenericException {
        Rental rental = rentalRepository.findById(rentalId)
                .orElseThrow(() -> new GenericException("Rental not found"));

        if (rental.getDuration().isPositive())
            throw new GenericException("Rental already ended");

        rental.setDuration(Duration.between(rental.getStartTime(), LocalDateTime.now()));
        rentalRepository.update(rental);

        double priceForSecond = (double) vehicleRepository.findById(rental.getVehicleId()).get()
                .getPriceForMinute() / 6000;

        System.out.println("priceForSecond = " + priceForSecond);
        System.out.println("rental.getDuration().toSeconds() = " + rental.getDuration().toSeconds());

        long amount = (long) (priceForSecond * rental.getDuration().toSeconds() * 100);

        System.out.println("Rental ended the amount is: " + (double) amount / 100);

        //TODO Si può implementare la logica per avviare il pagamento attraverso il design pattern Observer
    }

    public boolean isDrivingLicenseValid(DrivingLicense drivingLicense, Vehicle vehicle) {
        List<DrivingLicenseTypology> drivingLicenseTypologies = drivingLicenseTypologyRepository
                .findAllByDrivingLicenseId(drivingLicense.getId());

        for (DrivingLicenseTypology dlt : drivingLicenseTypologies) {
            if (dlt.getLicenseTypoId().equals(vehicle.getLicenseTypo())) {
                return true;
            }
        }

        return false;
    }
}
