package com.university.database.model.dao.recipe;

import com.university.database.model.entity.recipe.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Long> {
}
