package dto;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DrivingLicenseDto {

    @NonNull
    private String lastName;

    @NonNull
    private String firstName;

    @NonNull
    private LocalDate birthDate;

    @NonNull
    private String birthPlace;

    @NonNull
    private LocalDate releaseDate;

    @NonNull
    private LocalDate expirationDate;

    @NonNull
    private String licenseNumber;
}
