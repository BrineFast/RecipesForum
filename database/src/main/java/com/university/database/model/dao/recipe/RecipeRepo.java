package com.university.database.model.dao.recipe;

import com.university.database.model.entity.dish.Dish;
import com.university.database.model.entity.recipe.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Long> {
}
