package com.university.database.service;

import com.university.database.exception.ProductNotFoundException;
import com.university.database.model.dao.*;
import com.university.database.model.dto.recipe.RecipeCreateDTO;
import com.university.database.model.dto.recipe.RecipeEditDTO;
import com.university.database.model.entity.recipe.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
@EnableTransactionManagement
public class RecipeService {

    @Autowired
    RecipeRepo recipeRepo;

    @Autowired
    DishRepo dishRepo;

    @Autowired
    RecipeTypeRepo recipeTypeRepo;

    @Autowired
    RecipeGroupRepo recipeGroupRepo;

    @Autowired
    SeasonRepo seasonRepo;

    public List<Recipe> getRecipesList(){
        return recipeRepo.findAll();
    }

    public Recipe getRecipe(Long recipeId){
        return recipeRepo.findById(recipeId).orElseThrow(() -> new ProductNotFoundException("Recipe with id " + recipeId.toString() + " not found."));
    }

    @Transactional
    public Recipe createRecipe(RecipeCreateDTO recipeCreateDTO){
        Recipe recipe = new Recipe();
        recipe.setCookingTechnology(recipeCreateDTO.getCookingTechnology());
        recipe.setName(recipeCreateDTO.getName());
        recipe.setCountry(recipeCreateDTO.getCountries());
        recipe.setProducts(recipeCreateDTO.getProducts());
        recipe.setFeedbacks(new HashSet<>());
        recipe.setCreated(new Date());
        recipe.setUpdated(new Date());
        recipe.setDishId(dishRepo.findById(recipeCreateDTO.getDishId()).orElseThrow(() -> new ProductNotFoundException("Dish with id " + recipeCreateDTO.getDishId().toString() + " not found.")));
        recipe.setTypeId(recipeTypeRepo.findById(recipeCreateDTO.getTypeId()).orElseThrow(() -> new ProductNotFoundException("RecipeType with id " + recipeCreateDTO.getTypeId().toString() + " not found.")));
        recipe.setGroupId(recipeGroupRepo.findById(recipeCreateDTO.getGroupId()).orElseThrow(() -> new ProductNotFoundException("RecipeGroup with id " + recipeCreateDTO.getGroupId().toString() + " not found.")));
        recipe.setSeasonId(seasonRepo.findById(recipeCreateDTO.getSeasonId()).orElseThrow(() -> new ProductNotFoundException("Season with id " + recipeCreateDTO.getSeasonId().toString() + " not found.")));
        return recipeRepo.save(recipe);
    }

    @Transactional
    public Recipe editRecipe(Long recipeId, RecipeEditDTO recipeEditDTO){
        Recipe recipe = recipeRepo.findById(recipeId).orElseThrow(() -> new ProductNotFoundException("Recipe with id " + recipeId.toString() + " not found."));
        recipe.setName(recipeEditDTO.getName());
        recipe.setCookingTechnology(recipeEditDTO.getCookingTechnology());
        recipe.setUpdated(new Date());
        recipe.setCountry(recipeEditDTO.getCountries());
        recipe.setProducts(recipeEditDTO.getProducts());
        recipe.setDishId(dishRepo.findById(recipeEditDTO.getDishId()).orElseThrow(() -> new ProductNotFoundException("Dish with id " + recipeEditDTO.getDishId().toString() + " not found.")));
        recipe.setTypeId(recipeTypeRepo.findById(recipeEditDTO.getTypeId()).orElseThrow(() -> new ProductNotFoundException("RecipeType with id " + recipeEditDTO.getTypeId().toString() + " not found.")));
        recipe.setGroupId(recipeGroupRepo.findById(recipeEditDTO.getGroupId()).orElseThrow(() -> new ProductNotFoundException("RecipeGroup with id " + recipeEditDTO.getGroupId().toString() + " not found.")));
        recipe.setSeasonId(seasonRepo.findById(recipeEditDTO.getSeasonId()).orElseThrow(() -> new ProductNotFoundException("Season with id " + recipeEditDTO.getSeasonId().toString() + " not found.")));
        return recipeRepo.save(recipe);
    }
}
