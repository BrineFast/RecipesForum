package com.university.database.model.entity.recipe;

import com.university.database.model.entity.country.Country;
import com.university.database.model.entity.dish.Dish;
import com.university.database.model.entity.feedback.Feedback;
import com.university.database.model.entity.product.Product;
import com.university.database.model.entity.season.Season;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "RecipeCheaper")
public class RecipeCheaper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long calories;
}
