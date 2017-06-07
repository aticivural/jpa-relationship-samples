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
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "join_lesson_student",
            joinColumns = {@JoinColumn(name = "lesson_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "id")}
    )
    private Set<Lesson> lessons;

    @Override
    public String toString() {
        String info = "";
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("id", this.id);
        jsonInfo.put("first_name", this.firstName);
        jsonInfo.put("last_name", this.lastName);

        JSONArray subArray = new JSONArray();
        this.lessons.forEach( lesson -> {
            JSONObject subJson = new JSONObject();
            subJson.put("lesson_id", lesson.getId());
            subJson.put("lesson_name", lesson.getLessonName());
            subJson.put("credit", lesson.getCredit());
            subArray.put(subJson);
        });

        jsonInfo.put("lessons", subArray);
        info = jsonInfo.toString();
        return info;
    }

}
