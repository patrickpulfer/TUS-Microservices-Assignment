package com.socialmedia.user.controller;

import com.socialmedia.user.service.PostClientService;
import com.socialmedia.user.config.RestClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/external/posts")
public class PostClientController {

    @Autowired
    private PostClientService postClientService;

    @GetMapping
    public ResponseEntity<String> getAllPosts() {
        return ResponseEntity.ok(postClientService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getPostById(@PathVariable int id) {
        return ResponseEntity.ok(postClientService.getPostById(id));
    }

    @PostMapping
    public ResponseEntity<String> createPost(@RequestBody String postJson) {
        return ResponseEntity.ok(postClientService.createPost(postJson));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePost(@PathVariable int id, @RequestBody String postJson) {
        postClientService.updatePost(id, postJson);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable int id) {
        postClientService.deletePost(id);
        return ResponseEntity.ok().build();
    }
}