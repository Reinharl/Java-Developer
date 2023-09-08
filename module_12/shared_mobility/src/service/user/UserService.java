package service.user;

import dto.DrivingLicenseDto;
import dto.DrivingLicenseTypologyDto;
import dto.UserDto;
import exception.*;
import model.user.User;

import java.io.IOException;
import java.util.UUID;

public interface UserService {

    User findById(UUID id) throws IOException, GenericException;

    void registerUser(UserDto userDto, DrivingLicenseDto drivingLicenseDto, DrivingLicenseTypologyDto drivingLicenseTypologyDto)
            throws IOException, GenericException;
}
