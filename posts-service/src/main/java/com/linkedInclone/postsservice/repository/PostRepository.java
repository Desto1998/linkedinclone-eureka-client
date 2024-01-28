package com.linkedInclone.postsservice.repository;

import com.linkedInclone.postsservice.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {
    public List <Post> findPostByProfileId(int profileId);
}
