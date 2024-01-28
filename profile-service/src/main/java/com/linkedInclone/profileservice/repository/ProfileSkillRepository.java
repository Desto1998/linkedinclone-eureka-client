package com.linkedInclone.profileservice.repository;

import com.linkedInclone.profileservice.model.ProfileSkill;
import com.linkedInclone.profileservice.model.ProfileSkillID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileSkillRepository extends JpaRepository<ProfileSkill, ProfileSkillID> {
}
