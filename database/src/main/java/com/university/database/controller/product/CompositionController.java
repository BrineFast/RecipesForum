package com.university.database.controller.product;

import com.university.database.model.dto.composition.CompositionCreateDTO;
import com.university.database.model.dto.composition.CompositionEditDTO;
import com.university.database.model.entity.product.Composition;
import com.university.database.service.product.CompositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompositionController {

    @Autowired
    CompositionService compositionService;


    @PostMapping("/compositions/create")
    public Composition createComposition(@RequestBody CompositionCreateDTO compositionCreateDTO){
        return compositionService.createComposition(compositionCreateDTO);
    }

    @GetMapping("/compositions")
    public List<Composition> getCompositionsList(){
        return compositionService.getCompositionsList();
    }

    @GetMapping("/compositions/{id}")
    public Composition getComposition(@PathVariable("id") Long compositionId){
        return compositionService.getComposition(compositionId);
    }

    @PatchMapping("/compositions/{id}")
    public Composition editComposition(@PathVariable("id") Long compositionId, @RequestBody CompositionEditDTO compositionEditDTO){
        return compositionService.editComposition(compositionId, compositionEditDTO);
    }


}
