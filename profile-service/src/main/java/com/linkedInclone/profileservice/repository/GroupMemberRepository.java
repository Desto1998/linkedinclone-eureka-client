package com.linkedInclone.profileservice.repository;

import com.linkedInclone.profileservice.model.GroupMember;
import com.linkedInclone.profileservice.model.GroupMemberID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GroupMemberRepository extends JpaRepository<GroupMember, GroupMemberID> {
//    public List<GroupMember> findByGroupMemberIDProfile(Profile profile);
//    public List<GroupMember> findByGroupMemberIDGroup(Group group);
}
