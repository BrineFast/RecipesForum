package com.university.database.model.dao.recipe;

import com.university.database.model.entity.recipe.RecipeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeTypeRepo extends JpaRepository<RecipeType, Long> {
}
