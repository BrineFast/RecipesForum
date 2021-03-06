package com.university.database.model.dao.recipe;

import com.university.database.model.entity.recipe.RecipeGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeGroupRepo extends JpaRepository<RecipeGroup, Long> {
}
