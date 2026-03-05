package com.nix.education.persistence.repository;

import com.nix.education.persistence.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {}
