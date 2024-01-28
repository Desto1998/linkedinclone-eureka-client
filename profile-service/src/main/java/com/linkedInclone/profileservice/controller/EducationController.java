package com.linkedInclone.profileservice.controller;

import com.linkedInclone.profileservice.model.Education;
import com.linkedInclone.profileservice.model.Profile;
import com.linkedInclone.profileservice.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/profile/education")
@RestController
public class EducationController {
    @Autowired
    private EducationService educationService;

    @PostMapping
    public Education addEducation(@RequestBody Education education){
        return educationService.addEducation(education);
    }

    @GetMapping
    public List<Education> fetchEducations(){
        return  educationService.fetchEducations();
    }

    @GetMapping("/{id}")
    public Education fetchEducationById(@PathVariable int id){
        return educationService.fetchEducation(id);
    }

    @PutMapping("/{id}")
    public Education fetchEducationById(@PathVariable int id, @RequestBody Education education){
        return educationService.updateEducation(id,education);
    }
    @DeleteMapping("/{id}")
    public Education deleteEducationById(@PathVariable int id){
        return educationService.deleteEducation(id);
    }

    @GetMapping("/profile/{profileId}")
    public List<Education> profileEducations(@PathVariable int profileId){
        return   educationService.profileEducations(profileId);
    }

}
