package com.nix.education.persistence.repository;

import com.nix.education.persistence.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {}
