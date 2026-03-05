package com.nix.education.controller;

import com.nix.education.persistence.entity.Comment;
import com.nix.education.service.CommentService;
import lombok.AllArgsConstructor;
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
@RequestMapping("/comments")
@AllArgsConstructor
public class CommentController {
  private final CommentService commentService;

  @PostMapping
  @RequestMapping("/create")
  public Comment create(@RequestBody Comment comment) {
    return commentService.createComment(comment);
  }

  @PutMapping
  @RequestMapping("/update/{commentId}")
  public Comment update(@RequestBody Comment comment, @PathVariable("commentId") String commentId) {
    return commentService.updateComment(commentId, comment);
  }

  @DeleteMapping
  @RequestMapping("/delete/{commentId}")
  public void delete(@PathVariable("commentId") String commentId) {
    commentService.deleteComment(commentId);
  }

  @GetMapping
  @RequestMapping("/all")
  public List<Comment> allComments() {
    return commentService.getAllComments();
  }

  @GetMapping
  @RequestMapping("/{commentId}")
  public Comment getCommentById(@PathVariable("commentId") String commentId) {
    return commentService.getCommentById(commentId);
  }
}
