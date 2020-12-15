package com.university.database.model.dto.recipe;

import com.university.database.model.entity.country.Country;
import com.university.database.model.entity.product.Product;
import lombok.Data;

import java.util.Set;


@Data
public class RecipeCreateDTO {

    private String name;

    private String cookingTechnology;

    private Long dishId;

    private Long groupId;

    private Long typeId;

    private Long seasonId;

    private Long productId;

    private Long countryId;
}