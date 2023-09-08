package org.example;

import org.example.controller.RentalController;
import org.example.controller.UserController;
import org.example.controller.VehicleController;
import org.example.service.rental.RentalService;
import org.example.service.rental.RentalServiceImpl;
import org.example.service.user.UserService;
import org.example.service.user.UserServiceImpl;
import org.example.service.vehicle.VehicleService;
import org.example.service.vehicle.VehicleServiceImpl;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        UserService userService = new UserServiceImpl();
        VehicleService vehicleService = new VehicleServiceImpl();
        RentalService rentalService = new RentalServiceImpl();

        UserController userController = new UserController();
        userController.start(userService);

        VehicleController vehicleController = new VehicleController();
        vehicleController.start(vehicleService);

        RentalController rentalController = new RentalController();
        rentalController.start(rentalService);
    }

}
