package com.example.excel.homewok2.repositories;

import com.example.excel.homewok2.entities.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DataRepository extends JpaRepository<Data, Long> {
    boolean existsByLatitudeAndLongitude(Double latitude, Double longitude);
    boolean existsByLatitudeAndLongitudeAndName(Double latitude, Double longitude, String name);
    Optional<Data> findByName(String name);

}
