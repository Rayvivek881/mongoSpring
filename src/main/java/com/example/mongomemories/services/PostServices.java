package com.example.mongomemories.services;

import com.example.mongomemories.documents.Post;
import com.example.mongomemories.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServices {

  private final PostRepository postRepository;

  public Post createPost(Post post) {
    return postRepository.save(post);
  }

  public Post getPostById(String id) {
    return postRepository.findById(id).orElse(null);
  }

  public void deletePostById(String id) {
    postRepository.deleteById(id);
  }

  public Post updatePostById(String _id, Post post) {
    Post postToUpdate = postRepository.findById(_id).orElse(null);
    if (postToUpdate == null) {
      return null;
    }
    if (post.getTitle() != null) {
      postToUpdate.setTitle(post.getTitle());
    }
    if (post.getDescription() != null) {
      postToUpdate.setDescription(post.getDescription());
    }
    return postRepository.save(postToUpdate);
  }

  public void deleteAllPosts() {
    postRepository.deleteAll();
  }

  public List<Post> getAllPosts() {
    return postRepository.findAll();
  }
}
