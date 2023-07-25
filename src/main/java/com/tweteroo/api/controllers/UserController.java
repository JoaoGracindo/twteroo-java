package com.tweteroo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.repositories.UserRepository;

@RestController
@RequestMapping("/sign-up")
public class UserController {

    @Autowired
    UserRepository userRepository;
    
    @PostMapping
    public void create(@RequestBody UserModel userInfo){
        this.userRepository.save(userInfo);
    }
}
