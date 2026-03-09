package com.nix.education.controller;

import com.nix.education.persistence.entity.User;
import com.nix.education.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
  private final UserService userService;

  @PostMapping("/create")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public User create(@RequestBody User user) {
    return userService.createUser(user);
  }

  @PutMapping("/update/{userId}")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public User update(@RequestBody User user, @PathVariable("userId") String userId) {
    return userService.updateUser(userId, user);
  }

  @DeleteMapping("/delete/{userId}")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public void update(@PathVariable("userId") String userId) {
    userService.deleteUser(userId);
  }

  @GetMapping("/all")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public List<User> allUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/{userId}")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public User getUserById(@PathVariable("userId") String userId) {
    return userService.getUserById(userId);
  }
}
