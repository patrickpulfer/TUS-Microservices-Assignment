package com.socialmedia.content.model;

import jakarta.persistence.*;


@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user", nullable = false)
    private int userId;

    @Column(name = "post", length = 1000)
    private String postContent;


    public Post() {
    }

    public Post(int userId, String postContent) {
        this.userId = userId;
        this.postContent = postContent;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
}
