package com.university.database.model.entity.recipe;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Recipe_type")
public class RecipeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
