package com.university.database.model.entity.product;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Composition")
public class Composition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double water;
    private Double protein;
    private Double fats;
    private Double carbohydrates;
    private Double calories;
}
