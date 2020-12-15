package com.university.database.controller.feedback;

import com.university.database.model.dto.feedback.FeedbackCreateDTO;
import com.university.database.model.dto.feedback.FeedbackEditDTO;
import com.university.database.model.entity.feedback.Feedback;
import com.university.database.service.feedback.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @GetMapping("/feedbacks")
    public List<Feedback> getFeedbacksList(){
        return feedbackService.getFeedbacksList();
    }

    @GetMapping("/feedbacks/{id}")
    public Feedback getFeedback(@PathVariable("id") Long feedbackId){
        return feedbackService.getFeedback(feedbackId);
    }

    @PatchMapping("/feedbacks/{id}")
    public Feedback editFeedback(@PathVariable("id") Long feedbackId, @RequestBody FeedbackEditDTO feedbackEditDTO){
        return feedbackService.editFeedback(feedbackId, feedbackEditDTO);
    }

    @GetMapping("/dishes/{id}/feedbacks")
    public Set<Feedback> getDishFeedbacks(@PathVariable("id") Long dishId){
        return feedbackService.getDishFeedbacks(dishId);
    }

    @GetMapping("/recipes/{id}/feedbacks")
    public Set<Feedback> getRecipeFeedbacks(@PathVariable("id") Long recipeId){
        return feedbackService.getRecipeFeedbacks(recipeId);
    }

    @PostMapping("/dishes/{id}/feedbacks/create")
    public Feedback createDishFeedback(@PathVariable("id") Long dishId, @RequestBody FeedbackCreateDTO feedbackCreateDTO){
        return feedbackService.createDishFeedback(dishId, feedbackCreateDTO);
    }

    @PatchMapping("/dishes/{id}/feedbacks/{fid}")
    public Feedback editDishFeedback(@PathVariable("id") Long dishId, @PathVariable("fid") Long feedbackId, @RequestBody FeedbackEditDTO feedbackEditDTO){
        return feedbackService.editDishFeedback(dishId, feedbackEditDTO);
    }

    @PostMapping("/recipes/{id}/feedbacks/create")
    public Feedback createRecipeFeedback(@PathVariable("id") Long recipeId, @RequestBody FeedbackCreateDTO feedbackCreateDTO){
        return feedbackService.createRecipeFeedback(recipeId, feedbackCreateDTO);
    }

    @PatchMapping("/recipes/{id}/feedbacks/{fid}")
    public Feedback editRecipeFeedback(@PathVariable("id") Long recipeId, @PathVariable("fid") Long feedbackId, @RequestBody FeedbackEditDTO feedbackEditDTO){
        return feedbackService.editRecipeFeedback(recipeId, feedbackEditDTO);
    }
}
