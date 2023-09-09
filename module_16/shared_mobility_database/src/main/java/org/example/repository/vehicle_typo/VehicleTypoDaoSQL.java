package org.example.repository.vehicle_typo;

import org.example.connection_handler.ConnectionHandler;
import org.example.model.vehicle.VehicleTypo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class VehicleTypoDaoSQL implements DaoVehicleTypo {
    @Override
    public Optional<VehicleTypo> findByName(String name) throws SQLException {
        String query = "SELECT * FROM vehicle_typo WHERE name = ?;";

        Optional<VehicleTypo> vehicleTypo = Optional.empty();

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {

            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                vehicleTypo = Optional.of(VehicleTypo.fromResultSet(rs));

        }

        return vehicleTypo;
    }
}
