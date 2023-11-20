package com.example.excel.homewok2.services;

import com.example.excel.homewok2.entities.User;
import com.example.excel.homewok2.entities.Vehicle;
import com.example.excel.homewok2.models.VehicleModel;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getAllVehicles();
    Vehicle addVehicle(Vehicle vehicle);

    Vehicle addVehicle(Integer id, VehicleModel vehicleModel);
}