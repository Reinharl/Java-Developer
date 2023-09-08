package org.example.service.user;

import org.example.dto.DrivingLicenseDto;
import org.example.dto.DrivingLicenseTypologyDto;
import org.example.dto.UserDto;
import org.example.exception.GenericException;
import org.example.model.user.DrivingLicense;
import org.example.model.user.DrivingLicenseTypology;
import org.example.model.user.User;
import org.example.repository.driving_license.DaoDrivingLicense;
import org.example.repository.driving_license.DrivingLicenseDaoCsv;
import org.example.repository.driving_license_typology.DaoDrivingLicenseTypology;
import org.example.repository.driving_license_typology.DrivingLicenseTypologyDaoCsv;
import org.example.repository.license_typo.DaoLicenseTypo;
import org.example.repository.license_typo.LicenseTypoDaoCsv;
import org.example.repository.user.DaoUser;
import org.example.repository.user.UserDaoCsv;

import java.io.IOException;
import java.util.UUID;
import java.util.logging.Logger;

public class UserServiceImpl implements UserService {
    private final Logger logger = Logger.getLogger("USER-SERVICE");
    private final DaoUser userRepository;
    private final DaoDrivingLicense drivingLicenseRepository;
    private final DaoLicenseTypo typologyRepository;
    private final DaoDrivingLicenseTypology drivingLicenseTypologyRepository;

    public UserServiceImpl() throws IOException {
        userRepository = UserDaoCsv.getInstance();
        drivingLicenseRepository = DrivingLicenseDaoCsv.getInstance();
        typologyRepository = LicenseTypoDaoCsv.getInstance();
        drivingLicenseTypologyRepository = DrivingLicenseTypologyDaoCsv.getInstance();
    }

    @Override
    public User findById(UUID id) throws GenericException {
        return userRepository.findById(id).orElseThrow(() -> new GenericException("User not found"));
    }

    @Override
    public void registerUser(UserDto userDto, DrivingLicenseDto drivingLicenseDto, DrivingLicenseTypologyDto drivingLicenseTypologyDto)
            throws GenericException {

        if (userRepository.findByTaxCode(userDto.getTaxCode()).isPresent())
            throw new GenericException("User already registered");

        if (drivingLicenseRepository.findByLicenseNumber(drivingLicenseDto.getLicenseNumber()).isPresent())
            throw new GenericException("License number already exist");

        User user = User.builder()
                .id(UUID.randomUUID())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .birthDate(userDto.getBirthDate())
                .taxCode(userDto.getTaxCode())
                .hasHelmet(userDto.isHasHelmet())
                .credit(0L)
                .build();

        DrivingLicense drivingLicense = DrivingLicense.builder()
                .id(UUID.randomUUID())
                .lastName(drivingLicenseDto.getLastName())
                .firstName(drivingLicenseDto.getFirstName())
                .birthDate(drivingLicenseDto.getBirthDate())
                .birthPlace(drivingLicenseDto.getBirthPlace())
                .releaseDate(drivingLicenseDto.getReleaseDate())
                .expirationDate(drivingLicenseDto.getExpirationDate())
                .licenseNumber(drivingLicenseDto.getLicenseNumber())
                .userId(user.getId())
                .build();

        user.setDrivingLicenseId(drivingLicense.getId());

        for (String s : drivingLicenseTypologyDto.getTypologies()) {
            UUID typologyId = typologyRepository.findIdByName(s)
                    .orElseThrow(() -> new GenericException("Typology: " + s + " not found"));

            DrivingLicenseTypology dlt = DrivingLicenseTypology.builder()
                    .id(UUID.randomUUID())
                    .licenseTypoId(typologyId)
                    .drivingLicenseId(drivingLicense.getId())
                    .build();

            drivingLicenseTypologyRepository.save(dlt);
        }

        userRepository.save(user);
        logger.info("Saved user: " + user);

        drivingLicenseRepository.save(drivingLicense);
        logger.info("Saved driving license: " + drivingLicense);

        //TODO Si può implementare la logica per notificare la corretta registrazione dell'utente tramite il pattern Observer
    }

}
