package com.university.database.model.dao.recipe;

import com.university.database.model.entity.dish.DishTop;
import com.university.database.model.entity.recipe.Recipe;
import com.university.database.model.entity.recipe.RecipeCheaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeCheaperRepo extends JpaRepository<RecipeCheaper, Long> {



    @Query(value = "exec recipes_cheaper_then_max_with_calories_sum :maxPrice", nativeQuery = true)
    List<RecipeCheaper> recipes_cheaper_then_max_with_calories_sum(@Param("maxPrice") Integer maxPrice);

}
