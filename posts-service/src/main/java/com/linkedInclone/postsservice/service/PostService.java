package com.linkedInclone.postsservice.service;

import com.linkedInclone.postsservice.Exception.NotFoundException;
import com.linkedInclone.postsservice.model.Post;
import com.linkedInclone.postsservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post addPost(Post post){
        return postRepository.save(post);
    }
    public List<Post> fetchPosts(){
        return postRepository.findAll();
    }
    public Post fetchPostById(int id){
        return postRepository.findById(id).orElseThrow(() -> new NotFoundException("Post not found."));
    }

    public Post updatePost(int postId, Post postDetail){
        Post updatePost = postRepository.findById(postId).
                orElseThrow( ()-> new NotFoundException("Post not exist with id. " + postId));
        updatePost.setContent(postDetail.getContent());
        updatePost.setProfileId(postDetail.getProfileId());
        updatePost.setTitle(postDetail.getTitle());

        return postRepository.save(updatePost);
    }
    public Post deletePost(int postId) {
        Post post= postRepository.findById(postId).
                orElseThrow( () -> new NotFoundException("Post not found"));
        postRepository.deleteById(postId);
        return post;
    }
    public List<Post> profilePosts(int profileId){
        return postRepository.findPostByProfileId(profileId);
    }

}
