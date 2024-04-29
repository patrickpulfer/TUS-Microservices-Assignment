package com.socialmedia.user.service;

import com.socialmedia.user.config.RestClientConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class PostClientService {

    private static final String BASE_URL = "http://localhost:8090/api/posts";

    @Autowired
    private RestTemplate restTemplate;

    public String getAllPosts() {
        return restTemplate.getForObject(BASE_URL, String.class);
    }

    public String getPostById(int id) {
        return restTemplate.getForObject(BASE_URL + "/" + id, String.class);
    }

    public String createPost(String postJson) {
        return restTemplate.postForObject(BASE_URL, postJson, String.class);
    }

    public void updatePost(int id, String postJson) {
        restTemplate.put(BASE_URL + "/" + id, postJson);
    }

    public void deletePost(int id) {
        restTemplate.delete(BASE_URL + "/" + id);
    }
}