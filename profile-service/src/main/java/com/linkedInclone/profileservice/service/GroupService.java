package com.linkedInclone.profileservice.service;

import com.linkedInclone.profileservice.Exception.NotFoundException;
import com.linkedInclone.profileservice.model.Group;
import com.linkedInclone.profileservice.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public List<Group> fetchGroups(){
        return groupRepository.findAll();
    }
    public Group addGroup(Group group){
        return groupRepository.save(group);
    }

    public Group fetchGroup(int groupId){
        return groupRepository.findById(groupId).orElseThrow(()->new NotFoundException("Group introuvable avec l'id: " + groupId));
    }

    public Group updateGroup(int GroupId, Group GroupDetail){
        Group updateGroup = groupRepository.findById(GroupId).orElseThrow(()->new NotFoundException("Group introuvable avec l'id: " + GroupId));
        updateGroup.setProfile(GroupDetail.getProfile());
        updateGroup.setName(GroupDetail.getName());
        updateGroup.setProfile(GroupDetail.getProfile());
        updateGroup.setDescription(GroupDetail.getDescription());
        return groupRepository.save(updateGroup);
    }

    public Group deleteGroup(int GroupId){
        Group group = groupRepository.findById(GroupId).orElseThrow(()->new NotFoundException("Group introuvable avec l'id: " + GroupId));
        groupRepository.deleteById(GroupId);
        return group;
    }
}
