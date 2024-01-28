package com.linkedInclone.profileservice.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "groups_members")
public class GroupMember {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @EmbeddedId
    private GroupMemberID id;
    private String status;

}
