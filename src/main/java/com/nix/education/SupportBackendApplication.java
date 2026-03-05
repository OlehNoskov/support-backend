package com.nix.education;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.nix.education.persistence.repository")
public class SupportBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(SupportBackendApplication.class, args);
  }
}
