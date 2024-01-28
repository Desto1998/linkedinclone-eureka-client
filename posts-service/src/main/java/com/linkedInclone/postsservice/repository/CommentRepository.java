package com.linkedInclone.postsservice.repository;

import com.linkedInclone.postsservice.model.Comment;
import com.linkedInclone.postsservice.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByPost(Post post);
}
