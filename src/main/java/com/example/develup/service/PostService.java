package com.example.develup.service;

import com.example.develup.entity.Post;
import com.example.develup.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Long id){
        return postRepository.findById(id);
    }

    public Post updatePost(Long id, Post newPostData) {
        return postRepository.findById(id).map(post -> {
            post.setTitle(newPostData.getTitle());
            post.setContent(newPostData.getContent());
            post.setUpdatedAt(LocalDateTime.now());
            return postRepository.save(post);
        }).orElseThrow(() -> new RuntimeException("Post not found with id" + id));
    }
}
