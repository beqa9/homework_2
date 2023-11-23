package com.example.excel.homewok2.models;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record DataModel(
        Double latitude,
        Double longitude,
        String name,
        LocalDateTime createdAt
) {
}
