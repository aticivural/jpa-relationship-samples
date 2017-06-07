package com.vural.controller;

import com.vural.model.Lesson;
import com.vural.model.Student;
import com.vural.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by vural on 05-Jun-17.
 */

@RestController
@RequestMapping(value = "/lessons")
public class LessonController {

    LessonRepository lessonRepository;

    @Autowired
    public LessonController(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @GetMapping(value = "/all")
    public List<Lesson> getAll() {
        List<Lesson> lessonList = lessonRepository.findAll();
        return lessonList;
    }

    @GetMapping(value = "/create")
    public List<Lesson> create() {

        Set<Student> studentList = new HashSet<>();

        Student ahmet = Student.builder()
                .firstName("Ahmet")
                .lastName("Kerim")
                .build();
        studentList.add(ahmet);

        Student mehmet = Student.builder()
                .firstName("Mehmet")
                .lastName("Tas")
                .build();
        studentList.add(mehmet);


        Lesson compsci = Lesson.builder().lessonName("Computer Science")
                .credit(5).students(studentList).build();

        Lesson database = Lesson.builder().lessonName("Database").credit(3)
                .students(studentList).build();

        lessonRepository.save(compsci);
        lessonRepository.save(database);

        List<Lesson> lessonList = lessonRepository.findAll();
        return lessonList;
    }

    @GetMapping(value = "/delete/{id}")
    public List<Lesson> delete(@PathVariable Long id) {
        lessonRepository.deleteById(id);
        List<Lesson> lessonList = lessonRepository.findAll();
        return lessonList;
    }
}
