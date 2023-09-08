package model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DrivingLicenseTypology {

    private UUID id;
    private UUID licenseTypoId;
    private UUID drivingLicenseId;

    public String getCsv() {
        return String.join(",", Arrays.asList(
                id.toString(),
                String.valueOf(licenseTypoId),
                drivingLicenseId.toString()
        ));
    }

    public static DrivingLicenseTypology parseCsv(String csv) {
        String[] values = csv.split(",");

        return DrivingLicenseTypology.builder()
                .id(UUID.fromString(values[0]))
                .licenseTypoId(UUID.fromString(values[1]))
                .drivingLicenseId(UUID.fromString(values[2]))
                .build();
    }
}
