package com.nix.education.service;

import com.nix.education.persistence.entity.Comment;

import java.util.List;

public interface CommentService {
  Comment createComment(Comment comment);
  Comment updateComment(String id, Comment comment);
  void deleteComment(String id);
  List<Comment> getAllComments();
  Comment getCommentById(String id);
}
