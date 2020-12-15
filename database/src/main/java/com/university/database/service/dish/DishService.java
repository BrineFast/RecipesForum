package com.university.database.service.dish;

import com.university.database.exception.entities.ItemNotFoundException;
import com.university.database.model.dao.dish.DishRepo;
import com.university.database.model.dao.dish.DishTopRepo;
import com.university.database.model.dto.dish.DishCreateDTO;
import com.university.database.model.dto.dish.DishEditDTO;
import com.university.database.model.entity.dish.DishTop;
import com.university.database.model.entity.dish.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

@Service
@EnableTransactionManagement
public class DishService {

    @Autowired
    DishRepo dishRepo;

    @Autowired
    DishTopRepo dishTopRepo;

    @Transactional
    public Dish createDish(DishCreateDTO DishCreateDTO){
        Dish Dish = new Dish();
        Dish.setTitle(DishCreateDTO.getTitle());
        Dish.setFeedbacks(new HashSet<>());
        return dishRepo.save(Dish);
    }

    public List<Dish> getDishesList(){
        return dishRepo.findAll();
    }

    public Dish getDish(Long dishId){
        return dishRepo.findById(dishId).orElseThrow(() -> new ItemNotFoundException("Dish with id " + dishId +  " not found."));
    }

    @Transactional
    public Dish editDish(Long dishId, DishEditDTO DishEditDTO){
        Dish Dish = dishRepo.findById(dishId).orElseThrow(() -> new ItemNotFoundException("Dish with id " + dishId +  " not found."));
        Dish.setTitle(DishEditDTO.getTitle());
        return dishRepo.save(Dish);
    }

    public List<DishTop> getTopTenDishes(){
        return dishTopRepo.most_popular_dish();
    }
}
