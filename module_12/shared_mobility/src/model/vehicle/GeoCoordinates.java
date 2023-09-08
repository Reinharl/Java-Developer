package model.vehicle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeoCoordinates {

    private int latitude;
    private int longitude;

    public String getCsv() {
        return String.join("-",
                String.valueOf(latitude),
                String.valueOf(longitude));
    }

    public static GeoCoordinates parse(String s) {
        String[] values = s.split("-");

        return GeoCoordinates.builder()
                .latitude(Integer.parseInt(values[0]))
                .longitude(Integer.parseInt(values[1]))
                .build();
    }
}
