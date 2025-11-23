package com.project.lms.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id @GeneratedValue
    private Long id;

    private String courseName;
    private String grade;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

    @ManyToMany(mappedBy = "courses")
    private Set<Teacher> teachers;

    @OneToMany(mappedBy = "course")
    private Set<Assignment> assignments;
}