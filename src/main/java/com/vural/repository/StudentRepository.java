package com.vural.repository;

import com.vural.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vural on 05-Jun-17.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
