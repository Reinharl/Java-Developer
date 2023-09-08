package org.example.repository.driving_license_typology;

import org.example.model.user.DrivingLicenseTypology;
import org.example.repository.Dao;

import java.util.List;
import java.util.UUID;

public interface DaoDrivingLicenseTypology extends Dao<DrivingLicenseTypology> {
    List<DrivingLicenseTypology> findAllByDrivingLicenseId(UUID id);
}
