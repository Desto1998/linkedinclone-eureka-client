package com.linkedInclone.profileservice.controller;

import com.linkedInclone.profileservice.model.Skill;
import com.linkedInclone.profileservice.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/profile/skill")
@RestController
public class SkillController {
    @Autowired
    private SkillService skillService;

    @PostMapping
    public Skill addSkill(@RequestBody Skill skill){
        return skillService.addSkill(skill);
    }

    @GetMapping
    public List<Skill> fetchSkills(){
        return  skillService.fetchSkills();
    }

    @GetMapping("/{id}")
    public Skill fetchSkillById(@PathVariable int id){
        return skillService.fetchSkillById(id);
    }

    @PutMapping("/{id}")
    public Skill fetchSkillById(@PathVariable int id, @RequestBody Skill skill){
        return skillService.updateSkill(id,skill);
    }
    @DeleteMapping("/{id}")
    public Skill deleteSkillById(@PathVariable int id){
        return skillService.deleteSkill(id);
    }
}
