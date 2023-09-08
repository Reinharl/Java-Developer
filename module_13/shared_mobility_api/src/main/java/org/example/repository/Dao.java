package org.example.repository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

// dao pattern
public interface Dao<T> {

    boolean save(T t);

    boolean update(T t);

    boolean deleteById(UUID id);

    Optional<T> findById(UUID id);

    Collection<T> findAll();

}
