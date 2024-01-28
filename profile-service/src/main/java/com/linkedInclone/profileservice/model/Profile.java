package com.linkedInclone.profileservice.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Column(name = "current_job_title", nullable = false)
    private String currentJobTitle;
    @NonNull
    private String industry;
    @Nullable
    private String summary;
    @NonNull
    private String headline;
    @Nullable
    private String website;
    @Column(name = "open_for_work", nullable = false)
    private boolean openForWork;

    private int setOpen(boolean opened){
        return opened ? 1 : 0;
    }

}
