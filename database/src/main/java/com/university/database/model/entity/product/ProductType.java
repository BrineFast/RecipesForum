package com.university.database.model.entity.product;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Product_type")
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
