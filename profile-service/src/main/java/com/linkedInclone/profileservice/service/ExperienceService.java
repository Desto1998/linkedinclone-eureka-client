package com.linkedInclone.profileservice.service;

import com.linkedInclone.profileservice.Exception.NotFoundException;
import com.linkedInclone.profileservice.model.Education;
import com.linkedInclone.profileservice.model.Experience;
import com.linkedInclone.profileservice.model.Profile;
import com.linkedInclone.profileservice.repository.ExperienceRepository;
import com.linkedInclone.profileservice.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {
    @Autowired
    private ExperienceRepository experienceRepository;
    @Autowired
    private ProfileRepository profileRepository;

    public List<Experience> fetchExperiences(){
        return experienceRepository.findAll();
    }
    public Experience addExperience(Experience experience){
        return experienceRepository.save(experience);
    }

    public Experience fetchExperience(int experienceId){
        return experienceRepository.findById(experienceId).orElseThrow(()->new NotFoundException("Experience introuvable avec l'id: " + experienceId));
    }

    public Experience updateExperience(int ExperienceId, Experience ExperienceDetail){
        Experience updateExperience = experienceRepository.findById(ExperienceId).orElseThrow(()->new NotFoundException("Experience introuvable avec l'id: " + ExperienceId));
        updateExperience.setProfile(ExperienceDetail.getProfile());
        updateExperience.setStartDate(ExperienceDetail.getStartDate());
        updateExperience.setEndDate(ExperienceDetail.getEndDate());
        updateExperience.setLocation(ExperienceDetail.getLocation());
        updateExperience.setJobTitle(ExperienceDetail.getJobTitle());
        updateExperience.setCompany_name(ExperienceDetail.getCompany_name());
        return experienceRepository.save(updateExperience);
    }

    public Experience deleteExperience(int ExperienceId){
        Experience experience = experienceRepository.findById(ExperienceId).orElseThrow(()->new NotFoundException("Experience introuvable avec l'id: " + ExperienceId));
        experienceRepository.deleteById(ExperienceId);
        return experience;
    }

    public List<Experience> profileExperiences(int profileId){
        Profile profile = profileRepository.findById(profileId).orElseThrow(()->new NotFoundException("Profile introuvable avec l'id: " + profileId));
        return experienceRepository.findByProfile(profile);
    }
}
