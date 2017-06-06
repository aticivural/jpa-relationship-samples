package com.vural.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by vural on 05-Jun-17.
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id")
    private Long id;
    private String lessonName;
    private Integer credit;


}
