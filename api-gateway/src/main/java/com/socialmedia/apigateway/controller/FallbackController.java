package com.socialmedia.apigateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class FallbackController {

    @RequestMapping("/userServiceFallBack")
    public ResponseEntity<?> userServiceFallback() {
        return ResponseEntity.internalServerError()
                .body("The User Service is currently unavailable. Please try again later.");
    }

    @RequestMapping("/ContentServiceFallBack")
    public ResponseEntity<?> contentServiceFallBack() {
        return ResponseEntity.internalServerError()
                .body("The Content Service is currently unavailable. Please try again later.");
    }

}