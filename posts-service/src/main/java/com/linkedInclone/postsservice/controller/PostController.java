package com.linkedInclone.postsservice.controller;

import com.linkedInclone.postsservice.model.Post;
import com.linkedInclone.postsservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/post")
@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public Post addPost(@RequestBody Post post){
        return postService.addPost(post);
    }

    @GetMapping
    public List<Post> fetchPosts(){
        return  postService.fetchPosts();
    }

    @GetMapping("/{id}")
    public Post fetchPostById(@PathVariable int id){
        return postService.fetchPostById(id);
    }

    @PutMapping("/{id}")
    public Post fetchPostById(@PathVariable int id, @RequestBody Post post){
        return postService.updatePost(id,post);
    }

    @DeleteMapping("/{id}")
    public Post deletePostById(@PathVariable int id){
        return postService.deletePost(id);
    }

    @GetMapping("/profile/{profileId}")
    public List<Post> profilePosts(@PathVariable int profileId){
        return  postService.profilePosts(profileId);
    }
}
