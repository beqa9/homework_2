package com.example.excel.homewok2.repositories;

import com.example.excel.homewok2.entities.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data, Long> {
    boolean existsByLatitudeAndLongitude(Double latitude, Double longitude);

}
