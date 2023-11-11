package com.example.excel.homewok2.services;

import com.example.excel.homewok2.entities.User;
import com.example.excel.homewok2.models.UserModel;

import java.util.List;


public interface UserService {
    List<User> getAllUsers();

    User addUser(User user);

    User addUser(Integer id, UserModel userModel);
}