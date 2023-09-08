package service.user;

import exception.GenericException;
import model.user.DrivingLicense;

import java.io.IOException;
import java.util.UUID;

public interface DrivingLicenseService {

    DrivingLicense findById(UUID id) throws IOException, GenericException;
}
