package com.project.lms.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Announcement {
    @Id @GeneratedValue
    private Long id;
    private String title;
    @Column(length=2000)
    private String content;
    private LocalDateTime dateCreated;

    @ManyToOne
    @JoinColumn(name = "created_by_media_team_id")
    private MediaTeam createdBy;
}