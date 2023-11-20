package com.example.excel.homewok2.services;

import com.example.excel.homewok2.entities.Data;
import com.example.excel.homewok2.entities.Vehicle;
import com.example.excel.homewok2.models.VehicleModel;
import com.example.excel.homewok2.repositories.DataRepository;
import com.example.excel.homewok2.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final DataRepository dataRepository;


    public VehicleServiceImpl(VehicleRepository vehicleRepository, DataRepository dataRepository) {
        this.vehicleRepository = vehicleRepository;
        this.dataRepository=dataRepository;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle addVehicle(Integer id, VehicleModel vehicleModel) {
        Optional<Integer> exelIdOptional = getExelIdForRegistrationNumber(vehicleModel.registrationNumber());

        if (exelIdOptional.isPresent()) {
            Integer exelId = exelIdOptional.get();

            String updatedRegistrationNumber = exelId.toString();

            Vehicle vehicle = new Vehicle();
            vehicle.setId(id);
            vehicle.setRegistrationNumber(updatedRegistrationNumber);
            vehicle.setDriverName(vehicleModel.driverName());
            vehicle.setVehicleType(vehicleModel.vehicleType());
            vehicle.setLength(vehicleModel.length());
            vehicle.setWidth(vehicleModel.width());
            vehicle.setHeight(vehicleModel.height());
            vehicle.setCapacity(vehicleModel.capacity());
            vehicle.setStatus(vehicleModel.status());

            return vehicleRepository.save(vehicle);
        } else {
            return null;
        }
    }

    private Optional<Integer> getExelIdForRegistrationNumber(String registrationNumber) {
        return dataRepository.findByName(registrationNumber)
                .map(Data::getId);
    }
}