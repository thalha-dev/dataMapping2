package com.learn.newMapping.controllers;

import com.learn.newMapping.entity.CommentEntity;
import com.learn.newMapping.repository.CommentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

  private final CommentRepository commentRepository;

  public CommentController(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  @PostMapping("/comments")
  public ResponseEntity<CommentEntity> createComment(@RequestBody CommentEntity comment) {
    CommentEntity savedComment = commentRepository.save(comment);
    return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
  }
}
