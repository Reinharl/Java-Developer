package org.example.model.vehicle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    private UUID id;
    private GeoCoordinates position;
    private boolean isAvailable;
    private long priceForMinute;
    private String plate;
    private Integer fuelPercentage;
    private UUID licenseTypo;
    private Boolean needHelmet;
    private UUID vehicleTypo;

    public static Vehicle fromResultSet(ResultSet rs) throws SQLException {
        return Vehicle.builder()
                .id(UUID.fromString(rs.getString("id")))
                .position(new GeoCoordinates(rs.getInt("latitude"), rs.getInt("longitude")))
                .isAvailable(rs.getBoolean("is_available"))
                .priceForMinute(rs.getLong("price_for_minute"))
                .plate(rs.getString("plate"))
                .fuelPercentage(rs.getInt("fuel_percentage"))
                .licenseTypo(UUID.fromString(rs.getString("license_typo_id")))
                .needHelmet(rs.getBoolean("need_helmet"))
                .vehicleTypo(UUID.fromString(rs.getString("vehicle_typo_id")))
                .build();
    }

}
