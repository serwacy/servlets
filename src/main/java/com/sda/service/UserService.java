package com.sda.service;

import com.sda.model.User;
import com.sda.repository.UserRepository;
import com.sda.request.EditUserRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

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
    }

    public String loginUser (final String login, final String password) {
        final Optional<User> user = userRepository.getUserByLogin(login);
        if(user.isPresent()) {
            if(user.get().getPassword().equals(password)) {
                return "correctInput";
            } else {
                return "wrongPassword";
            }
        } else {
            return "noSuchLogin";
        }
    }

    public User getUserByLogin (final String login) {
        return userRepository.getUserByLogin(login).get();
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public void updateUser(final EditUserRequest request){
        userRepository.update(request);
    }
}
