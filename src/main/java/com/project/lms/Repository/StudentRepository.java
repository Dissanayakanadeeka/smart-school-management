package com.project.lms.repository;

import com.project.lms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.project.lms.entity.Student;
import java.util.List;

 
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByClassRoomId(Long classId);
}
