package com.linkedInclone.profileservice.service;

import com.linkedInclone.profileservice.Exception.NotFoundException;
import com.linkedInclone.profileservice.model.Profile;
import com.linkedInclone.profileservice.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
   @Autowired
   private ProfileRepository profileRepository;

   public List<Profile> fetchProfiles(){
       return profileRepository.findAll();
   }
   public Profile addProfile(Profile profile){
       return profileRepository.save(profile);
   }

   public Profile fetchProfileById(int profileId){
       return profileRepository.findById(profileId).orElseThrow(()->new NotFoundException("Profile introuvable avec l'id: " + profileId));
   }

   public Profile updateProfile(int profileId, Profile profileDetail){
       Profile updateProfile = profileRepository.findById(profileId).orElseThrow(()->new NotFoundException("Profile introuvable avec l'id: " + profileId));
       updateProfile.setHeadline(profileDetail.getHeadline());
       updateProfile.setSummary(profileDetail.getSummary());
       updateProfile.setIndustry(profileDetail.getIndustry());
       updateProfile.setWebsite(profileDetail.getWebsite());
       updateProfile.setCurrentJobTitle(profileDetail.getCurrentJobTitle());
       updateProfile.setUserId(profileDetail.getUserId());
       updateProfile.setOpenForWork(profileDetail.isOpenForWork());
       return profileRepository.save(updateProfile);
   }

   public Profile deleteProfile(int profileId){
       Profile profile = profileRepository.findById(profileId).orElseThrow(()->new NotFoundException("Profile introuvable avec l'id: " + profileId));
       profileRepository.deleteById(profileId);
       return profile;
   }

}
