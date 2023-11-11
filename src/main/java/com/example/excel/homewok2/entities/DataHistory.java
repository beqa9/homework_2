package com.example.excel.homewok2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "exel_history")
public class DataHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double latitude;
    private Double longtitude;
    private String name;
    @Column(name = "created_at")
    private LocalDateTime createdAt;  // or Date createdAt for a Date field

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}