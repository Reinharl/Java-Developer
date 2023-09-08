package org.example.repository.vehicle_typo;

import java.util.Optional;
import java.util.UUID;

public interface DaoVehicleTypo {

    Optional<UUID> findIdByName(String name);
}
