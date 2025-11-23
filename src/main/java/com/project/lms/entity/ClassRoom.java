package com.project.lms.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassRoom {
    @Id @GeneratedValue
    private Long id;

    private String className;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher; // teacher assigned


    @OneToMany(mappedBy = "classRoom") // must match Student.classRoom
    private List<Student> students;
}
