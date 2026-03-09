package com.nix.education.service;

import com.nix.education.persistence.entity.Comment;

public interface CommentService {
  Comment createComment(Comment comment);
  Comment updateComment(String id, Comment comment);
  void deleteComment(String id);
}
