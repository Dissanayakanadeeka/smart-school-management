package com.project.lms.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private LocalDate dateOfBirth;
    private String gender;
    private String status;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private ClassRoom classRoom; 

    @ManyToMany
    @JoinTable(name = "student_course",
       joinColumns = @JoinColumn(name = "student_id"),
       inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses;
}
