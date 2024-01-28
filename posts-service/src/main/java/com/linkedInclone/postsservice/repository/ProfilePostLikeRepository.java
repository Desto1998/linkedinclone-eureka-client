package com.linkedInclone.postsservice.repository;

import com.linkedInclone.postsservice.model.ProfilePostLike;
import com.linkedInclone.postsservice.model.ProfilePostLikeID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilePostLikeRepository extends JpaRepository<ProfilePostLike, ProfilePostLikeID> {
}
