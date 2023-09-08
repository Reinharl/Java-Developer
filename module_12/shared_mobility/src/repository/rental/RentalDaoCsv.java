package repository.rental;

import model.rental.Rental;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RentalDaoCsv implements DaoRental {

    private static volatile RentalDaoCsv instance;
    private final Path RENTAL_REPOSITORY_PATH = Path.of("module_12", "shared_mobility", "src", "csv", "rental");
    private Map<UUID, Rental> rentalMap;

    private RentalDaoCsv() throws IOException {
        rentalMap = new HashMap<>();

        if (!Files.exists(RENTAL_REPOSITORY_PATH))
            Files.createFile(RENTAL_REPOSITORY_PATH);
        else
            this.rentalMap.putAll(Files.lines(RENTAL_REPOSITORY_PATH)
                    .map(Rental::parseCsv)
                    .collect(Collectors.toMap(
                            Rental::getId,
                            Function.identity()
                    )));
    }

    // singleton pattern
    public static RentalDaoCsv getInstance() throws IOException {
        RentalDaoCsv result = instance;

        if (result != null) {
            return result;
        }
        synchronized (RentalDaoCsv.class) {
            if (instance == null)
                instance = new RentalDaoCsv();
            return instance;
        }
    }

    public boolean updateCsv() {
        try (BufferedWriter bw = Files.newBufferedWriter(RENTAL_REPOSITORY_PATH)) {
            for (Rental r : rentalMap.values()) {
                bw.write(r.getCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean save(Rental rental) {
        rentalMap.put(rental.getId(), rental);
        return rentalMap.get(rental.getId()).equals(rental) && updateCsv();
    }

    @Override
    public boolean update(Rental rental) {
        rentalMap.replace(rental.getId(), rental);
        return rentalMap.get(rental.getId()).equals(rental) && updateCsv();
    }

    @Override
    public boolean deleteById(UUID id) {
        return rentalMap.remove(id) != null && updateCsv();
    }

    @Override
    public Optional<Rental> findById(UUID id) {
        return Optional.ofNullable(rentalMap.get(id));
    }

    @Override
    public Collection<Rental> findAll() {
        return rentalMap.values();
    }
}
