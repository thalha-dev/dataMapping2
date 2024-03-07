package com.learn.newMapping.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.newMapping.entity.UserEntity;
import com.learn.newMapping.repository.UserRepository;

@RestController
public class UserController {

  private final UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostMapping("/users")
  public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
    UserEntity savedUser = userRepository.save(user);
    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
  }

  @GetMapping("/users/{userId}")
  public ResponseEntity<UserEntity> getUser(@PathVariable Long userId) {
    Optional<UserEntity> user = userRepository.findById(userId);
    if (user.isPresent()) {
      return new ResponseEntity<>(user.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
