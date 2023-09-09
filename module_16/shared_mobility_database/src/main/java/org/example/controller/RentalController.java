package org.example.controller;

import com.google.gson.Gson;
import org.example.controller.response.HttpResponse;
import org.example.service.rental.RentalService;
import spark.Spark;

import java.util.UUID;
import java.util.logging.Logger;

public class RentalController {

    private final Logger logger = Logger.getLogger("RENTAL-CONTROLLER");

    public void start(RentalService rentalService) {
        Spark.post("/rentals/:userId/:vehicleId", (req, res) -> {
            res.type("application/json");

            String userId = req.params("userId");
            String vehicleId = req.params("vehicleId");

            try {
                rentalService.start(UUID.fromString(userId), UUID.fromString(vehicleId));

                return new Gson().toJson(HttpResponse.builder()
                        .statusResponse("200")
                        .build());
            } catch (Exception e) {
                e.printStackTrace();
                logger.severe(e.getMessage());
                res.status(500);
                return "Internal Server Error";
            }
        });

        Spark.post("/rentals/:rentalId", (req, res) -> {
            res.type("application/json");

            String rentalId = req.params("rentalId");

            try {
                rentalService.end(UUID.fromString(rentalId));

                return new Gson().toJson(HttpResponse.builder()
                        .statusResponse("200")
                        .build());
            } catch (Exception e) {
                logger.severe(e.getMessage());
                res.status(500);
                return "Internal Server Error";
            }
        });
    }
}
