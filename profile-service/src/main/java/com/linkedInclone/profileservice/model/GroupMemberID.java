package com.linkedInclone.profileservice.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class GroupMemberID implements Serializable {
    @JoinColumn(name = "profile_id", referencedColumnName = "id" , nullable = false)
    @ManyToOne(optional = false)
    private Profile profile;
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Group group;
}
