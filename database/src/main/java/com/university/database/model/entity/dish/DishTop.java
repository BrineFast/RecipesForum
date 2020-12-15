package com.university.database.model.entity.dish;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "DishTop")
public class DishTop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dish_id;
    private Long feedback_count;
}
