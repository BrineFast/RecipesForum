package com.university.database.service.recipe;

import com.university.database.exception.entities.ItemNotFoundException;
import com.university.database.model.dao.country.CountryRepo;
import com.university.database.model.dao.dish.DishRepo;
import com.university.database.model.dao.product.ProductRepo;
import com.university.database.model.dao.recipe.RecipeCheaperRepo;
import com.university.database.model.dao.recipe.RecipeGroupRepo;
import com.university.database.model.dao.recipe.RecipeRepo;
import com.university.database.model.dao.recipe.RecipeTypeRepo;
import com.university.database.model.dao.season.SeasonRepo;
import com.university.database.model.dto.recipe.RecipeCreateDTO;
import com.university.database.model.dto.recipe.RecipeEditDTO;
import com.university.database.model.entity.country.Country;
import com.university.database.model.entity.product.Product;
import com.university.database.model.entity.recipe.Recipe;
import com.university.database.model.entity.recipe.RecipeCheaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@EnableTransactionManagement
public class RecipeService {

    @Autowired
    RecipeRepo recipeRepo;

    @Autowired
    RecipeCheaperRepo recipeCheaperRepo;

    @Autowired
    DishRepo dishRepo;

    @Autowired
    CountryRepo countryRepo;

    @Autowired
    ProductRepo productRepo;

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
        return recipeRepo.findById(recipeId).orElseThrow(() -> new ItemNotFoundException("Recipe with id " + recipeId.toString() + " not found."));
    }

    @Transactional
    public Recipe createRecipe(RecipeCreateDTO recipeCreateDTO){
        Recipe recipe = new Recipe();
        Set<Country> countries = new HashSet<>();
        Set<Product> products = new HashSet<>();
        countries.add(countryRepo.findById(recipeCreateDTO.getCountryId()).orElseThrow(() -> new ItemNotFoundException("Country with id " + recipeCreateDTO.getDishId().toString() + " not found.")));
        products.add(productRepo.findById(recipeCreateDTO.getProductId()).orElseThrow(() -> new ItemNotFoundException("Product with id " + recipeCreateDTO.getDishId().toString() + " not found.")));
        recipe.setCookingTechnology(recipeCreateDTO.getCookingTechnology());
        recipe.setName(recipeCreateDTO.getName());
        recipe.setCountry(countries);
        recipe.setProducts(products);
        recipe.setFeedbacks(new HashSet<>());
        recipe.setCreated(new Date());
        recipe.setUpdated(new Date());
        recipe.setDishId(dishRepo.findById(recipeCreateDTO.getDishId()).orElseThrow(() -> new ItemNotFoundException("Dish with id " + recipeCreateDTO.getDishId().toString() + " not found.")));
        recipe.setTypeId(recipeTypeRepo.findById(recipeCreateDTO.getTypeId()).orElseThrow(() -> new ItemNotFoundException("RecipeType with id " + recipeCreateDTO.getTypeId().toString() + " not found.")));
        recipe.setGroupId(recipeGroupRepo.findById(recipeCreateDTO.getGroupId()).orElseThrow(() -> new ItemNotFoundException("RecipeGroup with id " + recipeCreateDTO.getGroupId().toString() + " not found.")));
        recipe.setSeasonId(seasonRepo.findById(recipeCreateDTO.getSeasonId()).orElseThrow(() -> new ItemNotFoundException("Season with id " + recipeCreateDTO.getSeasonId().toString() + " not found.")));
        return recipeRepo.save(recipe);
    }

    @Transactional
    public Recipe editRecipe(Long recipeId, RecipeEditDTO recipeEditDTO){
        Recipe recipe = recipeRepo.findById(recipeId).orElseThrow(() -> new ItemNotFoundException("Recipe with id " + recipeId.toString() + " not found."));
        recipe.setName(recipeEditDTO.getName());
        recipe.setCookingTechnology(recipeEditDTO.getCookingTechnology());
        recipe.setUpdated(new Date());
        Set<Country> countries = new HashSet<>();
        Set<Product> products = new HashSet<>();
        countries.add(countryRepo.findById(recipeEditDTO.getCountryId()).orElseThrow(() -> new ItemNotFoundException("Country with id " + recipeEditDTO.getDishId().toString() + " not found.")));
        products.add(productRepo.findById(recipeEditDTO.getProductId()).orElseThrow(() -> new ItemNotFoundException("Product with id " + recipeEditDTO.getDishId().toString() + " not found.")));
        recipe.setCountry(countries);
        recipe.setProducts(products);
        recipe.setDishId(dishRepo.findById(recipeEditDTO.getDishId()).orElseThrow(() -> new ItemNotFoundException("Dish with id " + recipeEditDTO.getDishId().toString() + " not found.")));
        recipe.setTypeId(recipeTypeRepo.findById(recipeEditDTO.getTypeId()).orElseThrow(() -> new ItemNotFoundException("RecipeType with id " + recipeEditDTO.getTypeId().toString() + " not found.")));
        recipe.setGroupId(recipeGroupRepo.findById(recipeEditDTO.getGroupId()).orElseThrow(() -> new ItemNotFoundException("RecipeGroup with id " + recipeEditDTO.getGroupId().toString() + " not found.")));
        recipe.setSeasonId(seasonRepo.findById(recipeEditDTO.getSeasonId()).orElseThrow(() -> new ItemNotFoundException("Season with id " + recipeEditDTO.getSeasonId().toString() + " not found.")));
        return recipeRepo.save(recipe);
    }

    public List<RecipeCheaper> getRecipesCheaperThen(Integer maxPrice){
        return recipeCheaperRepo.recipes_cheaper_then_max_with_calories_sum(maxPrice);
    }
}
