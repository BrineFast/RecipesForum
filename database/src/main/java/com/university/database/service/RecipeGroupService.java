package com.university.database.service;

import com.university.database.exception.ProductNotFoundException;
import com.university.database.model.dao.RecipeGroupRepo;
import com.university.database.model.dto.recipe.RecipeGroupCreateDTO;
import com.university.database.model.dto.recipe.RecipeGroupEditDTO;
import com.university.database.model.entity.recipe.RecipeGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@EnableTransactionManagement
public class RecipeGroupService {

    @Autowired
    RecipeGroupRepo recipeGroupRepo;

    public List<RecipeGroup> getRecipeGroupsList(){
        return recipeGroupRepo.findAll();
    }

    public RecipeGroup getRecipeGroup(Long recipeGroupId){
        return recipeGroupRepo.findById(recipeGroupId).orElseThrow(() -> new ProductNotFoundException("RecipeGroup with id " + recipeGroupId.toString() + " not found."));
    }

    @Transactional
    public RecipeGroup createRecipeGroup(RecipeGroupCreateDTO recipeGroupCreateDTO){
        RecipeGroup recipeGroup = new RecipeGroup();
        recipeGroup.setName(recipeGroupCreateDTO.getName());
        return recipeGroupRepo.save(recipeGroup);
    }

    @Transactional
    public RecipeGroup editRecipeGroup(Long recipeGroupId, RecipeGroupEditDTO recipeGroupEditDTO){
        RecipeGroup recipeGroup = recipeGroupRepo.findById(recipeGroupId).orElseThrow(() -> new ProductNotFoundException("RecipeGroup with id " + recipeGroupId.toString() + " not found."));
        recipeGroup.setName(recipeGroupEditDTO.getName());
        return recipeGroupRepo.save(recipeGroup);
    }
}
