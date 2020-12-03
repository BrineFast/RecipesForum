package com.university.database.model.entity.recipe;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Recipe_group")
public class RecipeGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
