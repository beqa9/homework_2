package com.example.excel.homewok2.services;

import com.example.excel.homewok2.entities.User;
import com.example.excel.homewok2.models.UserModel;
import com.example.excel.homewok2.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public User addUser(Integer id, UserModel userModel) {
        User user = new User();
        user.setId(id);
        user.setEmail(userModel.email());
        user.setFirstName(userModel.firstName());
        user.setLastName(userModel.lastName());
        user.setPassword(userModel.password());
        userRepository.save(user);
        return user;
    }
}