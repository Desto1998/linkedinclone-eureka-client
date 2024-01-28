package com.linkedInclone.profileservice.controller;

import com.linkedInclone.profileservice.model.Group;
import com.linkedInclone.profileservice.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/profile/group")
@RestController
public class GroupController {
    @Autowired
    private GroupService groupService;

    @PostMapping
    public Group addGroup(@RequestBody Group group){
        return groupService.addGroup(group);
    }

    @GetMapping
    public List<Group> fetchGroups(){
        return  groupService.fetchGroups();
    }

    @GetMapping("/{id}")
    public Group fetchGroupById(@PathVariable int id){
        return groupService.fetchGroup(id);
    }

    @PutMapping("/{id}")
    public Group fetchGroupById(@PathVariable int id, @RequestBody Group group){
        return groupService.updateGroup(id,group);
    }
    @DeleteMapping("/{id}")
    public Group deleteGroupById(@PathVariable int id){
        return groupService.deleteGroup(id);
    }
}
