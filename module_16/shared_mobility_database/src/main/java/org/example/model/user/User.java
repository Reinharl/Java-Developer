package org.example.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String taxCode;
    private UUID drivingLicenseId;
    private boolean hasHelmet;
    private long credit;

    public static User fromResultSet(ResultSet rs) throws SQLException {
        return User.builder()
                .id(UUID.fromString(rs.getString("id")))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .birthDate(LocalDate.parse(rs.getString("birth_date")))
                .taxCode(rs.getString("tax_code"))
                .drivingLicenseId(UUID.fromString(rs.getString("driving_license_id")))
                .hasHelmet(rs.getBoolean("has_helmet"))
                .credit(rs.getLong("credit"))
                .build();
    }

}
