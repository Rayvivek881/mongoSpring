package com.example.mongomemories.controllers;

import com.example.mongomemories.documents.Post;
import com.example.mongomemories.documents.ResponseMessage;
import com.example.mongomemories.services.PostServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

  private final PostServices postServices;

  @GetMapping("/")
  public String home() {
    return "Welcome to Mongo Memories";
  }

  @PostMapping("/posts")
  public Post createPost(@RequestBody Post post) {
    return postServices.createPost(post);
  }

  @GetMapping("/posts")
  public List<Post> getAllPosts() {
    return postServices.getAllPosts();
  }

  @GetMapping("/posts/{id}")
  public ResponseMessage getPostById(@PathVariable String id) {
    Post post = postServices.getPostById(id);
    if (post == null) {
      return ResponseMessage.builder()
          .message("Post not found").success(false).build();
    }
    return ResponseMessage.builder().data(post).success(true).build();
  }

  @PutMapping("/posts/{id}")
  public ResponseMessage updatePostById(@PathVariable String id, @RequestBody Post post) {
    Post result = postServices.updatePostById(id, post);
    if (result == null) {
      return ResponseMessage.builder()
          .message("Post not found").success(false).build();
    }
    return ResponseMessage.builder().data(result).success(true).build();
  }

  @DeleteMapping("/posts/{id}")
  public void deletePostById(@PathVariable String id) {
    postServices.deletePostById(id);
  }

  @DeleteMapping("/posts")
  public void deleteAllPosts() {
    postServices.deleteAllPosts();
  }
}
