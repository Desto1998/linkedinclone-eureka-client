package com.linkedInclone.profileservice.repository;

import com.linkedInclone.profileservice.model.ProfileConnection;
import com.linkedInclone.profileservice.model.ProfileConnectionID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileConnectionRepository extends JpaRepository<ProfileConnection, ProfileConnectionID> {
}
