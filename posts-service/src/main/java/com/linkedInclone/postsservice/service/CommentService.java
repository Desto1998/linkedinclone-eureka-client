package com.linkedInclone.postsservice.service;

import com.linkedInclone.postsservice.Exception.NotFoundException;
import com.linkedInclone.postsservice.model.Comment;
import com.linkedInclone.postsservice.model.Post;
import com.linkedInclone.postsservice.repository.CommentRepository;
import com.linkedInclone.postsservice.repository.PostRepository;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    public Comment addComment(Comment comment){
        return commentRepository.save(comment);
    }
    public List<Comment> fetchComments(){
        return commentRepository.findAll();
    }
    public Comment fetchCommentById(int id){
        return commentRepository.findById(id).orElseThrow(() -> new NotFoundException("Comment not found."));
    }

    public Comment updateComment(int commentId, Comment commentDetail){
        Comment updateComment = commentRepository.findById(commentId).
                orElseThrow( ()-> new NotFoundException("Comment not exist with id. " + commentId));
        updateComment.setComment(commentDetail.getComment());
        updateComment.setPost(commentDetail.getPost());
        updateComment.setContent(commentDetail.getContent());
        updateComment.setProfileId(commentDetail.getProfileId());

        return commentRepository.save(updateComment);
    }
    public Comment deleteComment(int commentId) {
        Comment comment= commentRepository.findById(commentId).
                orElseThrow( () -> new NotFoundException("Comment not found"));
        commentRepository.deleteById(commentId);
        return comment;
    }
    public List<Comment> postComments(int postId){
        Post post = postRepository.findById(postId).orElseThrow(()->new NotFoundException("post introuvable avec l'id: " + postId));
        return commentRepository.findByPost(post);
    }
}
