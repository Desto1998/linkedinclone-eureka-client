package com.linkedInclone.postsservice.model;

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
@Entity(name = "profiles_posts_likes")
public class ProfilePostLike {
    @EmbeddedId
    private ProfilePostLikeID id;

}
