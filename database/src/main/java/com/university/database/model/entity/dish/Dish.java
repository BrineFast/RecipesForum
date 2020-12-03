package com.university.database.model.entity.dish;

import com.university.database.model.entity.feedback.Feedback;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "Dish")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany
    Set<Feedback> feedbacks;
}
