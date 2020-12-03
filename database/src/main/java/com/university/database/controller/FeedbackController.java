package com.university.database.controller;

import com.university.database.model.dto.feedback.FeedbackCreateDTO;
import com.university.database.model.dto.feedback.FeedbackEditDTO;
import com.university.database.model.entity.feedback.Feedback;
import com.university.database.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @GetMapping("/feedbacks")
    public List<Feedback> getFeedbacksList(){
        return feedbackService.getFeedbacksList();
    }

    @GetMapping("/feedback/{id}")
    public Feedback getFeedback(@PathVariable("id") Long feedbackId){
        return feedbackService.getFeedback(feedbackId);
    }

    @PatchMapping("/feedback/{id}")
    public Feedback editFeedback(@PathVariable("id") Long feedbackId, @RequestBody FeedbackEditDTO feedbackEditDTO){
        return feedbackService.editFeedback(feedbackId, feedbackEditDTO);
    }

    @PostMapping("/dishes/{id}/feedbacks/create")
    public Feedback createDishFeedback(@PathVariable("id") Long dishId, @RequestBody FeedbackCreateDTO feedbackCreateDTO){
        return feedbackService.createDishFeedback(dishId, feedbackCreateDTO);
    }

    @PatchMapping("/dishes/{id}/feedbacks/create")
    public Feedback editDishFeedback(@PathVariable("id") Long dishId, @RequestBody FeedbackEditDTO feedbackEditDTO){
        return feedbackService.editDishFeedback(dishId, feedbackEditDTO);
    }

    @PostMapping("/recipes/{id}/feedbacks/create")
    public Feedback createRecipeFeedback(@PathVariable("id") Long recipeId, @RequestBody FeedbackCreateDTO feedbackCreateDTO){
        return feedbackService.createRecipeFeedback(recipeId, feedbackCreateDTO);
    }

    @PatchMapping("/recipes/{id}/feedbacks/create")
    public Feedback editRecipeFeedback(@PathVariable("id") Long recipeId, @RequestBody FeedbackEditDTO feedbackEditDTO){
        return feedbackService.editRecipeFeedback(recipeId, feedbackEditDTO);
    }
}
