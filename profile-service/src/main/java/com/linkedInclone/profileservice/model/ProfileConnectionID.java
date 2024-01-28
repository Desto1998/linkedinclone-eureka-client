package com.linkedInclone.profileservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class ProfileConnectionID implements Serializable {
    @JoinColumn(name = "profile1_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Profile profile1;

    @JoinColumn(name = "profile2_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Profile profile2;
}
