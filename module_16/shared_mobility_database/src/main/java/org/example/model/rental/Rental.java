package org.example.model.rental;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
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

    public static Rental fromResultSet(ResultSet rs) throws SQLException {
        return Rental.builder()
                .id(UUID.fromString(rs.getString("id")))
                .userId(UUID.fromString(rs.getString("user_id")))
                .vehicleId(UUID.fromString(rs.getString("vehicle_id")))
                .startTime(LocalDateTime.parse(rs.getString("start_time")))
                .duration(Duration.parse(rs.getString("duration")))
                .build();
    }
}
