package com.vural.controller;

import com.vural.model.Lesson;
import com.vural.model.Student;
import com.vural.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by vural on 05-Jun-17.
 */

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping(value = "/all")
    public List<Student> getAll() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    @GetMapping(value = "/create")
    public List<Student> create(){

        Set<Lesson> lessonList = new HashSet<>();

        Lesson lesson1 = Lesson.builder()
                .lessonName("Computer Architecture")
                .credit(4)
                .build();
        lessonList.add(lesson1);

        Lesson lesson2 = Lesson.builder()
                .lessonName("Advanced Java")
                .credit(3)
                .build();
        lessonList.add(lesson2);


        Student vural= Student.builder().firstName("Vural").lastName("Atici").lessons(lessonList).build();
        Student ufuk= Student.builder().firstName("ufuk").lastName("Atici").lessons(lessonList).build();

        studentRepository.save(vural);
        studentRepository.save(ufuk);

        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    @GetMapping(value = "/delete/{id}")
    public List<Student> delete(@PathVariable Long id){
        studentRepository.deleteById(id);
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }
}
