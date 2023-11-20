package com.example.excel.homewok2.models;

import lombok.Builder;

@Builder
public record VehicleModel(
        Integer id,
        String registrationNumber,
        String driverName,
        String vehicleType,
        Double length,
        Double width,
        Double height,
        Double capacity,
        boolean status
) {
}