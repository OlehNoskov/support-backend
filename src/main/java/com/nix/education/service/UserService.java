package com.nix.education.service;

import com.nix.education.persistence.entity.User;

import java.util.List;

public interface UserService {
  User createUser(User user);
  User updateUser(String id, User user);
  void deleteUser(String id);
  List<User> getAllUsers();
  User getUserById(String id);
}
