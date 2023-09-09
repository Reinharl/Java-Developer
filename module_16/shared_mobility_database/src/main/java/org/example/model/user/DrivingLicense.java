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
public class DrivingLicense {

    private UUID id;
    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    private String birthPlace;
    private LocalDate releaseDate;
    private LocalDate expirationDate;
    private String licenseNumber;
    private UUID userId;

    public static DrivingLicense fromResultSet(ResultSet rs) throws SQLException {
        return DrivingLicense.builder()
                .id(UUID.fromString(rs.getString("id")))
                .lastName(rs.getString("last_name"))
                .firstName(rs.getString("first_name"))
                .birthDate(LocalDate.parse(rs.getString("birth_date")))
                .birthPlace(rs.getString("birth_place"))
                .releaseDate(LocalDate.parse(rs.getString("release_date")))
                .expirationDate(LocalDate.parse(rs.getString("expiration_date")))
                .licenseNumber(rs.getString("license_number"))
                .userId(UUID.fromString(rs.getString("user_id")))
                .build();
    }

}
