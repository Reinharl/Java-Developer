package org.example.repository.driving_license_typology;

import org.example.connection_handler.ConnectionHandler;
import org.example.model.user.DrivingLicenseTypology;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DrivingLicenseTypologyDaoSQL implements DaoDrivingLicenseTypology {
    @Override
    public boolean save(DrivingLicenseTypology drivingLicenseTypology) throws SQLException {
        String query = "INSERT INTO driving_license_typology (id, license_typo_id, driving_license_id) VALUES (?, ?, ?);";

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {

            ps.setString(1, String.valueOf(drivingLicenseTypology.getId()));
            ps.setString(2, String.valueOf(drivingLicenseTypology.getLicenseTypoId()));
            ps.setString(3, String.valueOf(drivingLicenseTypology.getDrivingLicenseId()));
            int insertedCount = ps.executeUpdate();

            return insertedCount > 0;
        }
    }

    @Override
    public boolean update(DrivingLicenseTypology drivingLicenseTypology) throws SQLException {
        String query = "UPDATE driving_license_typology SET license_typo_id = ?, driving_license_id = ? WHERE id = ?;";

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {

            ps.setString(1, String.valueOf(drivingLicenseTypology.getLicenseTypoId()));
            ps.setString(2, String.valueOf(drivingLicenseTypology.getDrivingLicenseId()));
            ps.setString(3, String.valueOf(drivingLicenseTypology.getId()));
            int updatedCount = ps.executeUpdate();

            return updatedCount > 0;
        }
    }

    @Override
    public boolean deleteById(UUID id) throws SQLException {
        String query = "DELETE FROM driving_license_typology WHERE id = ?;";

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {

            ps.setString(1, String.valueOf(id));
            int deletedCount = ps.executeUpdate();

            return deletedCount > 0;
        }
    }

    @Override
    public Optional<DrivingLicenseTypology> findById(UUID id) throws SQLException {
        String query = "SELECT * FROM driving_license_typology WHERE id = ?;";

        Optional<DrivingLicenseTypology> drivingLicenseTypology = Optional.empty();

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {

            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                drivingLicenseTypology = Optional.of(DrivingLicenseTypology.fromResultSet(rs));

        }

        return drivingLicenseTypology;
    }

    @Override
    public List<DrivingLicenseTypology> findAll() throws SQLException {
        String query = "SELECT * FROM driving_license_typology;";

        List<DrivingLicenseTypology> drivingLicenseTypologies = new ArrayList<>();

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next())
                drivingLicenseTypologies.add(DrivingLicenseTypology.fromResultSet(rs));
        }

        return drivingLicenseTypologies;
    }

    @Override
    public List<DrivingLicenseTypology> findAllByDrivingLicenseId(UUID id) throws SQLException {
        String query = "SELECT * FROM driving_license_typology WHERE driving_license_id = ?;";

        List<DrivingLicenseTypology> drivingLicenseTypologies = new ArrayList<>();

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {

            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();

            while (rs.next())
                drivingLicenseTypologies.add(DrivingLicenseTypology.fromResultSet(rs));
        }

        return drivingLicenseTypologies;
    }
}
