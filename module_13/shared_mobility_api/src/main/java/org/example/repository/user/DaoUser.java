package org.example.repository.user;

import org.example.model.user.User;
import org.example.repository.Dao;

import java.util.Optional;

public interface DaoUser extends Dao<User> {

    Optional<User> findByTaxCode(String taxCode);
}
