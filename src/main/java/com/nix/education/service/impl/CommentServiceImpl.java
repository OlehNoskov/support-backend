package com.nix.education.service.impl;

import com.nix.education.persistence.entity.Comment;
import com.nix.education.persistence.repository.CommentRepository;
import com.nix.education.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
  private final CommentRepository commentRepository;

  @Override
  public Comment createComment(Comment comment) {
    comment.setCreatedDate(new Date());
    return commentRepository.save(comment);
  }

  @Override
  public Comment updateComment(String id, Comment comment) {
    Comment existingComment = commentRepository.findById(id).orElse(null);
    if (existingComment != null) {
      existingComment.setText(comment.getText());
      return commentRepository.save(existingComment);
    }
    return null;
  }

  @Override
  public void deleteComment(String id) {
    commentRepository.deleteById(id);
  }
}
