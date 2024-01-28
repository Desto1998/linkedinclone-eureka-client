package com.linkedInclone.profileservice.controller;

import com.linkedInclone.profileservice.model.Experience;
import com.linkedInclone.profileservice.model.Profile;
import com.linkedInclone.profileservice.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/profile/experience")
@RestController
public class ExperienceController {
    @Autowired
    private ExperienceService experienceService;

    @PostMapping
    public Experience addExperience(@RequestBody Experience experience){
        return experienceService.addExperience(experience);
    }

    @GetMapping
    public List<Experience> fetchExperiences(){
        return  experienceService.fetchExperiences();
    }

    @GetMapping("/{id}")
    public Experience fetchExperienceById(@PathVariable int id){
        return experienceService.fetchExperience(id);
    }

    @PutMapping("/{id}")
    public Experience fetchExperienceById(@PathVariable int id, @RequestBody Experience experience){
        return experienceService.updateExperience(id,experience);
    }
    @DeleteMapping("/{id}")
    public Experience deleteExperienceById(@PathVariable int id){
        return experienceService.deleteExperience(id);
    }

    @GetMapping("/profile/{profileId}")
    public List<Experience> profileExperiences(@PathVariable int profileId){
        return   experienceService.profileExperiences(profileId);
    }
}
