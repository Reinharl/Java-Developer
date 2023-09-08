package org.example.model.vehicle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    private UUID id;
    private GeoCoordinates position;
    private boolean isAvailable;
    private long priceForMinute;
    private String plate;
    private Integer fuelPercentage;
    private UUID licenseTypo;
    private Boolean needHelmet;
    private UUID vehicleTypo;

    public String getCsv() {
        return String.join(",",
                id.toString(),
                position.getCsv(),
                String.valueOf(isAvailable),
                String.valueOf(priceForMinute),
                plate,
                String.valueOf(fuelPercentage),
                licenseTypo.toString(),
                String.valueOf(needHelmet),
                vehicleTypo.toString());
    }

    public static Vehicle parseCsv(String csv) {
        String[] values = csv.split(",");

        return Vehicle.builder()
                .id(UUID.fromString(values[0]))
                .position(GeoCoordinates.parse(values[1]))
                .isAvailable(Boolean.parseBoolean(values[2]))
                .priceForMinute(Long.parseLong(values[3]))
                .plate(values[4])
                .fuelPercentage(Integer.parseInt(values[5]))
                .licenseTypo(UUID.fromString(values[6]))
                .needHelmet(Boolean.parseBoolean(values[7]))
                .vehicleTypo(UUID.fromString(values[8]))
                .build();
    }

}
