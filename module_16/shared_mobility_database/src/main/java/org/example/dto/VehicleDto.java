package org.example.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto {

    @NonNull
    private int latitude;

    @NonNull
    private int longitude;

    @NonNull
    private boolean isAvailable;

    @NonNull
    private long priceForMinute;

    @NonNull
    private String plate;

    @NonNull
    private int fuelPercentage;

    @NonNull
    private String licenseTypology;

    @NonNull
    private boolean needHelmet;

    @NonNull
    private String vehicleTypo;
}
