package com.linkedInclone.profileservice.service;

import com.linkedInclone.profileservice.model.Education;
import com.linkedInclone.profileservice.model.Profile;
import com.linkedInclone.profileservice.repository.EducationRepository;
import com.linkedInclone.profileservice.Exception.NotFoundException;
import com.linkedInclone.profileservice.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {
    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private ProfileRepository profileRepository;

    public List<Education> fetchEducations(){
        return educationRepository.findAll();
    }
    public Education addEducation(Education education){
        return educationRepository.save(education);
    }

    public Education fetchEducation(int educationId){
        return educationRepository.findById(educationId).orElseThrow(()->new NotFoundException("Education introuvable avec l'id: " + educationId));
    }

    public Education updateEducation(int EducationId, Education EducationDetail){
        Education updateEducation = educationRepository.findById(EducationId).orElseThrow(()->new NotFoundException("Education introuvable avec l'id: " + EducationId));
        updateEducation.setDegree(EducationDetail.getDegree());
        updateEducation.setSchool(EducationDetail.getSchool());
        updateEducation.setProfile(EducationDetail.getProfile());
        updateEducation.setEndDate(EducationDetail.getEndDate());
        updateEducation.setStartDate(EducationDetail.getStartDate());
        updateEducation.setFieldOfStudy(EducationDetail.getFieldOfStudy());
        return educationRepository.save(updateEducation);
    }
    public Education deleteEducation(int EducationId){
        Education education = educationRepository.findById(EducationId).orElseThrow(()->new NotFoundException("Education introuvable avec l'id: " + EducationId));
        educationRepository.deleteById(EducationId);
        return education;
    }
    public List<Education> profileEducations(int profileId){
        Profile profile = profileRepository.findById(profileId).orElseThrow(()->new NotFoundException("Profile introuvable avec l'id: " + profileId));

        return educationRepository.findEducationByProfile(profile);
    }
}
