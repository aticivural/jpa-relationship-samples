package com.vural.repository;

import com.vural.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vural on 05-Jun-17.
 */
public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
