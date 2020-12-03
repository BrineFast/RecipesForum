package com.university.database.service;

import com.university.database.exception.ProductNotFoundException;
import com.university.database.model.dao.RecipeTypeRepo;
import com.university.database.model.dto.recipe.RecipeTypeCreateDTO;
import com.university.database.model.dto.recipe.RecipeTypeEditDTO;
import com.university.database.model.entity.recipe.RecipeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@EnableTransactionManagement
public class RecipeTypeService {

    @Autowired
    RecipeTypeRepo recipeTypeRepo;

    public List<RecipeType> getRecipeTypesList(){
        return recipeTypeRepo.findAll();
    }

    public RecipeType getRecipeType(Long recipeTypeId){
        return recipeTypeRepo.findById(recipeTypeId).orElseThrow(() -> new ProductNotFoundException("RecipeType with id " + recipeTypeId.toString() + " not found."));
    }

    @Transactional
    public RecipeType createRecipeType(RecipeTypeCreateDTO recipeTypeCreateDTO){
        RecipeType recipeType = new RecipeType();
        recipeType.setName(recipeTypeCreateDTO.getName());
        return recipeTypeRepo.save(recipeType);
    }

    @Transactional
    public RecipeType editRecipeType(Long recipeTypeId, RecipeTypeEditDTO recipeTypeEditDTO){
        RecipeType recipeType = recipeTypeRepo.findById(recipeTypeId).orElseThrow(() -> new ProductNotFoundException("RecipeType with id " + recipeTypeId.toString() + " not found."));
        recipeType.setName(recipeTypeEditDTO.getName());
        return recipeTypeRepo.save(recipeType);
    }
}
