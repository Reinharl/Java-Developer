package org.example.service.rental;

import org.example.exception.GenericException;

import java.util.UUID;

public interface RentalService {

    void start(UUID userId, UUID vehicleId) throws GenericException;

    void end(UUID rentalId) throws GenericException;
}
