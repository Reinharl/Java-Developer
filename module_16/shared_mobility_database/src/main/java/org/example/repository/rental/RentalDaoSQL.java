package org.example.repository.rental;

import org.example.connection_handler.ConnectionHandler;
import org.example.model.rental.Rental;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RentalDaoSQL implements DaoRental {
    @Override
    public boolean save(Rental rental) throws SQLException {
        String query = "INSERT INTO rental (id, user_id, vehicle_id, start_time, duration) VALUES (?,?,?,?,?);";

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {
            ps.setString(1, String.valueOf(rental.getId()));
            ps.setString(2, String.valueOf(rental.getUserId()));
            ps.setString(3, String.valueOf(rental.getVehicleId()));
            ps.setString(4, String.valueOf(rental.getStartTime()));
            ps.setString(5, String.valueOf(rental.getDuration()));
            int insertedCount = ps.executeUpdate();

            return insertedCount > 0;
        }
    }

    @Override
    public boolean update(Rental rental) throws SQLException {
        String query = "UPDATE rental SET user_id = ?, vehicle_id = ?, start_time = ?, duration = ? WHERE id = ?;";

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {
            ps.setString(1, String.valueOf(rental.getUserId()));
            ps.setString(2, String.valueOf(rental.getVehicleId()));
            ps.setString(3, String.valueOf(rental.getStartTime()));
            ps.setString(4, String.valueOf(rental.getDuration()));
            ps.setString(5, String.valueOf(rental.getId()));
            int insertedCount = ps.executeUpdate();

            return insertedCount > 0;
        }
    }

    @Override
    public boolean deleteById(UUID id) throws SQLException {
        String query = "DELETE FROM rental WHERE id = ?;";

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {

            ps.setString(1, String.valueOf(id));
            int deletedCount = ps.executeUpdate();
            return deletedCount > 0;
        }
    }

    @Override
    public Optional<Rental> findById(UUID id) throws SQLException {
        String query = "SELECT * FROM rental WHERE id = ?;";

        Optional<Rental> rental = Optional.empty();

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {

            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                rental = Optional.of(Rental.fromResultSet(rs));
        }
        return rental;
    }

    @Override
    public List<Rental> findAll() throws SQLException {
        String query = "SELECT * FROM rental;";

        List<Rental> rentals = new ArrayList<>();

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next())
                rentals.add(Rental.fromResultSet(rs));
        }
        return rentals;
    }
}
