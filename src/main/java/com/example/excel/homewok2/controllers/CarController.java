package com.example.excel.homewok2.controllers;

import com.example.excel.homewok2.entities.Data;
import com.example.excel.homewok2.entities.DataHistory;
import com.example.excel.homewok2.entities.Vehicle;
import com.example.excel.homewok2.repositories.VehicleRepository;
import com.example.excel.homewok2.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/car")
public class CarController {
    private final DataService dataService;
    private final VehicleRepository vehicleRepository;


    @Autowired
    public CarController(DataService dataService,VehicleRepository vehicleRepository) {
        this.dataService = dataService;
        this.vehicleRepository=vehicleRepository;
    }

    @PostMapping("/coordinates")
    public ResponseEntity<String> saveCarCoordinates(
            @RequestParam("carNumber") String carNumber,
            @RequestParam("latitude") Double latitude,
            @RequestParam("longitude") Double longitude) {
        try {
            // Check if carNumber exists in the VehicleRepository
            Optional<Vehicle> matchingVehicle = vehicleRepository.findByRegistrationNumber(carNumber);

            if (matchingVehicle.isPresent()) {
                // If the carNumber exists, use the corresponding ID
                Integer vehicleId = matchingVehicle.get().getId();

                // Save to Data repository using the vehicleId as the name
                Data data = new Data();
                data.setLatitude(latitude);
                data.setLongitude(longitude);
                data.setName(vehicleId.toString());

                DataHistory dataHistory = new DataHistory();
                dataHistory.setLatitude(latitude);
                dataHistory.setLongitude(longitude);
                dataHistory.setName(vehicleId.toString());

                dataService.saveToDatabase(data);
                dataService.saveToHistoryDatabase(dataHistory);

                return ResponseEntity.ok("Coordinates for car " + carNumber + " saved successfully with ID: " + vehicleId);
            } else {
                // If the carNumber doesn't exist in VehicleRepository, proceed with the original name
                Data data = new Data();
                data.setLatitude(latitude);
                data.setLongitude(longitude);
                data.setName(carNumber);

                DataHistory dataHistory = new DataHistory();
                dataHistory.setLatitude(latitude);
                dataHistory.setLongitude(longitude);
                dataHistory.setName(carNumber);

                dataService.saveToDatabase(data);
                dataService.saveToHistoryDatabase(dataHistory);

                return ResponseEntity.ok("Coordinates for car " + carNumber + " saved successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while saving car coordinates.");
        }
    }
}

