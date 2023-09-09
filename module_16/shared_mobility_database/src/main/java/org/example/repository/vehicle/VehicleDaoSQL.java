package org.example.repository.vehicle;

import org.example.connection_handler.ConnectionHandler;
import org.example.model.vehicle.Vehicle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class VehicleDaoSQL implements DaoVehicle {
    @Override
    public boolean save(Vehicle vehicle) throws SQLException {
        String query = "INSERT INTO vehicle (id, latitude, longitude, is_available, price_for_minute, plate, fuel_percentage, license_typo_id, need_helmet, vehicle_typo_id) VALUES (?,?,?,?,?,?,?,?,?,?);";

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {
            ps.setString(1, String.valueOf(vehicle.getId()));
            ps.setInt(2, vehicle.getPosition().getLatitude());
            ps.setInt(3, vehicle.getPosition().getLongitude());
            ps.setBoolean(4, vehicle.isAvailable());
            ps.setLong(5, vehicle.getPriceForMinute());
            ps.setString(6, vehicle.getPlate());
            ps.setInt(7, vehicle.getFuelPercentage());
            ps.setString(8, String.valueOf(vehicle.getLicenseTypo()));
            ps.setBoolean(9, vehicle.getNeedHelmet());
            ps.setString(10, String.valueOf(vehicle.getVehicleTypo()));
            int insertedCount = ps.executeUpdate();

            return insertedCount > 0;
        }
    }

    @Override
    public boolean update(Vehicle vehicle) throws SQLException {
        String query = "UPDATE vehicle SET latitude = ?, longitude = ?, is_available = ?, price_for_minute = ?, plate = ?, fuel_percentage = ?, license_typo_id = ?, need_helmet = ?, vehicle_typo_id = ? WHERE id = ?;";

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {

            ps.setInt(1, vehicle.getPosition().getLatitude());
            ps.setInt(2, vehicle.getPosition().getLongitude());
            ps.setBoolean(3, vehicle.isAvailable());
            ps.setLong(4, vehicle.getPriceForMinute());
            ps.setString(5, vehicle.getPlate());
            ps.setInt(6, vehicle.getFuelPercentage());
            ps.setString(7, String.valueOf(vehicle.getLicenseTypo()));
            ps.setBoolean(8, vehicle.getNeedHelmet());
            ps.setString(9, String.valueOf(vehicle.getVehicleTypo()));
            ps.setString(10, String.valueOf(vehicle.getId()));
            int updatedCount = ps.executeUpdate();

            return updatedCount > 0;
        }
    }

    @Override
    public boolean deleteById(UUID id) throws SQLException {
        String query = "DELETE FROM vehicle WHERE id = ?;";

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {

            ps.setString(1, String.valueOf(id));
            int deletedCount = ps.executeUpdate();
            return deletedCount > 0;
        }
    }

    @Override
    public Optional<Vehicle> findById(UUID id) throws SQLException {
        String query = "SELECT * FROM vehicle WHERE id = ?;";

        Optional<Vehicle> vehicle = Optional.empty();

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {

            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                vehicle = Optional.of(Vehicle.fromResultSet(rs));
        }
        return vehicle;
    }

    @Override
    public List<Vehicle> findAll() throws SQLException {
        String query = "SELECT * FROM vehicle;";

        List<Vehicle> vehicles = new ArrayList<>();

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next())
                vehicles.add(Vehicle.fromResultSet(rs));
        }
        return vehicles;
    }

    @Override
    public Optional<Vehicle> findByPlate(String plate) throws SQLException {
        String query = "SELECT * FROM vehicle WHERE plate = ?;";

        Optional<Vehicle> vehicle = Optional.empty();

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {

            ps.setString(1, plate);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                vehicle = Optional.of(Vehicle.fromResultSet(rs));
        }
        return vehicle;
    }

    @Override
    public List<Vehicle> findByVehicleType(UUID vehicleTypoId) throws SQLException {
        String query = "SELECT * FROM vehicle WHERE vehicle_typo_id = ?;";

        List<Vehicle> vehicles = new ArrayList<>();

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {

            ps.setString(1, String.valueOf(vehicleTypoId));
            ResultSet rs = ps.executeQuery();

            while (rs.next())
                vehicles.add(Vehicle.fromResultSet(rs));
        }
        return vehicles;
    }
}
