package com.university.database.model.entity.product;

import com.university.database.model.entity.country.Country;
import com.university.database.model.entity.season.Season;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer price;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "compositionId", nullable = false)
    private Composition compositionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seasonId", nullable = false)
    private Season seasonId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "countryId", nullable = false)
    private Country countryId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeId", nullable = false)
    private ProductType typeId;
}
