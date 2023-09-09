package org.example.repository.license_typo;

import org.example.model.user.LicenseTypo;

import java.sql.SQLException;
import java.util.Optional;

public interface DaoLicenseTypo {

    Optional<LicenseTypo> findByName(String name) throws SQLException;
}
