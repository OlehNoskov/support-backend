package com.nix.education.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class Test {

  @GetMapping
  @RequestMapping("/all")
  public List<String> getAllLabels() {
    return List.of("Test");
  }
}
