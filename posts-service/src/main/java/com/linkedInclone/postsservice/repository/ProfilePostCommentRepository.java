package com.linkedInclone.postsservice.repository;

import com.linkedInclone.postsservice.model.ProfilePostComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilePostCommentRepository extends JpaRepository<ProfilePostComment, Integer> {
}
