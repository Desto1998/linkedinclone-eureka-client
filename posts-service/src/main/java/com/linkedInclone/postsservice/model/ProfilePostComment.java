package com.linkedInclone.postsservice.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "profiles_posts_comments")
public class ProfilePostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "profile_id", nullable = false)
    private int profileId;
    @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Post post;
    @NonNull
    private String content;
    @Column(name = "creation_date", updatable = false)
    @CreationTimestamp
    private DateTimeLiteralExpression.DateTime creationDate;



}
