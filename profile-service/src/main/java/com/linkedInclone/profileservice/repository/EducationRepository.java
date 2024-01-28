package com.linkedInclone.profileservice.repository;

import com.linkedInclone.profileservice.model.Education;
import com.linkedInclone.profileservice.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface  EducationRepository extends JpaRepository<Education, Integer> {
        List<Education> findEducationByProfile(Profile profile);
}
