package com.university.database.controller;

import com.university.database.model.dto.recipe.RecipeCreateDTO;
import com.university.database.model.dto.recipe.RecipeEditDTO;
import com.university.database.model.entity.recipe.Recipe;
import com.university.database.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @GetMapping("/recipes")
    public List<Recipe> getRecipesList(){
        return recipeService.getRecipesList();
    }

    @GetMapping("/recipes/{id}")
    public Recipe getRecipe(@PathVariable("id") Long recipeId){
        return recipeService.getRecipe(recipeId);
    }

    @PostMapping("/recipes/create")
    public Recipe createRecipe(@RequestBody RecipeCreateDTO recipeCreateDTO){
        return recipeService.createRecipe(recipeCreateDTO);
    }

    @PatchMapping("/recipes/{id}")
    public Recipe editRecipe(@PathVariable("id") Long recipeId, @RequestBody RecipeEditDTO recipeEditDTO){
        return recipeService.editRecipe(recipeId, recipeEditDTO);
    }

}
