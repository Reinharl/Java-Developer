package service.user;

import dto.DrivingLicenseDto;
import dto.DrivingLicenseTypologyDto;
import dto.UserDto;
import exception.GenericException;
import model.user.DrivingLicense;
import model.user.DrivingLicenseTypology;
import model.user.User;
import repository.driving_license.DaoDrivingLicense;
import repository.driving_license.DrivingLicenseDaoCsv;
import repository.driving_license_typology.DaoDrivingLicenseTypology;
import repository.driving_license_typology.DrivingLicenseTypologyDaoCsv;
import repository.license_typo.DaoLicenseTypo;
import repository.license_typo.LicenseTypoDaoCsv;
import repository.user.DaoUser;
import repository.user.UserDaoCsv;

import java.io.IOException;
import java.util.UUID;

public class UserServiceImpl implements UserService {

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
        System.out.println("Saved user: " + user);

        drivingLicenseRepository.save(drivingLicense);
        System.out.println("Saved driving license: " + drivingLicense);

        //TODO Si può implementare la logica per notificare la corretta registrazione dell'utente tramite il pattern Observer
    }

}
