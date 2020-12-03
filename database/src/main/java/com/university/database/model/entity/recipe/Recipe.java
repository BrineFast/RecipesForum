package com.university.database.model.entity.recipe;

import com.university.database.model.entity.country.Country;
import com.university.database.model.entity.dish.Dish;
import com.university.database.model.entity.feedback.Feedback;
import com.university.database.model.entity.season.Season;
import com.university.database.model.entity.product.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "Recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cookingTechnology;
    private Date created;
    private Date updated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dishId", nullable = false)
    private Dish dishId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupId", nullable = false)
    private RecipeGroup groupId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeId", nullable = false)
    private RecipeType typeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seasonId", nullable = false)
    private Season seasonId;

    @ManyToMany
    private Set<Feedback> feedbacks;

    @ManyToMany
    private Set<Country> country;

    @ManyToMany
    private Set<Product> products;
}
