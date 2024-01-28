package com.linkedInclone.postsservice.repository;

import com.linkedInclone.postsservice.model.ProfileCommentLike;
import com.linkedInclone.postsservice.model.ProfileCommentLikeID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileCommentLikeRepository extends JpaRepository<ProfileCommentLike, ProfileCommentLikeID> {
}
