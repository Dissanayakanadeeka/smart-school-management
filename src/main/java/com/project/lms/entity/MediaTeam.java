package com.project.lms.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MediaTeam {
    @Id @GeneratedValue
    private Long id;
    private Integer numberOfMembers;

    @OneToMany(mappedBy = "createdBy")
    private Set<Announcement> announcements;

    @ManyToMany
    @JoinTable(
        name = "media_team_members",
        joinColumns = @JoinColumn(name = "media_team_id"),
        inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private Set<User> users;

}