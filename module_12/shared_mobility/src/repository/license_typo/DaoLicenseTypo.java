package repository.license_typo;

import java.util.Optional;
import java.util.UUID;

public interface DaoLicenseTypo {

    Optional<UUID> findIdByName(String name);
}
