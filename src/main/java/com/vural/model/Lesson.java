package com.vural.model;

import lombok.*;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by vural on 05-Jun-17.
 */
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lessonName;
    private Integer credit;


    @ManyToMany(mappedBy = "lessons")
    private Set<Student> students;


    @Override
    public String toString() {
        String info = "";
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("id", this.id);
        jsonInfo.put("lesson_name", this.lessonName);
        jsonInfo.put("credit", this.credit);

        JSONArray subArray = new JSONArray();
        this.students.forEach(student -> {
            JSONObject subJson = new JSONObject();
            subJson.put("student_id",student.getId());
            subJson.put("first_name",student.getFirstName());
            subJson.put("last_name",student.getLastName());
        });

        jsonInfo.put("students", subArray);
        info = jsonInfo.toString();
        return info;
    }


}
