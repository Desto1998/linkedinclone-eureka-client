package com.linkedInclone.profileservice.service;

import com.linkedInclone.profileservice.Exception.NotFoundException;
import com.linkedInclone.profileservice.model.Group;
import com.linkedInclone.profileservice.model.GroupMember;
import com.linkedInclone.profileservice.model.Profile;
import com.linkedInclone.profileservice.repository.GroupMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupMemberService {
    @Autowired
    private GroupMemberRepository groupMemberRepository;

    public List<GroupMember> fetchGroupMembers(){
        return groupMemberRepository.findAll();
    }
    public GroupMember addGroupMember(GroupMember groupMember){
        return groupMemberRepository.save(groupMember);
    }

//    public List <GroupMember> fetchGroupMember(Group group){
//        return groupMemberRepository.findByGroupMemberIDGroup(group);
//    }
//
//    public List <GroupMember> fetchProfileGroup(Profile profile){
//        return groupMemberRepository.findByGroupMemberIDProfile(profile);
//    }
}
