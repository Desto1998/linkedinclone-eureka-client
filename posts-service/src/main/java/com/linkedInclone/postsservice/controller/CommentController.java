package com.linkedInclone.postsservice.controller;

import com.linkedInclone.postsservice.model.Comment;
import com.linkedInclone.postsservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/post/comment")
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    public Comment addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }

    @GetMapping
    public List<Comment> fetchComments(){
        return  commentService.fetchComments();
    }

    @GetMapping("/{id}")
    public Comment fetchCommentById(@PathVariable int id){
        return commentService.fetchCommentById(id);
    }

    @PutMapping("/{id}")
    public Comment fetchCommentById(@PathVariable int id, @RequestBody Comment comment){
        return commentService.updateComment(id,comment);
    }

    @DeleteMapping("/{id}")
    public Comment deleteCommentById(@PathVariable int id){
        return commentService.deleteComment(id);
    }

    @GetMapping("/post/{postId}")
    public List<Comment> postComments(@PathVariable int postId){
        return   commentService.postComments(postId);
    }
}
