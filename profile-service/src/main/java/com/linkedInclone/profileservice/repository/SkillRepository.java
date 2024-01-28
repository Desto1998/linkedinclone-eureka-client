package com.linkedInclone.profileservice.repository;

import com.linkedInclone.profileservice.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
}
