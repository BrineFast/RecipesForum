package com.university.database.service;

import com.university.database.exception.ProductNotFoundException;
import com.university.database.model.dao.DishRepo;
import com.university.database.model.dao.FeedbackRepo;
import com.university.database.model.dao.RecipeRepo;
import com.university.database.model.dto.feedback.FeedbackCreateDTO;
import com.university.database.model.dto.feedback.FeedbackEditDTO;
import com.university.database.model.entity.dish.Dish;
import com.university.database.model.entity.feedback.Feedback;
import com.university.database.model.entity.recipe.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@EnableTransactionManagement
public class FeedbackService {

    @Autowired
    FeedbackRepo feedbackRepo;

    @Autowired
    DishRepo dishRepo;

    @Autowired
    RecipeRepo recipeRepo;

    public List<Feedback> getFeedbacksList(){
        return feedbackRepo.findAll();
    }

    public Feedback getFeedback(Long feedbackId){
        return feedbackRepo.findById(feedbackId).orElseThrow(() -> new ProductNotFoundException("Feedback with id " + feedbackId.toString() + " not found."));
    }

    @Transactional
    public Feedback editFeedback(Long feedbackId, FeedbackEditDTO feedbackEditDTO){
        Feedback feedback = feedbackRepo.findById(feedbackId).orElseThrow(() -> new ProductNotFoundException("Dish with id " + feedbackId.toString()+ " not found."));
        feedback.setUpdated(new Date());
        feedback.setMark(feedbackEditDTO.getMark());
        feedback.setText(feedbackEditDTO.getText());
        feedback.setTitle(feedbackEditDTO.getTitle());
        return feedbackRepo.save(feedback);
    }

    @Transactional
    public Feedback createDishFeedback(Long dishId, FeedbackCreateDTO feedbackCreateDTO){
        Dish dish = dishRepo.findById(dishId).orElseThrow(() -> new ProductNotFoundException("Dish with id " + dishId.toString() + " not found."));
        Feedback feedback = new Feedback();
        feedback.setCreated(new Date());
        feedback.setUpdated(new Date());
        feedback.setMark(feedbackCreateDTO.getMark());
        feedback.setText(feedbackCreateDTO.getText());
        feedback.setTitle(feedbackCreateDTO.getTitle());
        feedback = feedbackRepo.save(feedback);
        dish.getFeedbacks().add(feedback);
        dishRepo.save(dish);
        return feedback;
    }

    @Transactional
    public Feedback editDishFeedback(Long dishId, FeedbackEditDTO feedbackEditDTO){
        dishRepo.findById(dishId).orElseThrow(() -> new ProductNotFoundException("Dish with id " + dishId.toString() + " not found."));
        Feedback feedback = new Feedback();
        feedback.setUpdated(new Date());
        feedback.setMark(feedbackEditDTO.getMark());
        feedback.setText(feedbackEditDTO.getText());
        feedback.setTitle(feedbackEditDTO.getTitle());
        return feedbackRepo.save(feedback);
    }

    @Transactional
    public Feedback createRecipeFeedback(Long recipeId, FeedbackCreateDTO feedbackCreateDTO){
        Recipe recipe = recipeRepo.findById(recipeId).orElseThrow(() -> new ProductNotFoundException("Recipe with id " + recipeId.toString() + " not found."));
        Feedback feedback = new Feedback();
        feedback.setCreated(new Date());
        feedback.setUpdated(new Date());
        feedback.setMark(feedbackCreateDTO.getMark());
        feedback.setText(feedbackCreateDTO.getText());
        feedback.setTitle(feedbackCreateDTO.getTitle());
        feedback = feedbackRepo.save(feedback);
        recipe.getFeedbacks().add(feedback);
        recipeRepo.save(recipe);
        return feedback;
    }

    @Transactional
    public Feedback editRecipeFeedback(Long recipeId,FeedbackEditDTO feedbackEditDTO){
        recipeRepo.findById(recipeId).orElseThrow(() -> new ProductNotFoundException("Recipe with id " + recipeId.toString() + " not found."));
        Feedback feedback = new Feedback();
        feedback.setUpdated(new Date());
        feedback.setMark(feedbackEditDTO.getMark());
        feedback.setText(feedbackEditDTO.getText());
        feedback.setTitle(feedbackEditDTO.getTitle());
        return feedbackRepo.save(feedback);
    }

}