package org.example.repository.driving_license;

import org.example.model.user.DrivingLicense;
import org.example.repository.Dao;

import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

public interface DaoDrivingLicense extends Dao<DrivingLicense> {

    Optional<DrivingLicense> findByLicenseNumber(String licenseNumber) throws SQLException;
    Optional<DrivingLicense> findByUserId(UUID userId) throws SQLException;
}
