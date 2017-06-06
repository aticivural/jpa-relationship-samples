package com.vural.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vural on 05-Jun-17.
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    private String firstName;
    private String lastName;

    @JoinColumn(name = "student_id_in_lesson", referencedColumnName = "student_id")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Lesson> lessonList;


}
