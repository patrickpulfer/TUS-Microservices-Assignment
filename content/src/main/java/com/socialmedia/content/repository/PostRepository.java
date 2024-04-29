package com.socialmedia.content.repository;

import com.socialmedia.content.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Integer> {
}
