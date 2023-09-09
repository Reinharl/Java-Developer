package org.example.service.rental;

import org.example.exception.GenericException;

import java.sql.SQLException;
import java.util.UUID;

public interface RentalService {

    void start(UUID userId, UUID vehicleId) throws GenericException, SQLException;

    void end(UUID rentalId) throws GenericException, SQLException;
}
