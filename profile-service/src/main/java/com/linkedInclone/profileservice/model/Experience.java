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
@Entity(name = "experiences")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @JoinColumn(name = "profile_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Profile profile;
    @Column(name = "job_title", nullable = false)
    private String jobTitle;
    @Column(name = "companyName", nullable = false)
    private String company_name;
    @NonNull
    private String location;
    @Column(name = "start_date", nullable = false)
    private Date startDate;
    @Column(name = "end_date")
    @Nullable
    private Date endDate;
}
