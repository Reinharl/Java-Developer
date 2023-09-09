package org.example.repository.license_typo;

import org.example.connection_handler.ConnectionHandler;
import org.example.model.user.LicenseTypo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class LicenseTypoDaoSQL implements DaoLicenseTypo {
    @Override
    public Optional<LicenseTypo> findByName(String name) throws SQLException {
        String query = "SELECT * FROM license_typo WHERE name = ?;";

        Optional<LicenseTypo> licenseTypo = Optional.empty();

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {

            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                licenseTypo = Optional.of(LicenseTypo.fromResultSet(rs));

        }

        return licenseTypo;
    }
}
