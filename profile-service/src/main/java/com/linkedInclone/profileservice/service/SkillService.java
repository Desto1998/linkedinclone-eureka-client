package com.linkedInclone.profileservice.service;

import com.linkedInclone.profileservice.Exception.NotFoundException;
import com.linkedInclone.profileservice.model.Skill;
import com.linkedInclone.profileservice.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> fetchSkills(){
        return skillRepository.findAll();
    }
    public Skill addSkill(Skill skill){
        return skillRepository.save(skill);
    }

    public Skill fetchSkillById(int skillId){
        return skillRepository.findById(skillId).orElseThrow(()->new NotFoundException("Skill introuvable avec l'id: " + skillId));
    }

    public Skill updateSkill(int SkillId, Skill SkillDetail){
        Skill updateSkill = skillRepository.findById(SkillId).orElseThrow(()->new NotFoundException("Skill introuvable avec l'id: " + SkillId));
        updateSkill.setName(SkillDetail.getName());
        return skillRepository.save(updateSkill);
    }

    public Skill deleteSkill(int SkillId){
        Skill skill = skillRepository.findById(SkillId).orElseThrow(()->new NotFoundException("Skill introuvable avec l'id: " + SkillId));
        skillRepository.deleteById(SkillId);
        return skill;
    }
}
