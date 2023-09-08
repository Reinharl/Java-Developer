package org.example.repository.user;

import org.example.model.user.User;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserDaoCsv implements DaoUser {

    private static volatile UserDaoCsv instance;
    private final Path USER_REPOSITORY_PATH = Path.of("module_13", "shared_mobility_api", "src", "main", "java", "org", "example", "csv", "user");
    private Map<UUID, User> userMap;

    private UserDaoCsv() throws IOException {
        userMap = new HashMap<>();

        if (!Files.exists(USER_REPOSITORY_PATH))
            Files.createFile(USER_REPOSITORY_PATH);
        else
            this.userMap.putAll(Files.lines(USER_REPOSITORY_PATH)
                    .map(User::parseCsv)
                    .collect(Collectors.toMap(
                            User::getId,
                            Function.identity()
                    )));
    }

    // singleton pattern
    public static UserDaoCsv getInstance() throws IOException {
        UserDaoCsv result = instance;

        if (result != null) {
            return result;
        }
        synchronized (UserDaoCsv.class) {
            if (instance == null)
                instance = new UserDaoCsv();
            return instance;
        }
    }

    public boolean updateCsv() {
        try (BufferedWriter bw = Files.newBufferedWriter(USER_REPOSITORY_PATH)) {
            for (User u : userMap.values()) {
                bw.write(u.getCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean save(User user) {
        userMap.put(user.getId(), user);
        return userMap.get(user.getId()).equals(user) && updateCsv();
    }

    @Override
    public boolean update(User user) {
        userMap.replace(user.getId(), user);
        return userMap.get(user.getId()).equals(user) && updateCsv();
    }

    @Override
    public boolean deleteById(UUID id) {
        return userMap.remove(id) != null && updateCsv();
    }

    @Override
    public Optional<User> findById(UUID id) {
        return Optional.ofNullable(userMap.get(id));
    }

    @Override
    public Optional<User> findByTaxCode(String taxCode) {
        return userMap.values().stream()
                .filter(user -> user.getTaxCode().equals(taxCode))
                .findFirst();
    }

    @Override
    public Collection<User> findAll() {
        return userMap.values();
    }
}
