package model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Arrays;
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

    public String getCsv() {
        return String.join(",", Arrays.asList(
                id.toString(),
                lastName,
                firstName,
                birthDate != null ? birthDate.toString() : "",
                birthPlace,
                releaseDate != null ? releaseDate.toString() : "",
                expirationDate != null ? expirationDate.toString() : "",
                licenseNumber,
                userId.toString()
        ));
    }

    public static DrivingLicense parseCsv(String csv) {
        String[] values = csv.split(",");

        return DrivingLicense.builder()
                .id(UUID.fromString(values[0]))
                .lastName(values[1])
                .firstName(values[2])
                .birthDate(LocalDate.parse(values[3]))
                .birthPlace(values[4])
                .releaseDate(LocalDate.parse(values[5]))
                .expirationDate(LocalDate.parse(values[6]))
                .licenseNumber(values[7])
                .userId(UUID.fromString(values[8]))
                .build();
    }

}
