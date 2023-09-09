package org.example.repository.driving_license;

import org.example.connection_handler.ConnectionHandler;
import org.example.model.user.DrivingLicense;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DrivingLicenseDaoSQL implements DaoDrivingLicense {
    @Override
    public boolean save(DrivingLicense drivingLicense) throws SQLException {
        String query = "INSERT INTO driving_license (id, last_name, first_name, birth_date, birth_place, release_date, expiration_date, license_number, user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {

            ps.setString(1, String.valueOf(drivingLicense.getId()));
            ps.setString(2, drivingLicense.getLastName());
            ps.setString(3, drivingLicense.getFirstName());
            ps.setDate(4, Date.valueOf(drivingLicense.getBirthDate()));
            ps.setString(5, drivingLicense.getBirthPlace());
            ps.setDate(6, Date.valueOf(drivingLicense.getReleaseDate()));
            ps.setDate(7, Date.valueOf(drivingLicense.getExpirationDate()));
            ps.setString(8, drivingLicense.getLicenseNumber());
            ps.setString(9, String.valueOf(drivingLicense.getUserId()));
            int insertedCount = ps.executeUpdate();

            return insertedCount > 0;
        }
    }

    @Override
    public boolean update(DrivingLicense drivingLicense) throws SQLException {
        String query = "UPDATE driving_license SET last_name = ?, first_name = ?, birth_date = ?, birth_place = ?, release_date = ?, expiration_date = ?, license_number = ?, user_id = ? WHERE id = ?;";

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {

            ps.setString(1, drivingLicense.getLastName());
            ps.setString(2, drivingLicense.getFirstName());
            ps.setDate(3, Date.valueOf(drivingLicense.getBirthDate()));
            ps.setString(4, drivingLicense.getBirthPlace());
            ps.setDate(5, Date.valueOf(drivingLicense.getReleaseDate()));
            ps.setDate(6, Date.valueOf(drivingLicense.getExpirationDate()));
            ps.setString(7, drivingLicense.getLicenseNumber());
            ps.setString(8, String.valueOf(drivingLicense.getUserId()));
            ps.setString(9, String.valueOf(drivingLicense.getId()));
            int updatedCount = ps.executeUpdate();

            return updatedCount > 0;
        }
    }

    @Override
    public boolean deleteById(UUID id) throws SQLException {
        String query = "DELETE FROM driving_license WHERE id = ?;";

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {

            ps.setString(1, String.valueOf(id));
            int deletedCount = ps.executeUpdate();

            return deletedCount > 0;
        }
    }

    @Override
    public Optional<DrivingLicense> findById(UUID id) throws SQLException {
        String query = "SELECT * FROM driving_license WHERE id = ?;";

        Optional<DrivingLicense> drivingLicense = Optional.empty();

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {

            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                drivingLicense = Optional.of(DrivingLicense.fromResultSet(rs));
        }

        return drivingLicense;
    }

    @Override
    public List<DrivingLicense> findAll() throws SQLException {
        String query = "SELECT * FROM driving_license;";

        List<DrivingLicense> drivingLicense = new ArrayList<>();

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next())
                drivingLicense.add(DrivingLicense.fromResultSet(rs));
        }

        return drivingLicense;
    }

    @Override
    public Optional<DrivingLicense> findByLicenseNumber(String licenseNumber) throws SQLException {
        String query = "SELECT * FROM driving_license WHERE license_number = ?;";

        Optional<DrivingLicense> drivingLicense = Optional.empty();

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {

            ps.setString(1, licenseNumber);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                drivingLicense = Optional.of(DrivingLicense.fromResultSet(rs));
        }

        return drivingLicense;
    }

    @Override
    public Optional<DrivingLicense> findByUserId(UUID userId) throws SQLException {
        String query = "SELECT * FROM driving_license WHERE user_id = ?;";

        Optional<DrivingLicense> drivingLicense = Optional.empty();

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {

            ps.setString(1, String.valueOf(userId));
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                drivingLicense = Optional.of(DrivingLicense.fromResultSet(rs));
        }

        return drivingLicense;
    }
}
