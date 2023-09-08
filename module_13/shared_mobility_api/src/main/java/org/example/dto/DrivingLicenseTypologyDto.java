package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class DrivingLicenseTypologyDto {

    @NonNull
    private List<String> typologies;

}
