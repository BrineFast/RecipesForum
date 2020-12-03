package com.university.database.controller;

import com.university.database.model.dto.dish.DishCreateDTO;
import com.university.database.model.dto.dish.DishEditDTO;
import com.university.database.model.entity.dish.Dish;
import com.university.database.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DishController {

    @Autowired
    DishService dishService;

    @PostMapping("/dishes/create")
    public Dish createDish(@RequestBody DishCreateDTO dishCreateDTO){
        return dishService.createDish(dishCreateDTO);
    }

    @GetMapping("/dishes")
    public List<Dish> getDishesList(){
        return dishService.getDishesList();
    }

    @GetMapping("/dishes/{id}")
    public Dish getDish(@PathVariable("id") Long dishId){
        return dishService.getDish(dishId);
    }

    @PostMapping("/dishes/{id}")
    public Dish editDish(@PathVariable("id") Long dishId, @RequestBody DishEditDTO dishEditDTO){
        return dishService.editDish(dishId, dishEditDTO);
    }
}
