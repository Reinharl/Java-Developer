package service.user;

import exception.GenericException;
import model.user.DrivingLicense;
import repository.driving_license.DaoDrivingLicense;
import repository.driving_license.DrivingLicenseDaoCsv;

import java.io.IOException;
import java.util.UUID;

public class DrivingLicenseServiceImpl implements DrivingLicenseService {


    DaoDrivingLicense drivingLicenseRepository;

    public DrivingLicenseServiceImpl() throws IOException {
        drivingLicenseRepository = DrivingLicenseDaoCsv.getInstance();
    }

    @Override
    public DrivingLicense findById(UUID id) throws GenericException {
        return drivingLicenseRepository.findById(id)
                .orElseThrow(() -> new GenericException("Driving license not found"));
    }
}
