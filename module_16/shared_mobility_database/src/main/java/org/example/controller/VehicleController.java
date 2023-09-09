package org.example.controller;

import com.google.gson.Gson;
import org.example.controller.response.HttpResponse;
import org.example.dto.VehicleDto;
import org.example.model.vehicle.Vehicle;
import org.example.service.vehicle.VehicleService;
import spark.Spark;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public class VehicleController {

    private final Logger logger = Logger.getLogger("VEHICLE-SERVICE");

    public void start(VehicleService vehicleService) {

        Spark.post("/vehicles/", (req, res) -> {
            res.type("application/json");

            try {
                VehicleDto vehicleDto = new Gson().fromJson(req.body(), VehicleDto.class);

                vehicleService.save(vehicleDto);
                return new Gson().toJson(HttpResponse.builder()
                        .statusResponse("200")
                        .build());

            } catch (Exception e) {
                logger.severe(e.getMessage());
                res.status(500);
                return "Internal Server Error";
            }
        });

        Spark.get("/vehicles/:vehicleTypeId", (req, res) -> {
            res.type("application/json");

            String vehicleTypeId = req.params("vehicleTypeId");

            try {
                List<Vehicle> vehicles = vehicleService.findByVehicleType(UUID.fromString(vehicleTypeId));

                return new Gson().toJson(HttpResponse.builder()
                        .statusResponse("200")
                        .data(new Gson().toJsonTree(vehicles))
                        .build());

            } catch (Exception e) {
                logger.severe(e.getMessage());
                res.status(500);
                return "Internal Server Error";
            }
        });
    }
}
