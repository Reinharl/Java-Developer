package org.example.repository.user;

import org.example.connection_handler.ConnectionHandler;
import org.example.model.user.User;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserDaoSQL implements DaoUser {

    @Override
    public boolean save(User user) throws SQLException {
        String query = "INSERT INTO _user (id, first_name, last_name, birth_date, tax_code, driving_license_id, has_helmet, credit) VALUES (?,?,?,?,?,?,?,?);";

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {
            ps.setString(1, String.valueOf(user.getId()));
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            ps.setDate(4, Date.valueOf(user.getBirthDate()));
            ps.setString(5, user.getTaxCode());
            ps.setString(6, String.valueOf(user.getDrivingLicenseId()));
            ps.setBoolean(7, user.isHasHelmet());
            ps.setLong(8, user.getCredit());
            int insertedCount = ps.executeUpdate();

            return insertedCount > 0;
        }
    }

    @Override
    public boolean update(User user) throws SQLException {
        String query = "UPDATE _user SET first_name = ?, last_name = ?, birth_date = ?, tax_code = ?, driving_license_id = ?, has_helmet = ?, credit = ? WHERE id = ?;";

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setDate(3, Date.valueOf(user.getBirthDate()));
            ps.setString(4, user.getTaxCode());
            ps.setString(5, String.valueOf(user.getDrivingLicenseId()));
            ps.setBoolean(6, user.isHasHelmet());
            ps.setLong(7, user.getCredit());
            ps.setString(8, String.valueOf(user.getId()));
            int updatedCount = ps.executeUpdate();

            return updatedCount > 0;
        }
    }

    @Override
    public boolean deleteById(UUID id) throws SQLException {
        String query = "DELETE FROM _user WHERE id = ?;";

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {

            ps.setString(1, String.valueOf(id));
            int deletedCount = ps.executeUpdate();
            return deletedCount > 0;
        }
    }

    @Override
    public Optional<User> findById(UUID id) throws SQLException {
        String query = "SELECT * FROM _user WHERE id = ?;";

        Optional<User> user = Optional.empty();

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {

            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                user = Optional.of(User.fromResultSet(rs));
        }
        return user;
    }

    @Override
    public List<User> findAll() throws SQLException {
        String query = "SELECT * FROM _user;";

        List<User> users = new ArrayList<>();

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next())
                users.add(User.fromResultSet(rs));
        }
        return users;
    }

    @Override
    public Optional<User> findByTaxCode(String taxCode) throws SQLException {
        String query = "SELECT * FROM _user WHERE tax_code = ?;";

        Optional<User> user = Optional.empty();

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {

            ps.setString(1, taxCode);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                user = Optional.of(User.fromResultSet(rs));
        }
        return user;
    }
}
