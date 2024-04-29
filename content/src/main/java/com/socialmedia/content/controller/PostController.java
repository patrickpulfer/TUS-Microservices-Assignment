package com.socialmedia.content.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.socialmedia.content.model.Post;
import com.socialmedia.content.service.PostService;

import java.util.List;


@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.findAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable int id) {
        return postService.findPostById(id).orElse(null);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.savePost(post);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable int id, @RequestBody Post post) {
        return postService.findPostById(id)
                .map(existingPost -> {
                    existingPost.setUserId(post.getUserId());
                    existingPost.setPostContent(post.getPostContent());
                    return postService.savePost(existingPost);
                })
                .orElseGet(() -> {
                    post.setId(id);
                    return postService.savePost(post);
                });
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id) {
        postService.deletePost(id);
    }
}
