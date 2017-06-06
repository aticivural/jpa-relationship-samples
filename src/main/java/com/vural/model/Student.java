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
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @JoinColumn(name = "lesson_id_in_student", referencedColumnName = "lesson_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Lesson lesson;

}
