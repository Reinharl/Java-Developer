package repository.user;

import model.user.User;
import repository.Dao;

import java.util.Optional;

public interface DaoUser extends Dao<User> {

    Optional<User> findByTaxCode(String taxCode);
}
