package com.vural.controller;

import com.vural.model.Lesson;
import com.vural.repository.LessonRepository;
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
@RequestMapping(value = "/lessons")
public class LessonController {

    LessonRepository lessonRepository;

    @Autowired
    public LessonController(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @GetMapping(value = "/all")
    public List<Lesson> getAll(){
        return lessonRepository.findAll();
    }

    @GetMapping(value = "/create")
    public Lesson createRandomLesson(){
        Lesson lesson = new Lesson();
        lesson.setLessonName("Computer Science");
        lesson.setCredit(5);
        lessonRepository.save(lesson);
        return lesson;
    }

    @GetMapping(value = "/delete/{id}")
    public List<Lesson> delete(@PathVariable Long id){
        lessonRepository.deleteById(id);
        return lessonRepository.findAll();
    }
}
