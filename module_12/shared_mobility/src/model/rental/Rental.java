package model.rental;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rental {

    private UUID id;
    private UUID userId;
    private UUID vehicleId;
    private LocalDateTime startTime;
    private Duration duration;

    public static Rental parseCsv(String csv) {
        String[] values = csv.split(",");

        return Rental.builder()
                .id(UUID.fromString(values[0]))
                .userId(UUID.fromString(values[1]))
                .vehicleId(UUID.fromString(values[2]))
                .duration(Duration.parse(values[3]))
                .startTime(LocalDateTime.parse(values[4]))
                .build();
    }

    public String getCsv() {
        return String.join(",",
                id.toString(),
                userId.toString(),
                vehicleId.toString(),
                duration != null ? duration.toString() : "",
                startTime != null ? startTime.toString() : ""
        );
    }
}
