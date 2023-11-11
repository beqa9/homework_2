package com.example.excel.homewok2.repositories;

import com.example.excel.homewok2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}