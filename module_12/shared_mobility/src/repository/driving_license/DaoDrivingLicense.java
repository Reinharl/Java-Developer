package repository.driving_license;

import model.user.DrivingLicense;
import repository.Dao;

import java.util.Optional;
import java.util.UUID;

public interface DaoDrivingLicense extends Dao<DrivingLicense> {

    Optional<DrivingLicense> findByLicenseNumber(String licenseNumber);
    Optional<DrivingLicense> findByUserId(UUID userId);
}
