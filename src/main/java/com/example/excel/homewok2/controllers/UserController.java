package com.example.excel.homewok2.controllers;

import com.example.excel.homewok2.entities.User;
import com.example.excel.homewok2.models.UserModel;
import com.example.excel.homewok2.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/{id}")
    public User addUser(@PathVariable Integer id, @RequestBody UserModel userModel) {
        return userService.addUser(id, userModel);
    }
}