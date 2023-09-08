package model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public String getCsv() {
        return String.join(",",
                id.toString(),
                firstName,
                lastName,
                birthDate != null ? birthDate.toString() : "",
                taxCode,
                drivingLicenseId != null ? drivingLicenseId.toString() : "",
                String.valueOf(hasHelmet),
                String.valueOf(credit));
    }

    public static User parseCsv(String csv) {
        String[] values = csv.split(",");

        return User.builder()
                .id(UUID.fromString(values[0]))
                .firstName(values[1])
                .lastName(values[2])
                .birthDate(LocalDate.parse(values[3]))
                .taxCode(values[4])
                .drivingLicenseId(UUID.fromString(values[5]))
                .hasHelmet(Boolean.parseBoolean(values[6]))
                .credit(Long.parseLong(values[7]))
                .build();
    }

}
