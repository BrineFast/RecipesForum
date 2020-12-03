package com.university.database.controller.recipe;

import com.university.database.model.dto.recipe.RecipeTypeCreateDTO;
import com.university.database.model.dto.recipe.RecipeTypeEditDTO;
import com.university.database.model.entity.recipe.RecipeType;
import com.university.database.service.recipe.RecipeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeTypeController {

    @Autowired
    RecipeTypeService recipeTypeService;

    @GetMapping("/recipe_types")
    public List<RecipeType> getRecipeTypesList(){
        return recipeTypeService.getRecipeTypesList();
    }

    @GetMapping("/recipe_types/{id}")
    public RecipeType getRecipeType(@PathVariable("id") Long recipeTypeId){
        return recipeTypeService.getRecipeType(recipeTypeId);
    }

    @PostMapping("/recipe_types/create")
    @Transactional
    public RecipeType createRecipeType(@RequestBody RecipeTypeCreateDTO recipeTypeCreateDTO){
        return recipeTypeService.createRecipeType(recipeTypeCreateDTO);
    }

    @PatchMapping("/recipe_types/{id}")
    @Transactional
    public RecipeType editRecipeType(@PathVariable("id") Long recipeTypeId, @RequestBody RecipeTypeEditDTO recipeTypeEditDTO){
        return recipeTypeService.editRecipeType(recipeTypeId, recipeTypeEditDTO);
    }

}
