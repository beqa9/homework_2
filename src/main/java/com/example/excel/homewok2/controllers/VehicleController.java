package com.example.excel.homewok2.controllers;

import com.example.excel.homewok2.entities.Vehicle;
import com.example.excel.homewok2.models.VehicleModel;
import com.example.excel.homewok2.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicle")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @PostMapping("/{id}")
    public Vehicle addVehicle(@PathVariable Integer id, @RequestBody VehicleModel vehicleModel) {
        return vehicleService.addVehicle(id, vehicleModel);
    }
}