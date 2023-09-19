package com.tweteroo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.repositories.TweetRepository;

@RestController
@RequestMapping("/tweets")
public class TweetsController {
    
    @Autowired
    TweetRepository tweetRepository;

    @PostMapping
    public void create(@RequestBody TweetModel tweetInfo){
        this.tweetRepository.save(tweetInfo);
    }

    @GetMapping
    public java.util.List<TweetModel> find(){
        return this.tweetRepository.findAll();
    }
}
