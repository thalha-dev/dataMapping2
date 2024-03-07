package com.learn.newMapping.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.newMapping.entity.BlogEntity;
import com.learn.newMapping.repository.BlogRepository;

@RestController
public class BlogController {

  private final BlogRepository blogRepository;

  public BlogController(BlogRepository blogRepository) {
    this.blogRepository = blogRepository;
  }

  @PostMapping("/blogs")
  public ResponseEntity<BlogEntity> createBlog(@RequestBody BlogEntity blog) {
    BlogEntity savedBlog = blogRepository.save(blog);
    return new ResponseEntity<>(savedBlog, HttpStatus.CREATED);
  }

  @GetMapping("/blogs/{blogId}")
  public ResponseEntity<BlogEntity> getBlog(@PathVariable Long blogId) {
    Optional<BlogEntity> blog = blogRepository.findById(blogId);
    if (blog.isPresent()) {
      return new ResponseEntity<>(blog.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/blogs")
  public ResponseEntity<List<BlogEntity>> getAllBlogs() {
    List<BlogEntity> blogs = blogRepository.findAll();
    return new ResponseEntity<>(blogs, HttpStatus.OK);
  }
}
