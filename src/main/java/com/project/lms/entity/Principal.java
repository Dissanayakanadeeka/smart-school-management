package com.project.lms.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Principal {
    @Id @GeneratedValue
    private long id;

    private String name;
    private LocalDate enterDate;
    private String status;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    
}
