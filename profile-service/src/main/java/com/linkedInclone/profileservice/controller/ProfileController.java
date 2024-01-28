package com.linkedInclone.profileservice.controller;

import com.linkedInclone.profileservice.model.Profile;
import com.linkedInclone.profileservice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/profile")
@RestController
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @PostMapping
    public Profile addProfile(@RequestBody Profile profile){
        return profileService.addProfile(profile);
    }

    @GetMapping
    public List<Profile> fetchProfiles(){
        return  profileService.fetchProfiles();
    }

    @GetMapping("/{id}")
    public Profile fetchProfileById(@PathVariable int id){
        return profileService.fetchProfileById(id);
    }

    @PutMapping("/{id}")
    public Profile fetchProfileById(@PathVariable int id, @RequestBody Profile profile){
        return profileService.updateProfile(id,profile);
    }
    @DeleteMapping("/{id}")
    public Profile deleteProfileById(@PathVariable int id){
        return profileService.deleteProfile(id);
    }
}
