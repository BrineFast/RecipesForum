package com.university.database.controller;

import com.university.database.model.dto.recipe.RecipeGroupCreateDTO;
import com.university.database.model.dto.recipe.RecipeGroupEditDTO;
import com.university.database.model.entity.recipe.RecipeGroup;
import com.university.database.service.RecipeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RecipeGroupController {

    @Autowired
    RecipeGroupService recipeGroupService;

    @GetMapping("/recipe_groups")
    public List<RecipeGroup> getRecipeGroupsList(){
        return recipeGroupService.getRecipeGroupsList();
    }

    @GetMapping("/recipe_groups/{id}")
    public RecipeGroup getRecipeGroup(@PathVariable("id") Long recipeGroupId){
        return recipeGroupService.getRecipeGroup(recipeGroupId);
    }

    @PostMapping("/recipe_groups/create")
    public RecipeGroup createRecipeGroup(@RequestBody RecipeGroupCreateDTO recipeGroupCreateDTO){
        return recipeGroupService.createRecipeGroup(recipeGroupCreateDTO);
    }

    @PatchMapping("/recipe_groups/{id}")
    public RecipeGroup editRecipeGroup(@PathVariable("id") Long recipeGroupId, @RequestBody RecipeGroupEditDTO recipeGroupEditDTO){
        return recipeGroupService.editRecipeGroup(recipeGroupId, recipeGroupEditDTO);
    }

}
