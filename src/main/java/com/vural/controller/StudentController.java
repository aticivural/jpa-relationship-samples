package com.vural.controller;

import com.vural.model.Lesson;
import com.vural.model.Student;
import com.vural.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        return studentRepository.findAll();
    }

    @GetMapping(value = "/create")
    public Student create(){

        Lesson lesson = new Lesson();
        lesson.setLessonName("Database System");
        lesson.setCredit(4);

        Student student = new Student();
        student.setFirstName("Vural");
        student.setLastName("Atici");
        student.setLesson(lesson);

        studentRepository.save(student);
        return student;
    }

    @GetMapping(value = "/delete/{id}")
    public List<Student> delete(@PathVariable Long id){
        studentRepository.deleteById(id);
        return studentRepository.findAll();
    }
}
