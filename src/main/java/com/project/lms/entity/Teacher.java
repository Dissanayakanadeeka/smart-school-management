package com.project.lms.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String dateOfBirth;
    private String gender;
    private String status;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "teacher_course",
       joinColumns = @JoinColumn(name = "teacher_id"),
       inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses;

    @OneToMany(mappedBy = "assignedBy")
    private Set<Assignment> assignmentsCreated;
}
