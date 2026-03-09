package com.nix.education.controller;

import com.nix.education.persistence.entity.Comment;
import com.nix.education.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
public class CommentController {
  private final CommentService commentService;

  @PostMapping("/create")
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
  public Comment create(@RequestBody Comment comment) {
    return commentService.createComment(comment);
  }

  @PutMapping("/update/{commentId}")
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
  public Comment update(@RequestBody Comment comment, @PathVariable("commentId") String commentId) {
    return commentService.updateComment(commentId, comment);
  }

  @DeleteMapping("/delete/{commentId}")
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
  public void delete(@PathVariable("commentId") String commentId) {
    commentService.deleteComment(commentId);
  }
}
