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
public class VehicleTypo {

    private UUID id;
    private String name;

    public static VehicleTypo fromResultSet(ResultSet rs) throws SQLException {
        return VehicleTypo.builder()
                .id(UUID.fromString(rs.getString("id")))
                .name(rs.getString("name"))
                .build();
    }
}
