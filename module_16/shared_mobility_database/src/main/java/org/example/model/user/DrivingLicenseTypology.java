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
public class DrivingLicenseTypology {

    private UUID id;
    private UUID licenseTypoId;
    private UUID drivingLicenseId;

    public static DrivingLicenseTypology fromResultSet(ResultSet rs) throws SQLException {
        return DrivingLicenseTypology.builder()
                .id(UUID.fromString(rs.getString("id")))
                .licenseTypoId(UUID.fromString(rs.getString("license_typo_id")))
                .drivingLicenseId(UUID.fromString(rs.getString("driving_license_id")))
                .build();
    }
}
