package com.nix.education.service.impl;

import com.nix.education.persistence.entity.User;
import com.nix.education.persistence.repository.UserRepository;
import com.nix.education.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;


  @Override
  public User createUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public User updateUser(String id, User user) {
    User existingUser = userRepository.findById(id).orElse(null);
    if (existingUser != null) {
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setRole(user.getRole());
        return userRepository.save(existingUser);
    }
    return null;
  }

  @Override
  public void deleteUser(String id) {
  userRepository.deleteById(id);
  }

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public User getUserById(String id) {
    return userRepository.findById(id).orElse(null);
  }
}
