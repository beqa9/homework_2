package com.example.excel.homewok2.repositories;

import com.example.excel.homewok2.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    Optional<Vehicle> findByRegistrationNumber(String registrationNumber);
}
