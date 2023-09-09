package org.example.service.user;

import org.example.dto.DrivingLicenseDto;
import org.example.dto.DrivingLicenseTypologyDto;
import org.example.dto.UserDto;
import org.example.exception.GenericException;
import org.example.model.user.User;

import java.sql.SQLException;
import java.util.UUID;

public interface UserService {

    User findById(UUID id) throws SQLException, GenericException;

    void registerUser(UserDto userDto, DrivingLicenseDto drivingLicenseDto, DrivingLicenseTypologyDto drivingLicenseTypologyDto)
            throws SQLException, GenericException;
}
