package org.example.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// dao pattern
public interface Dao<T> {

    boolean save(T t) throws SQLException;

    boolean update(T t) throws SQLException;

    boolean deleteById(UUID id) throws SQLException;

    Optional<T> findById(UUID id) throws SQLException;

    List<T> findAll() throws SQLException;

}
