package com.socialmedia.user.controller;

import com.socialmedia.user.model.User;
import com.socialmedia.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/")
public class UserController
{
    @Autowired
    private UserRepository userRepository;

    @GetMapping(name = "root", value="/")
    public String identifySelf(){
        return System.getProperty("program.name");
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
