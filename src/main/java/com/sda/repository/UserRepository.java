package com.sda.repository;

import com.sda.model.User;
import com.sda.request.EditUserRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRepository {
   private static UserRepository userRepository;
   private List<User> users;

   public static UserRepository aUserRepository() {
      if (userRepository == null) {
         userRepository = new UserRepository(new ArrayList<>());
      }
      return userRepository;
   }

   public boolean save(final User user) {
      final Optional<User> existingUser =
              users.stream().filter(u -> u.getLogin().equals(user.getLogin())).findAny();
      if (existingUser.isPresent()) {
         return false;
      }
      users.add(user);
      return true;
   }

   public Optional<User> getUserByLogin(final String login) {
      return users.stream().filter(user -> user.getLogin().equals(login)).findFirst();
   }

   public List<User> getAll() {
      return Collections.unmodifiableList(users);
   }

   public void update(final EditUserRequest request) {
      if(!request.getName().isEmpty() && !request.getName().equals("Enter new name")){
         getUserByLogin(request.getLogin()).get().setName(request.getName());
      }
      if(!request.getSurname().isEmpty() && !request.getSurname().equals("Enter new surname")){
         getUserByLogin(request.getLogin()).get().setSurname(request.getSurname());
      }
   }
}
