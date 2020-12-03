package com.university.database.service;

import com.university.database.exception.ProductNotFoundException;
import com.university.database.model.dao.CompositionRepo;
import com.university.database.model.dto.composition.CompositionCreateDTO;
import com.university.database.model.dto.composition.CompositionEditDTO;
import com.university.database.model.entity.product.Composition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@EnableTransactionManagement
public class CompositionService {

    @Autowired
    CompositionRepo compositionRepo;

    @Transactional
    public Composition createComposition(CompositionCreateDTO compositionCreateDTO){
        Composition composition = new Composition();
        composition.setCalories(compositionCreateDTO.getCalories());
        composition.setCarbohydrates(compositionCreateDTO.getCarbohydrates());
        composition.setFats(compositionCreateDTO.getFats());
        composition.setProtein(compositionCreateDTO.getProtein());
        composition.setWater(compositionCreateDTO.getWater());
        return compositionRepo.save(composition);
    }

    public List<Composition> getCompositionsList(){
        return compositionRepo.findAll();
    }

    public Composition getComposition(Long compositionId){
        return compositionRepo.findById(compositionId).orElseThrow(() -> new ProductNotFoundException("Composition with id " + compositionId +  " not found."));
    }

    @Transactional
    public Composition editComposition(Long compositionId, CompositionEditDTO compositionEditDTO){
        Composition composition = compositionRepo.findById(compositionId).orElseThrow(() -> new ProductNotFoundException("Composition with id " + compositionId +  " not found."));
        composition.setCalories(compositionEditDTO.getCalories());
        composition.setCarbohydrates(compositionEditDTO.getCarbohydrates());
        composition.setFats(compositionEditDTO.getFats());
        composition.setProtein(compositionEditDTO.getProtein());
        composition.setWater(compositionEditDTO.getWater());
        return compositionRepo.save(composition);
    }

}
