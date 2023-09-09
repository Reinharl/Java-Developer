package org.example.model.user;

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
public class LicenseTypo {

    private UUID id;
    private String name;

    public static LicenseTypo fromResultSet(ResultSet rs) throws SQLException {
        return LicenseTypo.builder()
                .id(UUID.fromString(rs.getString("id")))
                .name(rs.getString("name"))
                .build();
    }
}
