package com.tweteroo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.repositories.TweetRepository;
import com.tweteroo.api.repositories.UserRepository;

@RestController
@RequestMapping("/tweets")
public class TweetsController {
    
    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public java.util.List<TweetModel> find(@RequestParam("page") Integer page){
        Integer start = 0 + (5 * (page - 1));
        Integer end = 4 + (5 * (page - 1));
        return this.tweetRepository.findAll().subList(start, end);
    }

    @GetMapping("/{username}")
    public java.util.List<TweetModel> findByUser(@PathVariable String username){
        return this.tweetRepository.findAllByUsername(username);
    }

    @PostMapping
    public void create(@RequestBody TweetModel tweetInfo){
        String avatar = this.userRepository.findByUsername(tweetInfo.getUsername()).get(0).getAvatar();
        tweetInfo.setAvatar(avatar);
        this.tweetRepository.save(tweetInfo);
    }

}
