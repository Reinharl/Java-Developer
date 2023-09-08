package repository.driving_license_typology;

import model.user.DrivingLicenseTypology;
import repository.Dao;

import java.util.List;
import java.util.UUID;

public interface DaoDrivingLicenseTypology extends Dao<DrivingLicenseTypology> {
    List<DrivingLicenseTypology> findAllByDrivingLicenseId(UUID id);
}
