package com.linkedInclone.postsservice.model;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "profiles_comments_likes")
public class ProfileCommentLike {
    @EmbeddedId
    private ProfileCommentLikeID id;

}
