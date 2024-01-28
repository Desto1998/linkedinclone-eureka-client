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
@Entity(name = "educations")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @JoinColumn(name = "profile_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    @NonNull
    private Profile profile;
    @NonNull
    private String school;
    @NonNull
    private String degree;
    @Column(name = "field_of_study", nullable = false)
    private String fieldOfStudy;
    @Column(name = "start_date", nullable = false)
    private Date startDate;
    @Column(name = "end_date", nullable = false)
    @Nullable
    private Date endDate;


}
