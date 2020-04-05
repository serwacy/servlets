package com.sda.service;

import com.sda.model.User;
import com.sda.repository.UserRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
    private static UserService userService;
    private UserRepository userRepository;

    public static UserService aUserService() {
        if (userService == null) {
            userService = new UserService(UserRepository.aUserRepository());
        }
        return userService;
    }

    public boolean registerUser (final User user) {
        return userRepository.save(user);
//        return true;
    }
}
