package com.linkedInclone.profileservice.repository;

import com.linkedInclone.profileservice.model.Education;
import com.linkedInclone.profileservice.model.Experience;
import com.linkedInclone.profileservice.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
    List<Experience> findByProfile(Profile profile);

}
