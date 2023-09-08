package org.example.controller;

import com.google.gson.*;
import org.example.controller.response.HttpResponse;
import org.example.dto.DrivingLicenseDto;
import org.example.dto.DrivingLicenseTypologyDto;
import org.example.dto.UserDto;
import org.example.service.user.UserService;
import spark.Spark;

import java.time.LocalDate;
import java.util.UUID;
import java.util.logging.Logger;

public class UserController {

    private final Logger logger = Logger.getLogger("USER-CONTROLLER");

    public static Gson gson() {
        return new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, (JsonSerializer<LocalDate>)
                        (localDate, type, jsonSerializationContext) -> new JsonPrimitive(localDate.toString()))
                .registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>)
                        (jsonElement, type, jsonDeserializationContext) -> LocalDate.parse(jsonElement.getAsString()))
                .create();
    }

    public void start(UserService userService) {

        Spark.get("/users/:id", (req, res) -> {
            String paramId = req.params("id");
            res.type("application/json");

            try {
                HttpResponse httpResponse = new HttpResponse("200",
                        gson().toJsonTree(userService.findById(UUID.fromString(paramId))));

                return new Gson().toJson(httpResponse);

            } catch (Exception e) {
                logger.severe(e.getMessage());
                res.status(500);
                return "Internal Server Error";
            }
        });

        Spark.post("/users/", (req, res) -> {
            res.type("application/json");

            try {
                JsonObject jsonObject = gson().fromJson(req.body(), JsonObject.class);
                JsonElement userDtoElement = jsonObject.get("userDto");
                JsonElement drivingLicenseDtoElement = jsonObject.get("drivingLicenseDto");
                JsonElement drivingLicenseTypologyDtoElement = jsonObject.get("drivingLicenseTypologyDto");

                UserDto userDto = gson().fromJson(userDtoElement, UserDto.class);
                DrivingLicenseDto drivingLicenseDto = gson().fromJson(drivingLicenseDtoElement, DrivingLicenseDto.class);
                DrivingLicenseTypologyDto drivingLicenseTypologyDto = gson().fromJson(drivingLicenseTypologyDtoElement, DrivingLicenseTypologyDto.class);

                userService.registerUser(userDto, drivingLicenseDto, drivingLicenseTypologyDto);

                return gson().toJson(HttpResponse.builder()
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
