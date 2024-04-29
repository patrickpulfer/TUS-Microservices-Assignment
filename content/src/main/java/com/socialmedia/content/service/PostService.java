package com.socialmedia.content.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.content.repository.PostRepository;
import com.socialmedia.content.model.Post;

import java.util.List;
import java.util.Optional;


@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> findPostById(int id) {
        return postRepository.findById(id);
    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public void deletePost(int id) {
        postRepository.deleteById(id);
    }
}
